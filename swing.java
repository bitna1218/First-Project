package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class swing {

	private JFrame frame;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {			
				try {
					swing window = new swing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					}
				}
			});
	}
	int inputCash;
	int changes;
	int num;
	int number;
	int menu;
	private JLabel HelloLabel;
	/**
	 * Create the application.
	 */
	public swing() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
		// 프레임 생성
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setFont(new Font("굴림", Font.BOLD, 12));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("거기서 거기 카페");
		frame.setSize(1080, 720);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				//객체 생성
		InvenTB i = new InvenTB();
		OrderTB o = new OrderTB();
		SalesTB s = new SalesTB();
		Menu m = new Menu();
		
		
		//각종 패널 생성
//현금 영수증 확인 패널 생성
		JPanel Moneypanel = new JPanel();
		frame.getContentPane().add(Moneypanel, BorderLayout.NORTH);
		Moneypanel.setBounds(0, 0, 1080, 720);
		Moneypanel.setLayout(null);
		Moneypanel.setVisible(false);	
//현금 입력 패널 생성
		JPanel MoneyInputpanel = new JPanel();
		frame.getContentPane().add(MoneyInputpanel, BorderLayout.NORTH);
		MoneyInputpanel.setBounds(0, 0, 1080, 720);
		MoneyInputpanel.setLayout(null);
		MoneyInputpanel.setVisible(false);
//카드 결제 영수증 확인 패널 생성
		JPanel Cardpanel = new JPanel();
		frame.getContentPane().add(Cardpanel, BorderLayout.NORTH);
		Cardpanel.setBounds(0, 0, 1080, 720);
		Cardpanel.setLayout(null);
		Cardpanel.setVisible(false);
//결제 선택 패널 생성
		JPanel Paypanel = new JPanel();
		frame.getContentPane().add(Paypanel, BorderLayout.NORTH);
		Paypanel.setBounds(0, 0, 1080, 720);
		Paypanel.setLayout(null);
		Paypanel.setVisible(false);				
//재고 확인 패널 생성 
		JPanel InvenCheckpanel = new JPanel();
		frame.getContentPane().add(InvenCheckpanel, BorderLayout.NORTH);
		InvenCheckpanel.setBounds(0, 0, 1080, 720);
		InvenCheckpanel.setLayout(null);
		InvenCheckpanel.setVisible(false);
// 메뉴 추가 주문 확인 패널 생성
		JPanel PlusOrderpanel = new JPanel();
		frame.getContentPane().add(PlusOrderpanel, BorderLayout.NORTH);
		PlusOrderpanel.setBounds(0, 0, 1080, 720);
		frame.getContentPane().add(PlusOrderpanel);
		PlusOrderpanel.setLayout(null);
		PlusOrderpanel.setVisible(false);				
//추가 주문 패널
		JPanel Ordernumpanel = new JPanel();
		frame.getContentPane().add(Ordernumpanel, BorderLayout.NORTH);
		Ordernumpanel.setBounds(0, 0, 1080, 720);
		frame.getContentPane().add(Ordernumpanel);
		Ordernumpanel.setLayout(null);
		Ordernumpanel.setVisible(false);
// 메뉴 선택 패널 생성
		JPanel Orderpanel = new JPanel();
		frame.getContentPane().add(Orderpanel, BorderLayout.NORTH);
		Orderpanel.setBounds(0, 0, 1080, 720);
		frame.getContentPane().add(Orderpanel);
		Orderpanel.setLayout(null);	
		Orderpanel.setVisible(false);
// 카페 메인 패널 생성
		JPanel CafeMainpanel = new JPanel();
		frame.getContentPane().add(CafeMainpanel, BorderLayout.NORTH);
		CafeMainpanel.setBounds(0, 0, 1080, 720);
		frame.getContentPane().add(CafeMainpanel);
		CafeMainpanel.setLayout(null);
		CafeMainpanel.setVisible(false);				
// 카페 시작 화면 패널 생성
		JPanel CafeStartpanel = new JPanel();
		frame.getContentPane().add(CafeStartpanel, BorderLayout.NORTH);
		CafeStartpanel.setBounds(0, 0, 1080, 720);
		frame.getContentPane().add(CafeStartpanel);
		CafeStartpanel.setLayout(null);
		CafeStartpanel.setVisible(true);				
// 리턴 선택화면 생성
		JPanel Quaspanel = new JPanel();
		Quaspanel.setBounds(0, 0, 1080, 720);
		frame.getContentPane().add(Quaspanel);
		Quaspanel.setVisible(false);
		Quaspanel.setLayout(null);
// 자산관리 테이블보여주는 패널 생성
		JPanel tablepanel = new JPanel();
		tablepanel.setBounds(0, 0, 1080, 720);
		tablepanel.setVisible(false);		
// 자산관리 버튼 및 기간별 구매내역 버튼 화면 패널 생성
		JPanel Checkpanel = new JPanel();
		Checkpanel.setBounds(0, 0, 1080, 720);
		frame.getContentPane().add(Checkpanel);
		Checkpanel.setVisible(false);
		Checkpanel.setLayout(null);				
// 로그인 화면 패널 생성
		JPanel Loginpanel = new JPanel();
		Loginpanel.setBounds(0, 0, 1080, 720);
		frame.getContentPane().add(Loginpanel);
		Loginpanel.setLayout(null);
		Loginpanel.setVisible(false);
// 총 자산 조회 패널 생성
		JPanel Totalpanel = new JPanel();
		 Totalpanel.setBounds(0, 0, 1080, 720);
	      frame.getContentPane().add(Totalpanel, BorderLayout.CENTER);
	      Totalpanel.setLayout(null);
	      Totalpanel.setVisible(false);
// 한달 순이익 조회 패널 생성
	     JPanel NetPrintpanel = new JPanel();
		   frame.getContentPane().add(NetPrintpanel, BorderLayout.CENTER);
			NetPrintpanel.setBounds(0, 0, 1080, 720);
			NetPrintpanel.setLayout(null);
			NetPrintpanel.setVisible(false);
// 한달 매출 조회			
		 JPanel SalesPrintpanel = new JPanel();
			frame.getContentPane().add(SalesPrintpanel, BorderLayout.CENTER);
			SalesPrintpanel.setBounds(0, 0, 1080, 720);
			SalesPrintpanel.setLayout(null);
// 자산 관리 선택 패널 생성				
		 JPanel SalesChoicepanel = new JPanel();
			frame.getContentPane().add(SalesChoicepanel, BorderLayout.CENTER);
			SalesChoicepanel.setBounds(0, 0, 1080, 720);
			SalesChoicepanel.setLayout(null);	
			SalesChoicepanel.setVisible(false);
			
//재고 주문 패널 생성
		 JPanel InvenPrintpanel = new JPanel();
			frame.getContentPane().add(InvenPrintpanel, BorderLayout.CENTER);
			InvenPrintpanel.setBounds(0, 0, 1080, 720);
			InvenPrintpanel.setLayout(null);	
			InvenPrintpanel.setVisible(false);
