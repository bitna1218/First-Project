package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InvenTB extends CafeMain{
	String[] v = new String[5];
	ArrayList<String> v2 = new ArrayList<>(); 
	int[] invenpiceList = new int[] {2500,3200,3200,2000,6200};
	int[] invenNumList = new int[] {10,20,30,40};
	int Invenp = 1;
	ArrayList<String> Invenprint = new ArrayList<>(); 
	int a;
	Menu m = new Menu(); 	

public static Connection makeConnection(){ 		
	    Connection con = null; //DB 커넥션 연결 객체

	     String url = "jdbc:mysql://localhost:3306/cafeadmin?serverTimezone=Asia/Seoul";
	  try {
		  //jdbc 드라이버로드
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		//  System.out.println("연결중...");
		  //데이터베이스 연결을 위한 Connection 객체 생성
		  con = DriverManager.getConnection(url, "root", "my1234");
		//  System.out.println("연결 성공");
	  }catch(ClassNotFoundException e) {
		  System.out.println("드라이버 어디?");
	  }catch (SQLException e){
		  System.out.println("연결 실패");
	  }
	  return con;  	  
	}

public void alarm() {
	try {
		Connection con = makeConnection();
		//String sql= "create view vinven as select menu_name from inventory_expensetb where inven_count = 0";
		String sql= "select menu_name from inventory_expensetb where inven_count = 0;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

			for(int i = 1;i<v.length;i++) {
			while(rs.next()) {
				v[i] = rs.getString(i);
				v2.add(v[i]);
			}	
		}
			rs.close(); //ResultSet 객체 닫기
			ps.close(); //PreparedStatement객체닫기
			con.close(); //Connection 객체닫기 
	}catch (SQLException e) {
		System.out.println("안돼!");
		e.printStackTrace();
	}
}

		//재고 조회 메서드
public void invenOrder() {
	try {
		Connection con=makeConnection();
		String sql="select menu_name, inven_order_Date, inven_count, inven_total from inventory_expensetb";
		
		PreparedStatement ps =con.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Invenprint.add(rs.getString("menu_name"));
			Invenprint.add(rs.getString("inven_order_Date"));
			Invenprint.add(rs.getString("inven_count"));
			Invenprint.add(rs.getString("inven_total"));
			}
		rs.close(); //ResultSet 객체 닫기
		ps.close(); //PreparedStatement객체닫기
		con.close(); //Connection 객체닫기 
	}catch (SQLException e) {
	System.out.println("안되네;;");
		}
	}

		String plusname;
		int plusnum;
public void InvenPlus(int p,String n) {
	try {
		Connection con=makeConnection();
		String sql = "update inventory_expensetb set inven_count =  inven_count + ? where menu_name = ?";	
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setInt(1, p);
		ps.setString(2, n);
		ps.execute();
	}catch (SQLException e) {
		System.out.println("왜또....");
		e.printStackTrace();
	}
}


public static void main(String[] args) throws SQLException {
	makeConnection();
}
		@Override
		public void salesMain() {		
		}
}