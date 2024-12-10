package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateEmployee extends JFrame implements ActionListener{
	
	JTextField teducation,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation,tname;
	JLabel tempid;
	JButton add,back;
	String number;

	
	public UpdateEmployee(String number) {
		super();
		this.number=number;
		getContentPane().setBackground(new Color(163,255,188));
		
		JLabel heading=new JLabel("Update Employee Detail");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("serif",Font.BOLD,25));
		add(heading);
		
		//Name
		JLabel name=new JLabel("Name");
		name.setBounds(50, 150, 150, 30);
		name.setFont(new Font("san_serif",Font.BOLD,20));
		add(name);
		
		JLabel tname=new JLabel();
		tname.setBounds(200, 150, 150, 30);
		tname.setBackground(new Color(177,252,197));
		add(tname);
		
		//Father name
		JLabel fname=new JLabel("Father's Name");
		fname.setBounds(400, 150, 150, 30);
		fname.setFont(new Font("san_serif",Font.BOLD,20));
		add(fname);
		
		tfname=new JTextField();
		tfname.setBounds(600, 150, 150, 30);
		tfname.setBackground(new Color(177,252,197));
		add(tfname);
		
		//date of birth
		JLabel dob =new JLabel("Date Of Birth");
		dob.setBounds(50, 200, 150, 30);
		dob.setFont(new Font("san_serif",Font.BOLD,20));
		add(dob);
		
		JLabel tdob=new JLabel();
		tdob.setBounds(200, 200, 150, 30);
		tdob.setFont(new Font("tahoma",Font.BOLD,20));
		add(tdob);
		
		//salary
		JLabel salary=new JLabel("Salary");
		salary.setBounds(400, 200, 150, 30);
		salary.setFont(new Font("san_serif",Font.BOLD,20));
		add(salary);
		
		tsalary=new JTextField();
		tsalary.setBounds(600, 200, 150, 30);
		tsalary.setBackground(new Color(177,252,197));
		add(tsalary);
		
		//adress
		JLabel adress=new JLabel("Adress");
		adress.setBounds(50, 250, 150, 30);
		adress.setFont(new Font("san_serif",Font.BOLD,20));
		add(adress);
		
		taddress=new JTextField();
		taddress.setBounds(200, 250, 150, 30);
		taddress.setBackground(new Color(177,252,197));
		add(taddress);
		
		//phone no
		JLabel phone=new JLabel("Phone No");
		phone.setBounds(400, 250, 150, 30);
		phone.setFont(new Font("san_serif",Font.BOLD,20));
		add(phone);
		
		tphone=new JTextField();
		tphone.setBounds(600, 250, 150, 30);
		tphone.setBackground(new Color(177,252,197));
		add(tphone);
		
		//email
		JLabel email=new JLabel("Email");
		email.setBounds(50, 300, 150, 30);
		email.setFont(new Font("san_serif",Font.BOLD,20));
		add(email);
		
		temail=new JTextField();
		temail.setBounds(200, 300, 150, 30);
		temail.setBackground(new Color(177,252,197));
		add(temail);
		
		//eduction
		JLabel education=new JLabel(" Highest Education");
		education.setBounds(400, 300, 150, 30);
		education.setFont(new Font("san_serif",Font.BOLD,20));
		add(education);
		
		teducation=new JTextField();
		teducation.setBounds(600, 300, 150, 30);
		teducation.setBackground(new Color(177,252,197));
		add(teducation);
		
		//aadhar
		
		JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(aadhar);

        JLabel taadhar= new JLabel();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);
		
		//employee id
		
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid= new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);
        
		
		//designation

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(designation);

        tdesignation= new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);
        
        try {
			Conn c=new Conn();
			String query="select * from employee where empId='"+number+"'";
			ResultSet resultSet=c.statement.executeQuery(query);
			while(resultSet.next()) {
				tname.setText(resultSet.getString("name"));
				tfname.setText(resultSet.getString("fname"));
				tdob.setText(resultSet.getString("dob"));
				taddress.setText(resultSet.getString("address"));
				tsalary.setText(resultSet.getString("salary"));
				tphone.setText(resultSet.getString("phone"));
				temail.setText(resultSet.getString("email"));
				teducation.setText(resultSet.getString("education"));
				taadhar.setText(resultSet.getString("aadhar"));
				tempid.setText(resultSet.getString("empId"));
				tdesignation.setText(resultSet.getString("designation"));
			}
			
		} catch (Exception E) {
			E.printStackTrace();
		}
		
		//adding buttons
		add=new JButton("UPDATE");
		add.setBounds(450, 550, 150, 40);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("BACK");
		back.setBounds(250, 550, 150, 40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		setSize(900,700);
		setLayout(null);
		setLocation(300,50);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			String fname=tfname.getText();
			String salary=tsalary.getText();
			String address=taddress.getText();
			String phone=tphone.getText();
			String email=temail.getText();
			String education=teducation.getText();
			String designation=tdesignation.getText();
			
			try {
				Conn c=new Conn();
				String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empId='"+number+"'";
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Details updated succesfully");
				setVisible(false);
				new Main_class();
			} catch (Exception E) {
				E.printStackTrace();
			}
		}else {
			setVisible(false);
			new View_Employee();
		}
		
	}

	public static void main(String[] args) {
		new UpdateEmployee("");
	}
}
