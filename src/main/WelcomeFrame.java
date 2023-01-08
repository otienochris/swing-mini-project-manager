package main;


import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import main.model.Project;
import main.views.LoginFrame;

/**
 *
 * @author
 */
public class WelcomeFrame extends JFrame {
    
    private static final Logger logger = Logger.getLogger(MiniProjectManagementSystem.class.getName());
    
    
    public WelcomeFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Welcome Page");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);

        
        try{
            File file = new File("./phases-project-management-lifecycle-header.png");
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(file))));
        } catch (IOException e) {
            logger.severe("Error Opening the image");
        }
        
        
        this.pack();
        
        // title
        JLabel welcome = new JLabel("Welcome to Mini Project Manager");
        welcome.setBounds(150,110,550,40);
        welcome.setFont(new Font("monospaced", Font.BOLD, 24));
        this.add(welcome);
        
        // getStarted or signup
        JButton getStarted = new JButton();
        
        getStarted.setBackground(Color.ORANGE);
        getStarted.setBorder(new LineBorder(Color.DARK_GRAY));
        getStarted.setFocusable(false);
        getStarted.setText("Get Started >>");
        getStarted.setBounds(250,180,250,50);
        getStarted.setFont(new Font("monospaced", Font.BOLD, 24));
        getStarted.addActionListener(event -> {
            Project project = new Project();
            System.out.println(project.getDueDate().toString());
            this.dispose();
            new LoginFrame();
        });
        
            
        this.add(getStarted);
        
        this.setVisible(true);
    }
    
}
