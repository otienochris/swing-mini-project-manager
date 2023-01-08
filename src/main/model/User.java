package main.model;

import java.time.LocalDate;
import main.enums.RoleEnum;

/**
 *
 * @author
 */
public class User {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private RoleEnum role;
    private GenderEnum gender;
    private LocalDate dateOfBirth;

    public User(Integer id, String username, String firstName, String lastName, String password, RoleEnum role, GenderEnum gender, LocalDate dateOfBirth) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.gender = gender;
        
        if(isDateOfBirthValid(dateOfBirth)){
            throw new IllegalStateException("Date of birth cannot be in the future. It must be in the past");
        }
        
        this.dateOfBirth = dateOfBirth;        
    }

    private static boolean isDateOfBirthValid(LocalDate dob) {
        return dob.isBefore(LocalDate.now());
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(isDateOfBirthValid(dateOfBirth))
            throw new IllegalStateException("Date of birth cannot be in the future. It must be in the past");
        else 
            this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" 
                + "id=" + id 
                + ", username=" + username 
                + ", firstName=" + firstName 
                + ", lastName=" + lastName 
                + ", password=" + password 
                + ", role=" + role 
                + ", gender=" + gender 
                + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
    
    
}
