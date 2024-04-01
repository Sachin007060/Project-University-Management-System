
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class FeeStructure extends JFrame{
    
    FeeStructure(){
        
        //for displaing of the frame where size, location, layout and color are mentioned
        
        
        setSize(1000, 700);
        setLocation(300, 50);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JTable table = new JTable();                        //for creating table..
        
        try{
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        add(jsp);
        
        
        
        
        
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FeeStructure();
    }
}
