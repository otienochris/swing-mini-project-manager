package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import main.model.Project;
import main.model.User;


/**
 *
 * @author
 */
public class MiniProjectManagementSystem {
    
    public static final String BASE_DIRECTORY_FOR_TXT_FILES = "";
    public static String loggedInUserId = "";
    public static String loggedInUserName = "";
    public static String loggedInUserRole = "";
    public static String USER_TXT_FILE = "user.txt";
    public static String SPECIALIZATION_TXT_FILE = "specializations.txt";
    public static String PROJECT_TXT_FILE = "projects.txt";
    public static String FILE_DELIMITER = "<>";
    private static final Logger logger = Logger.getLogger(MiniProjectManagementSystem.class.getName());
    private static final List<User> users = new ArrayList<>();
    private static final List<Project> projects = new ArrayList<>();
    private static final List<ProjectAssignment> enrollments = new ArrayList<>();

    public static void main(String[] args) {
        new WelcomeFrame();
//        new ProjectsFrame();
//        new UsersFrame();
//        new LoginFrame();
    }
    
    
    /**
     * This method reads a document line by line considering each line as a record
     * 
     * @author
     * 
     * @param fileName - the file being read
     * @return a list of records as read from the file
     */
    public static List<String> getData(String fileName) {
        logger.log(Level.INFO,"Retrieving data from {0}", new String[]{fileName});
        List<String> data = new ArrayList<>();
        
        File myObj = new File(BASE_DIRECTORY_FOR_TXT_FILES + fileName);
        
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            logger.severe("File not found exception");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred reading data from {0} \n\n {1}", new String[]{fileName, e.getMessage()});
        }
        
        if (data.isEmpty()) {
            logger.log(Level.WARNING, "The file {0} seems empty", new String[]{fileName});
        }
        
