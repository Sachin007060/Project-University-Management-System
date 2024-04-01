
package university.management.system;

import com.mysql.cj.protocol.Resultset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    // defining the JButton variable(login,cancel) globly because they are in constructor so we can not call them because 
    // they are local variable globly defined so now they can be accessed by the actionPerformer funtion....
    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //for text field
        JLabel lblusername = new  JLabel("USER NAME");
        lblusername.setBounds(40, 20,100 ,20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        
        
        //for password field
        JLabel lblpassword = new  JLabel("PASSWORD");
        lblpassword.setBounds(40, 70,100 ,20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        
        
        //for login button and 
        login = new JButton("LOGIN");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("tahoma",Font.BOLD, 16));
        add(login);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tohoma",Font.BOLD, 19));
        add(cancel);
        
        
        
        //for dispaling image in the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);   //it use when we setLayout null.
        add(image);
        
        
        
        //for displaying the prompt frame.
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
    
     
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            try{
                ConnectingDB c = new ConnectingDB();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new MainProjectFrame();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username/Password");
                    setVisible(false);
                }
                c.s.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
       new Login();
    }
}
