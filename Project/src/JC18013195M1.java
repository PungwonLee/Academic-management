

import java.awt.event.*;
//import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;


public class JC18013195M1 extends JFrame implements ActionListener {
   /**
	 * 
	 */
	
	private static final long serialVersionUID = -8966028848022783732L;
    JButton btnOk,btnOk1,btnOk2;					//1 ��ư ����
   JTextArea txtResult, txtStatus;
   JPanel panel1,pn2;

   static Connection con;
   Statement stmt;
   ResultSet rs;
   String Driver = "";
   String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
   String userid = "madang";
   String pwd = "madang";
   private JPanel panel2;
   private JButton btnNewButton;
   private JButton btnNewButton_2;
   private JButton btnNewButton_3;
   private JButton btnNewButton_4;
   private JButton btnNewButton_5;
   private JButton btnNewButton_8;
   private JPanel panel3;
   private JPanel panel4;
   private JButton btnNewButton_6;
   private JButton btnNewButton_7;
   private JTextField textField;
   private JButton btnNewButton_9;
   private JButton btnNewButton_10;
   private JLabel lblNewLabel_1;
   private JTextField textField_1;
   private JButton btnNewButton_11;
   private JButton btnNewButton_12;
   private JButton btnNewButton_13;
   private JButton btnNewButton_14;
   private JTextField textField_2;
   private JButton btnNewButton_15;
   private JTable table;
   private JScrollPane scrollPane_1;
   private JLabel lblId;
   private JLabel lblNewLabel_2;
   private JTextField textField_3;
   private JButton btnNewButton_16;
   private JButton btnNewButton_17;
   String header[]={"CourseID","Class","ProfessorID","CourseName","Day","ClassTime","Credit","LectureTime","Department","Room","����/�б�"};
   String cells[][]= {};
   String header2[]={"Student","Name","Address","PhoneNumber","Email","Major","AccountNumber","ProfessorID"};
   String cells2[][]= {};
   String header3[]={"Name","CourseName","StudentID","CourseID","ProfessorID","AttendanceScore","MidScore","FinalScore","OtherScore","TotalScore","Grade","�г�/�б�"};
   String cells3[][]= {};   
	
  DefaultTableModel model = new DefaultTableModel(cells,header) { public boolean isCellEditable(int rowIndex, int mColIndex) {
      return false;
  }
};
  DefaultTableModel model2 = new DefaultTableModel(cells2,header2) {
	  public boolean isCellEditable(int rowIndex, int mColIndex) {
          return false;
      }
  
  };  
  DefaultTableModel model3 = new DefaultTableModel(cells3,header3) {
	  public boolean isCellEditable(int rowIndex, int mColIndex) {
          if(!(mColIndex>=5 && mColIndex<=10))
        	  return false;
          return true;
      }
  
  };  

  private JScrollPane scrollPane_2;
  private JButton btnNewButton_18;
  private JTable table_1;
  private JScrollPane scrollPane_3;
  private JButton btnNewButton_19;
  private JTable table_2;
  private JScrollPane scrollPane_4;
  private JButton btnNewButton_20;
  private JLabel lblNewLabel_3;
  private JButton button_1;
  private JLabel lblNewLabel_4;
  private JButton button_2;
  private JButton button_3;
  private JButton button_4;
  private JButton button_5;
  private JButton button_6;
  private JButton button_7;
  private JButton button_8;
  private JButton button;
  
   public JC18013195M1() {
	   
      super("�л���� �����ͺ��̽�");
      layInit();
      conDB();
      setVisible(true);
      setBounds(200,0, 1250, 800); //������
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      datainit();
      
   }

   public void layInit() {
      getContentPane().setLayout(null);
            
            panel4 = new JPanel();
            panel4.setBounds(0, 0, 1224, 422);
            getContentPane().add(panel4);
            panel4.setLayout(null);
            
            btnNewButton_7 = new JButton("ó������");
            btnNewButton_7.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		panel1.setVisible(true);
                  panel4.setVisible(false);
                  txtResult.setText("");
                  txtStatus.setText("");
            	}
            });
            btnNewButton_7.setBounds(12, 10, 91, 23);
            panel4.add(btnNewButton_7);
            
            lblNewLabel_1 = new JLabel("'����/�б�' �Է�:");
            lblNewLabel_1.setBounds(424, 12, 103, 19);
            panel4.add(lblNewLabel_1);
            
            textField_1 = new JTextField();
            textField_1.setColumns(10);
            textField_1.setBounds(529, 11, 96, 21);
            panel4.add(textField_1);
            
            btnNewButton_11 = new JButton("��ȸ");
            btnNewButton_11.addActionListener(this);
            btnNewButton_11.setBounds(629, 10, 91, 23);
            panel4.add(btnNewButton_11);
            
            btnNewButton_12 = new JButton("�ð�ǥ ��ȸ");
            btnNewButton_12.addActionListener(this);
            btnNewButton_12.setBounds(789, 10, 102, 23);
            panel4.add(btnNewButton_12);
            
            btnNewButton_13 = new JButton("���Ƹ� ��ȸ");
            btnNewButton_13.addActionListener(this)
            ;
            btnNewButton_13.setBounds(932, 10, 117, 23);
            panel4.add(btnNewButton_13);
            
            btnNewButton_14 = new JButton("���� ��ȸ");
            btnNewButton_14.addActionListener(this);
            btnNewButton_14.setBounds(1088, 10, 91, 23);
            panel4.add(btnNewButton_14);
            
            lblNewLabel_2 = new JLabel("�л� ID �Է�:");
            lblNewLabel_2.setBounds(127, 12, 80, 19);
            panel4.add(lblNewLabel_2);
            
            textField_3 = new JTextField();
            textField_3.setColumns(10);
            textField_3.setBounds(219, 11, 96, 21);
            panel4.add(textField_3);
            
            btnNewButton_16 = new JButton("�α���");
            btnNewButton_16.setBounds(321, 10, 91, 23);
            panel4.add(btnNewButton_16);
            panel4.setVisible(false);
            btnNewButton_16.addActionListener(this);
            
                  btnNewButton_11.addActionListener(this);
         
            btnOk = new JButton("������  ");
            btnOk.setBounds(268, 5, 129, 23);
            btnOk1=new JButton("���� �����");
            btnOk1.setBounds(538, 5, 99, 23);
            btnOk2=new JButton("�л� �����");
            btnOk2.setBounds(783, 5, 113, 23);
            
            panel1 = new JPanel();
            panel1.setBounds(0, 0, 1236, 422);
            panel1.setLayout(null);
            panel1.add(btnOk);
            panel1.add(btnOk1);		//3. ��ư�߰�
            panel1.add(btnOk2);
            
        


 
            getContentPane().add(panel1);
            
            btnOk.addActionListener(this);
            btnOk1.addActionListener(this);		///////////////////////////////////////////////4. ��ư ����
            btnOk2.addActionListener(this);
         
         
     
         panel2 = new JPanel();
         panel2.setBounds(0, 0, 1224, 451);
         getContentPane().add(panel2);
         panel2.setLayout(null);
         
         btnNewButton = new JButton("������ �ʱ�ȭ");
         btnNewButton.setBounds(257, 10, 128, 23);
         panel2.add(btnNewButton);
         
         btnNewButton_2 = new JButton("����");
         btnNewButton_2.setBounds(515, 10, 128, 23);
         panel2.add(btnNewButton_2);
         
         btnNewButton_3 = new JButton("����");
         btnNewButton_3.setBounds(753, 10, 140, 23);
         panel2.add(btnNewButton_3);
         
         btnNewButton_2.addActionListener(this);
         btnNewButton_3.addActionListener(this);
         btnNewButton_4 = new JButton("��ü���̺���ȸ");
         btnNewButton_4.setBounds(1012, 10, 140, 23);
         panel2.add(btnNewButton_4);
         
         btnNewButton_5 = new JButton("ó������");
         btnNewButton_5.setBounds(12, 10, 91, 23);
         btnNewButton_5.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {	
         		 panel1.setVisible(true);
                panel2.setVisible(false);
                txtResult.setText("");
                txtStatus.setText("");
                
         	}
         });
         panel2.add(btnNewButton_5);
         
         button_1 = new JButton("�����Է�");
         button_1.setBounds(191, 428, 91, 23);
         panel2.add(button_1);
         
         lblNewLabel_4 = new JLabel("���̺� �Է�:");
         lblNewLabel_4.setBounds(15, 432, 72, 15);
         panel2.add(lblNewLabel_4);
         
         button_2 = new JButton("�а��Է�");
         button_2.setBounds(294, 428, 91, 23);
         panel2.add(button_2);
         
         button_3 = new JButton("�����Է�");
         button_3.setBounds(397, 428, 91, 23);
         panel2.add(button_3);
         
         button_4 = new JButton("���ǳ����Է�");
         button_4.setBounds(491, 428, 112, 23);
         panel2.add(button_4);
         
         button_5 = new JButton("���Ƹ��Է�");
         button_5.setBounds(611, 428, 103, 23);
         panel2.add(button_5);
         
         button_6 = new JButton("���γ����Է�");
         button_6.setBounds(726, 428, 112, 23);
         panel2.add(button_6);
         
         button_7 = new JButton("�л� �������� �����Է�");
         button_7.setBounds(850, 428, 169, 23);
         panel2.add(button_7);
         
         button_8 = new JButton("���Ƹ� �л� ���� �Է�");
         button_8.setBounds(1031, 428, 181, 23);
         panel2.add(button_8);
         
         button = new JButton("�л��Է�");
         button.setBounds(88, 428, 91, 23);
         panel2.add(button);
         
         button.addActionListener(this);
         button_1.addActionListener(this);
         button_2.addActionListener(this);
         button_3.addActionListener(this);
         button_4.addActionListener(this);
         button_5.addActionListener(this);
         button_6.addActionListener(this);
         button_7.addActionListener(this);
         button_8.addActionListener(this);

         
         panel2.setVisible(false);
         
         btnNewButton.addActionListener(this);
         btnNewButton_4.addActionListener(this);
      
         
            
      panel3 = new JPanel();
      panel3.setBounds(0, 0, 1224, 451);
      getContentPane().add(panel3);
      
      btnNewButton_6 = new JButton("ó������");
      btnNewButton_6.setBounds(12, 10, 91, 23);
      btnNewButton_6.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		panel1.setVisible(true);
            panel3.setVisible(false);
            txtResult.setText("");
            txtStatus.setText("");
            model.setNumRows(0);
      	}
      });
      panel3.setLayout(null);
      
      scrollPane_4 = new JScrollPane();
      scrollPane_4.setBounds(0, 33, 1224, 389);
      panel3.add(scrollPane_4);
      
      table_2 = new JTable(model3);
     
    
      scrollPane_4.setViewportView(table_2);
      
      scrollPane_3 = new JScrollPane();
      scrollPane_3.setBounds(0, 43, 1224, 379);
      panel3.add(scrollPane_3);
      
      table_1 = new JTable(model2);
      table_1.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		try {
         		 if (e.getButton() == 1) { 
           			int row = table_1.getSelectedRow();
           			
           			
           			Object value = table_1.getValueAt(row, 0);
           			
     	
           			txtStatus.setText("");
           			txtStatus.append("				Ŭ���� �л� ���� ���̺�\n\n");
           			txtStatus.append("StudentID	CourseID	ProfessorID	AttendanceScore	MidScore	FinalScore	OtherScore	TotalScore	Grade	PaymentStatus\n");
           			rs=stmt.executeQuery("SELECT c.*\r\n" + 
           					"FROM coursedetails c\r\n" + 
           					"WHERE c.StudentID="+value+ ";");
           		 
           			while(rs.next()) {
                		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t" +rs.getString(8)+"\t" +rs.getString(9)+"\t" +rs.getString(10)+"\n";
                		 txtStatus.append(str2);
                	 }
                   	
           		
        
          		 }
         		}catch (Exception e2) {
         	    	  System.out.println("���� �б� ���� :" + e2);
         		}
      	}
      });
      scrollPane_3.setViewportView(table_1);
      
      scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(0, 43, 1224, 379);
      panel3.add(scrollPane_1);
      
      table = new JTable(model);	////////////////////////////////���� ���� Ŭ��
      table.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		try {
      		 if (e.getButton() == 1) { 
        			int row = table.getSelectedRow();
        			
        			
        			Object value = table.getValueAt(row, 0);
        			
        			
                	 	
        			txtStatus.setText("");
        			txtStatus.append("			�л� ���̺�\n\n");
        			txtStatus.append("StudentID	Name	Address		PhoneNumber		Email		Major	Minor	AccountNumber	ProfessorID\n");
        			rs=stmt.executeQuery("SELECT s.*\r\n" + 
        			 		"FROM student s,coursedetails c\r\n" + 
        			 		"WHERE c.CourseID ="+(value)+" and c.StudentID = s.StudentID;");
        		 
        			while(rs.next()) {
        				String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t\t" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t" +rs.getString(8)+"\t\t"+rs.getString(9)+"\n";
        				txtStatus.append(str2);
        			}
                	
        		
     
       		 }
      		}catch (Exception e2) {
      	    	  System.out.println("���� �б� ���� :" + e2);
      		}
      	}
      });
      
      scrollPane_1.setViewportView(table);
      
      
      
      panel3.add(btnNewButton_6);
      
      JLabel lblNewLabel = new JLabel("\"����/�б�\" �Է�:");
      lblNewLabel.setBounds(408, 12, 103, 19);
      panel3.add(lblNewLabel);
      
      textField = new JTextField();
      textField.setBounds(504, 11, 96, 21);
      panel3.add(textField);
      textField.setColumns(10);
      
      
      btnNewButton_9 = new JButton("�Ҽ��а� ����");
      btnNewButton_9.setBounds(852, 10, 115, 23);
      panel3.add(btnNewButton_9);
      btnNewButton_9.addActionListener(this);
      
      btnNewButton_10 = new JButton("���ǽð�ǥ");
      btnNewButton_10.setBounds(979, 10, 115, 23);
      panel3.add(btnNewButton_10);
      btnNewButton_10.addActionListener(this);
      
      textField_2 = new JTextField();
      textField_2.setBounds(197, 11, 96, 21);
      panel3.add(textField_2);
      textField_2.setColumns(10);
      
      btnNewButton_15 = new JButton("�α���");
      btnNewButton_15.setBounds(305, 10, 91, 23);
      panel3.add(btnNewButton_15);
      
      
      
      lblId = new JLabel("���� ID�Է�:");
      lblId.setBounds(126, 12, 75, 19);
      panel3.add(lblId);
      
      btnNewButton_17 = new JButton("��ȸ");
      btnNewButton_17.setBounds(612, 10, 91, 23);
      panel3.add(btnNewButton_17);
      
      btnNewButton_18 = new JButton("�����л���ȸ");
      btnNewButton_18.setBounds(715, 10, 125, 23);
      panel3.add(btnNewButton_18);
      
      btnNewButton_19 = new JButton("�����Է�");
      btnNewButton_19.setBounds(1106, 10, 106, 23);
      panel3.add(btnNewButton_19);
      
      btnNewButton_20 = new JButton("���� ���� �Ϸ�");
      btnNewButton_20.setBounds(564, 428, 218, 23);
      panel3.add(btnNewButton_20);
      
      
      lblNewLabel_3 = new JLabel("���� �Է� ��ư Ŭ�� �� ���� ���̺��� ���� Ŭ���Ͽ� ���� �� ���� ��ư�� ���� �ּ���");
      lblNewLabel_3.setBounds(10, 432, 542, 15);
      panel3.add(lblNewLabel_3);
      panel3.setVisible(false);
      
      btnNewButton_20.addActionListener(this);

      btnNewButton_19.addActionListener(this);
      btnNewButton_18.addActionListener(this);
      btnNewButton_17.addActionListener(this);
      btnNewButton_15.addActionListener(this);
         
         scrollPane_2 = new JScrollPane();
         scrollPane_2.setBounds(10, 450, 1214, 291);
         getContentPane().add(scrollPane_2);
         txtStatus = new JTextArea(5,30);
         scrollPane_2.setViewportView(txtStatus);
         txtStatus.setEditable(false);
         String in[]=new String[11];
         
         model.addRow(in);
         
         txtResult = new JTextArea();
         
         txtResult.setEditable(false);
         JScrollPane scrollPane = new JScrollPane(txtResult);
         scrollPane.setBounds(10, 33, 1214, 389);
         getContentPane().add(scrollPane);
   }

   public void conDB() {
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         //System.out.println("����̹� �ε� ����");
	         txtStatus.append("����̹� �ε� ����...\n");
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	      
	      try { /* �����ͺ��̽��� �����ϴ� ���� */
	          //System.out.println("�����ͺ��̽� ���� �غ�...");
	    	  txtStatus.append("�����ͺ��̽� ���� �غ�...\n");
	          con = DriverManager.getConnection(url, userid, pwd);
	          //System.out.println("�����ͺ��̽� ���� ����");
	          txtStatus.append("�����ͺ��̽� ���� ����...\n");
	       } catch (SQLException e1) {
	          e1.printStackTrace();
	       }
	   }

