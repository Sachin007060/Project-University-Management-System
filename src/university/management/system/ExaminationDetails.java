
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton submit, cancel;
    JTable table;
    
    ExaminationDetails(){
        
        // for the frame display
        setSize(1000, 475);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // for heading text..  
        JLabel heading = new JLabel("Check Result"); //it is used to print as it is in the prompt.
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);
        
        
        // for searching by using rollnumbers..
        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);
        
        
        //for submit button and 
        submit = new JButton("RESULT");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma", Font.BOLD, 16));
        add(submit);

        //for cancel button and 
        cancel = new JButton("BACK  ");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma", Font.BOLD, 16));
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("tahoma", Font.PLAIN, 16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);
        
        
        // connecting with DB
        try{
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
                
                        
            }
        });
        
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            setVisible(false);
            new Marks(search.getText());
            
        }else{
            setVisible(false);
        }
    }
    
    
    
    public static void main(String[] args) {
        new ExaminationDetails();
        
    }
}
