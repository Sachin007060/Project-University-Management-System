
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class TeacherLeave extends JFrame implements ActionListener{
    Choice cEmpId, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    TeacherLeave(){
        
        // for frame layout..
        setSize(550, 550);
        setLocation(550, 100);
        setLayout(null);
        
        // for color of frame
        getContentPane().setBackground(Color.white);
        
        // for the heading
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(heading);
        
        // for the searching by roll number..
        JLabel lblrollno = new JLabel("Search By Employee Id");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(lblrollno);
        
        // for choice
        cEmpId = new Choice();
        cEmpId.setBounds(60, 130, 200, 20);
        add(cEmpId);
        
        
        // for connecting to the database..
        try{
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("Select * from Teacher");
            while(rs.next()){
            cEmpId.add(rs.getString("empId"));
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // for date..
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(lbldate);
        
        // date chooser
        dcdate= new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);
        
        // for time duration..
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(lbltime);
        
        // for choice
        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        
        //for submit button and 
        submit = new JButton("SUBMIT");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD, 16));
        add(submit);
        
        //for cancel button and 
            cancel = new JButton("CANCEL");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD, 16));
        add(cancel);
 
        
        
        setVisible(true);
    }
    
    // abstract method should be overrided because ActionListener is implemented..
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
                String rollno = cEmpId.getSelectedItem();
                String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
                String  duration = ctime.getSelectedItem();
                
                String query = "insert into teacherleave values ('"+rollno+"','"+date+"','"+duration+"')";
                
                try{
                    
                    ConnectingDB c = new ConnectingDB();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Leave request submited");
                    setVisible(false);
                    
                }catch(Exception e){
                    
                    e.printStackTrace();
                    
                }
                
            } else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        
        new TeacherLeave();
        
    }
}


