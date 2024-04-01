package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainProjectFrame extends JFrame implements ActionListener{
    
    MainProjectFrame(){
        setSize(1920,1080);
        
        
    //for dispaling image in the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 980, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        //for menu bar in the display frame
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        //menu bar content:- Information 
        JMenu newInfromation= new JMenu("New Information");
        mb.add(newInfromation);
        //for color the text 
        newInfromation.setForeground(Color.red);
        //for menu list:- first list
        JMenuItem facultyInfo = new JMenuItem("New Faculty Infromation");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInfromation.add(facultyInfo);
        
        //for menu list:- second list
        JMenuItem studentInfo = new JMenuItem("New Student Infromation");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInfromation.add(studentInfo);
        
        
        
        //menu bar content:- Details  
        JMenu details= new JMenu("View Details");
        mb.add(details);
        //for color the text 
        details.setForeground(Color.blue);
        //for menu list:- first list
        JMenuItem facultyDetails = new JMenuItem("Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        //for menu list:- second list
        JMenuItem studentDetails = new JMenuItem("Student Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        details.add(studentDetails);
        
        
        
        //menu bar content:- Leave  
        JMenu leave= new JMenu("Apply Leaves");
        mb.add(leave);
        
        //for color the text 
        leave.setForeground(Color.red);
        
        //for menu list:- first list
        JMenuItem facultyLeave = new JMenuItem("Apply Faculty Leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        
        //for menu list:- second list
        JMenuItem studentLeave = new JMenuItem("Apply Student Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);
        
        
        
        //menu bar content:- Leave Details 
        JMenu leaveDetails= new JMenu("Leave Details");
        mb.add(leaveDetails);
        //for color the text 
        leaveDetails.setForeground(Color.blue);
        //for menu list:- first list
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.white);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        
        //for menu list:- second list
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);
        
        
        
        //menu bar content:- Exam Details 
        JMenu exam= new JMenu("Examination ");
        mb.add(exam);
        //for color the text 
        exam.setForeground(Color.red);
        //for menu list:- first list
        JMenuItem examDetails = new JMenuItem("Examination Details");
        examDetails.setBackground(Color.white);
        examDetails.addActionListener(this);
        exam.add(examDetails);
        //for menu list:- second list
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.white);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);
        
        
        
        //menu bar content:- Update Details 
        JMenu updateInfo= new JMenu("Update Details ");
        mb.add(updateInfo);
        //for color the text 
        updateInfo.setForeground(Color.blue);
        //for menu list:- first list
        JMenuItem updateFacInfo = new JMenuItem("Update Faculty Details");
        updateFacInfo.setBackground(Color.white);
        updateFacInfo.addActionListener(this);
        updateInfo.add(updateFacInfo);
        //for menu list:- second list
        JMenuItem updateStuInfo = new JMenuItem("Update Student Details");
        updateStuInfo.setBackground(Color.white);
        updateStuInfo.addActionListener(this);
        updateInfo.add(updateStuInfo);
        
        
        
        //menu bar content:- Fees 
        JMenu fee= new JMenu("Fee Details ");
        mb.add(fee);
        //for color the text 
        fee.setForeground(Color.red);
        //for menu list:- first list
        JMenuItem feeStructure = new JMenuItem("Fee Structure Details");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);
        //for menu list:- second list
        JMenuItem feeForm = new JMenuItem("Fee Form");
        feeForm.setBackground(Color.white);
        fee.add(feeForm);
        
        
        //menu bar content:- about 
        JMenu about= new JMenu("About");
        mb.add(about);
        //for color the text 
        about.setForeground(Color.blue);
        //for menu list:- first list
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.white);
        ab.addActionListener(this);
        about.add(ab);
        
        
        //menu bar content:- Exit 
        JMenu exit= new JMenu("Exit");
        mb.add(exit);
        //for color the text 
        exit.setForeground(Color.red);
        //for menu list:- first list
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);
        
        
        setVisible(true);  // it should be the last statement in the this file. Means when we set all the value than display.
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("New Faculty Infromation")){
            new AddTeacher();
        }else if(msg.equals("New Student Infromation")){
            new AddStudent();
        }else if(msg.equals("Faculty Details")){
            new TeacherDetails();
        }else if(msg.equals("Student Details")){
            new StudentDetails();
        }else if(msg.equals("Apply Faculty Leave")){
            new TeacherLeave();
        }else if(msg.equals("Apply Student Leave")){
            new StudentLeave();
        } else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        } else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }else if(msg.equals("Examination Details")){
            new ExaminationDetails();
        }else if(msg.equals("Fee Structure Details")){
            new FeeStructure();
        }
        else if(msg.equals("About")){
            new About();
        }
    }
    
    public static void main(String[] args) {
        new MainProjectFrame();
    }
}
