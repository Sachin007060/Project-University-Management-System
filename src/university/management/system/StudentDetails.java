package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class StudentDetails extends JFrame implements ActionListener {
    
     Choice crollno;
     JTable table;
     JButton search, print, update, add, cancel;
    
    StudentDetails(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search By Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        try{
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("Select * from student");
            while(rs.next()){
            crollno.add(rs.getString("rollno"));
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("Select * from student");
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
        
        
        update = new JButton("UPDATE");
        update.setBounds(230, 70, 90, 20);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("ADD");
        add.setBounds(340, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(440, 70, 90, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700);
        setLocation(350, 100);
        
        
        setVisible(true);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"' ";
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
        }else if(ae.getSource() == update){
            setVisible(false);
            new UpdateStudent();
        }else if(ae.getSource() == add){
            setVisible(false);
            new AddStudent();
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new StudentDetails();
    }
}
