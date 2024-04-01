
package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    
    About(){
        
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.white); 
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);
        
        // for displaing the text into the frame..
        JLabel heading = new JLabel("<html>University<br> Management System</html>");
        heading.setBounds(70, 20, 250, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        // --------------------------------------
        JLabel name = new JLabel("Developed by Sachin Baskandi");
        name.setBounds(60, 220, 600, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);
        // --------------------------------------
        JLabel email = new JLabel("Email : sachinbaskandi20@gmail.com");
        email.setBounds(60, 280, 600, 40);
        email.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(email);
        // --------------------------------------
        JLabel education = new JLabel("Education : BTech (Computer Science)");
        education.setBounds(60, 340, 600, 40);
        education.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(education);
        // --------------------------------------
        JLabel phno = new JLabel("Phone number : 9876543210");
        phno.setBounds(60, 400, 600, 40);
        phno.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(phno);
        
        
        
        
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new About();
    }
}
