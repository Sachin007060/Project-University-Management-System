package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class TeacherLeaveDetails extends JFrame implements ActionListener {
    
     Choice cEmpId;
     JTable table;
     JButton search, print, cancel;
    
    TeacherLeaveDetails(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search By Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        cEmpId = new Choice();
        cEmpId.setBounds(180, 20, 150, 20);
        add(cEmpId);
        try{
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            while(rs.next()){
            cEmpId.add(rs.getString("empId"));
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("Select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        
        search = new JButton("SEARCH");
        search.setBounds(20, 70, 90, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("PRINT");
        print.setBounds(130, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(230, 70, 90, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700);
        setLocation(350, 100);
        
        
        setVisible(true);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from teacherleave where empid = '"+cEmpId.getSelectedItem()+"' ";
            try{
                ConnectingDB c = new ConnectingDB();
                ResultSet rs  = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
