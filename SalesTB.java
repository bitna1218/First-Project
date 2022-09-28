package project;

import java.sql.*;
import java.util.*;

public class SalesTB extends CafeMain{
   
   //데이터베이스 연동 메서드
   public static Connection makeConnection() {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/cafeadmin?serverTimezone=Asia/Seoul";
      String user = "root";
      String pwd = "my1234";
      
      Connection con = null;
      
      try {
         //드라이버 메모리에 로드
         Class.forName(driver);
         //System.out.println("데이터 베이스 연결 중");
         System.out.println();
         
         //데이터베이스 연결을 위한 Connection 객체를 생성
         con = DriverManager.getConnection(url,user,pwd);
         
        // System.out.println("데이터베이스 연결 성공");
         System.out.println();
         
      }catch(ClassNotFoundException e) {
         System.out.println("드라이버 연결 실패");
         
      }catch(SQLException e) {
         System.out.println("데이터베이스 연결 실패");
      }
      
      return con;
   }
   
   
   
   public int sum=0;
   public ArrayList<String> salesDataCard = new ArrayList<>();
   //한 달 매출 내역 출력 준비 메서드
      public void salesData() {
         PreparedStatement pstmt;
         ResultSet rs;
         
         try {
            Connection con = SalesTB.makeConnection();
            
            //Connection 객체에서 PreparedStatement 객체 생성, ordertb 내용을 확인하는 쿼리 생성
            pstmt = con.prepareStatement("SELECT * FROM ordertb "
                    + " WHERE order_Date BETWEEN DATE_ADD('2022-05-01', INTERVAL -1 DAY)AND NOW()");//날짜로 조회 한달치
           // pstmt = con.prepareStatement("SELECT * FROM ordertb");
            
            
            // 쿼리를 PreparedStatement 객체를 통해 전달하여 출력
            rs = pstmt.executeQuery();
            
            while(rs.next()) {     
               
               salesDataCard.add(rs.getString("order_number")); //주문번호 출력
               salesDataCard.add(rs.getString("order_Date")); //주문날짜 출력
               salesDataCard.add(rs.getString("menu_name")); //메뉴명 출력
               salesDataCard.add(rs.getString("order_count")); //주문수량 출력
               salesDataCard.add(rs.getString("menu_price")); //메뉴가격 출력
               salesDataCard.add(rs.getString("order_total")); //주문 총 가격 출력

               sum += rs.getInt("order_total");

            }   
            
            //객체 닫기
            rs.close();
            pstmt.close();
            con.close();
            
         }catch(SQLException e) {
            System.out.println("SQL문이 잘못 되었습니다."+e.getMessage());
        	e.printStackTrace();
         }
      }
      
      
      public int sum2 = 0;
      public ArrayList<String> netIncomeDataCard = new ArrayList<>();
      //한 달 순이익 내역 메서드
      public void netIncome() {
         PreparedStatement pstmt;
         ResultSet rs;
         
         try {
            Connection con = SalesTB.makeConnection();
            
            //Connection 객체에서 Statement 객체 생성, 쿼리문 생성
            pstmt = con.prepareStatement("SELECT * FROM ordertb"
                   + " WHERE order_Date BETWEEN DATE_ADD('2022-05-01', INTERVAL -1 DAY)AND NOW()");
            
            rs = pstmt.executeQuery();

            //한 달 총 순이익 출력하기 = sum값
            while(rs.next()) {
               netIncomeDataCard.add(rs.getString("order_Date")); //순이익 출력
               netIncomeDataCard.add(rs.getString("order_income")); //순이익 출력
               sum2 += rs.getInt("order_income");
            }
            
            //객체 닫기  
            rs.close();
            pstmt.close();
            con.close();
            
         }catch(SQLException e) {
            System.out.println("SQL문이 잘못 되었습니다."+e.getMessage());
         }
      }
      
      
      
      public int sum3 = 0, sum4 = 0, total = 100000;
      //총 자산 계산 메서드
      public void salesCalculation() {
         PreparedStatement pstmt;
         ResultSet rs;
         
         try {
            Connection con = SalesTB.makeConnection();
            pstmt = con.prepareStatement("SELECT * FROM ordertb WHERE order_Date BETWEEN DATE_ADD('2022-05-01', INTERVAL -1 DAY)AND NOW()");
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                 sum3 += rs.getInt("order_income");
                 sum4 += rs.getInt("order_total");
            }
            
            total += sum3-sum4;
            
            //객체 닫기
            rs.close();
            pstmt.close();
            con.close();
            
         }catch(SQLException e) {
            System.out.println("SQL문이 잘못 되었습니다."+e.getMessage());
         }
      }
      
      
      
      public ArrayList<String> assetDataCard = new ArrayList<>();
      public ArrayList<String> assetDataCard2 = new ArrayList<>();
      //총 자산 조회 메서드
      public void salesPrint() {
         PreparedStatement pstmt;
         ResultSet rs;
         
         try {
            Connection con = SalesTB.makeConnection();
            pstmt = con.prepareStatement("SELECT * FROM ordertb WHERE order_Date BETWEEN DATE_ADD('2022-05-01', INTERVAL -1 DAY)AND NOW()");
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
               assetDataCard.add(rs.getString("order_Date"));
               assetDataCard.add(rs.getString("order_income")); //한 달 순이익
               assetDataCard.add(rs.getString("order_total")); //한 달 재고지출비용
            }
            
            //총 자산 계산
            salesCalculation();
            
            assetDataCard2.add(Integer.toString(sum3)); //한 달 순이익 합계
            assetDataCard2.add(Integer.toString(sum4)); //한 달 재고지출비용 합계
            assetDataCard2.add(Integer.toString(total)); //총 자산
            
         }catch(SQLException e) {
            System.out.println("SQL문이 잘못 되었습니다."+e.getMessage());
         }
      }
	@Override
	public void salesMain() {
		// TODO Auto-generated method stub
		
	}
}