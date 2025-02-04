package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener {
	Choice choiceEMPID; 
	JButton delete,back;
	public RemoveEmployee() {
		super();
		JLabel label=new JLabel("Employee ID");
		label.setBounds(50, 50, 100, 30);
		label.setFont(new Font("Tahoma",Font.BOLD,15));
		add(label);
		
		choiceEMPID=new Choice(); 
		choiceEMPID.setBounds(200, 50, 150, 30);
		add(choiceEMPID);
		
		try {
			Conn c=new Conn();
			ResultSet resultSet=c.statement.executeQuery("select * from employee");
			while(resultSet.next()) {
				choiceEMPID.add(resultSet.getString("empId"));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		//Name
		JLabel labelname=new JLabel("Name");
		labelname.setBounds(50, 100, 100, 30);
		labelname.setFont(new Font("Tahoma",Font.BOLD,15));
		add(labelname);
		
		JLabel textName=new JLabel();
		textName.setBounds(200, 100, 100, 30);
		add(textName);
		
		//phone
		JLabel labelphone=new JLabel("Phone");
		labelphone.setBounds(50, 150, 100, 30);
		labelphone.setFont(new Font("Tahoma",Font.BOLD,15));
		add(labelphone);
		
		JLabel textphone=new JLabel();
		textphone.setBounds(200, 150, 100, 30);
		add(textphone);
		
		//email
		JLabel labelemail=new JLabel("Email");
		labelemail.setBounds(50, 200, 100, 30);
		labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
		add(labelemail);
		
		JLabel textemail=new JLabel();
		textemail.setBounds(200, 200, 100, 30);
		add(textemail);
		
		try {
			Conn c=new Conn();
			ResultSet resultSet=c.statement.executeQuery("select * from employee where empId='"+choiceEMPID.getSelectedItem()+"'");
			while(resultSet.next()) {
				textName.setText(resultSet.getString("name"));
				textphone.setText(resultSet.getString("phone"));
				textemail.setText(resultSet.getString("email"));
				
				
			}
			
			
		} catch (Exception E) {
			E.printStackTrace();
		}
		
		choiceEMPID.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					Conn c=new Conn();
					ResultSet resultSet=c.statement.executeQuery("select * from employee where empId='"+choiceEMPID.getSelectedItem()+"'");
					while(resultSet.next()) {
						textName.setText(resultSet.getString("name"));
						textphone.setText(resultSet.getString("phone"));
						textemail.setText(resultSet.getString("email"));
					}
				}catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		//delete button
		delete=new JButton("Delete");
		delete.setBounds(80, 300, 100, 30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		add(delete);
		
		//back button
		back=new JButton("Back");
		back.setBounds(220, 300, 100, 30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		//add delete image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)	;
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(700, 80, 200, 200);
		add(img);
		
		//add background  image
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
		Image i22=i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT)	;
		ImageIcon i33=new ImageIcon(i22);
		JLabel image=new JLabel(i33);
		image.setBounds(0, 0, 1120, 630);
		add(image);
		
		setSize(1000, 400);
		setLocation(300, 150);
		setLayout(null);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==delete) {
			try {
				Conn c=new Conn();
				String query="delete from employee where empId='"+choiceEMPID.getSelectedItem()+"'";
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Employee Deleted Sucessfully");
				setVisible(false);
				new Main_class();
			}catch(Exception E) {
				E.printStackTrace();
			}
		}else {
			setVisible(false);
			new Main_class();
		}
		
	}
	public static void main(String[] args) {
		new RemoveEmployee();
	}

}
