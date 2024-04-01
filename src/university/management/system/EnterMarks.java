
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class EnterMarks extends JFrame implements ActionListener{                       // extending the JFrame class..
    
    Choice crollno;                                             // for multiple choice Using Choice.
    JComboBox cbsemester;                                       // for multiple choice using JComboBox.
    JTextField tfsubl, tfsub2, tfsub3, tfsub4, tfsub5, tfsub6, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5, tfmarks6;
    JButton submit, cancel;
    
    
    EnterMarks(){                                              // creating constructor of EnterMarks class..

        
        setSize(1000,500);                           // set the size of the frame..
        setLocation(300, 150);                            // set the location of a frame in display..
        setLayout(null);                                
        getContentPane().setBackground(Color.WHITE);        // for frame color white..
        
        
        // for adding the image into the frame..
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);     //this is used in a number of places within the framework.
        add(image);
        
        
        
        JLabel heading = new JLabel("Enter Marks of Student"); //it is used to print as it is in the prompt.
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        // searching by roll_number 
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 70, 150, 20);
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);
        try {
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("Select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 110, 150, 20);
        add(lblsemester);
        
        String semester[] = {"1st Semester","2st Semester", "3st Semester", "4st Semester", "5st Semester","6st Semester","7st Semester","8st Semester"};                                     // for inserting the values.
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 110, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 150, 200, 40);
        add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(320, 150, 200, 40);
        add(lblentermarks);
        
        tfsubl = new JTextField();
        tfsubl.setBounds(50, 200, 200, 20);
        add(tfsubl);
        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 230, 200, 20);
        add(tfsub2);
        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 260, 200, 20);
        add(tfsub3);
        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 290, 200, 20);
        add(tfsub4);
        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 320, 200, 20);
        add(tfsub5);
        tfsub6 = new JTextField();
        tfsub6.setBounds(50, 350, 200, 20);
        add(tfsub6);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(255, 200, 200, 20);
        add(tfmarks1);
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(255, 230, 200, 20);
        add(tfmarks2);
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(255, 260, 200, 20);
        add(tfmarks3);
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(255, 290, 200, 20);
        add(tfmarks4);
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(255, 320, 200, 20);
        add(tfmarks5);
        tfmarks6 = new JTextField();
        tfmarks6.setBounds(255, 350, 200, 20);
        add(tfmarks6);
        
        //for submit button and 
        submit = new JButton("SUBMIT");
        submit.setBounds(70, 380, 150, 25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma", Font.BOLD, 16));
        add(submit);

        //for cancel button and 
        cancel = new JButton("CANCEL");
        cancel.setBounds(280, 380, 150, 25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma", Font.BOLD, 16));
        add(cancel);
        
        
        
        
        
        setVisible(true);                                   // by this  frame will be visible in display..
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                ConnectingDB c =  new ConnectingDB();
                
                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfsubl.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"', '"+tfsub6.getText()+"')"; 
                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"', '"+tfmarks6.getText()+"')"; 
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Sucessfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new EnterMarks();                                     // creating object of the EnterMarks class..
    }
}