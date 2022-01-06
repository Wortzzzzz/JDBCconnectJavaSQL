package ConnData;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.sound.sampled.*;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
public class JFrameStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtScore;
	private JTextField txtMajor;
	private static JTable table;
	private JTextField txtID;
	private JTextField txtNhapid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				try {
				
					JFrameStudent frame = new JFrameStudent();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
}
	/**
	 * Create the frame.
	 */

	public JFrameStudent() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 687);
		contentPane = new JPanel();
		contentPane.setBackground(Color.lightGray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(65, 171, 93, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(65, 239, 93, 36);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gender");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(65, 309, 93, 36);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(65, 377, 93, 36);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Position");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(65, 449, 93, 36);
		contentPane.add(lblNewLabel_1_4);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setBounds(149, 171, 200, 36);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(149, 239, 200, 36);
		contentPane.add(txtAge);
		
		txtScore = new JTextField();
		txtScore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtScore.setColumns(10);
		txtScore.setBounds(149, 450, 200, 36);
		contentPane.add(txtScore);
		
		txtMajor = new JTextField();
		txtMajor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMajor.setColumns(10);
		txtMajor.setBounds(149, 377, 200, 36);
		contentPane.add(txtMajor);
		
		JComboBox cbGender = new JComboBox();
		cbGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(149, 309, 109, 36);
		contentPane.add(cbGender);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st=new Student();
				st.setName(txtName.getText());
				st.setAge(Integer.parseInt(txtAge.getText()));
				st.setGender(cbGender.getSelectedIndex());
				st.setMajor(txtMajor.getText());
				st.setScore(txtScore.getText());
				ConnJDBC.insert(st);
				JOptionPane.showMessageDialog(null, "Save Success! ");
				showData(ConnJDBC.findAll());
			}
		});
		btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnNewButton.setBackground(Color.RED);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnNewButton.setBackground(UIManager.getColor("control"));
		    }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(41, 521, 132, 51);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st=new Student();
				st.setId(Integer.parseInt(txtID.getText()));
				ConnJDBC.delete(st);
				showData(ConnJDBC.findAll());
			}
		});
		btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnDelete.setBackground(Color.CYAN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnDelete.setBackground(UIManager.getColor("control"));
		    }
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(217, 583, 132, 51);
		contentPane.add(btnDelete);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st = new Student();
				
				if(txtName.getText().length()==0){
					showData(ConnJDBC.findAll());
				} else {
					st.setName(txtName.getText());
					showData(ConnJDBC.findByName(st));
				}
		//		st.setName(txtName.getText());
			//	showData(ConnJDBC.findByName(st));
			}
		
		});
		btnFind.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnFind.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnFind.setBackground(UIManager.getColor("control"));
		    }
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(397, 583, 132, 51);
		contentPane.add(btnFind);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtMajor.setText("");
				txtScore.setText("");
			}
		});
		btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnRefresh.setBackground(Color.BLUE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnRefresh.setBackground(UIManager.getColor("control"));
		    }
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(397, 434, 132, 51);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st=new Student();
				st.setId(Integer.parseInt(txtNhapid.getText()));
				st.setName(txtName.getText());
				st.setAge(Integer.parseInt(txtAge.getText()));
				st.setGender(cbGender.getSelectedIndex());
				st.setMajor(txtMajor.getText());
				st.setScore(txtScore.getText());
				ConnJDBC.Update(st);
				JOptionPane.showMessageDialog(null, "Save Success! ");
				showData(ConnJDBC.findAll());
			}
		});
		btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnUpdate.setBackground(Color.PINK);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnUpdate.setBackground(UIManager.getColor("control"));
		    }
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(566, 583, 132, 51);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(397, 36, 572, 374);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Age", "Gender", "Address", "Position"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  System.exit(0); 
			}
		});
		btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnExit.setBackground(Color.ORANGE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnExit.setBackground(UIManager.getColor("control"));
		    }
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(809, 583, 132, 51);
		contentPane.add(btnExit);
		
		txtID = new JTextField();
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtID.setBounds(217, 521, 132, 51);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID to delete");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(235, 497, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(65, 109, 93, 36);
		contentPane.add(lblNewLabel_1_5);
		
		txtNhapid = new JTextField();
		txtNhapid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNhapid.setColumns(10);
		txtNhapid.setBounds(149, 109, 77, 36);
		contentPane.add(txtNhapid);
		
		JLabel lblNewLabel = new JLabel("human resource management");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 31, 342, 51);
		contentPane.add(lblNewLabel);
		showData(ConnJDBC.findAll());
	}
	public void showData(List<Student>studentl) {
		List<Student>listStudent=new ArrayList<>();
		listStudent=studentl;
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    listStudent.forEach((student) -> { 
	    	String gender;
	    	if(student.getGender()==0)gender="Male";
	    	else {gender="Female";}
	    	tableModel.addRow(new Object [] {
	    		student.getId(),student.getName(),student.getAge(),
	    		gender,student.getMajor(),student.getScore()
	    	});
	    });
	    }
	}
