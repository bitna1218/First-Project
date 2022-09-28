package project;
import java.sql.*;
import java.util.ArrayList;

public class OrderTB extends CafeMain{
	
	//필드 선언
	int a; //order_number(프라이머리키)기억 전역
	int TotalSum;
	int reOrderNum=1;
	int updateNum=1;
	
	//데이터베이스 연결Connection 메서드 
	public static Connection makeCon(){	
		String driver="com.mysql.cj.jdbc.Driver"; 
		String url ="jdbc:mysql://localhost:3306/cafeadmin"; 
		String user="root";
		String pw="my1234";
		Connection con= null; 
		
		try {
			Class.forName(driver); 
			//System.out.println("데이터베이스 연결중...");
			con=DriverManager.getConnection(url,user,pw); 
		//	System.out.println("데이터베이스 연결성공");
			
		}catch(ClassNotFoundException e) {
			 System.out.println("jdbc드라이버 연결 실패");
		}catch(SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
		return con; 	
	}
	
	//DB에 주문한메뉴명과 가격을 넣어줌
	//매개변수를 int a에 1->2->3 넣어줌으로써 Menu1의 배열로 저장된 해당 인덱스에 맞게 menu_name과 menu_price를 불러옴
	public void insertMenuPrice (int a)  { 
		//메뉴판 객체생성(포함관계)
		Menu m =new Menu();
		
		try {
			Connection con=OrderTB.makeCon(); //Connection 객체생성 및 데이터베이스 연동
			//menu_name과 menu_price DB에 넣어죠 실행 sql명령문
			String sql="insert into ordertb(menu_name, menu_price)"+ "value(?,?)"; 
			PreparedStatement ps =con.prepareStatement(sql.toString()); //DB에 sql명령문 전달 객체 생성
			ps.setString(1,m.menuList[a]); //매개변수 숫자에 맞는 해당 인덱스의 메뉴판의 이름 가져오기
			ps.setInt(2, m.menuPrice[a]); //매개변수 숫자에 맞는 해당 인덱스의 가격의 이름 가져오기
			ps.execute(); //실행하기
			
			ps.close(); // PreparedStatement객체닫기
			con.close(); //Connection 객체닫기 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
	}
	
	//주문수량 DB에 넣어주는 메서드
	public void UpdeteOrderNum (int order_count, int order_number)  {
		
		try {
			Connection con=OrderTB.makeCon(); //Connection 객체생성 및 데이터베이스 연동
			//DB의 order_number(프라이머리키) 기준으로 order_count를 수정하라 
			String sql="update ordertb  set order_count= order_count + '?'  where order_number = ?"; 
			PreparedStatement ps =con.prepareStatement(sql.toString()); //DB에 sql명령문 전달 객체 생성
			ps.setInt(1,order_count); //주문수량 기준
			ps.setInt(2,order_number);//order_number(프라이머리키) 기준
			ps.execute(); //실행하기
			
			ps.close(); // PreparedStatement객체닫기
			con.close(); //Connection 객체닫기 
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
	}
	
	//각 order_number(프라이머리키)기준 주문에 대한 총 주문 금액 DB에 넣어주기 
	public void UpdeteOrderTotal (int order_number)  {
		
		try {
			Connection con=OrderTB.makeCon(); //Connection 객체생성 및 데이터베이스 연동
			//order_number(프라이머리키) 기준으로 menu_price*order_count 곱해서 order_total에 넣어죠
			String sql="update ordertb  set order_total=menu_price*order_count  where order_number=?;";  
			PreparedStatement ps =con.prepareStatement(sql.toString());//DB에 sql명령문 전달 객체 생성
			ps.setInt(1,order_number); //order_number(프라이머리키)기준
			ps.execute(); //실행하기
			
			ps.close(); // PreparedStatement객체닫기
			con.close(); //Connection 객체닫기 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
	}
	
	//재주문 마킹을 위한 메서드
	public void SelecteOrderNumber ()  {
		
		try {
			Connection con=OrderTB.makeCon();//Connection 객체생성 및 데이터베이스 연동
			//DB 끝에 들어가는(즉, 최근 주문건) 기억하기위한 메서드 인데, order_number(프라이머리키)를 기억하기 위함
			//order_number(프라이머리키)기준으로 ORDER BY는 정렬해주는걸로 최근 주문건의 'LIMIT 1'은 1줄에 해당하는 order_number(프라이머리키)를 가져와죠
			String sql="select order_number from ordertb ORDER BY order_number DESC LIMIT 1;";
			PreparedStatement ps = con.prepareStatement(sql); //DB에 sql명령문 전달 객체 생성
			ResultSet rs =ps.executeQuery(); //DB조회 결과를  ResultSet 객체에 담기
			
			while (rs.next()) {
			a=rs.getInt(1); //ResultSet 객체에 담은거(order_number(프라이머리키))를 변수a에 담아죠->a는 전역필드이기 때문에 결국은 최근주문한 order_number(프라이머리키)를 담고 있는다.
			}
			
			rs.close(); //ResultSet 객체 닫기
			ps.close(); //PreparedStatement객체닫기
			con.close(); //Connection 객체닫기 
			
		}catch(SQLException e) {
			System.out.println("SQLException 에러남1");
		}
			
	}
	
//	//다시 주문했을시 현재주문과 앞으로의주문을 기억하기 위한 메서드
//	public void print (int reOrderNum)  { //reOrderNum 은 재주문회수를 기억하기 위한 필드인데, 기본 1로 설정 재주문을 할시 ++1 을함, 추가주문Panel에 넣어줘야함
//		
//		try {
//			Connection con=OrderTB1.makeCon(); //Connection 객체생성 및 데이터베이스 연동
//			//reOrderNum으로 받은 숫자는 LIMIT ?에 들어가고 이것은 재주문한 횟수만큼 최근데이터기준 꺼꾸로 조회
//			//order_number(프라이머리키)기준으로 ORDER BY는 정렬해주고 조회데이터는 menu_name,order_count,order_total 내용이 조회됨
//			String sql="select menu_name,order_count,order_total from ordertb ORDER BY order_number DESC LIMIT ?;";
//			PreparedStatement ps = con.prepareStatement(sql.toString()); //DB에 sql명령문 전달 객체 생성
//			ps.setInt(1,reOrderNum); //reOrderNum으로 받은 숫자는 LIMIT ?에 들어감
//			ResultSet rs =ps.executeQuery(); //DB조회 결과를  ResultSet 객체에 담기
//			
//			while (rs.next()) {
//				String menu_name =rs.getString("menu_name"); //메뉴명 출력
//				String order_count =rs.getString("order_count"); //주문 수량 출력
//				String order_total =rs.getString("order_total"); //order_number(프라이머리키)기준의 해당 총액 출력
//		
//				System.out.println("메뉴:"+menu_name+" 주문수량:"+order_count+" 총액:"+order_total); //옆에 형식으로 출력
//			}
//			
//			rs.close(); //ResultSet 객체 닫기
//			ps.close(); //PreparedStatement객체닫기
//			con.close(); //Connection 객체닫기 
//			
//		}catch(SQLException e) {
//			System.out.println("SQLException 에러남1");
//			e.printStackTrace();
//		}
//			
//	}
	
	//모든 주문건(첫주문...재주문포함)의 총합을 구한 메서드
	public void Total (int reOrderNum)  { //reOrderNum 은 재주문회수를 기억하기 위한 필드
		
		try {
			Connection con=OrderTB.makeCon(); //Connection 객체생성 및 데이터베이스 연동
			//reOrderNum으로 받은 숫자는 LIMIT ?에 들어가고 이것은 재주문한 횟수만큼 최근데이터기준 꺼꾸로 order_total조회함
			//order_number(프라이머리키)기준으로 ORDER BY는 정렬해주고 재주문한 횟수만큼 order_total을 불러옴
			String sql="select order_total from ordertb ORDER BY order_number DESC LIMIT ?;";
			PreparedStatement ps = con.prepareStatement(sql.toString()); //DB에 sql명령문 전달 객체 생성
			ps.setInt(1,reOrderNum); //reOrderNum으로 받은 숫자는 LIMIT ?에 들어감
			ResultSet rs =ps.executeQuery(); //DB조회 결과를  ResultSet 객체에 담기
			
			while (rs.next()) {
				int sum =rs.getInt("order_total"); //order_total을 sum에 담아주고
				TotalSum+=sum;	//필드인 TotalSum에 각 해당order_total를 더해줌
			}
			
			rs.close(); //ResultSet 객체 닫기
			ps.close(); //PreparedStatement객체닫기
			con.close(); //Connection 객체닫기 
			
		}catch(SQLException e) {
			System.out.println("SQLException 에러남1");
			e.printStackTrace();
		}
			
	}
	

	
	//전역 으로 선언
	//SQL문으로 조회 한걸 printCard에 넣어줌
	ArrayList<String> printCard = new ArrayList<>(); 
	//출력을 위한 준비메서드
		public void print01 (int reOrderNum)  { 
			
			try {
				Connection con=OrderTB.makeCon();
				//영수증을 보여주기 위하여 sql문 조회
				String sql="select menu_name,order_count,order_total from ordertb ORDER BY order_number DESC LIMIT ?;";
				PreparedStatement ps = con.prepareStatement(sql.toString());//DB에 sql명령문 전달 객체 생성
				ps.setInt(1,reOrderNum); //주문횟수
				ResultSet rs =ps.executeQuery(); 
				
				while (rs.next()) {
					
					printCard.add(rs.getString("menu_name")); //메뉴명 출력
					printCard.add(rs.getString("order_count")); //주문 수량 출력
					printCard.add(rs.getString("order_total")); //총액 출력
				}
				
				rs.close(); //ResultSet 객체 닫기
				ps.close(); //PreparedStatement객체닫기
				con.close(); //Connection 객체닫기 
				
			}catch(SQLException e) {
				System.out.println("SQLException 에러남1");
				e.printStackTrace();
			}
				
		}	
		
		
		
		//순이익 DB넣기
		public void UpdeteOrderIncome (int a)  {
			
			//메뉴판 객체생성(포함관계)
			Menu m =new Menu();
			
			try {
				Connection con=OrderTB.makeCon(); 
				//메뉴별로 순이익 넣기
				String sql="update ordertb set order_income=?*order_count  where menu_name=?"; 
				PreparedStatement ps =con.prepareStatement(sql.toString());  //DB에 sql명령문 전달 객체 생성
				ps.setInt(1,m.income[a]); //순이익
				ps.setString(2,m.menuList[a]); //메뉴이름
				ps.execute(); //실행하기
				
				ps.close(); // PreparedStatement객체닫기
				con.close(); //Connection 객체닫기 
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}	
		
		ArrayList<Integer> OrderCount = new ArrayList<>(); 
		ArrayList<String> menuName = new ArrayList<>(); 
		public void selecteOrderCount (int reOrderNum)  { 
			
			try {
				Connection con=OrderTB.makeCon();
				String sql="select order_count,menu_name  from ordertb ORDER BY order_number DESC LIMIT ?;";
				PreparedStatement ps = con.prepareStatement(sql.toString());//DB에 sql명령문 전달 객체 생성
				ps.setInt(1,reOrderNum); //주문횟수
				ResultSet rs =ps.executeQuery(); 
				
				while (rs.next()) {
					OrderCount.add(rs.getInt("order_count")); //총 주문수량 배열에 저장
					menuName.add(rs.getString("menu_name"));//총 주문이름 배열에 저장
				}
				
				
				rs.close(); //ResultSet 객체 닫기
				ps.close(); //PreparedStatement객체닫기
				con.close(); //Connection 객체닫기 
				
			}catch(SQLException e) {
				System.out.println("SQLException 에러남1");
				e.printStackTrace();
			}catch(Exception e) {
				System.out.println("SQLException 에러남1");
				e.printStackTrace();
			}		
		}
		public void updateInvenCount (int OrderCount, String menuName) {
			
			try {
				Connection con=OrderTB.makeCon(); //Connection 객체생성 및 데이터베이스 연동
				String sql="update inventory_expensetb  set inven_count=inven_count-?  where menu_name=?;";  
				PreparedStatement ps =con.prepareStatement(sql.toString());//DB에 sql명령문 전달 객체 생성
				ps.setInt(1,OrderCount); //주문수량
				ps.setString(2,menuName); //주문명
				ps.execute(); //실행하기
				
				ps.close(); // PreparedStatement객체닫기
				con.close(); //Connection 객체닫기 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}  
		}
		
		public void update () {
			for(int i=0;i<OrderCount.size();i++) {
				updateInvenCount(OrderCount.get(i),menuName.get(i));
			}

		}

		//주문시 재고 체크 메서드
				ArrayList<String> InvenCount = new ArrayList<String>(); 
				public void OrderCheck()  {
					
					try {
						Connection con=OrderTB.makeCon();
						String sql="select menu_name from inventory_expensetb where inven_count = 0;";
						PreparedStatement ps = con.prepareStatement(sql); //DB에 sql명령문 전달 객체 생성
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
						InvenCount.add(rs.getString("menu_name"));
						}
						
						rs.close();
						ps.close(); //PreparedStatement객체닫기
						con.close(); //Connection 객체닫기 
						
					}catch(SQLException e) {
						System.out.println("SQLException 에러남1");
						e.printStackTrace();
					}
						
				}
		
		
		
	public static void main(String[] args) {

		OrderTB o =new OrderTB();
		o.selecteOrderCount(2);
		
		o.update ();
		
}

	@Override
	public void salesMain() {
		// TODO Auto-generated method stub
		
	}
	
}
