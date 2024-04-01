 
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class AddTeacher extends JFrame implements ActionListener{
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfAadhar;
    JLabel labelempId;       //label value can't be changed.
    
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;
    
    
    Random ran = new Random();
    long first4  = Math.abs((ran.nextLong() % 9000L)+1000L);
    AddTeacher(){
        setSize(900, 700);
        setLocation(360,50 );
        
        setLayout(null);
        
        //for displaing student detail
        JLabel heading  = new JLabel("New Teacher Details"); //it is used to print as it is in the prompt.
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        
        // for name.
        JLabel lblname  = new JLabel("Name"); //it is used to print as it is in the prompt.
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        
        // for father's name.
        JLabel lblfname  = new JLabel("Father's Name"); //it is used to print as it is in the prompt.
        lblfname.setBounds(450, 150, 150, 30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(650, 150, 150, 30);
        add(tffname);
        
        
         // for roll no.
        JLabel lblempId  = new JLabel("Employee Id"); //it is used to print as it is in the prompt.
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setFont(new Font("serif",Font.BOLD,20));
        add(lblempId);
        
        labelempId  = new JLabel("101"+first4); //it is used to print as it is in the prompt.
        labelempId.setBounds(200 , 200, 200, 30);
        labelempId.setFont(new Font("serif",Font.BOLD,20));
        add(labelempId);
        
        // for DOB.
        JLabel lbldob  = new JLabel("Date Of Birth"); //it is used to print as it is in the prompt.
        lbldob.setBounds(450, 200, 200, 30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
            
        dcdob= new JDateChooser();
        dcdob.setBounds(650, 200, 150, 30);
        add(dcdob);
        
        // for Address.
        JLabel lbladdress  = new JLabel("Address"); //it is used to print as it is in the prompt.
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        // for Phone number.
        JLabel lblphone  = new JLabel("Phone Number"); //it is used to print as it is in the prompt.
        lblphone.setBounds(450, 250, 200, 30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(650, 250, 150, 30);
        add(tfphone);
        
        
        // For Email
        JLabel lblemail = new JLabel("Email Id"); //it is used to print as it is in the prompt.
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        // for 10th %
        JLabel lblx  = new JLabel("Class X (%)"); //it is used to print as it is in the prompt.
        lblx.setBounds(450, 300, 200, 30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(650, 300, 150, 30);
        add(tfx);
        
        //++++++++++++++++++++++++++++++++++++++++
        
        JLabel lblxii  = new JLabel("Class XII (%)"); //it is used to print as it is in the prompt.
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        tfxii= new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);
        
        // for Aadhar Number
        JLabel lblaadhar  = new JLabel("Aadhar Number"); //it is used to print as it is in the prompt.
        lblaadhar.setBounds(450, 350, 200, 30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        tfAadhar = new JTextField();
        tfAadhar.setBounds(650, 350, 150, 30);
        add(tfAadhar);
        
        // for Course
        JLabel lblcourse  = new JLabel("Qualification"); //it is used to print as it is in the prompt.
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        String course[] = {"B.Tech","M.Tech","BBA","MBA","Bsc","Msc","BCA","MCA","MCom","MA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBackground(Color.white);
        cbcourse.setBounds(200, 400, 150, 30);
        add(cbcourse);
        
        // for branch
        JLabel lblbranch  = new JLabel("Department"); //it is used to print as it is in the prompt.
        lblbranch.setBounds(450, 400, 200, 30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        String branch[] = {"NONE","CSE","EE","ECE","ME","CE","IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBackground(Color.white);
        cbbranch.setBounds(650, 400, 150, 30);
        add(cbbranch);
        
        //for submit button and 
        submit = new JButton("SUBMIT");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD, 16));
        add(submit);
        
        //for cancel button and 
            cancel = new JButton("CANCEL");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD, 16));
        add(cancel);
 
         
        //++++++++++++++++++++++++
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = labelempId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText(); 
            String xii = tfxii.getText();
            String Aadhar = tfAadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            
            try{
                String query = "insert into  teacher values('"+name+"', '"+fname+"', '"+empId+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+Aadhar+"', '"+course+"', '"+branch+"')";
                ConnectingDB con = new ConnectingDB();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully!");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddTeacher();
    }
}
    