//재고 메뉴 선택 패널			
		 JPanel InvenOrderpanel = new JPanel();
			frame.getContentPane().add(InvenOrderpanel, BorderLayout.CENTER);
			InvenOrderpanel.setBounds(0, 0, 1080, 720);
			InvenOrderpanel.setLayout(null);	
			InvenOrderpanel.setVisible(false);
			
	      JTextArea textArea_2 = new JTextArea();
	      textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
	      textArea_2.setBounds(0, 0, 5, 24);
	      Totalpanel.add(textArea_2);

	      
	      JScrollPane scrollPane_2 = new JScrollPane(textArea_2);
	      scrollPane_2.setBounds(250, 180, 600, 350);
	      Totalpanel.add(scrollPane_2);
	      
	      JButton btnNewButton_9_1_1_1 = new JButton("조회");
	      btnNewButton_9_1_1_1.setForeground(Color.WHITE);
	      btnNewButton_9_1_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
	      btnNewButton_9_1_1_1.setBackground(new Color(101, 115, 94));
	      btnNewButton_9_1_1_1.setBounds(440, 70, 200, 80);
	      btnNewButton_9_1_1_1.setFocusable(false);
	      Totalpanel.add(btnNewButton_9_1_1_1);
	      btnNewButton_9_1_1_1.addActionListener(e->{
	    	  			s.salesPrint();
              
	    	  	  textArea_2.append("===================총 자산 조회===================\n");
	    	  	  textArea_2.setCaretPosition(textArea_2.getDocument().getLength()); //맨 아래로 스크롤
              for(int j=0; j<s.assetDataCard.size()-1; j+=3) {
            	  textArea_2.append(s.assetDataCard.get(j)+"\n");
            	  textArea_2.append("순이익: "+s.assetDataCard.get(j+1)+ "원" + "\n");
            	  textArea_2.append("재고지출비용: "+s.assetDataCard.get(j+2)+ "원" +"\n");
            	  textArea_2.append("=================================================\n");
              }
              
              for(int q=0; q<s.assetDataCard2.size(); q+=3) {
            	  textArea_2.append("한 달 순이익 합계: "+s.assetDataCard2.get(q)+ "원" +"\n");
            	  textArea_2.append("한 달 재고지출비용 합계: "+s.assetDataCard2.get(q+1)+ "원" +"\n");
            	  textArea_2.append("총 자산: "+s.assetDataCard2.get(q+2)+ "원" +"\n");
              }
	      });
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea_1.setBounds(0, 0, 5, 24);
		NetPrintpanel.add(textArea_1);
		
		JScrollPane scrollPane = new JScrollPane(textArea_1);
		scrollPane.setBounds(250, 180, 600, 350);
		NetPrintpanel.add(scrollPane);
		
		JButton btnNewButton_9_1_1 = new JButton("조회");
		btnNewButton_9_1_1.setForeground(Color.WHITE);
		btnNewButton_9_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_9_1_1.setBackground(new Color(101, 115, 94));
		btnNewButton_9_1_1.setBounds(440, 70, 200, 80);
		btnNewButton_9_1_1.setFocusable(false);
		NetPrintpanel.add(btnNewButton_9_1_1);
		btnNewButton_9_1_1.addActionListener(e->{
					s.netIncome();
              
					textArea_1.append("===============한 달 순이익 내역 조회===============\n");
					textArea_1.setCaretPosition(textArea_1.getDocument().getLength()); //맨 아래로 스크롤
              for(int j=0; j<s.netIncomeDataCard.size()-1; j+=2) {
            	  textArea_1.append(s.netIncomeDataCard.get(j)+ "원" +"\n");
            	  textArea_1.append(s.netIncomeDataCard.get(j+1)+"원 \n");
            	  textArea_1.append("=================================================\n");
              }
              textArea_1.append(" ★순이익 총 합계: "+s.sum2+ "원" +"\n");	
		});	
		
		JTextArea MoneytextArea_1 = new JTextArea();
		MoneytextArea_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		MoneytextArea_1.setBounds(190, 130, 450, 230);
		MoneytextArea_1.setEditable(false);
		SalesPrintpanel.add(MoneytextArea_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(MoneytextArea_1);
		scrollPane_1.setBounds(250, 180, 600, 350);
		SalesPrintpanel.add(scrollPane_1);
		SalesPrintpanel.setVisible(false);
		
		JButton OrderButton_1 = new JButton("한달 매출 조회");
		OrderButton_1.setForeground(Color.WHITE);
		OrderButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		OrderButton_1.setBackground(new Color(101, 115, 94));
		OrderButton_1.setBounds(110, 300, 200, 80);
		OrderButton_1.setFocusable(false);
		SalesChoicepanel.add(OrderButton_1);
		OrderButton_1.addActionListener(e->{
			SalesPrintpanel.setVisible(true);
			SalesChoicepanel.setVisible(false);
		});
		
		JButton ExitButton_2_1 = new JButton("한달 순이익 조회");
		ExitButton_2_1.setForeground(Color.WHITE);
		ExitButton_2_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ExitButton_2_1.setBackground(new Color(101, 115, 94));
		ExitButton_2_1.setBounds(425, 300, 220, 80);
		ExitButton_2_1.setFocusable(false);
		SalesChoicepanel.add(ExitButton_2_1);
		ExitButton_2_1.addActionListener(e->{
			NetPrintpanel.setVisible(true);
			SalesChoicepanel.setVisible(false);
			
		});
		JButton adminButton_1 = new JButton("총 자산 조회");
		adminButton_1.setForeground(Color.WHITE);
		adminButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		adminButton_1.setBackground(new Color(101, 115, 94));
		adminButton_1.setBounds(780, 300, 200, 80);
		adminButton_1.setFocusable(false);
		SalesChoicepanel.add(adminButton_1);
		adminButton_1.addActionListener(e->{
			Totalpanel.setVisible(true);
			SalesChoicepanel.setVisible(false);
		});
		
			JButton btnNewButton_9_1 = new JButton("조회");
			btnNewButton_9_1.setBounds(440, 70, 200, 80);
			btnNewButton_9_1.setForeground(Color.WHITE);
			btnNewButton_9_1.setFont(new Font("휴먼편지체", Font.BOLD, 20));
			btnNewButton_9_1.setBackground(new Color(101, 115, 94));
			btnNewButton_9_1.setFocusable(false);
			SalesPrintpanel.add(btnNewButton_9_1);
			btnNewButton_9_1.addActionListener(e->{
				 s.salesData();
				  MoneytextArea_1.append("================한 달 매출 내역 조회================\n");
				  MoneytextArea_1.setCaretPosition(MoneytextArea_1.getDocument().getLength()); //맨 아래로 스크롤
		            for(int j=0; j<s.salesDataCard.size(); j+=6) {
		            	MoneytextArea_1.append("주문번호: "+s.salesDataCard.get(j)+"\n");
		            	MoneytextArea_1.append("주문날짜: "+s.salesDataCard.get(j+1)+"\n");
		            	MoneytextArea_1.append("메뉴명: "+s.salesDataCard.get(j+2)+"\n");
		            	MoneytextArea_1.append("주문수량: "+s.salesDataCard.get(j+3)+"개 \n");
		            	MoneytextArea_1.append("메뉴가격: "+s.salesDataCard.get(j+4)+"원 \n");
		            	MoneytextArea_1.append("주문 총 가격: "+s.salesDataCard.get(j+5)+"원 \n");
		            	MoneytextArea_1.append("=================================================\n");
		            }
		            MoneytextArea_1.append("★매출 총 합계: "+s.sum+ "원" +"\n");				
			});

						//텍스트 모음
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 520, 680);
		InvenCheckpanel.add(textArea);
		textArea.setEditable(false);
		
		JTextArea InventextArea = new JTextArea();
		InventextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		InventextArea.setBounds(250, 180, 600, 350);
		InvenPrintpanel.add(InventextArea);
		InventextArea.setEditable(false);
		
		JPanel InvenPluspanel = new JPanel();
		frame.getContentPane().add(InvenPluspanel);
		InvenPluspanel.setBounds(0, 0, 1080, 720);
		InvenPluspanel.setLayout(null);	
		InvenPluspanel.setVisible(false);
		InvenOrderpanel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("재고를 선택해주세요");
		lblNewLabel_7.setBounds(400, 110, 450, 70);
		lblNewLabel_7.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		InvenOrderpanel.add(lblNewLabel_7);
		
		JLabel NumLabel_6 = new JLabel("주문하실 수량을 선택해주세요");
		NumLabel_6.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		NumLabel_6.setBounds(340, 110, 450, 70);
		InvenPluspanel.add(NumLabel_6);
				
		JButton btnNewButton1_6 = new JButton("10개");
		btnNewButton1_6.setForeground(Color.WHITE);
		btnNewButton1_6.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton1_6.setBackground(new Color(101, 115, 94));
		btnNewButton1_6.setBounds(100, 300, 200, 80);
		btnNewButton1_6.setFocusable(false);
		InvenPluspanel.add(btnNewButton1_6);
		btnNewButton1_6.addActionListener(e-> {
				number = 1;
				i.plusnum = 10;
				for(int j = 0;j<1;j++) {
				InvenPrintpanel.setVisible(true);
				InvenPluspanel.setVisible(false);
				}
			});
		
		JButton btnNewButton2_6 = new JButton("20개");
		btnNewButton2_6.setForeground(Color.WHITE);
		btnNewButton2_6.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton2_6.setBackground(new Color(101, 115, 94));
		btnNewButton2_6.setBounds(320, 300, 200, 80);
		btnNewButton2_6.setFocusable(false);
		InvenPluspanel.add(btnNewButton2_6);
		btnNewButton2_6.addActionListener(e-> {
				number = 2;
				i.plusnum = 20;
				for(int j = 0;j<1;j++) {
				InvenPrintpanel.setVisible(true);
				InvenPluspanel.setVisible(false);
				}
			});
		
		JButton	btnNewButton3_6 = new JButton("30개");
		btnNewButton3_6.setForeground(Color.WHITE);
		btnNewButton3_6.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton3_6.setBackground(new Color(101, 115, 94));
		btnNewButton3_6.setBounds(550, 300, 200, 80);
		btnNewButton3_6.setFocusable(false);
		InvenPluspanel.add(btnNewButton3_6);
		btnNewButton3_6.addActionListener(e-> {
				number = 3;
				i.plusnum = 30;
				for(int j = 0;j<1;j++) {
				InvenPrintpanel.setVisible(true);
				InvenPluspanel.setVisible(false);
				}
			});
		
		JButton btnNewButton4_7 = new JButton("40개");
		btnNewButton4_7.setForeground(Color.WHITE);
		btnNewButton4_7.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton4_7.setBackground(new Color(101, 115, 94));
		btnNewButton4_7.setBounds(770, 300, 200, 80);
		btnNewButton4_7.setFocusable(false);
		InvenPluspanel.add(btnNewButton4_7);
		btnNewButton4_7.addActionListener(e-> {
				number = 4;
				i.plusnum = 40;
				for(int j = 0;j<1;j++) {
				InvenPrintpanel.setVisible(true);
				InvenPluspanel.setVisible(false);
				}
			});
		
		JButton btnNewButton_11 = new JButton("네");
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_11.setBounds(580, 320, 200, 80);
		btnNewButton_11.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton_11.setFocusable(false);
		InvenCheckpanel.add(btnNewButton_11);
		btnNewButton_11.addActionListener(e-> {
				InvenCheckpanel.setVisible(false);
				InvenOrderpanel.setVisible(true);
			});
		
		JButton btnNewButton_12 = new JButton("재고 주문 영수증 확인");
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		btnNewButton_12.setBackground(new Color(101, 115, 94));
		btnNewButton_12.setBounds(440, 70, 200, 80);
		btnNewButton_12.setFocusable(false);
		InvenPrintpanel.add(btnNewButton_12);
		btnNewButton_12.addActionListener(e-> {
			i.InvenPlus(i.plusnum, i.plusname.toString());
			System.out.println(i.plusnum);
			System.out.println( i.plusname.toString());
				InventextArea.setText("");
				InventextArea.append("==================재고 주문 영수증==================\n");	
				for(int j=0;j<i.Invenp*3;j+=3) {				
					if(menu==1) {
							InventextArea.append("메뉴명 : " + m.menuList[j]+"\n");
						
						}else if(menu==2) {
							InventextArea.append("메뉴명 : " + m.menuList[j+1]+"\n");
							
						}else if(menu==3) {
							InventextArea.append("메뉴명 : " + m.menuList[j+2]+"\n");
						
						}else if(menu==4) {
							InventextArea.append("메뉴명 : " + m.menuList[j+3]+"\n");
						
						}else if(menu==5) {
							InventextArea.append("메뉴명 : " + m.menuList[j+4]+"\n");
						}					
							InventextArea.append("날짜 : " + i.Invenprint.get(j+1)+ "\n");
					if(number==1) {
							InventextArea.append("주문수량 : " +  i.invenNumList[j]+ "개" +"\n");
								
					    }else if(number==2) {
							InventextArea.append("주문수량 : " +  i.invenNumList[j+1]+ "개" +"\n");
							
					    }else if(number==3) {
							InventextArea.append("주문수량 : " +  i.invenNumList[j+2]+ "개" +"\n");
							
					    }else if(number==4) {
					 		InventextArea.append("주문수량 : " +  i.invenNumList[j+3]+ "개" +"\n");
					 		
					}				
					if(menu==1) {
							InventextArea.append("메뉴단가 : " + i.invenpiceList[j]+ "원" +"\n");
							InventextArea.append("총 주문 가격 : " + i.invenpiceList[j]*i.invenNumList[j]+ "원"  +"\n");
						}else if(menu==2) {
							InventextArea.append("메뉴단가 : " + i.invenpiceList[j+1]+"\n");
							InventextArea.append("총 주문 가격 : " + i.invenpiceList[j+1]*i.invenNumList[j+1]+ "원"  +"\n");
						}else if(menu==3) {
							InventextArea.append("메뉴단가 : " + i.invenpiceList[j+2]+"\n");
							InventextArea.append("총 주문 가격 : " + i.invenpiceList[j+2]*i.invenNumList[j+2]+ "원"  +"\n");
						}else if(menu==4) {
							InventextArea.append("메뉴단가 : " + i.invenpiceList[j+3]+"\n");
							InventextArea.append("총 주문 가격 : " + i.invenpiceList[j+3]*i.invenNumList[j+3]+ "원"  +"\n");
						}else if(menu==5) {
							InventextArea.append("메뉴단가 : " + i.invenpiceList[j+4]+"\n");
							InventextArea.append("총 주문 가격 : " + i.invenpiceList[j+4]*i.invenNumList[j+4]+ "원"  +"\n");
						}
				}
			});
		
		JButton CafeButton_2 = new JButton("초기화면");
		CafeButton_2.setForeground(Color.WHITE);
		CafeButton_2.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		CafeButton_2.setBackground(new Color(101, 115, 94));
		CafeButton_2.setBounds(110, 560, 200, 80);
		CafeButton_2.setFocusable(false);
		InvenPrintpanel.add(CafeButton_2);
		CafeButton_2.addActionListener(e-> {
				CafeMainpanel.setVisible(true);
				InvenPrintpanel.setVisible(false);
			});
		
		JButton ReloginButton_2 = new JButton("관리자 화면");
		ReloginButton_2.setForeground(Color.WHITE);
		ReloginButton_2.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ReloginButton_2.setBackground(new Color(101, 115, 94));
		ReloginButton_2.setBounds(440, 560, 200, 80);
		ReloginButton_2.setFocusable(false);
		InvenPrintpanel.add(ReloginButton_2);
		ReloginButton_2.addActionListener(e-> {
				Loginpanel.setVisible(true);
				InvenPrintpanel.setVisible(false);
			});
		JButton ExitButton_3 = new JButton("프로그램 종료");
		ExitButton_3.setForeground(Color.WHITE);
		ExitButton_3.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ExitButton_3.setBackground(new Color(101, 115, 94));
		ExitButton_3.setBounds(780, 560, 200, 80);
		ExitButton_3.setFocusable(false);
		InvenPrintpanel.add(ExitButton_3);
		ExitButton_3.addActionListener(e-> {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
				frame.setVisible(false);
			});
			
		JButton btnNewButton_11_1 = new JButton("아니오");
		btnNewButton_11_1.setForeground(Color.WHITE);
		btnNewButton_11_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_11_1.setBounds(800, 320, 200, 80);
		btnNewButton_11_1.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton_11_1.setFocusable(false);
		InvenCheckpanel.add(btnNewButton_11_1);
		btnNewButton_11_1.addActionListener(e-> {
				InvenCheckpanel.setVisible(false);
				Quaspanel.setVisible(true);
			});
		
		JButton americanoButton_1 = new JButton("디카페인_아메리카노");
		americanoButton_1.setBounds(400, 220, 280, 70);
		americanoButton_1.setForeground(Color.WHITE);
		americanoButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		americanoButton_1.setBackground(new Color(101, 115, 94));
		americanoButton_1.setFocusable(false);
		InvenOrderpanel.add(americanoButton_1);
		americanoButton_1.addActionListener(e-> {
				menu = 1;
					i.plusname = "디카페인_아메리카노";
				InvenPluspanel.setVisible(true);
				InvenOrderpanel.setVisible(false);	
			});
		
		JButton caffelatteButton_1 = new JButton("디카페인_카페라떼");
		caffelatteButton_1.setBounds(400, 300, 280, 70);
		caffelatteButton_1.setForeground(Color.WHITE);
		caffelatteButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		caffelatteButton_1.setBackground(new Color(101, 115, 94));
		caffelatteButton_1.setFocusable(false);
		InvenOrderpanel.add(caffelatteButton_1);
		caffelatteButton_1.addActionListener(e-> {
				menu = 2;
				i.plusname = "디카페인_카페라떼";
				InvenPluspanel.setVisible(true);
				InvenOrderpanel.setVisible(false);		
			});
		
		JButton caffemochaButton_1 = new JButton("디카페인_카페모카");
		caffemochaButton_1.setBounds(400, 380, 280, 70);
		caffemochaButton_1.setForeground(Color.WHITE);
		caffemochaButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		caffemochaButton_1.setBackground(new Color(101, 115, 94));
		caffemochaButton_1.setFocusable(false);
		InvenOrderpanel.add(caffemochaButton_1);
		caffemochaButton_1.addActionListener(e-> {
				menu = 3;
				i.plusname = "디카페인_카페모카";
				InvenPluspanel.setVisible(true);
				InvenOrderpanel.setVisible(false);
			});
		
		JButton madeleineButton_1 = new JButton("마들렌");
		madeleineButton_1.setBounds(400, 460, 280, 70);
		madeleineButton_1.setForeground(Color.WHITE);
		madeleineButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		madeleineButton_1.setBackground(new Color(101, 115, 94));
		madeleineButton_1.setFocusable(false);
		InvenOrderpanel.add(madeleineButton_1);
		madeleineButton_1.addActionListener(e-> {
				menu = 4;
				i.plusname = "마들렌";
				InvenPluspanel.setVisible(true);
				InvenOrderpanel.setVisible(false);	
			});
		
		JButton breadButton_1 = new JButton("허니 버터 브래드");
		breadButton_1.setBounds(400, 540, 280, 70);
		breadButton_1.setForeground(Color.WHITE);
		breadButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		breadButton_1.setBackground(new Color(101, 115, 94));
		breadButton_1.setFocusable(false);
		InvenOrderpanel.add(breadButton_1);
		breadButton_1.addActionListener(e-> {
				menu = 5;
				i.plusname = "허니 버터 브래드";
				InvenPluspanel.setVisible(true);
				InvenOrderpanel.setVisible(false);	
			});
		
		JLabel lblNewLabel_6 = new JLabel("재고 주문 하시겠습니까?");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		lblNewLabel_6.setBounds(560, 140, 450, 70);
		InvenCheckpanel.add(lblNewLabel_6);
		
		JButton BackButton_13 = new JButton("뒤로 가기");
		BackButton_13.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_13.setBounds(850, 560, 160, 70);
		BackButton_13.setFocusable(false);
		InvenCheckpanel.add(BackButton_13);
		BackButton_13.addActionListener(e-> {
				InvenCheckpanel.setVisible(false);
				Checkpanel.setVisible(true);
				});
		
		JTextArea CardtextArea = new JTextArea();
		CardtextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		CardtextArea.setBounds(250, 180, 600, 350);
		Cardpanel.add(CardtextArea);
		CardtextArea.setEditable(false);
		
		JTextArea MoneytextArea = new JTextArea();
		MoneytextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		MoneytextArea.setBounds(250, 180, 600, 350);
		Moneypanel.add(MoneytextArea);	
		MoneytextArea.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("현금을 입력해주세요");
		lblNewLabel_2.setFont(new Font("휴먼편지체", Font.BOLD, 40));
		lblNewLabel_2.setBounds(400, 130, 450, 70);
		MoneyInputpanel.add(lblNewLabel_2);
		
		JTextField textField = new JTextField("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("굴림", Font.BOLD, 25));
		textField.setBounds(365, 300, 350, 50);
		MoneyInputpanel.add(textField);
		textField.setColumns(10);
		
		JTextField passwordField = new JPasswordField();
		passwordField.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		passwordField.setBounds(500, 265, 320, 70);
		Loginpanel.add(passwordField);
		((JPasswordField) passwordField).setEchoChar('●');
		
						//레이블 모음
		JLabel lblNewLabel_5 = new JLabel("결제 방법을 선택해주세요");
		lblNewLabel_5.setFont(new Font("휴먼편지체", Font.BOLD, 40));
		lblNewLabel_5.setBounds(335, 130, 450, 70);
		Paypanel.add(lblNewLabel_5);
		Paypanel.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("추가 주문을 하시겠습니까? ");
		lblNewLabel_4.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		lblNewLabel_4.setBounds(370, 130, 450, 70);
		PlusOrderpanel.add(lblNewLabel_4);
		
		JLabel NumLabel_5 = new JLabel("주문하실 수량을 선택해주세요");
		NumLabel_5.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		NumLabel_5.setBounds(340, 110, 450, 70);
		Ordernumpanel.add(NumLabel_5);
		
		JLabel lblNewLabel = new JLabel("메뉴를 선택해주세요");
		lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		lblNewLabel.setBounds(400, 110, 450, 70);
		Orderpanel.add(lblNewLabel);

		HelloLabel = new JLabel("거기서 거기 카페에 오신걸 환영합니다");
		HelloLabel.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		HelloLabel.setBounds(280, 120, 700, 90);
		CafeStartpanel.add(HelloLabel);

		JLabel lblNewLabel_1 = new JLabel("재고를 주문하시겠습니까?");
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		lblNewLabel_1.setBounds(280, 200, 250, 30);
		tablepanel.add(lblNewLabel_1);
		
		JLabel PASS = new JLabel("Admin Pass : ");
		PASS.setBounds(260, 260, 260, 80);
		PASS.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		Loginpanel.add(PASS);

		JLabel LogIn = new JLabel("LOG IN");
		LogIn.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		LogIn.setBounds(470, 120, 200, 90);
		Loginpanel.add(LogIn);

		JButton btnNewButton_9 = new JButton("현금 영수증 확인");
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_9.setBounds(430, 70, 220, 80);
		btnNewButton_9.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton_9.setFocusable(false);
		Moneypanel.add(btnNewButton_9);
		
		JButton CafeButton_2_1_1_1_1 = new JButton("초기화면");
	      CafeButton_2_1_1_1_1.setForeground(Color.WHITE);
	      CafeButton_2_1_1_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
	      CafeButton_2_1_1_1_1.setBackground(new Color(101, 115, 94));
	      CafeButton_2_1_1_1_1.setBounds(110, 560, 200, 80);
	      CafeButton_2_1_1_1_1.setFocusable(false);
	      Totalpanel.add(CafeButton_2_1_1_1_1);
	      CafeButton_2_1_1_1_1.addActionListener(e->{
	    	  Totalpanel.setVisible(false);
	    	  CafeStartpanel.setVisible(true);
	      });
	      		
	      JButton ReloginButton_2_1_1_1_1 = new JButton("관리자 화면");
	      ReloginButton_2_1_1_1_1.setForeground(Color.WHITE);
	      ReloginButton_2_1_1_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
	      ReloginButton_2_1_1_1_1.setBackground(new Color(101, 115, 94));
	      ReloginButton_2_1_1_1_1.setBounds(440, 560, 200, 80);
	      ReloginButton_2_1_1_1_1.setFocusable(false);
	      Totalpanel.add(ReloginButton_2_1_1_1_1);
	      ReloginButton_2_1_1_1_1.addActionListener(e->{
	    	  tablepanel.setVisible(false);
	    	  Loginpanel.setVisible(true);
	      });
	      JButton ExitButton_3_1_1_1_1 = new JButton("프로그램 종료");
	      ExitButton_3_1_1_1_1.setForeground(Color.WHITE);
	      ExitButton_3_1_1_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
	      ExitButton_3_1_1_1_1.setBackground(new Color(101, 115, 94));
	      ExitButton_3_1_1_1_1.setBounds(780, 560, 200, 80);
	      ExitButton_3_1_1_1_1.setFocusable(false);
	      Totalpanel.add(ExitButton_3_1_1_1_1);
	      ExitButton_3_1_1_1_1.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
					frame.setVisible(false);	
				}
			});
	      
		JButton CafeButton_2_1 = new JButton("초기화면");
		CafeButton_2_1.setForeground(Color.WHITE);
		CafeButton_2_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		CafeButton_2_1.setBackground(new Color(101, 115, 94));
		CafeButton_2_1.setBounds(110, 560, 200, 80);
		CafeButton_2_1.setFocusable(false);
		Moneypanel.add(CafeButton_2_1);
		CafeButton_2_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputCash=0;
				changes=0;
				textField.setText("");
				MoneytextArea.setText("");
				o.TotalSum=0;
				o.updateNum=1;
				o.reOrderNum=1;
				o.OrderCount.clear();
				o.menuName.clear();
				o.printCard.clear();
				CafeStartpanel.setVisible(true);
				Moneypanel.setVisible(false);
				
			}
		});
		
		JButton ReloginButton_2_1 = new JButton("관리자 화면");
		ReloginButton_2_1.setForeground(Color.WHITE);
		ReloginButton_2_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ReloginButton_2_1.setBackground(new Color(101, 115, 94));
		ReloginButton_2_1.setBounds(440, 560, 200, 80);
		ReloginButton_2_1.setFocusable(false);
		Moneypanel.add(ReloginButton_2_1);
		ReloginButton_2_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Loginpanel.setVisible(true);
				Moneypanel.setVisible(false);	
			}
		});
		
		JButton ExitButton_3_1 = new JButton("프로그램 종료");
		ExitButton_3_1.setForeground(Color.WHITE);
		ExitButton_3_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ExitButton_3_1.setBackground(new Color(101, 115, 94));
		ExitButton_3_1.setBounds(780, 560, 200, 80);
		ExitButton_3_1.setFocusable(false);
		Moneypanel.add(ExitButton_3_1);
		
		JScrollPane scrollPane_3 = new JScrollPane(MoneytextArea);
		scrollPane_3.setBounds(250, 180, 600, 350);
		Moneypanel.add(scrollPane_3);
		
		
		ExitButton_3_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
				frame.setVisible(false);	
			}
		});
		
		JButton CafeButton_2_1_1_1 = new JButton("초기화면");
		CafeButton_2_1_1_1.setForeground(Color.WHITE);
		CafeButton_2_1_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		CafeButton_2_1_1_1.setBackground(new Color(101, 115, 94));
		CafeButton_2_1_1_1.setBounds(110, 560, 200, 80);
		CafeButton_2_1_1_1.setFocusable(false);
		NetPrintpanel.add(CafeButton_2_1_1_1);
		CafeButton_2_1_1_1.addActionListener(e->{
			NetPrintpanel.setVisible(false);
			CafeMainpanel.setVisible(true);
		});
		
		JButton ReloginButton_2_1_1_1 = new JButton("관리자 화면");
		ReloginButton_2_1_1_1.setForeground(Color.WHITE);
		ReloginButton_2_1_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ReloginButton_2_1_1_1.setBackground(new Color(101, 115, 94));
		ReloginButton_2_1_1_1.setBounds(440, 560, 200, 80);
		ReloginButton_2_1_1_1.setFocusable(false);
		NetPrintpanel.add(ReloginButton_2_1_1_1);
		ReloginButton_2_1_1_1.addActionListener(e->{
			NetPrintpanel.setVisible(false);
			Loginpanel.setVisible(true);
		});
		
		JButton ExitButton_3_1_1_1 = new JButton("프로그램 종료");
		ExitButton_3_1_1_1.setForeground(Color.WHITE);
		ExitButton_3_1_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ExitButton_3_1_1_1.setBackground(new Color(101, 115, 94));
		ExitButton_3_1_1_1.setBounds(780, 560, 200, 80);
		ExitButton_3_1_1_1.setFocusable(false);
		NetPrintpanel.add(ExitButton_3_1_1_1);
		ExitButton_3_1_1_1.addActionListener(e->{
			JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
			frame.setVisible(false);
		});
		
		JButton CafeButton_2_1_1 = new JButton("초기화면");
		CafeButton_2_1_1.setBounds(110, 560, 200, 80);
		CafeButton_2_1_1.setForeground(Color.WHITE);
		CafeButton_2_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		CafeButton_2_1_1.setBackground(new Color(101, 115, 94));
		CafeButton_2_1_1.setFocusable(false);
		SalesPrintpanel.add(CafeButton_2_1_1);
		CafeButton_2_1_1.addActionListener(e->{
			CafeStartpanel.setVisible(true);
			SalesPrintpanel.setVisible(false);
		});
		
		JButton ReloginButton_2_1_1 = new JButton("관리자 화면");
		ReloginButton_2_1_1.setBounds(440, 560, 200, 80);
		ReloginButton_2_1_1.setForeground(Color.WHITE);
		ReloginButton_2_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ReloginButton_2_1_1.setBackground(new Color(101, 115, 94));
		ReloginButton_2_1_1.setFocusable(false);
		SalesPrintpanel.add(ReloginButton_2_1_1);
		ReloginButton_2_1_1.addActionListener(e->{
			Loginpanel.setVisible(true);
			SalesPrintpanel.setVisible(false);
		});
		JButton ExitButton_3_1_1 = new JButton("프로그램 종료");
		ExitButton_3_1_1.setBounds(780, 560, 200, 80);
		ExitButton_3_1_1.setForeground(Color.WHITE);
		ExitButton_3_1_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ExitButton_3_1_1.setBackground(new Color(101, 115, 94));
		ExitButton_3_1_1.setFocusable(false);
		SalesPrintpanel.add(ExitButton_3_1_1);
		ExitButton_3_1_1.addActionListener(e->{
			JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
			frame.setVisible(false);
		});
		
		btnNewButton_9.addActionListener(e-> {	
			if(o.updateNum==1) {
				o.selecteOrderCount(o.reOrderNum);
				o.update ();
				MoneytextArea.setText("");
				MoneytextArea.append("====================현금 영수증====================\n");	
				for(int j=0;j<o.reOrderNum*3;j+=3) {
					MoneytextArea.append("메뉴명: "+o.printCard.get(j)+"\n");
					MoneytextArea.append("주문수량: "+o.printCard.get(j+1)+ "개" +"\n");
					MoneytextArea.append("메뉴별 총액: "+o.printCard.get(j+2)+ "원" +"\n");
					MoneytextArea.append("\n");	
						}
				MoneytextArea.append("==================================================\n");
				MoneytextArea.append("총 주문금액: "+o.TotalSum+ "원" +"\n");
				MoneytextArea.append("내가낸돈:" +inputCash+ "원" +"\n");				
				MoneytextArea.append("거스름돈: "+changes+ "원" +"\n");	
				
				o.updateNum++;
				return;
		}else {
			return;
		}	
			});
		
		JButton btnNewButton_8 = new JButton("확인");
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_8.setBounds(440, 460, 200, 80);
		btnNewButton_8.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton_8.setFocusable(false);
		MoneyInputpanel.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s1 =textField.getText();
		         int num=0;
		         for(int j=0;j<s1.length();j++) {
		            if('0'<=s1.charAt(j)&&s1.charAt(j)<='9') {
		               num++;
		               
		               if(num==s1.length()) {
		               
		         
		               if(textField.getText().trim().isEmpty()||textField.getText()=="") {
		                  textField.setText("다시 입력하세요.");
		               }else {
		                  inputCash=Integer.parseInt(textField.getText());
		                  if(inputCash<o.TotalSum) {
		                     JOptionPane.showMessageDialog(null, "금액이 부족합니다");
		                     return;
		                  }else if(inputCash>=o.TotalSum) {
		                     changes=inputCash-o.TotalSum;
		                     MoneyInputpanel.setVisible(false);
		                     Moneypanel.setVisible(true);
		                  }else {
		                     textField.setText("예외 발생");
		                  }
		               }}
		         }else {
		            lblNewLabel_2.setText("<HTML><pre>  문자안됨!!!</pre></HTML>");   }
		         }}
		});

		
		JButton btnNewButton_7 = new JButton("카드 영수증 확인");
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_7.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton_7.setBounds(430, 70, 220, 80);
		btnNewButton_7.setFocusable(false);
		Cardpanel.add(btnNewButton_7);
		
		JButton CafeButton_1 = new JButton("초기화면");
		CafeButton_1.setForeground(Color.WHITE);
		CafeButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		CafeButton_1.setBackground(new Color(101, 115, 94));
		CafeButton_1.setBounds(110, 560, 200, 80);
		CafeButton_1.setFocusable(false);
		Cardpanel.add(CafeButton_1);
		CafeButton_1.addActionListener(e-> {
			inputCash=0;
			changes=0;
			o.TotalSum=0;
			o.updateNum=1;
			o.reOrderNum=1;
			o.OrderCount.clear();
			o.menuName.clear();
			o.printCard.clear();
				Cardpanel.setVisible(false);
				CafeMainpanel.setVisible(true);	
				
			});
		
		JButton ReloginButton_1 = new JButton("관리자 화면");
		ReloginButton_1.setForeground(Color.WHITE);
		ReloginButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ReloginButton_1.setBackground(new Color(101, 115, 94));
		ReloginButton_1.setBounds(440, 560, 200, 80);
		ReloginButton_1.setFocusable(false);
		Cardpanel.add(ReloginButton_1);
		ReloginButton_1.addActionListener(e-> {
				Cardpanel.setVisible(false);
				Loginpanel.setVisible(true);		
			});
		
		JButton ExitButton_1 = new JButton("프로그램 종료");
		ExitButton_1.setForeground(Color.WHITE);
		ExitButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ExitButton_1.setBackground(new Color(101, 115, 94));
		ExitButton_1.setBounds(780, 560, 200, 80);
		ExitButton_1.setFocusable(false);
		Cardpanel.add(ExitButton_1);
		
		JScrollPane scrollPane_4 = new JScrollPane(CardtextArea);
		scrollPane_4.setBounds(250, 180, 600, 350);
		Cardpanel.add(scrollPane_4);
		ExitButton_1.addActionListener(e-> {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
				frame.setVisible(false);		
			});
		
		btnNewButton_7.addActionListener(e-> {
			if(o.updateNum==1) {
				o.print01(o.reOrderNum);
				o.Total(o.reOrderNum);
				o.selecteOrderCount(o.reOrderNum);
				o.update();
				CardtextArea.setText("");
				CardtextArea.append("====================카드 영수증====================\n");	
				for(int j=0;j<o.reOrderNum*3;j+=3) {
					CardtextArea.append("메뉴명: "+o.printCard.get(j)+"\n");
					CardtextArea.append("주문수량: "+o.printCard.get(j+1)+ "개" +"\n");
					CardtextArea.append("메뉴별 총액: "+o.printCard.get(j+2)+ "원" +"\n");
					CardtextArea.append("\n");	
						}
				CardtextArea.append("=================================================\n");
				CardtextArea.append("총 주문금액: "+o.TotalSum+ "원");
				o.updateNum++;
				return;
			}else {
				return;	
			}
			});
			
		JButton btnNewButton_5 = new JButton("카드 결제");
		btnNewButton_5.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(250, 380, 200, 80);
		btnNewButton_5.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton_5.setFocusable(false);
		Paypanel.add(btnNewButton_5);
		btnNewButton_5.addActionListener(e-> {
				Paypanel.setVisible(false);
				Cardpanel.setVisible(true);				
			});
		
		JButton btnNewButton_6 = new JButton("현금 결제");
		btnNewButton_6.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBounds(610, 380, 200, 80);
		btnNewButton_6.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton_6.setFocusable(false);
		Paypanel.add(btnNewButton_6);
		btnNewButton_6.addActionListener(e-> {
				o.print01(o.reOrderNum);
				o.Total(o.reOrderNum);
				Paypanel.setVisible(false);
				MoneyInputpanel.setVisible(true);				
			});

		JButton btnNewButton = new JButton("네");
		btnNewButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(250, 380, 200, 80);
		btnNewButton.setFocusable(false);
		PlusOrderpanel.add(btnNewButton);
		btnNewButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton.addActionListener(e-> {
				o.reOrderNum++;
				o.UpdeteOrderIncome(num);
				PlusOrderpanel.setVisible(false);
				Paypanel.setVisible(false);
				Orderpanel.setVisible(true);
			});		
		
		JButton btnNewButton_4 = new JButton("아니요");
		btnNewButton_4.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(610, 380, 220, 80);
		btnNewButton_4.setFocusable(false);
		PlusOrderpanel.add(btnNewButton_4);
		PlusOrderpanel.setVisible(false);
		btnNewButton_4.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));		
		btnNewButton_4.addActionListener(e-> {
				o.UpdeteOrderIncome(num);
				PlusOrderpanel.setVisible(false);
				Paypanel.setVisible(true);
			});		

		JButton BackButton_11 = new JButton("뒤로 가기");
		BackButton_11.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_11.setBounds(850, 560, 160, 70);
		BackButton_11.setFocusable(false);
		Ordernumpanel.add(BackButton_11);
		BackButton_11.addActionListener(e-> {			
				Ordernumpanel.setVisible(false);
				Orderpanel.setVisible(true);
			});

		JButton btnNewButton1_5 = new JButton("1");
		btnNewButton1_5.setForeground(new Color(255, 255, 255));
		btnNewButton1_5.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton1_5.setBounds(100, 300, 160, 80);
		btnNewButton1_5.setFocusable(false);
		Ordernumpanel.add(btnNewButton1_5);
		btnNewButton1_5.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton1_5.addActionListener(e -> {
				o.SelecteOrderNumber();
				o.UpdeteOrderNum(1, o.a);
				o.UpdeteOrderTotal(o.a);
				Ordernumpanel.setVisible(false);
				PlusOrderpanel.setVisible(true);
			});

		JButton btnNewButton2_5 = new JButton("2");
		btnNewButton2_5.setForeground(new Color(255, 255, 255));
		btnNewButton2_5.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton2_5.setBounds(280, 300, 160, 80);
		btnNewButton2_5.setFocusable(false);
		Ordernumpanel.add(btnNewButton2_5);
		btnNewButton2_5.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton2_5.addActionListener(e-> {
				o.SelecteOrderNumber();
				o.UpdeteOrderNum(2, o.a);
				o.UpdeteOrderTotal(o.a);
				Ordernumpanel.setVisible(false);
				PlusOrderpanel.setVisible(true);
			});

		JButton btnNewButton3_5 = new JButton("3");
		btnNewButton3_5.setForeground(new Color(255, 255, 255));
		btnNewButton3_5.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton3_5.setBounds(465, 300, 160, 80);
		btnNewButton3_5.setFocusable(false);
		Ordernumpanel.add(btnNewButton3_5);
		btnNewButton3_5.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton3_5.addActionListener(e-> {
				o.SelecteOrderNumber();
				o.UpdeteOrderNum(3, o.a);
				o.UpdeteOrderTotal(o.a);
				Ordernumpanel.setVisible(false);
				PlusOrderpanel.setVisible(true);
			});

		JButton btnNewButton4_5 = new JButton("4");
		btnNewButton4_5.setForeground(new Color(255, 255, 255));
		btnNewButton4_5.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton4_5.setBounds(650, 300, 160, 80);
		btnNewButton4_5.setFocusable(false);
		Ordernumpanel.add(btnNewButton4_5);
		btnNewButton4_5.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton4_5.addActionListener(e-> {
				o.SelecteOrderNumber();
				o.UpdeteOrderNum(4, o.a);
				o.UpdeteOrderTotal(o.a);
				Ordernumpanel.setVisible(false);
				PlusOrderpanel.setVisible(true);
			});
		
		JButton btnNewButton4_6 = new JButton("5");
		btnNewButton4_6.setForeground(new Color(255, 255, 255));
		btnNewButton4_6.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		btnNewButton4_6.setBounds(830, 300, 160, 80);
		btnNewButton4_5.setFocusable(false);
		Ordernumpanel.add(btnNewButton4_6);
		btnNewButton4_6.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		btnNewButton4_6.addActionListener(e-> {
				o.SelecteOrderNumber();
				o.UpdeteOrderNum(5, o.a);
				o.UpdeteOrderTotal(o.a);
				Ordernumpanel.setVisible(false);
				PlusOrderpanel.setVisible(true);
			});
		
		JButton americanoButton = new JButton("<HTML>디카페인_아메리카노<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3000원)</HTML>");
		americanoButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		americanoButton.setForeground(new Color(255, 255, 255));
		americanoButton.setBounds(400, 220, 280, 70);
		americanoButton.setFocusable(false);
		Orderpanel.add(americanoButton);
		americanoButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		americanoButton.addActionListener(e-> {
			o.OrderCheck();
			for(int j = 0;j<o.InvenCount.size();j++) {	
				if(o.InvenCount.get(j).equals(m.menuList[0])) {
					JOptionPane.showMessageDialog(null, "재고가 부족합니다!");
					Orderpanel.setVisible(true);
					Ordernumpanel.setVisible(false);
					PlusOrderpanel.setVisible(false);
				}else {
					num=0;
					o.insertMenuPrice(num);
					Orderpanel.setVisible(false);
					Ordernumpanel.setVisible(true);			
				}
		}
			o.InvenCount.clear();
			});

		JButton caffelatteButton = new JButton("<HTML>디카페인_카페라떼<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3500원)</HTML>");
		caffelatteButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		caffelatteButton.setForeground(new Color(255, 255, 255));
		caffelatteButton.setBounds(400, 300, 280, 70);
		caffelatteButton.setFocusable(false);
		Orderpanel.add(caffelatteButton);
		caffelatteButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		caffelatteButton.addActionListener(e-> {
			o.OrderCheck();
			for(int j = 0;j<o.InvenCount.size();j++) {		
				if(o.InvenCount.get(j).equals(m.menuList[1])) {
					JOptionPane.showMessageDialog(null, "재고가 부족합니다!");
					Orderpanel.setVisible(true);
					Ordernumpanel.setVisible(false);
					PlusOrderpanel.setVisible(false);
				}else {
					num=1;
					o.insertMenuPrice(num);
					Orderpanel.setVisible(false);
					Ordernumpanel.setVisible(true);
				
			}
				o.InvenCount.clear();
		}
			});
		JButton caffemochaButton = new JButton("<HTML>디카페인_카페모카<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3500원)</HTML>");
		caffemochaButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		caffemochaButton.setForeground(new Color(255, 255, 255));
		caffemochaButton.setBounds(400, 380, 280, 70);
		caffemochaButton.setFocusable(false);
		Orderpanel.add(caffemochaButton);
		caffemochaButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		caffemochaButton.addActionListener(e-> {
			o.OrderCheck();
			for(int j = 0;j<o.InvenCount.size();j++) {		
				if(o.InvenCount.get(j).equals(m.menuList[2])) {
					JOptionPane.showMessageDialog(null, "재고가 부족합니다!");
					Orderpanel.setVisible(true);
					Ordernumpanel.setVisible(false);
					PlusOrderpanel.setVisible(false);
			}else {
				num=2;
				o.insertMenuPrice(num);
				Orderpanel.setVisible(false);
				Ordernumpanel.setVisible(true);
			}
				o.InvenCount.clear();
		}
			});

		JButton madeleineButton = new JButton("<HTML>&nbsp;&nbsp;마들렌<br>(2500원)</HTML>");
		madeleineButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		madeleineButton.setForeground(new Color(255, 255, 255));
		madeleineButton.setBounds(400, 460, 280, 70);
		Orderpanel.add(madeleineButton);
		madeleineButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		madeleineButton.setFocusable(false);
		madeleineButton.addActionListener(e-> {
			o.OrderCheck();
			for(int j = 0;j<o.InvenCount.size();j++) {		
				if(o.InvenCount.get(j).equals(m.menuList[3])) {
					JOptionPane.showMessageDialog(null, "재고가 부족합니다!");
					Orderpanel.setVisible(true);
					Ordernumpanel.setVisible(false);
					PlusOrderpanel.setVisible(false);
				}else {
					num=3;
					o.insertMenuPrice(num);
					Orderpanel.setVisible(false);
					Ordernumpanel.setVisible(true);
				
			}
				o.InvenCount.clear();
		}
			});

		JButton breadButton = new JButton("<HTML>허니 버터 브래드<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(7000원)</HTML>");
		breadButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		breadButton.setForeground(new Color(255, 255, 255));
		breadButton.setBounds(400, 540, 280, 70);
		Orderpanel.add(breadButton);
		breadButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		breadButton.setFocusable(false);
		breadButton.addActionListener(e-> {
			o.OrderCheck();
			for(int j = 0;j<o.InvenCount.size();j++) {		
				if(o.InvenCount.get(j).equals(m.menuList[4])) {
					JOptionPane.showMessageDialog(null, "재고가 부족합니다!");
					Orderpanel.setVisible(true);
					Ordernumpanel.setVisible(false);
					PlusOrderpanel.setVisible(false);
				}else {
					num=4;
					o.insertMenuPrice(num);
					Orderpanel.setVisible(false);
					Ordernumpanel.setVisible(true);
				
			}
				o.InvenCount.clear();
		}
			});

		JButton OrderButton = new JButton("주문하기");
		OrderButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		OrderButton.setForeground(new Color(255, 255, 255));
		OrderButton.setBounds(110, 300, 220, 80);
		OrderButton.setFocusable(false);
		CafeMainpanel.add(OrderButton);
		OrderButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		OrderButton.addActionListener(e-> {
				CafeMainpanel.setVisible(false);
				Orderpanel.setVisible(true);
			});
		
		JButton adminButton = new JButton("관리자 모드");
		adminButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		adminButton.setForeground(new Color(255, 255, 255));
		adminButton.setBounds(440, 300, 200, 80);
		adminButton.setFocusable(false);
		CafeMainpanel.add(adminButton);
		adminButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		adminButton.addActionListener(e-> {
				CafeMainpanel.setVisible(false);
				Loginpanel.setVisible(true);
			});

		JButton ExitButton_2 = new JButton("프로그램 종료");
		ExitButton_2.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ExitButton_2.setForeground(new Color(255, 255, 255));
		ExitButton_2.setBounds(780, 300, 220, 80);
		ExitButton_2.setFocusable(false);
		CafeMainpanel.add(ExitButton_2);
		ExitButton_2.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		ExitButton_2.addActionListener(e-> {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
				frame.setVisible(false);
			});
		
		JButton StartButton = new JButton("시작하시려면 버튼을 눌러주세요");
		StartButton.setForeground(new Color(255, 255, 255));
		StartButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		StartButton.setBounds(352, 300, 400, 80);
		StartButton.setFocusable(false);
		CafeStartpanel.add(StartButton);
		StartButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		StartButton.addActionListener(e-> {
				CafeStartpanel.setVisible(false);
				CafeMainpanel.setVisible(true);
			});

		JButton CafeButton = new JButton("초기화면");
		CafeButton.setForeground(Color.WHITE);
		CafeButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		CafeButton.setBounds(110, 300, 200, 80);
		CafeButton.setFocusable(false);
		Quaspanel.add(CafeButton);
		CafeButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		CafeButton.addActionListener(e-> {
				Quaspanel.setVisible(false);
				CafeMainpanel.setVisible(true);
			});

		JButton ReloginButton = new JButton("관리자 화면");
		ReloginButton.setForeground(Color.WHITE);
		ReloginButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ReloginButton.setBounds(440, 300, 200, 80);
		ReloginButton.setFocusable(false);
		Quaspanel.add(ReloginButton);
		ReloginButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		ReloginButton.addActionListener(e-> {
				Checkpanel.setVisible(true);
				Quaspanel.setVisible(false);
			});
		
		JButton ExitButton = new JButton("프로그램 종료");
		ExitButton.setForeground(Color.WHITE);
		ExitButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		ExitButton.setBounds(780, 300, 200, 80);
		ExitButton.setFocusable(false);
		Quaspanel.add(ExitButton);
		ExitButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		ExitButton.addActionListener(e-> {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
				frame.setVisible(false);
			});
		
		JButton InvenButton_1 = new JButton("자산 관리");
		InvenButton_1.setForeground(new Color(255, 255, 255));
		InvenButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		InvenButton_1.setBounds(260, 300, 200, 80);
		InvenButton_1.setFocusable(false);
		Checkpanel.add(InvenButton_1);
		InvenButton_1.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		InvenButton_1.addActionListener(e-> {
				Checkpanel.setVisible(false);
				SalesChoicepanel.setVisible(true);	
			});	

		JButton InvenButton = new JButton("재고 관리");
		InvenButton.setForeground(new Color(255, 255, 255));
		InvenButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		InvenButton.setBounds(630, 300, 200, 80);
		InvenButton.setFocusable(false);
		Checkpanel.add(InvenButton);
		InvenButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
				InvenButton.addActionListener(e-> {
						
						Checkpanel.setVisible(false);
						InvenCheckpanel.setVisible(true);
						i.invenOrder();
						i.alarm();
						
						textArea.setText("");
						textArea.append("\n");	
						textArea.append("\n");	
						textArea.append("====================현 재고 현황====================\n");	
						textArea.append("\n");	
						for(int j = 0; j <19; j+=4) {						
							textArea.append("	 메뉴명: " + i.Invenprint.get(j) + "\n");
							textArea.append("	 주문 날짜 : " + i.Invenprint.get(j+1) + "\n");
							textArea.append("	 주문 수량 : " + i.Invenprint.get(j+2)+ "개"  + "\n");
							textArea.append("	 재고 단가 : " + i.Invenprint.get(j+3)+ "원"  + "\n");
							textArea.append("\n");
						}
						for(int k = 0; k < i.v2.size(); k++) {
							if(i.v2.get(k) != null) {
								JOptionPane.showMessageDialog(null, "현재 " + i.v2.get(k) + "의 재고가 없습니다!","알립니다!",JOptionPane.INFORMATION_MESSAGE);		
							}
						}
						i.v2.clear();
					});

		JButton LoginButton = new JButton("Log In");
		LoginButton.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		LoginButton.setForeground(Color.WHITE);
		LoginButton.setIcon(null);
		LoginButton.setBounds(440, 400, 200, 80);
		LoginButton.setFocusable(false);
		Loginpanel.add(LoginButton);
		LoginButton.setBackground(Color.getHSBColor(0.28f, 0.18f, 0.45f));
		LoginButton.addActionListener(e-> {
				if (passwordField.getText().equals("1")) {
					Checkpanel.setVisible(true);
					Loginpanel.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다!");
				}
				passwordField.setText("");
		});
		
		JButton BackButton_1 = new JButton("뒤로 가기");
		BackButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_1.setBounds(850, 560, 160, 70);
		BackButton_1.setFocusable(false);
		Loginpanel.add(BackButton_1);
		BackButton_1.addActionListener(e-> {
				Loginpanel.setVisible(false);
				CafeMainpanel.setVisible(true);
			});
	
		JButton BackButton_15 = new JButton("뒤로 가기");
		BackButton_15.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_15.setBounds(850, 560, 160, 70);
		BackButton_15.setFocusable(false);
		InvenPluspanel.add(BackButton_15);
		InvenPluspanel.setVisible(false);
		BackButton_15.addActionListener(e-> {
				InvenPluspanel.setVisible(false);
				InvenOrderpanel.setVisible(true);
			});
		
		JButton BackButton_14 = new JButton("뒤로 가기");
		BackButton_14.setBounds(850, 560, 160, 70);
		BackButton_14.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_14.setFocusable(false);
		InvenOrderpanel.add(BackButton_14);
		InvenOrderpanel.setVisible(false);
		BackButton_14.addActionListener(e-> {
				InvenOrderpanel.setVisible(false);
				InvenCheckpanel.setVisible(true);				
			});
		
		JButton BackButton_14_1 = new JButton("뒤로 가기");
		BackButton_14_1.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_14_1.setBounds(850, 560, 160, 70);
		BackButton_14_1.setFocusable(false);
		SalesChoicepanel.add(BackButton_14_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("자산 관리를 선택하셨습니다");
		lblNewLabel_3_1.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		lblNewLabel_3_1.setBounds(350, 130, 450, 70);
		SalesChoicepanel.add(lblNewLabel_3_1);
		BackButton_14_1.addActionListener(e->{
			Checkpanel.setVisible(true);
			SalesChoicepanel.setVisible(false);
		});
		
		JButton BackButton_7 = new JButton("뒤로 가기");
		Orderpanel.add(BackButton_7);
		BackButton_7.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_7.setBounds(850, 560, 160, 70);
		BackButton_7.setFocusable(false);
		BackButton_7.addActionListener(e-> {
				Orderpanel.setVisible(false);
				CafeMainpanel.setVisible(true);
			});	
		JButton BackButton_2 = new JButton("뒤로 가기");
		BackButton_2.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_2.setBounds(850, 560, 160, 70);
		BackButton_2.setFocusable(false);
		Checkpanel.add(BackButton_2);
		BackButton_2.addActionListener(e-> {
				Checkpanel.setVisible(false);
				Loginpanel.setVisible(true);
			});
		JButton BackButton_3 = new JButton("뒤로 가기");
		BackButton_3.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		BackButton_3.setBounds(670, 390, 116, 40);
		BackButton_3.setFocusable(false);
		tablepanel.add(BackButton_3);

		BackButton_3.addActionListener(e-> {
				tablepanel.setVisible(false);
				Checkpanel.setVisible(true);
			});
		}
}