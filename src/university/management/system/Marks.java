
package university.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class Marks extends JFrame implements ActionListener{
    
    String rollno;
    JButton cancel;
    
    Marks(String rollno) {
        this.rollno = rollno;
        
        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        // for heading text..  
        JLabel heading = new JLabel("Uttarakhand Technical University"); //it is used to print as it is in the prompt.
        heading.setBounds(70, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        // for subheading text..  
        JLabel subheading = new JLabel("Result of Examination 2023"); //it is used to print as it is in the prompt.
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);
        
        // for rollno text..  
        JLabel lblrollno = new JLabel("Roll Number :- "+ rollno); //it is used to print as it is in the prompt.
        lblrollno.setBounds(60, 100, 500, 25);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        // for  text..  
        JLabel lblsemester = new JLabel(); //it is used to print as it is in the prompt.
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);
        
        
        JLabel sub1 = new JLabel(); //it is used to print as it is in the prompt.
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);
        JLabel sub2 = new JLabel(); //it is used to print as it is in the prompt.
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);
        JLabel sub3 = new JLabel(); //it is used to print as it is in the prompt.
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);
        JLabel sub4 = new JLabel(); //it is used to print as it is in the prompt.
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);
        JLabel sub5 = new JLabel(); //it is used to print as it is in the prompt.
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);
        JLabel sub6 = new JLabel(); //it is used to print as it is in the prompt.
        sub6.setBounds(100, 350, 500, 20);
        sub6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub6);
        
        
        // for inserting data of subject from database..
        try{
            ConnectingDB c = new ConnectingDB();
            ResultSet rs1 = c.s.executeQuery(" select * from subject where rollno = '"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
                sub6.setText(rs1.getString("subject6"));
            }
            
            ResultSet rs2 = c.s.executeQuery(" select * from marks where rollno = '"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText()+ " ----------- " +rs2.getString("marks1"));
                sub2.setText(sub2.getText()+ " ----------- " +rs2.getString("marks2"));
                sub3.setText(sub3.getText()+ " ----------- " +rs2.getString("marks3"));
                sub4.setText(sub4.getText()+ " ----------- " +rs2.getString("marks4"));
                sub5.setText(sub5.getText()+ " ----------- " +rs2.getString("marks5"));
                sub6.setText(sub6.getText()+ " ----------- " +rs2.getString("marks6"));
                lblsemester.setText("Semester :- "+ rs2.getString("semester"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //for cancel button and 
        cancel = new JButton("BACK  ");
        cancel.setBounds(160, 425, 120, 25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma", Font.BOLD, 16));
        add(cancel);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
    }
    
    public static void main(String[] args) {
        new Marks("");
    }
    
}