        return data;
    }
    
     
    /**
     * This method clears a file's content
     * 
     * @author
     * 
     * @param fileName - the file to be cleared
     * @return true if the operation was successful
     * 
     */
     public static boolean clearFile(String fileName) {
        try(FileWriter myWriter = new FileWriter(BASE_DIRECTORY_FOR_TXT_FILES + fileName)){
            myWriter.write("");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred reading data from {0} \n\n {1}", new String[]{fileName, e.getMessage()});
            return false;
        }
        return true;
    }
     
     
     /**
      * This method appends a line (a record) to a file
      * 
      * @author
      * 
      * @param fileName - the file to be written
      * @param input - the new line to be appended
      * @return true if operation was successful
      */
     public static boolean writeLineToFile(String fileName, String input) {
        try(FileWriter myWriter = new FileWriter(BASE_DIRECTORY_FOR_TXT_FILES + fileName, true)) {
            myWriter.write(input);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred writing data to {0} \n\n {1}", new String[]{fileName, e.getMessage()});
        }
        return true;
    }
     
     
     /**
      * This method calculates the next unique id from id's of records in a file.
      * 
      * @author
      * 
      * @param fileName - the file the id is being generated from and for
      * @return the unique id
      */
     public static int getNextId(String fileName) {
        List<String> data = getData(fileName);
        if (!data.isEmpty()) {
            data.remove(0);
        }
        int[] maxNo = {0};
        data.forEach(line -> {
            String[] strings = line.split(FILE_DELIMITER);
            int num = Integer.parseInt(strings[0]);
            if (num > maxNo[0])
                maxNo[0] = num;
        });

        maxNo[0] += 1;
        return maxNo[0];
    }
     
     
     /**
     * This method updates a specific record in the file
     * 
     * @author
     * 
     * @param recordId - record id to identify the record to be updated
     * @param updatedRecord - the updated record to be saved
     * @param fileName - the file to be updated
     * 
     * @return true if operation was successful
     */
    public static boolean updateRecord(int recordId, String updatedRecord, String fileName) {
        logger.log(Level.INFO,"Changing record of id {0} in file {1}", new String[]{String.valueOf(recordId), fileName});
        
        // retrieve current data
        List<String> data = getData(fileName);
        String header = data.remove(0);
        
        // clear file first
        clearFile(fileName);
        
        
        // updating the data to be written
        List<String> outcome = data.stream()
                .map(record -> record.split(FILE_DELIMITER)[0].equals(String.valueOf(recordId)) ? updatedRecord : record)
                .collect(Collectors.toList());


        // write to the file one line at a time
        int[] count = {0}; 
        writeLineToFile(fileName, header + "\n");
        outcome.forEach(line -> {
            count[0] += 1;
            if (count[0] != outcome.size())
                line += "\n";
            writeLineToFile(fileName, line);

        });
        logger.log(Level.INFO,"Successfully updated the record of id {0} in file {1}", new String[]{String.valueOf(recordId), fileName});
        return true;
    }
    
    /**
     * This method deletes a specific record from a file
     * 
     * @author
     * 
     * @param recordId - record id to identify the record to be updated
     * @param fileName - the file to be updated
     * 
     * @return true if operation was successful
     * 
     * @throws Exception - throws exception when item not found
     */
    public static boolean deleteRecordById(int recordId, String fileName) throws Exception {
        
        logger.log(Level.INFO,"Deleting record of id {0} in file {1}", new String[]{String.valueOf(recordId), fileName});
        
        // retrieve current data
        List<String> data = getData(fileName);
        
        String header = "";
        if(!data.isEmpty())
            header = data.remove(0);
        
        // clear file first
        clearFile(fileName);
        
        // updating the data to be written
        List<String> outcome = data.stream()
                .filter(item -> !item.split(FILE_DELIMITER)[0].equals(String.valueOf(recordId)))
                .collect(Collectors.toList());

        if (data.size() == (outcome.size() - 1)){
            logger.log(Level.SEVERE,"Error deleting record of id {0} in file {1}: Record not found.", new String[]{String.valueOf(recordId), fileName});
            throw new Exception("Record not found");
        }

        // write one line at time
        int[] count = {0}; 
        writeLineToFile(fileName, header + "\n");
        outcome.forEach(line -> {
            count[0] += 1;
            if (count[0] != outcome.size())
                line += "\n";
            writeLineToFile(fileName, line);
        });
        
        return true;
    }
    
    
    /**
     * This method generates a random password of a specific length
     * 
     * @author
     * 
     * @param length - the password's length
     * 
     * @return the generated password
     */
    public static String randomPassword(int length) {
        logger.log(Level.INFO, "Generating random password of length {0}", new int[]{length});
        
        if(length < 8 || length > 12) {
            logger.log(Level.SEVERE, "Error generating random password of length {0}. Reason: Invalid length.", new int[]{length});
            throw new IllegalArgumentException("Password length must be between 8 and 12, 8 and 12 inclusive");            
        }
        
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        
        
        String generatedPassword = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(length)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
        
        logger.log(Level.INFO, "Successfully generated a random password of length {0}", new int[]{length});
        return generatedPassword;
    }

    
    /**
     * This method returns a user's old password
     * 
     * @param userId - user userId
     * @return the user's old password
     */
    public static String getOldPassword(String userId) {
        List<String> data = getData(USER_TXT_FILE);
        if (!data.isEmpty())
            data.remove(0);
        List<String> user = data.stream()
                .filter(line -> line.split(FILE_DELIMITER)[0].equalsIgnoreCase(userId))
                .collect(Collectors.toList());
        return user.isEmpty() ? "" : user.get(0).split(FILE_DELIMITER)[3];
    }   
    
    
    /**
     * This method retrieves a record from a file
     * 
     * @param recordId - the id of the record to be retrieved
     * @param fileName - the file the record exists in
     * 
     * @return the tokens of the record
     */
    
    public static String[] getRecordById(String recordId, String fileName) {
        logger.log(Level.INFO, "Retrieving a record of id {0} from {1}", new Object[]{recordId, fileName});
        
        List<String> record = getData(fileName).stream()
                .filter(line -> line.split(FILE_DELIMITER)[0].equalsIgnoreCase(recordId))
                .collect(Collectors.toList());
        
        if (record.isEmpty()){
            logger.log(Level.SEVERE, "Error Retrieving a record of id {0} from {1}", new Object[]{recordId, fileName});
            throw new RuntimeException("Record Not found");
        }
        
        logger.log(Level.INFO, "Successfully retrieved a record of id {0} from {1}", new Object[]{recordId, fileName});
        
        return record.get(0).split(FILE_DELIMITER);
    }
    
    
    public static String[][] getTableData(List<String> data){
        int size = data.size();
        int [] count = {0};
        String[][] tableData = new String[size][7];
        data.forEach(item -> {
            String [] i = item.split(FILE_DELIMITER);
            tableData[count[0]][0] = i[0];
            tableData[count[0]][1] = i[1];
            tableData[count[0]][2] = i[2];
            tableData[count[0]][3] = i[4];
            tableData[count[0]][4] = i[5];
            tableData[count[0]][5] = i[6];
            count[0] += 1;
        });
        return tableData;
    }
}
