package ConnData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ConnJDBC {
	static String url="jdbc:mysql://localhost:3306/studentmn";
	static String user="root";
	static String password="";
	
	public static Connection getConnection() { // connection function
		Connection connection = null;
		
		try {
			connection=DriverManager.getConnection(url,user,password);
		} catch(Exception ex) {
		ex.printStackTrace();
	}
		return connection;
	
}
	 public static List<Student> findAll(){
		 List<Student> studentList = new ArrayList<>();
		 String query = "SELECT * FROM student";
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Student st = new Student(rs.getInt("id"),
						 rs.getString("name"),rs.getInt("age"),
						 rs.getInt("gender"),
						 rs.getString("major"),
						 rs.getString("score"));
				 studentList.add(st);
			 }
		 } catch(Exception e){
			 
		 }
		 return studentList;
	 }
	 
	 public static void insert(Student st) {
		 String query="insert into student(name,age,gender,major,score) values(?,?,?,?,?)";
		 
		 try {
			 Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(query);
			 pstmt.setString(1,st.getName());
			 pstmt.setInt(2, st.getAge());
			 pstmt.setInt(3, st.getGender());
			 pstmt.setString(4, st.getMajor());
			 pstmt.setString(5, st.getScore());
			 pstmt.execute();
		 } catch (Exception e ) {
			 
		 }
	 }
	 public static void delete(Student st) {
		 String query="delete from student where id='"+ st.getId()+"'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} 
	 }
	 public static void Update(Student st) {
		String query = "Update student set name=?,age=?,gender=?,major=?,score=? where id='"+st.getId()+"'";
		
		 try {
			Connection connection = getConnection();
			PreparedStatement pstmt= connection.prepareStatement(query);
			pstmt.setString(1, st.getName());
			pstmt.setInt(2, st.getAge());
			pstmt.setInt(3, st.getGender());
			pstmt.setString(4, st.getMajor());
			pstmt.setString(5, st.getScore());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }	
	 public static void Update222(Student st) {
			String query = "Update student set name=?,age=?,gender=?,major=?,score=? where name='"+st.getName()+"'";
			
			 try {
				Connection connection = getConnection();
				PreparedStatement pstmt= connection.prepareStatement(query);
				pstmt.setString(1, st.getName());
				pstmt.setInt(2, st.getAge());
				pstmt.setInt(3, st.getGender());
				pstmt.setString(4, st.getMajor());
				pstmt.setString(5, st.getScore());
				pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
		 }	
	 public static List<Student> findByName(Student s) {
		 List<Student> studentl = new ArrayList<>();
		 String query = "SELECT * FROM student where name='"+ s.getName() +"'";
		 try {
			 Connection connection = getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 while(rs.next()) {
				 Student st = new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),
						 rs.getInt("gender"),rs.getString("major"),rs.getString("score"));
				 studentl.add(st);
			 }	
		 } catch(Exception e){
			 
		 }
		 return studentl;
	 }
}