package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelEmpId;       //label value can't be changed.

    JButton submit, cancel;
    Choice cEmpId;

    UpdateTeacher() {
        setSize(900, 650);
        setLocation(360, 50);

        setLayout(null);

        //for displaing student detail
        JLabel heading = new JLabel("Update Teacher Details"); //it is used to print as it is in the prompt.
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        add(heading);

        // searching by roll_number 
        JLabel lblrollnumber = new JLabel("Select Employee Id");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font("sarif", Font.BOLD, 20));
        add(lblrollnumber);

        cEmpId = new Choice();
        cEmpId.setBounds(250, 100, 200, 20);
        add(cEmpId);
        try {
            ConnectingDB c = new ConnectingDB();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

        // for name.
        JLabel lblname = new JLabel("Name"); //it is used to print as it is in the prompt.
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 19));
        add(labelname);

        // for father's name.
        JLabel lblfname = new JLabel("Father's Name"); //it is used to print as it is in the prompt.
        lblfname.setBounds(450, 150, 150, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(650, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 19));
        add(labelfname);

        // for roll no.
        JLabel lblrollno = new JLabel("Employee Id"); //it is used to print as it is in the prompt.
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelEmpId = new JLabel(); //it is used to print as it is in the prompt.
        labelEmpId.setBounds(200, 200, 200, 30);
        labelEmpId.setFont(new Font("serif", Font.PLAIN, 19));
        add(labelEmpId);

        // for DOB.
        JLabel lbldob = new JLabel("Date Of Birth"); //it is used to print as it is in the prompt.
        lbldob.setBounds(450, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(650, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 19));
        add(labeldob);

        // for Address.
        JLabel lbladdress = new JLabel("Address"); //it is used to print as it is in the prompt.
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        
        add(tfaddress);

        // for Phone number.
        JLabel lblphone = new JLabel("Phone Number"); //it is used to print as it is in the prompt.
        lblphone.setBounds(450, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(650, 250, 150, 30);
        add(tfphone);

        // For Email
        JLabel lblemail = new JLabel("Email Id"); //it is used to print as it is in the prompt.
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        // for 10th %
        JLabel lblx = new JLabel("Class X (%)"); //it is used to print as it is in the prompt.
        lblx.setBounds(450, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        JLabel labelx = new JLabel();
        labelx.setBounds(650, 300, 150, 30);
        labelx.setFont(new Font("serif", Font.PLAIN, 19));
        add(labelx);

        //++++++++++++++++++++++++++++++++++++++++
        JLabel lblxii = new JLabel("Class XII (%)"); //it is used to print as it is in the prompt.
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(200, 350, 150, 30);
        labelxii.setFont(new Font("serif", Font.PLAIN, 19));
        add(labelxii);

        // for Aadhar Number
        JLabel lblaadhar = new JLabel("Aadhar Number"); //it is used to print as it is in the prompt.
        lblaadhar.setBounds(450, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(650, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 19));
        add(labelaadhar);

        // for Course
        JLabel lblcourse = new JLabel("Education"); //it is used to print as it is in the prompt.
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        add(tfcourse);

        // for branch
        JLabel lblbranch = new JLabel("Department"); //it is used to print as it is in the prompt.
        lblbranch.setBounds(450, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        String branch[] = {"NONE", "CSE", "EE", "ECE", "ME", "CE", "IT"};
        tfbranch = new JTextField();
        tfbranch.setBounds(650, 400, 150, 30);
        add(tfbranch);

        // for displaying the data from database. which we have to fill and not changeble..
        try {
            ConnectingDB c = new ConnectingDB();
            String query = "select * from teacher where EmpId= '" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelEmpId.setText(rs.getString("empId"));
                tfcourse.setText(rs.getString("education"));
                tfbranch.setText(rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // for changing the data by selecting rollnbr..
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try {
                ConnectingDB c = new ConnectingDB();
            String query = "select * from teacher where EmpId= '" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                    labelname.setText(rs.getString("name"));
                    labelfname.setText(rs.getString("fname"));
                    labeldob.setText(rs.getString("dob"));
                    tfaddress.setText(rs.getString("address"));
                    tfphone.setText(rs.getString("phone"));
                    tfemail.setText(rs.getString("email"));
                    labelx.setText(rs.getString("class_x"));
                    labelxii.setText(rs.getString("class_xii"));
                    labelaadhar.setText(rs.getString("aadhar"));
                    labelEmpId.setText(rs.getString("empId"));
                    tfcourse.setText(rs.getString("education"));
                    tfbranch.setText(rs.getString("department"));
                }
            } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //for submit button and 
        submit = new JButton("UPDATE");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma", Font.BOLD, 16));
        add(submit);

        //for cancel button and 
        cancel = new JButton("CANCEL");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma", Font.BOLD, 16));
        add(cancel);

        //++++++++++++++++++++++++
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String empId = labelEmpId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {
                String query = "update teacher set address= '" + address + "', phone='" + phone + "', email= '" + email + "', education='" + course + "', department='" + branch + "' where empId='"+empId+"'";
                ConnectingDB con = new ConnectingDB();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully!");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}