public void datainit() {
	 try {
		stmt=con.createStatement();
	
	 stmt.executeUpdate("drop table if exists Student_has_Clup;");
	 stmt.executeUpdate("drop table if exists Student_has_Professor;");
	 stmt.executeUpdate("drop table if exists TuitionDetails;");
	 stmt.executeUpdate("drop table if exists Clup;");
	 stmt.executeUpdate("drop table if exists CourseDetails;");
	 stmt.executeUpdate("drop table if exists Course;");
	 stmt.executeUpdate("drop table if exists Department;");
	 stmt.executeUpdate("drop table if exists Student;");
	 stmt.executeUpdate("drop table if exists Professor;");

	 //stmt.executeUpdate("");
	 
	 
	 stmt.executeUpdate("CREATE TABLE Professor (\r\n" + 
	 		"ProfessorID VARCHAR(10) NOT NULL,\r\n" + 
	 		"  Name VARCHAR(15) NULL,\r\n" + 
	 		"  Address VARCHAR(100) NULL,\r\n" + 
	 		"  PhoneNumber VARCHAR(20) NULL,\r\n" + 
	 		"  Email VARCHAR(45) NULL,\r\n" + 
	 		"  DepartmentNumber VARCHAR(10) NOT NULL COMMENT '�Ҽ��а���ȣ',\r\n" + 
	 		"  PRIMARY KEY (ProfessorID)\r\n" + 
	 		");"); 
	 stmt.executeUpdate("CREATE TABLE  Student (\r\n" + 
	 		"  StudentID VARCHAR(10) NOT NULL,\r\n" + 
	 		"  Name VARCHAR(15) NULL,\r\n" + 
	 		"  Address VARCHAR(100) NULL,\r\n" + 
	 		"  PhoneNumber VARCHAR(20) NULL,\r\n" + 
	 		"  Emali VARCHAR(45) NULL,\r\n" + 
	 		"  Major VARCHAR(20) NULL,\r\n" +
	 		"  minor VARCHAR(20) NULL,\r\n" +
	 		"  AccountNumber VARCHAR(20) NULL,\r\n" + 
	 		"  Professor_ProfessorID VARCHAR(10) NOT NULL COMMENT '��米��',\r\n" + 
	 		"  PRIMARY KEY (StudentID),\r\n" + 
	 		"  INDEX fk_Student_Professor_idx (Professor_ProfessorID ASC) VISIBLE,\r\n" + 
	 		"  CONSTRAINT fk_Student_Professor\r\n" + 
	 		"    FOREIGN KEY (Professor_ProfessorID)\r\n" + 
	 		"    REFERENCES Professor (ProfessorID)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION\r\n" + 
	 		");"); 
	 stmt.executeUpdate("CREATE TABLE Department (\r\n" + 
	 		"  DepartmentID VARCHAR(10) NOT NULL,\r\n" + 
	 		"  DepartmentName VARCHAR(45) NULL,\r\n" + 
	 		"  De_TelePhone VARCHAR(20) NULL,\r\n" + 
	 		"  DepartmentOffice VARCHAR(20) NULL,\r\n" + 
	 		"   `Chairperson` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  PRIMARY KEY (`DepartmentID`),\r\n" + 
	 		"  INDEX `fk_Department_Professor1_idx` (`Chairperson` ASC) VISIBLE,\r\n" + 
	 		"  CONSTRAINT `fk_Department_Professor1`\r\n" + 
	 		"    FOREIGN KEY (`Chairperson`)\r\n" + 
	 		"    REFERENCES `Professor` (`ProfessorID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION\r\n" + 
	 		");"); 
	 stmt.executeUpdate("CREATE TABLE Course (\r\n" + 
	 		"`CourseID` VARCHAR(10) NOT NULL COMMENT '���¹�ȣ',\r\n" + 
	 		"  `Class` INT NOT NULL COMMENT '�й�\\n',\r\n" + 
	 		"  `ProfessorID` VARCHAR(10) NOT NULL COMMENT '�����ϴ� ����',\r\n" + 
	 		"  `CourseName` VARCHAR(20) NOT NULL COMMENT '�����̸�\\n',\r\n" + 
	 		"  Day VARCHAR(10) NOT NULL COMMENT '���ǿ���\\n',\r\n" + 
	 		"  `ClassTime` VARCHAR(10) NOT NULL COMMENT '���Ǳ��� 13:00~15:00',\r\n" + 
	 		"  `Credit` INT NOT NULL COMMENT '����(1~4)',\r\n" + 
	 		"  `LectureTime` INT NOT NULL COMMENT '���½ð�(1~6)\\n',\r\n" + 
	 		"  `Department` VARCHAR(10) NOT NULL COMMENT '�����а�',\r\n" + 
	 		"  `Room` VARCHAR(10) NOT NULL COMMENT '���ǽ�',\r\n" + 
	 		"  `G_S` VARCHAR(10) NOT NULL COMMENT '�г�/�б�',\r\n" + 
	 		"  PRIMARY KEY (`CourseID`),\r\n" + 
	 		"  CHECK(`Credit`>=1 and `Credit` <=4),\r\n" + 
	 		"  CHECK(`LectureTime`>=1 and `LectureTime` <=6)\r\n" + 
	 		");"); 
	 stmt.executeUpdate("CREATE TABLE CourseDetails (\r\n" + 
	 		"  `StudentID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `CourseID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `ProfessorID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `AttendanceScore` INT NULL COMMENT '�⼮����',\r\n" + 
	 		"  `MidScore` INT NULL,\r\n" + 
	 		"  `FinalScore` INT NULL,\r\n" + 
	 		"  `OtherScore` INT NULL COMMENT '��Ÿ����',\r\n" + 
	 		"  `TotalScore` INT NULL,\r\n" + 
	 		"  `Grade` VARCHAR(3) NULL COMMENT '����(����)A+,B..',\r\n" + 
	 		"   PaymentStatus VARCHAR(15) ,\r\n" + 
	 		"  PRIMARY KEY (`StudentID`, `CourseID`, `ProfessorID`),\r\n" + 
	 		"  INDEX `fk_CourseDetails_Student1_idx` (`StudentID` ASC) VISIBLE,\r\n" + 
	 		"  INDEX `fk_CourseDetails_Course1_idx` (`CourseID` ASC) VISIBLE,\r\n" + 
	 		"  INDEX `fk_CourseDetails_Professor1_idx` (`ProfessorID` ASC) VISIBLE,\r\n" + 
	 		"  CONSTRAINT `fk_CourseDetails_Student1`\r\n" + 
	 		"    FOREIGN KEY (`StudentID`)\r\n" + 
	 		"    REFERENCES `Student` (`StudentID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION,\r\n" + 
	 		"  CONSTRAINT `fk_CourseDetails_Course1`\r\n" + 
	 		"    FOREIGN KEY (`CourseID`)\r\n" + 
	 		"    REFERENCES `Course` (`CourseID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION,\r\n" + 
	 		"  CONSTRAINT `fk_CourseDetails_Professor1`\r\n" + 
	 		"    FOREIGN KEY (`ProfessorID`)\r\n" + 
	 		"    REFERENCES `Professor` (`ProfessorID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION,\r\n" + 
	 		"	 CHECK(`TotalScore`>=0 and `TotalScore` <=100),\r\n" +
	 		" CHECK(`Grade`='A+' or `Grade`='A' or `Grade`='B+' or `Grade`='B' or `Grade`='C+' or `Grade`='C' or `Grade`='D+' or `Grade`='D' or `Grade`='F')"+
	 		");"); 
	 stmt.executeUpdate("CREATE TABLE Clup (\r\n" + 
	 		"  `ClupID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `ClupName` VARCHAR(15) NULL,\r\n" + 
	 		"  `Personnel` VARCHAR(10) NULL COMMENT '�ο�(�л���)',\r\n" + 
	 		"  `StudentID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `ProfessorID` VARCHAR(10) NULL COMMENT '��������',\r\n" + 
	 		"  `Room` VARCHAR(10) NULL,\r\n" + 
	 		"  PRIMARY KEY (`ClupID`),\r\n" + 
	 		"  INDEX `fk_Clup_Student1_idx` (`StudentID` ASC) VISIBLE,\r\n" + 
	 		"  CONSTRAINT `fk_Clup_Student1`\r\n" + 
	 		"    FOREIGN KEY (`StudentID`)\r\n" + 
	 		"    REFERENCES `Student` (`StudentID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION\r\n" + 
	 		");"); 
	 stmt.executeUpdate("CREATE TABLE TuitionDetails (\r\n" + 
	 		"`StudentID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `TuitionPaymentYear` VARCHAR(5) NULL COMMENT '��ϱ� ���� ����',\r\n" + 
	 		"  `TuitionPaymentSemester` VARCHAR(5) NULL COMMENT '��ϱݳ����б�',\r\n" + 
	 		"  `TotalTuition` INT NULL COMMENT '��ϱ��Ѿ�',\r\n" + 
	 		"  `TotalAmountPaid` INT NULL COMMENT '�����Ѿ�',\r\n" + 
	 		"  `LastPaymentDate` DATE NULL COMMENT '������ ��������',\r\n" + 
	 		" \r\n" + 
	 		"  INDEX `fk_TuitionDetails_Student1_idx` (`StudentID` ASC) VISIBLE,\r\n" + 
	 		"  PRIMARY KEY (`StudentID`),\r\n" + 
	 		"  CONSTRAINT `fk_TuitionDetails_Student1`\r\n" + 
	 		"    FOREIGN KEY (`StudentID`)\r\n" + 
	 		"    REFERENCES `Student` (`StudentID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION\r\n" + 
	 		");"); 
	 stmt.executeUpdate("CREATE TABLE Student_has_Professor (\r\n" + 
	 		"  `Student_StudentID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `Professor_ProfessorID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `Grade/Semester` VARCHAR(10) NULL,\r\n" + 
	 		"  PRIMARY KEY (`Student_StudentID`, `Professor_ProfessorID`),\r\n" + 
	 		"  INDEX `fk_Student_has_Professor_Professor1_idx` (`Professor_ProfessorID` ASC) VISIBLE,\r\n" + 
	 		"  INDEX `fk_Student_has_Professor_Student1_idx` (`Student_StudentID` ASC) VISIBLE,\r\n" + 
	 		"  CONSTRAINT `fk_Student_has_Professor_Student1`\r\n" + 
	 		"    FOREIGN KEY (`Student_StudentID`)\r\n" + 
	 		"    REFERENCES `Student` (`StudentID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION,\r\n" + 
	 		"  CONSTRAINT `fk_Student_has_Professor_Professor1`\r\n" + 
	 		"    FOREIGN KEY (`Professor_ProfessorID`)\r\n" + 
	 		"    REFERENCES `Professor` (`ProfessorID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION\r\n" + 
	 		");"); 
	 stmt.executeUpdate("CREATE TABLE Student_has_Clup (\r\n" + 
	 		"`Student_StudentID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  `Clup_ClupID` VARCHAR(10) NOT NULL,\r\n" + 
	 		"  PRIMARY KEY (`Student_StudentID`, `Clup_ClupID`),\r\n" + 
	 		"  INDEX `fk_Student_has_Clup_Clup1_idx` (`Clup_ClupID` ASC) VISIBLE,\r\n" + 
	 		"  INDEX `fk_Student_has_Clup_Student1_idx` (`Student_StudentID` ASC) VISIBLE,\r\n" + 
	 		"  CONSTRAINT `fk_Student_has_Clup_Student1`\r\n" + 
	 		"    FOREIGN KEY (`Student_StudentID`)\r\n" + 
	 		"    REFERENCES `Student` (`StudentID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION,\r\n" + 
	 		"  CONSTRAINT `fk_Student_has_Clup_Clup1`\r\n" + 
	 		"    FOREIGN KEY (`Clup_ClupID`)\r\n" + 
	 		"    REFERENCES Clup (`ClupID`)\r\n" + 
	 		"    ON DELETE NO ACTION\r\n" + 
	 		"    ON UPDATE NO ACTION\r\n" + 
	 		");"); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(1, '���⼮', '���� Ư����', '010-7235-8853','rltj2r@gmail.com',10);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(2, '�̹���', '��� ����', '010-3742-8932','alswns@gmail.com',20);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(3, '���ؼ�', '��õ', '010-7434-2633','wnstj@gmail.com',30);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(4, '�̿���', '��õ', '010-2995-2484','dPwns@gmail.com',40);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(5, '�ֵ���', '��⵵ ������', '010-1284-6743','ehdbs@gmail.com',50);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(6, '��ÿ�', '��⵵ ����', '010-1288-9854','tldn@gmail.com',60);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(7, '���ֿ�', '��⵵ ���ν�', '010-3182-1285','wndnjs@gmail.com',70);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(8, '������', '��û�ϵ� û�ֽ�', '010-6793-9673','gkwns@gmail.com',80);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(9, '����ȣ', '��⵵ �����ֽ�', '010-3322-5552','wlgh@gmail.com',90);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(10, '�輭��', '����ϵ� ���ֽ�', '010-1298-8843','tjgus@gmail.com',100);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(11, '������', '��û���� õ�Ƚ�', '010-8633-2679','gkdms@gmail.com',110);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(12, '������', '��û���� õ�Ƚ�', '010-8543-3262','wlals@gmail.com',120);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(13, '������', '��⵵ �Ȼ��', '010-2052-5232','dmstj@gmail.com',130);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(14, '�̿���', '��⵵ �Ⱦ��', '010-1222-3743','dPdms@gmail.com',140);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(15, '�����', '��󳲵� ���ؽ�', '010-8643-8532','dnwls@gmail.com',150);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(16, '�ڰǿ�', '��⵵ ���ý�', '010-9743-2222','rjsdn@gmail.com',160);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(17, '������', '���ϵ� ���׽�', '010-7453-1236','tldns@sejong.com',170);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(18, '������', '����Ư�����ֽ�', '010-8655-1272','dmsdn@sejong.com',180);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(19, '����ȯ', '��⵵ �����', '010-1283-7463','wlghks@naver.com',190);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(20, '����', '��⵵ ���ֽ�', '010-8655-8425','dbsdnn@yahoo.com',200);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(21, '���ؿ�', '��⵵ �����ν�', '010-1262-9753','wnsdud@gmail.com',210);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(22, '�����', '��⵵ �ϳ���', '010-8452-6244','alswl@gmail.com',220);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(23, '�谡��', '���󳲵� ������', '010-5214-1251','rkdms@gmail.com',230);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(24, '���缮', '���󳲵� ��õ��', '010-5523-1235','wotjr@gmail.com',240);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Professor VALUES(25, '���½�', '���� Ư����', '010-7235-8853','e1Q@naver.com',250);\r\n" + 
	 		""); 
	 
	 stmt.executeUpdate("INSERT INTO Student VALUES(1, '������', '���� Ư����', '010-7235-8853','rltaajr@gmail.com','10','20','110414861280','1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(2, '�輭��', '��� ����', '010-3742-8932','alswns@gmail.com',10,'NULL','11041486450','2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(3, '�ε���', '��õ', '010-7434-2633','wnstj@gmail.com',20,'20','1107435250', '3');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(4, '�̽ÿ�', '��õ', '010-2995-2484','dPwns@gmail.com',20,'20','660414861280', '4');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(5, '�ֿ���', '��⵵ ������', '010-1284-6743','ehdbs@gmail.com',30,'20','1266734280', '5');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(6, '��', '��⵵ ����', '010-1288-9854','tldn@gmail.com',30,'20','121231235', '6');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(7, '������', '��⵵ ���ν�', '010-3182-1285','wndnjs@gmail.com',30,'20','33330393312', '7');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(8, '������', '��û�ϵ� û�ֽ�', '010-6793-9673','gkwns@gmail.com',30,'20','353039633312', '8');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(9, '�̽���', '��⵵ �����ֽ�', '010-3322-5552','wlgh@gmail.com',40,'20','37530333312', '9');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(10, '���', '����ϵ� ���ֽ�', '010-1298-8843','tjgus@gmail.com',50,'20','414884533334', '1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(11, '�ֱԹ�', '��û���� õ�Ƚ�', '010-8633-2679','gkdms@gmail.com',20,'20','126363422224', '11');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(12, '�⵵��', '��û���� õ�Ƚ�', '010-8543-3262','wlals@gmail.com',30,'20','12512612323', '12');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(13, '������', '��⵵ �Ȼ��', '010-2052-5232','dmstj@gmail.com',40,'20','12512612552', '13');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(14, '�̼���', '��⵵ �Ⱦ��', '010-1222-3743','dPdms@gmail.com',50,'20','885545344423', '14');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(15, '���ȯ', '��󳲵� ���ؽ�', '010-8643-8532','dnwls@gmail.com',50,'20','1263237744', '15');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(16, '������', '��⵵ ���ý�', '010-9743-2222','rjsdn@gmail.com',40,'20','1263588323', '16');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(17, '���¹�', '���ϵ� ���׽�', '010-7453-1236','tldns@sejong.com',30,'20','7884443242', '17');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(18, '���϶�', '����Ư�����ֽ�', '010-8655-1272','dmsdn@sejong.com',30,'20','6185525943', '18');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(19, '���α�', '��⵵ �����', '010-1283-7463','wlghks@naver.com',20,'20','7464467984', '19');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(20, '������', '��⵵ ���ֽ�', '010-8655-8425','dbsdnn@yahoo.com',20,'20','7600446743', '20');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(21, '������', '��⵵ �����ν�', '010-1262-9753','wnsdud@gmail.com',10,'20','86844235343', '21');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(22, '�����', '��⵵ �ϳ���', '010-8452-6244','alswl@gmail.com',30,'20','88854545343', '22');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(23, '�赵��', '���󳲵� ������', '010-5214-1251','rkdms@gmail.com',40,'20','844535434', '23');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(24, '����ȣ', '���󳲵� ��õ��', '010-5523-1235','wotjr@gmail.com',40,'NULL','753453523', '1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(25, '�����', '���� Ư����', '010-7235-8853','e1Q@naver.com',20,'NULL','1261261245', '25');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(26, '���½�', '���� Ư����', '010-735-8853','e1Q@naver.com',10,'NULL','1261262245', '1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student VALUES(27, '�̼���', '���� Ư����', '010-735-8853','e1Q@naver.com',10,'NULL','1261262245', '1');\r\n" + 
		 		""); 
	 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(1,1,'1/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(10,1,'1/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(24,1,'1/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(26,1,'1/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(2,2,'1/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(3,3,'2/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(4,4,'2/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(5,5,'4/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(6,6,'4/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(7,7,'4/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(8,8,'4/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(9,9,'3/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(10,10,'3/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(11,11,'1/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(12,12,'1/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(13,13,'2/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(14,14,'3/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(15,15,'3/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(16,16,'4/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(17,17,'3/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(18,18,'3/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(19,19,'3/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(20,20,'4/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(21,21,'1/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(22,22,'1/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(23,23,'1/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(24,24,'3/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES(25,25,'2/2');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(10,'��ǻ�Ͱ��а�','02-235-4423','��B302',2);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(20,'�����ͻ��̾��а�','02-745-6623','��B108',1);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(30,'����Ʈ�����а�','02-2345-6696','��B405',3);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(40,'������ȣ�а�','02-8535-4553','��B501',4);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(50,'���ɱ������к�','02-935-7723','��B503',5);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(60,'â�Ǽ���Ʈ�к�','02-8855-4773','��B302',6);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(70,'������к�','02-895-9923','��B108',7);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(80,'�Ǽ�ȯ����а�','02-9045-6696','��B405',8);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(90,'ȯ�濡�����������հ�','02-5035-4553','��B501',9);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(100,'�����ڿ��ý��۰��а�','02-6045-7723','��B503',10);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(110,'����װ����ְ��к�','02-6665-5573','��B302',11);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(120,'����ż�����а�','02-7445-2323','��B108',12);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(130,'���ڿ��ڷ°��а�','02-4445-7896','��B405',13);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(140,'����ý��۰��а�','02-1025-6053','��B501',14);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(150,'�װ��ý��۰��а�','02-205-2323','��B503',15);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(160,'��������к�','02-993-4478','��B302',16);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(170,'����õ���а�','02-339-6553','��B108',17);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(180,'ȭ�а�','02-3325-5956','��B405',18);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(190,'����ý����к�','02-535-8953','��B501',19);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(200,'����������Ű��а�','02-2535-7883','��B503',20);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(210,'���к�','02-1335-2223','��B503',21);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(220,'������а�','02-5535-9903','��B503',22);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(230,'�����к�','02-905-7993','��B503',23);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(240,'�����а�','02-945-7333','��B503',24);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Department VALUES(250,'�����а�','02-925-7883','��B503',25);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00101',1,'1', 'C���α׷���','��','1����',2,2,'��ǻ�Ͱ��а�','��B303','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00201',1,'1', '�����ͺ��̽�','��','5����',2,2,'��ǻ�Ͱ��а�','��B303','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('10202',1,'1', '���ȵ�����','��','9����',2,2,'��ǻ�Ͱ��а�','��B303','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('01114',3,'1', '�������        ','��','4����',2,2,'����ý��۰��а�','��B366','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('01110',4,'1', '�׷��ȵ�����','��','10����',2,2,'�����ڿ��ý��۰��а�','��B834','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('01108',2,'1', '��ǻ�ͳ�Ʈ��ũ','��','4����',2,2,'�Ǽ�ȯ����а�','��B353','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('01112',3,'1', '����ó��         ','ȭ','16����',2,2,'����ż�����а�','��B632','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('01117',3,'1', 'JAVA���α׷���','ȭ','13����',2,2,'����õ���а�','��B113','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('01115',4,'1', '��ǻ�ͱ���','��','2����',2,2,'�װ��ý��۰��а�','��B523','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00102',3,'2', '����ŷ������','ȭ','4����',2,2,'�����ͻ��̾��а�','��B503','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00103',2,'3', '��ĪŰ��ȣ��','��','7����',2,2,'����Ʈ�����а�','��B403','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00104',3,'4', '�������','��','10����',2,2,'������ȣ�а�','��B703','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00105',4,'5', '����Ű��ȣ��','��','13����',2,2,'���ɱ������к�','��B263','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00106',1,'6', '������������','��','16����',2,2,'â�Ǽ���Ʈ�к�','��B103','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00107',3,'7', '�Ӻ����ý��ۺ���','ȭ','1����',2,2,'������к�','��B113','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00108',2,'8', '��ǻ�ͳ�Ʈ��ũ','��','4����',2,2,'�Ǽ�ȯ����а�','��B353','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00109',3,'9', 'C���α׷���','��','7����',2,2,'ȯ�濡�����������հ�','��B407','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00110',4,'10', '�׷��ȵ�����','��','10����',2,2,'�����ڿ��ý��۰��а�','��B834','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00111',1,'11', 'ĸ���������','��','13����',2,2,'����װ����ְ��к�','��B373','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00112',3,'12', '����ó��          ','ȭ','16����',2,2,'����ż�����а�','��B632','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00113',2,'13', 'HCI����        ','��','1����',2,2,'���ڿ��ڷ°��а�','��B623','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00114',3,'14', '�������       ','��','4����',2,2,'����ý��۰��а�','��B366','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00115',4,'15', '��ǻ�ͱ���','��','7����',2,2,'�װ��ý��۰��а�','��B523','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00116',1,'16', '�ü��       ','��','10����',2,2,'��������к�','��B821','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00117',3,'17', 'JAVA���α׷���','ȭ','13����',2,2,'����õ���а�','��B113','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00118',2,'18', '��������        ','��','16����',2,2,'ȭ�а�','��B223','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00119',3,'19', '��ġ�ؼ�        ','��','1����',2,2,'����ý����к�','��B333','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00120',4,'20', 'C���α׷���','��','4����',2,2,'����������Ű��а�','��B443','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00121',1,'21', 'C���α׷���','��','7����',2,2,'���к�','��B553','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00122',3,'22', '���C���α׷���','ȭ','10����',2,2,'������а�','��B663','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00123',2,'23', 'C���α׷���','��','13����',2,2,'�����к�','��B853','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00124',3,'24', 'C���α׷���','��','16����',2,2,'�����а�','��B903','2020/1');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00125',4,'25', 'C���α׷���','��','1����',2,2,'�����а�','��B103','2020/1');\r\n" + 
	 		""); 
	 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00126',4,'3', '����� ����','��','1����',2,2,'���а�      ','��B103','2020/1');\r\n" + 
		 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00127',4,'3', '�ι���Ģ     ','ȭ','4����',2,2,'���а�      ','��B103','2020/1');\r\n" + 
		 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00128',4,'3', '�����ѷ�     ','��','2����',2,2,'���а�      ','��B103','2020/1');\r\n" + 
		 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00129',4,'3', '�������ǹ�','��','10����',2,2,'���а�      ','��B103','2020/1');\r\n" + 
		 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00130',4,'3', '�ٷκ�ȣ��','��','3����',2,2,'���а�      ','��B103','2020/1');\r\n" + 
		 		""); 
	 stmt.executeUpdate("INSERT INTO Course VALUES('00131',4,'3', '�۾���        ','��','5����',2,2,'���а�      ','��B103','2020/1');\r\n" + 
		 		""); 
	 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(1,'00101',1,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(2,'00101',1,10,30,30,10,80,'B+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(3,'00101',1,10,30,30,20,90,'A',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(1,'00102',2,10,10,10,30,60,'D',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(1,'00103',3,10,0,30,30,70,'C+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(1,'00201',2,10,10,10,30,60,'D',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(1,'10202',3,10,0,30,30,70,'C+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(26,'00102',2,10,0,2,3,15,'F',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(26,'00103',1,10,0,4,3,17,'F',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(26,'00201',1,10,0,10,0,23,'F',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(26,'10202',1,10,0,22,0,32,'D',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(2,'00102',2,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(3,'00103',3,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(4,'00104',4,10,30,30,30,100,'A+','��ϱ� �̳�');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(5,'00105',5,10,30,30,30,100,'A+','��ϱ� �̳�');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(6,'00106',6,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(7,'00107',7,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(8,'00108',8,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(9,'00109',9,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(10,'00110',10,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(11,'00111',11,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(12,'00112',12,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(13,'00113',13,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(14,'00114',14,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(15,'00115',15,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(16,'00116',16,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(17,'00117',17,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(18,'00118',18,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(19,'00119',19,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(20,'00120',20,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(21,'00121',21,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(22,'00122',22,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(23,'00123',23,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(24,'00124',24,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(25,'00125',25,10,30,30,30,100,'A+',NULL);\r\n" + 
	 		""); 
	 
	 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(27,'00126',19,10,30,30,30,100,'A+',NULL);\r\n" + 
		 		""); 
		 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(27,'00127',20,10,30,30,30,100,'A+',NULL);\r\n" + 
		 		""); 
		 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(27,'00128',21,10,30,30,30,100,'A+',NULL);\r\n" + 
		 		""); 
		 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(27,'00129',22,10,30,30,30,100,'A+',NULL);\r\n" + 
		 		""); 
		 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(27,'00130',23,10,30,30,20,100,'A',NULL);\r\n" + 
		 		""); 
		 stmt.executeUpdate("INSERT INTO CourseDetails VALUES(27,'00131',24,10,30,30,30,100,'A+',NULL);\r\n" + 
		 		""); 
		
	 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(1,'SSG',3,1,1,'��B101');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(2,'����',3,2,1,'��B102');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(3,'����',3,7,1,'��B103');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(4,'����',3,7,1,'��B104');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(5,'����',3,5,1,'��B105');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(6,'�ŵ�',3,6,1,'��B106');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(7,'������',3,7,1,'��B107');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(8,'�̳�',3,8,1,'��B108');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(9,'�̶�',3,9,1,'��B109');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(10,'�ٴ�',3,10,1,'��B110');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(11,'���̳�',3,11,1,'��B111');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(12,'����',3,12,1,'��B112');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(13,'�η�',3,13,1,'��B113');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(14,'������',3,14,1,'��B114');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(15,'����',3,15,1,'��B115');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(16,'������',3,16,1,'��B116');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(17,'��',3,17,1,'��B117');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(18,'����',3,18,1,'��B118');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(19,'����',3,19,1,'��B119');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(20,'����',3,20,1,'��B120');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(21,'����',3,21,1,'��B121');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(22,'����',3,22,1,'��B122');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(23,'����',3,23,1,'��B123');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(24,'����',3,24,1,'��B124');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Clup VALUES(25,'����',3,25,1,'��B125');\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(2,2);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,1);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,2);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,3);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,4);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,5);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,6);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,7);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,8);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,9);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,10);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,11);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,12);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,13);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,14);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,15);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,16);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,17);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,18);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,19);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,20);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,21);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,22);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,23);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,24);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(1,25);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(9,1);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(2,1);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(3,1);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(4,2);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(5,2);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(6,2);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(7,2);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(8,2);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(5,5);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(6,6);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(7,7);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(8,8);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(9,9);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(10,10);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(11,11);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(12,12);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(13,13);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(14,14);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(15,15);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(16,16);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(17,17);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(18,18);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(19,19);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(20,20);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(21,21);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(22,22);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(23,23);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(24,24);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES(25,25);\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(1,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(2,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(3,2020,1,4000000,3000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(4,2020,1,4000000,3000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(5,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(6,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(7,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(8,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(9,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(10,2020,1,4000000,3000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(11,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(12,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(13,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(14,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(15,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(16,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(17,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(18,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(19,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(20,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(21,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(22,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(23,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(24,2020,1,4000000,4000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES(25,2020,1,4000000,3000000,STR_TO_DATE('2020-07-10','%Y-%m-%d'));\r\n" + 
	 		""); 
	 stmt.executeUpdate("UPDATE tuitiondetails t, coursedetails c \r\n" + 
	 		"SET c.PaymentStatus='��ϱݹ̳�' \r\n" + 
	 		"WHERE (t.TotalTuition > t.TotalAmountPaid) and c.studentID=t.studentID;\r\n" + 
	 		"");
	 stmt.executeUpdate("commit"); 
	 } catch (SQLException e) {
			// TODO �ڵ� ������ catch ���
     	 txtStatus.append("���� �б� ���� :" + e+"\n");

		}
   }
   @Override
   
   public void actionPerformed(ActionEvent e) {
    
      try {
     	 stmt=con.createStatement();
     	 String pid = null;
     	 String pgs;
     	 String sid;
     	 String sgs;
         
         if (e.getSource() == btnOk) {	//������ �̵�
             panel2.setVisible(true);
             panel1.setVisible(false);
             txtResult.setText("");
             txtStatus.setText("");
         }
         else if(e.getSource()==btnOk1) {////////�����̵�
        	 model.setNumRows(0);
        	 panel3.setVisible(true);
             panel1.setVisible(false);
             txtResult.setText("");
             txtStatus.setText("");
         }
         else if(e.getSource()==btnOk2) {//////// �л� �̵�
        	 
        	 panel4.setVisible(true);
             panel1.setVisible(false);
             txtResult.setText("");
             txtStatus.setText("");
         }
         else if(e.getSource()==btnNewButton) {  //������ �ʱ�ȭ
        	 
        	datainit();
        
         }
         else if(e.getSource()==btnNewButton_4) {
        	 txtResult.setText("");
        	 txtResult.append("			�л� ���̺�\n\n");
        	 txtResult.append("StudentID	Name	Address		PhoneNumber		Email		Major	Minor	AccountNumber	ProfessorID\n");
        	 rs=stmt.executeQuery("SELECT * FROM student");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t\t" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t" +rs.getString(8)+"\t\t"+rs.getString(9)+"\n";
        		 txtResult.append(str2);
        	 }

        	 txtResult.append("\n			���� ���̺�\n\n");
        	 txtResult.append("ProfessorID	Name	Address		PhoneNumber		Email		DepartmentNumber\n");
        	 rs=stmt.executeQuery("SELECT * FROM professor");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t\t" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t" +rs.getString(6)+"\n";
        		 txtResult.append(str2);
        	 }
        	 
        	 txtResult.append("\n			�а� ���̺�\n\n");
        	 txtResult.append("DepartmentID	departmentName	De_TelePhone		departmentOffice	ChairpersonID\n");
        	 rs=stmt.executeQuery("SELECT * FROM department");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "	" +rs.getString(2)+ "                	" +rs.getString(3)+"		" +rs.getString(4)+"		" +rs.getString(5)+"\n";
        		 txtResult.append(str2);
        	 }
        	 
        	 txtResult.append("\n			���� ���̺�\n\n");
        	 txtResult.append("CourseID	Class	ProfessorID	CourseName	 	  Day	ClassTime	Credit	LectureTime	Department		Room	����/�б�\n");
        	 rs=stmt.executeQuery("SELECT * FROM course");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+" \t" +rs.getString(3)+"\t" +rs.getString(4)+"         \t" +rs.getString(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t" +rs.getString(8)+
        				 "\t" +rs.getString(9)+"                \t" +rs.getString(10)+"\t" +rs.getString(11)+"\n";
        		 txtResult.append(str2);
        	 }
        	 
        	 txtResult.append("\n			�������� ���̺�\n\n");
        	 txtResult.append("StudentID	CourseID	ProfessorID	AttendanceScore	MidScore	FinalScore	OtherScore	TotalScore	Grade	PaymentStatus\n");
        	 rs=stmt.executeQuery("SELECT * FROM coursedetails");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t" +rs.getString(8)+"\t" +rs.getString(9)+"\t" +rs.getString(10)+"\n";
        		 txtResult.append(str2);
        	 }
        	 
        	 txtResult.append("\n			���Ƹ� ���̺�\n\n");
        	 txtResult.append("ClupID	ClupName	Personnel	StudentID(�л�ȸ��)	ProfessorID(��米��)	Romm\n");
        	 rs=stmt.executeQuery("SELECT * FROM clup");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t\t" +rs.getString(6)+"\n";
        		 txtResult.append(str2);
        	 }
        	 
        	 txtResult.append("\n				Ŭ�� ID�� Student ID ���̺�\n\n");
        	 txtResult.append("Student_StudentID	Clup_ClupID\n");
        	 rs=stmt.executeQuery("SELECT *\r\n" + 
        	 		"FROM student_has_clup;");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "	\t" +rs.getString(2)+"\n";
        		 txtResult.append(str2);
        	 }
        	 
        	 txtResult.append("\n				�л��� �������� ���� ���̺�\n\n");
        	 txtResult.append("Student_StudentID	Professor_ProfessorID	Grade/Semester\n");
        	 rs=stmt.executeQuery("select *\r\n" + 
        	 		"from student_has_professor;;");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "	\t" +rs.getString(2)+"	\t"+rs.getString(3)+"\n";
        		 txtResult.append(str2);
        	 }
        	 
        	 txtResult.append("\n			��ϱ� ���� ���� ���̺�\n\n");
        	 txtResult.append("StudentID	TuitionPaymentYear	TuitionPaymentSemester		TotalTuition		TotalAmountPaid	LastPaymentDate\n");
        	 rs=stmt.executeQuery("select *\r\n" + 
        	 		"from tuitiondetails;");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t		" +rs.getString(3)+"\t	" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t\t" +rs.getString(6)+"\n";
        		 txtResult.append(str2);
        	 }
        	 
         }else if(e.getSource()==btnNewButton_9) { //////////////�Ҽӵ� �а� !���
        	 txtStatus.setText("");
        	 pid = textField_2.getText();
        	 rs=stmt.executeQuery("SELECT d2.Chairperson FROM professor p2, department d2 WHERE p2.professorID ="+pid+" and p2.DepartmentNumber = d2.DepartmentID");
        	 rs.next();
        	 pid=rs.getString(1);
        	 rs=stmt.executeQuery("SELECT * FROM department d,professor p WHERE d.Chairperson = p.professorID and p.professorID = "+pid);

        	 txtStatus.append("\n				�Ҽӵ� �а� �� �а��� ���\n\n");
        	 txtStatus.append("DepartmentID	departmentName	De_TelePhone		departmentOffice	ChairpersonID(�а�����̵�)\n");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "	" +rs.getString(2)+ "                	" +rs.getString(3)+"		" +rs.getString(4)+"		" +rs.getString(5)+"\n";
        		 txtStatus.append(str2);
        		 txtStatus.append("ProfessorID	Name	Address		PhoneNumber		Email		DepartmentNumber\n");
        		 str2=rs.getString(6)+ "\t" +rs.getString(7)+"\t" +rs.getString(8)+"\t\t" +rs.getString(9)+"\t\t" +rs.getString(10)+"\t" +rs.getString(11);
        		 txtStatus.append(str2);
        	 }

         }
         else if(e.getSource()==btnNewButton_16) { ///////////�л��α���
        	 sid = textField_3.getText();
        	 txtStatus.append("�л� ID:"+sid+" �α��� �Ϸ�\n");
         }
         else if(e.getSource()==btnNewButton_11) {  //�л� ID + �г�/�б� �� ���� ���̺�~~~~~~~~~~
        	 sid = textField_3.getText();
        	 sgs = textField_1.getText();
        	 txtResult.setText("");
        	 txtResult.append("					"+sgs+"�� �����ߴ� ���̺�\n\n");
        	
        	 txtResult.append("CourseID	Class	ProfessorID	CourseName	 	  Day	ClassTime	Credit	LectureTime	Department		Room	����/�б�\n");
        	 rs=stmt.executeQuery("SELECT c.*\r\n" + 
         	 		"FROM coursedetails cd, course c\r\n" + 
         	 		"WHERE cd.studentID = "+sid+" and cd.CourseID= c.CourseID and c.G_S="+sgs+";");
         
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+" \t" +rs.getString(3)+"\t" +rs.getString(4)+"         \t" +rs.getString(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t" +rs.getString(8)+
        				 "\t" +rs.getString(9)+"                \t" +rs.getString(10)+"\t" +rs.getString(11)+"\n";
        		 txtResult.append(str2);
        	 }
         }else if(e.getSource()==btnNewButton_13) { //���� ���Ƹ� ��ȸ~~~~~~~~~~~
        	 sid = textField_3.getText();
        	 sgs = textField_1.getText();
        	 txtResult.setText("");
        	 
        	 txtResult.append("\n			���Ƹ� ���̺�\n\n");
        	 txtResult.append("ClupID	ClupName	Personnel	StudentID(�л�ȸ��)	ProfessorID(��米��)	Romm\n");
        	 rs=stmt.executeQuery("SELECT c.*\r\n" + 
        	 		"FROM clup c, student_has_clup sc\r\n" + 
        	 		"WHERE	sc.Student_StudentID="+sid+" and sc.Clup_ClupID=c.clupID;");
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t\t" +rs.getString(6)+"\n";
        		 txtResult.append(str2);
        	 }
        	 try {
        	 rs=stmt.executeQuery("SELECT c.StudentID,c.ClupID\r\n" + 
        	 		"FROM clup c\r\n" + 
        	 		"WHERE c.StudentID="+sid+";\r\n" + 
        	 		"");
        	 rs.next();
        	 String a=rs.getString(1);//�л���ǥID����
        	 String b=rs.getString(2);//�ش� Ŭ�� ID����
        	
        	 if(sid.equals(a)) {
        		 txtResult.append("\n\n			���Ƹ�ID: "+b+" �� �л� ȸ���̹Ƿ� �ش� ���Ƹ� �Ҽ� �л� ���̺� ��ȸ\n\n");
            	 txtResult.append("StudentID	Name	Address		PhoneNumber		Email		Major	AccountNumber	ProfessorID\n");
            	 rs=stmt.executeQuery("SELECT s.*\r\n" + 
            	 		"FROM student_has_clup sc,student s\r\n" + 
            	 		"WHERE sc.clup_ClupID="+b+" and s.studentId = sc.student_StudentID;");
            	 while(rs.next()) {
            		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t\t" +rs.getString(4)+"\t\t" +rs.getString(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t\t" +rs.getString(8)+"\n";
            		 txtResult.append(str2);
            	 }
        	 }
        	 }catch (Exception e2) {
           	  
        		 txtResult.append("\n�ش� �л��� �л�ȸ���� ���Ƹ��� �����ϴ�\n");
        	 }
         }else if(e.getSource()==btnNewButton_14) {		///�л� ��忡�� ������ȸ
        	 sid = textField_3.getText();
        	 sgs = textField_1.getText();
        	 txtResult.setText("");
        	 txtResult.append("\n			����ǥ ���̺�\n\n");
        	 rs=stmt.executeQuery("SELECT name\r\n" + 
        	 		"FROM student\r\n" + 
        	 		"WHERE studentID= "+sid+";");
        	 rs.next();
        	 txtResult.append("�̸�: "+rs.getString(1)+"\n");

        	 txtResult.append("CourseID	Class	ProfessorID	CourseName	 	  Day	ClassTime	Credit	LectureTime	Department		Room	����/�б�	Grade\n");
        	 rs=stmt.executeQuery("SELECT c.*, cd.Grade\r\n" + 
        	 		"FROM coursedetails cd, course c\r\n" + 
        	 		"WHERE cd.StudentID="+sid+" and c.CourseID = cd.CourseID;");
        	 int cnt=0;
        	 double sum=0;
        	 while(rs.next()) {
        		 String str2=rs.getString(1)+ "\t" +rs.getString(2)+" \t" +rs.getString(3)+"\t" +rs.getString(4)+"         \t" +rs.getString(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t" +rs.getString(8)+
        				 "\t" +rs.getString(9)+"                \t" +rs.getString(10)+"\t" +rs.getString(11)+"\t" +rs.getString(12)+"\n";
        		 txtResult.append(str2);
        		 cnt++;
        		 if(rs.getString(12).equals("A+"))
        			 sum+=4.5;
        		 else if(rs.getString(12).equals("A"))
        			 sum+=4.0;
        		 else if(rs.getString(12).equals("B+"))
        			 sum+=3.5;
        		 else if(rs.getString(12).equals("B"))
        			 sum+=3.0;
        		 else if(rs.getString(12).equals("C+"))
        			 sum+=2.5;
        		 else if(rs.getString(12).equals("C"))
        			 sum+=2.0;
        		 else if(rs.getString(12).equals("D+"))
        			 sum+=1.5;
        		 else if(rs.getString(12).equals("D"))
        			 sum+=1.0;
        	 }
        	
        	 txtResult.append("���� ���(GPA) "+Double.toString(sum/cnt));
        	 
         }          else if(e.getSource()==btnNewButton_12) {///�л� ���� �ð�ǥ
        	 sid = textField_3.getText();
        	 sgs = textField_1.getText();
        	 txtStatus.setText("");
        	 String [][] table= {{"����/����\t","��\t","ȭ\t","��\t","��\t","��\t","��\t"},{"1����","","","","","",""},{"08:00~08:30","","","","","",""},{"2����","","","","","",""},{"08:30~09:00","","","","","",""}
        	 ,{"3����","","","","","",""},{"09:00~09:30","","","","","",""},{"4����","","","","","",""},{"09:30~10:00","","","","","",""}
        	 ,{"5����","","","","","",""},{"10:00~10:30","","","","","",""},{"6����","","","","","",""},{"10:30~11:00","","","","","",""}
        	 ,{"7����","","","","","",""},{"11:00~11:30","","","","","",""},{"8����","","","","","",""},{"11:30~12:00","","","","","",""}
        	 ,{"9����","","","","","",""},{"12:00~12:30","","","","","",""},{"10����","","","","","",""},{"12:30~13:00","","","","","",""}
        	 ,{"11����","","","","","",""},{"13:00~13:30","","","","","",""},{"12����","","","","","",""},{"13:30~14:00","","","","","",""}
        	 ,{"13����","","","","","",""},{"14:00~14:30","","","","","",""},{"14����","","","","","",""},{"14:30~15:00","","","","","",""}
        	 ,{"15����","","","","","",""},{"15:00~15:30","","","","","",""},{"16����","","","","","",""},{"15:30~16:00","","","","","",""}
        	 ,{"17����","","","","","",""},{"16:00~16:30","","","","","",""},{"18����","","","","","",""},{"16:30~17:00","","","","","",""}
        	 ,{"19����","","","","","",""},{"17:00~17:30","","","","","",""},{"20����","","","","","",""},{"17:30~18:00","","","","","",""}};
        	 for(int i=1;i<40;i+=2) {
            		for(int j=1;j<7;j++) {
            				table[i][j]="\t";
            				table[i+1][j]="      \t    ";    			
            		}
      		 }
        	 
        	 rs=stmt.executeQuery("SELECT c.*\r\n" + 
        	 		"FROM coursedetails cd,course c\r\n" + 
        	 		"WHERE cd.courseID=c.courseID and cd.StudentID="+sid+" and c.G_S="+sgs+";");
        	 int day,start,end,time;
        	 while(rs.next()) {
        		 if(rs.getString(5).equals("��"))
        			 day=1;
        		 else if(rs.getString(5).equals("ȭ"))
        			 day=2;
        		 else if(rs.getString(5).equals("��"))
        			 day=3;
        		 else if(rs.getString(5).equals("��"))
        			 day=4;
        		 else if(rs.getString(5).equals("��"))
        			 day=5;
        		 else 
        			 day=6;
        		 
        		 if(Character.isDigit(rs.getString(6).charAt(1)))  //��°�ڸ��� �������� 1* ����
        			 start=((rs.getString(6).charAt(0)-'0')*10+(rs.getString(6).charAt(1)-'0'))*2-1;
        		 else
        			 start=2*(rs.getString(6).charAt(0)-'0')-1;
        		 
        		 end=start+(rs.getString(8).charAt(0)-'0')*2+2;
        		 
        		 
        		
        		 for(int i=1;i<=40;i+=2) {
              		for(int j=1;j<7;j++) {
              			if(j==day && start<=i &&i<=end) {
              				table[i][j]="\t"+rs.getString(4);
              				table[i+1][j]="   \t      "+rs.getString(10);
              			}
              			
              		}
          
        		 }
        	
        	 }
        	 

        	 for(int i=0;i<41;i++) {
        		for(int j=0;j<7;j++) {
        			txtStatus.append(table[i][j]+"\t");
        		}
        		txtStatus.append("\n");
        		if(i%2==0)
            		txtStatus.append("\n");

        	}

        	
         }
         else if(e.getSource()==btnNewButton_10) {///���� �ð� ����ǥ
        	 pgs=textField.getText();
        	 pid = textField_2.getText();
        	 txtStatus.setText("");
        	 String [][] table= {{"����/����\t","��\t","ȭ\t","��\t","��\t","��\t","��\t"}
        	 ,{"1����","","","","","",""},{"08:00~08:30","","","","","",""},{"2����","","","","","",""},{"08:30~09:00","","","","","",""}
        	 ,{"3����","","","","","",""},{"09:00~09:30","","","","","",""},{"4����","","","","","",""},{"09:30~10:00","","","","","",""}
        	 ,{"5����","","","","","",""},{"10:00~10:30","","","","","",""},{"6����","","","","","",""},{"10:30~11:00","","","","","",""}
        	 ,{"7����","","","","","",""},{"11:00~11:30","","","","","",""},{"8����","","","","","",""},{"11:30~12:00","","","","","",""}
        	 ,{"9����","","","","","",""},{"12:00~12:30","","","","","",""},{"10����","","","","","",""},{"12:30~13:00","","","","","",""}
        	 ,{"11����","","","","","",""},{"13:00~13:30","","","","","",""},{"12����","","","","","",""},{"13:30~14:00","","","","","",""}
        	 ,{"13����","","","","","",""},{"14:00~14:30","","","","","",""},{"14����","","","","","",""},{"14:30~15:00","","","","","",""}
        	 ,{"15����","","","","","",""},{"15:00~15:30","","","","","",""},{"16����","","","","","",""},{"15:30~16:00","","","","","",""}
        	 ,{"17����","","","","","",""},{"16:00~16:30","","","","","",""},{"18����","","","","","",""},{"16:30~17:00","","","","","",""}
        	 ,{"19����","","","","","",""},{"17:00~17:30","","","","","",""},{"20����","","","","","",""},{"17:30~18:00","","","","","",""}};
        	 for(int i=1;i<40;i+=2) {
            		for(int j=1;j<7;j++) {
            				table[i][j]="\t";
            				table[i+1][j]="      \t    ";    			
            		}
      		 }
        	 
        	 rs=stmt.executeQuery("SELECT *\r\n" + 
         	 		"FROM course\r\n" + 
         	 		"WHERE G_S="+pgs+" and ProfessorID="+pid+";");
        	 int day,start,end;
        	 while(rs.next()) {
        		 if(rs.getString(5).equals("��"))
        			 day=1;
        		 else if(rs.getString(5).equals("ȭ"))
        			 day=2;
        		 else if(rs.getString(5).equals("��"))
        			 day=3;
        		 else if(rs.getString(5).equals("��"))
        			 day=4;
        		 else if(rs.getString(5).equals("��"))
        			 day=5;
        		 else 
        			 day=6;
        		 if(Character.isDigit(rs.getString(6).charAt(1)))  //��°�ڸ��� �������� 1* ����
        			 start=((rs.getString(6).charAt(0)-'0')*10+(rs.getString(6).charAt(1)-'0'))*2-1;
        		 else
        			 start=2*(rs.getString(6).charAt(0)-'0')-1;
        		 
        		 end=start+(rs.getString(8).charAt(0)-'0')*2+2;
        		 
        		 for(int i=1;i<=40;i+=2) {
              		for(int j=1;j<7;j++) {
              			if(j==day && start<=i &&i<=end) {
              				table[i][j]="\t"+rs.getString(4);
              				table[i+1][j]="   \t      "+rs.getString(10);
              			}
              			
              		}
          
        		 }
        	
        	 }
        	 

        	 for(int i=0;i<41;i++) {
        		for(int j=0;j<7;j++) {
        			txtStatus.append(table[i][j]+"\t");
        		}
        		txtStatus.append("\n");
        		if(i%2==0)
            		txtStatus.append("\n");

        	}

        	
        	
         }
         
         
         else if(e.getSource()==btnNewButton_15) {//���� �α���
        	 pid = textField_2.getText();
        	 
        	 txtStatus.append("���� ID:"+pid+" �α��� �Ϸ�\n");
         }
         else if(e.getSource()==btnNewButton_17) {//���� �г�/�б�        	 
        	 scrollPane_1.setVisible(true);
        	 scrollPane_4.setVisible(false);
        	 scrollPane_3.setVisible(false);

        	 pgs=textField.getText();
        	 pid = textField_2.getText();
        	 txtStatus.append("����ID:"+pid+" �г�/�б�: "+pgs+"\n");
        	 
        	 

        	 model.setNumRows(0);
        	 rs=stmt.executeQuery("SELECT *\r\n" + 
        	 		"FROM course\r\n" + 
        	 		"WHERE G_S=\""+pgs+"\" and ProfessorID=\""+pid+"\";");
      	  

        	 while(rs.next()) {
        		 String [] arr= new String[11];
        		 arr[0]=rs.getString(1);
        		 arr[1]=rs.getString(2);
        		 arr[2]=rs.getString(3);
        		 arr[3]=rs.getString(4);
        		 arr[4]=rs.getString(5);
        		 arr[5]=rs.getString(6);
        		 arr[6]=rs.getString(7);
        		 arr[7]=rs.getString(8);
        		 arr[8]=rs.getString(9);
         		 arr[9]=rs.getString(10);
         		 arr[10]=rs.getString(11);
        		 
        		 model.addRow(arr);

        	 }
        	
         }
         else if(e.getSource()==btnNewButton_18) {
        	 model.setNumRows(0);
        	 model2.setNumRows(0);
        	 model3.setNumRows(0);
        	 scrollPane_1.setVisible(false);
        	 scrollPane_4.setVisible(false);
        	 scrollPane_3.setVisible(true);

        	 pid = textField_2.getText();
        	 
        	 rs=stmt.executeQuery("SELECT s.*\r\n" + 
        	 		"FROM student_has_professor sp ,student s\r\n" + 
        	 		"WHERE sp.Student_StudentID=s.studentID and sp.Professor_ProfessorID=\""+pid+"\";\r\n" + 
        	 		"");
        	 
	
         	 while(rs.next()) {
         		 String [] arr= new String[11];
         		 arr[0]=rs.getString(1);
         		 arr[1]=rs.getString(2);
         		 arr[2]=rs.getString(3);
         		 arr[3]=rs.getString(4);
         		 arr[4]=rs.getString(5);
         		 arr[5]=rs.getString(6);
         		 arr[6]=rs.getString(7);
         		 arr[7]=rs.getString(8);
         	
         		 model2.addRow(arr);

         	 }
        	 
         }else if(e.getSource()== btnNewButton_19) {
        	 model.setNumRows(0);
        	 model2.setNumRows(0);
        	 model3.setNumRows(0);
        	 scrollPane_1.setVisible(false);
        	 scrollPane_4.setVisible(true);
        	 scrollPane_3.setVisible(false);
        	 pid = textField_2.getText();
        	 pgs=textField.getText();

        	 rs=stmt.executeQuery("SELECT s.name, c.CourseName, cd.*, c.G_S\r\n" + 
        	 		"FROM coursedetails cd, course c, student s\r\n" + 
        	 		"WHERE cd.CourseID=c.CourseID and c.professorID = "+pid+" and s.studentID = cd.studentID and c.G_S="+pgs+";");
        	 while(rs.next()) {
         		 String [] arr= new String[12];
         		 arr[0]=rs.getString(1);
         		 arr[1]=rs.getString(2);
         		 arr[2]=rs.getString(3);
         		 arr[3]=rs.getString(4);
         		 arr[4]=rs.getString(5);
         		 arr[5]=rs.getString(6);
         		 arr[6]=rs.getString(7);
         		 arr[7]=rs.getString(8);
         		 arr[8]=rs.getString(9);
         		 arr[9]=rs.getString(10);
         		 arr[10]=rs.getString(11);
         		 arr[11]=rs.getString(13); 
         		 model3.addRow(arr);
         		 
         	 }
         }else if(e.getSource()== btnNewButton_20) {
        	 for (int i=0;i<model3.getRowCount();i++) {
        		 String [] arr= new String[9];
        		 	arr[0]=(String) model3.getValueAt(i, 2);
     		 		arr[1]=(String) model3.getValueAt(i, 3);
     		 		arr[2]=(String) model3.getValueAt(i, 4);
     		 	
        		 	arr[3]=(String) model3.getValueAt(i, 5);
        		 	arr[4]=(String) model3.getValueAt(i, 6);
        		 	arr[5]=(String) model3.getValueAt(i, 7);
        		 	arr[6]=(String) model3.getValueAt(i, 8);
        		 	arr[7]=(String) model3.getValueAt(i, 9);
        		 	arr[8]=(String) model3.getValueAt(i, 10);
        		 	
        		 	stmt.executeUpdate("UPDATE coursedetails SET AttendanceScore="+arr[3]+", MidScore="+arr[4]+",FinalScore="+arr[5]+
        		 			",OtherScore="+arr[6]+",TotalScore="+arr[7]+" WHERE StudentID="+arr[0]+" and CourseID="+arr[1]+" and ProfessorID="+arr[2]+";\r\n" + 
        		 			"");
        		 	stmt.executeUpdate("UPDATE coursedetails SET Grade=\""+arr[8]+"\" WHERE StudentID="+arr[0]+" and CourseID="+arr[1]+" and ProfessorID="+arr[2]+";\r\n" + 
        		 			"");
        		 	
        	 }
        	 txtStatus.append("���� ������Ʈ�� �Ϸ� �Ǿ����ϴ�.\n");
         }else if(e.getSource()== button) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("StudentID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("Name:"));
             myPanel.add(Field2);
             myPanel.add(new JLabel("Address:"));
             myPanel.add(Field3);
             myPanel.add(new JLabel("PhoneNumber:"));
             myPanel.add(Field4);
             myPanel.add(new JLabel("Email:"));
             myPanel.add(Field5);
             myPanel.add(new JLabel("Major(����ID):"));
             myPanel.add(Field6);
             myPanel.add(new JLabel("AccountNumber:"));
             myPanel.add(Field7);
             myPanel.add(new JLabel("ProfessorID(��米��ID):"));
             myPanel.add(Field8);
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "�л� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 stmt.executeUpdate("INSERT INTO Student VALUES("+Field.getText().toString()+", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\", \""+Field4.getText().toString()+"\",\""+Field5.getText().toString()+"\",\""+Field6.getText().toString()+"\",\""+Field7.getText().toString()+"\",\""+Field8.getText().toString()+"\");\r\n" + 
            	 		"");
             } 
         }
         else if(e.getSource()== button_1) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("ProfessorID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("Name:"));
             myPanel.add(Field2);
             myPanel.add(new JLabel("Address:"));
             myPanel.add(Field3);
             myPanel.add(new JLabel("PhoneNumber:"));
             myPanel.add(Field4);
             myPanel.add(new JLabel("Email:"));
             myPanel.add(Field5);
             myPanel.add(new JLabel("DepartmentNumber:"));
             myPanel.add(Field6);
            
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "���� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 stmt.executeUpdate("INSERT INTO Professor VALUES(\""+Field.getText().toString()+"\", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\", \""+Field4.getText().toString()+"\",\""+Field5.getText().toString()+"\",\""+Field6.getText().toString()+"\");\r\n" + 
            	 		"");
             } 
         }else if(e.getSource()== button_2) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("DepartmentID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("DepartmentName:"));
             myPanel.add(Field2);
             myPanel.add(new JLabel("De_TelePhone:"));
             myPanel.add(Field3);
             myPanel.add(new JLabel("DepartmentOffice:"));
             myPanel.add(Field4);
             myPanel.add(new JLabel("Chairperson(�а���ID):"));
             myPanel.add(Field5);
             
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "�а� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 stmt.executeUpdate("INSERT INTO Department VALUES("+Field.getText().toString()+", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\", \""+Field4.getText().toString()+"\",\""+Field5.getText().toString()+"\");\r\n" + 
            	 		"");
             } 
         }else if(e.getSource()== button_3) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JTextField Field9 = new JTextField(5);
             JTextField Field10 = new JTextField(5);
             JTextField Field11 = new JTextField(5);
             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("CourseID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("Class:"));
             myPanel.add(Field2);
             myPanel.add(new JLabel("ProfessorID:"));
             myPanel.add(Field3);
             myPanel.add(new JLabel("CourseName:"));
             myPanel.add(Field4);
             myPanel.add(new JLabel("Day:"));
             myPanel.add(Field5);
             myPanel.add(new JLabel("ClassTime:"));
             myPanel.add(Field6);
             myPanel.add(new JLabel("Credit:"));
             myPanel.add(Field7);
             myPanel.add(new JLabel("LectureTime:"));
             myPanel.add(Field8);
             myPanel.add(new JLabel("Department:"));
             myPanel.add(Field9);
             myPanel.add(new JLabel("Room:"));
             myPanel.add(Field10);
             myPanel.add(new JLabel("G_S(����/�б�):"));
             myPanel.add(Field11);
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "���� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 stmt.executeUpdate("INSERT INTO Course VALUES(\""+Field.getText().toString()+"\", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\", \""+Field4.getText().toString()+"\",\""+Field5.getText().toString()+"\",\""+Field6.getText().toString()+"\",\""+Field7.getText().toString()+"\",\""+Field8.getText().toString()+"\",\""+Field9.getText().toString()+"\",\""+Field10.getText().toString()+"\",\""+Field11.getText().toString()+"\");\r\n" + 
            	 		"");
             } 
         }else if(e.getSource()== button_4) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JTextField Field9 = new JTextField(5);
             JTextField Field10 = new JTextField(5);


             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("StudentID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("CourseID:"));
             myPanel.add(Field2);
             myPanel.add(new JLabel("ProfessorID:"));
             myPanel.add(Field3);
             myPanel.add(new JLabel("AttendanceScore:"));
             myPanel.add(Field4);
             myPanel.add(new JLabel("MidScore:"));
             myPanel.add(Field5);
             myPanel.add(new JLabel("FinalScore:"));
             myPanel.add(Field6);
             myPanel.add(new JLabel("OtherScore:"));
             myPanel.add(Field7);
             myPanel.add(new JLabel("TotalScore:"));
             myPanel.add(Field8);
             myPanel.add(new JLabel("Grade:"));
             myPanel.add(Field9);
             myPanel.add(new JLabel("PaymentStatus(��ϱ� ���ο���):"));
             myPanel.add(Field10);
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "�������� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 if(Field10.getText().equals(""))
            		 stmt.executeUpdate("INSERT INTO CourseDetails VALUES("+Field.getText().toString()+", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\", \""+Field4.getText().toString()+"\",\""+Field5.getText().toString()+"\",\""+Field6.getText().toString()+"\",\""+Field7.getText().toString()+"\",\""+Field8.getText().toString()+"\",\""+Field9.getText().toString()+"\",NULL);\r\n" + 
                 	 		"");
            	 else 
            		 stmt.executeUpdate("INSERT INTO CourseDetails VALUES("+Field.getText().toString()+", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\", \""+Field4.getText().toString()+"\",\""+Field5.getText().toString()+"\",\""+Field6.getText().toString()+"\",\""+Field7.getText().toString()+"\",\""+Field8.getText().toString()+"\",\""+Field9.getText().toString()+"\",\""+Field10.getText().toString()+"\");\r\n" + 
            	 		"");
             } 
         }else if(e.getSource()== button_5) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("ClupID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("ClupName:"));
             myPanel.add(Field2);
             myPanel.add(new JLabel("Personnel(�ο���):"));
             myPanel.add(Field3);
             myPanel.add(new JLabel("StudentID(���Ƹ���ǥ):"));
             myPanel.add(Field4);
             myPanel.add(new JLabel("Professor(��������ID):"));
             myPanel.add(Field5);
             myPanel.add(new JLabel("Room:"));
             myPanel.add(Field6);
  
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "���Ƹ� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 stmt.executeUpdate("INSERT INTO Clup VALUES("+Field.getText().toString()+", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\", \""+Field4.getText().toString()+"\",\""+Field5.getText().toString()+"\",\""+Field6.getText().toString()+"\");\r\n" + 
            	 		"");
             } 
         }else if(e.getSource()== button_6) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("StudentID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("TuitionPaymentYear:"));
             myPanel.add(Field2);
             myPanel.add(new JLabel("TuitionPaymentSemester:"));
             myPanel.add(Field3);
             myPanel.add(new JLabel("TotalTuition:"));
             myPanel.add(Field4);
             myPanel.add(new JLabel("TotalAmountPaid:"));
             myPanel.add(Field5);
             myPanel.add(new JLabel("LastPaymentDate:(yyyy-mm--dd)"));
             myPanel.add(Field6);
         
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "��ϱ� ���� ���� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 stmt.executeUpdate("INSERT INTO TuitionDetails VALUES("+Field.getText().toString()+", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\", \""+Field4.getText().toString()+"\",\""+Field5.getText().toString()+"\",\""+Field6.getText().toString()+"\");\r\n" + 
             	 		"");
             } 
         }else if(e.getSource()== button_7) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("StudentID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("ProfessorID:"));
             myPanel.add(Field2);
             myPanel.add(new JLabel("Grade/Semester:"));
             myPanel.add(Field3);
         
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "�л� �������� ���� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 stmt.executeUpdate("INSERT INTO Student_has_Professor VALUES("+Field.getText().toString()+", \""+Field2.getText().toString()+"\", \""+Field3.getText().toString()+"\");\r\n" + 
            	 		"");
             } 
         }else if(e.getSource()== button_8) {
        	 JTextField Field = new JTextField(5);
             JTextField Field2 = new JTextField(5);
             JTextField Field3 = new JTextField(5);
             JTextField Field4 = new JTextField(5);
             JTextField Field5 = new JTextField(5);
             JTextField Field6 = new JTextField(5);
             JTextField Field7 = new JTextField(5);
             JTextField Field8 = new JTextField(5);
             JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
             myPanel.add(new JLabel("StudentID:"));
             myPanel.add(Field);
             myPanel.add(new JLabel("ClupID:"));
             myPanel.add(Field2);
           
           
             int result = JOptionPane.showConfirmDialog(null, myPanel, 
                      "���Ƹ� �л� ���� ���̺� �Է�", JOptionPane.OK_CANCEL_OPTION);
             if (result == JOptionPane.OK_OPTION) {
            	 stmt.executeUpdate("INSERT INTO Student_has_Clup VALUES("+Field.getText().toString()+", \""+Field2.getText().toString()+"\");\r\n" + 
            	 		"");
             } 
         }         else if(e.getSource()== btnNewButton_2 ) {
        	 

           
             String[] table={"Professor","Student","Department","Course","CourseDetails","Clup","TuitionDetails","Student_has_Professor",
            		 "Student_has_Clup"};
             JComboBox box = new JComboBox(table);
          
             box.setEditable(true);
             
        	 	JTextField Field = new JTextField(30);
        	 	JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        	 	myPanel.add(new JLabel("DELETE FROM ���̺�� WHERE = ����;"));
        	 	
        	 	myPanel.add(new JLabel("DELETE FROM:"));
        	 	myPanel.add(box);
                myPanel.add(new JLabel("WHERE:"));
                myPanel.add(Field);

                int result = JOptionPane.showConfirmDialog(null, myPanel, 
                        "����", JOptionPane.OK_CANCEL_OPTION);
               if (result == JOptionPane.OK_OPTION) {
            	    stmt.executeUpdate("DELETE FROM "+box.getSelectedItem().toString()+" WHERE "+Field.getText().toString()+"");
               } 
         
         }
         else if(e.getSource()== btnNewButton_3 ) {
        	 String[] table={"Professor","Student","Department","Course","CourseDetails","Clup","TuitionDetails","Student_has_Professor",
    		 "Student_has_Clup"};
	     JComboBox box = new JComboBox(table);
	  
	     box.setEditable(true);
     
	 	JTextField Field = new JTextField(30);
	 	JTextField Field1 = new JTextField(30);

	 	JPanel myPanel = new JPanel(new GridLayout(0, 1, 2, 2));
	 	myPanel.add(new JLabel("UPDATE ���̺�� SET �ʵ�� = ������ ���� WHERE �ʵ�� = ���� �Ӽ���;"));
	 	
	 	myPanel.add(new JLabel("UPDATE:"));
	 	myPanel.add(box);
        myPanel.add(new JLabel("SET:"));
        myPanel.add(Field);
        myPanel.add(new JLabel("WHERE:"));
        myPanel.add(Field1);

        int result = JOptionPane.showConfirmDialog(null, myPanel, 
                "����", JOptionPane.OK_CANCEL_OPTION);
       if (result == JOptionPane.OK_OPTION) {
    	    stmt.executeUpdate("UPDATE "+box.getSelectedItem().toString()+" SET "+Field.getText().toString()+" WHERE "+Field1.getText().toString()+"");
       } 
         }


         
         
         
        
      } catch (Exception e2) {
    	  System.out.println("���� �б� ���� :" + e2);
     	 txtStatus.append("���� �б� ���� :" + e2+"\n");

/*      } finally {
         try {
            if (rs != null)
               rs.close();
            if (stmt != null)
               stmt.close();
            if (con != null)
               con.close();
         } catch (Exception e3) {
            // TODO: handle exception
         }
  */
      }

   }

 

public static void main(String[] args) {
      JC18013195M1 BLS = new JC18013195M1();
      
      
      //BLS.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      //BLS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      BLS.addWindowListener(new WindowAdapter() {
    	  public void windowClosing(WindowEvent we) {
    		try {
    			con.close();
    		} catch (Exception e4) { 	}
    		System.out.println("���α׷� ���� ����!");
    		System.exit(0);
    	  }
    	});
   }
}
