package test2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Main extends Frame implements ActionListener {
	
	/*
	CardLayout card;
	Panel first_panel, second_panel, third_panel;
	
	public Main() {
		super("CardLayout 테스트");
		card = new CardLayout();
		setLayout(card);
		
		first_panel = new Panel();
		first_panel.add(new Button("1"));
		first_panel.add(new Button("2"));
		
		second_panel = new Panel();
		second_panel.add(new Button("3"));
		second_panel.add(new Button("4"));
		
		third_panel = new Panel();
		third_panel.add(new Button("5"));
		third_panel.add(new Button("6"));
		
		add("1", first_panel);
		add("2", second_panel);
		add("3", third_panel);
		
	}
	
	public void rotate() {
		for(int i = 0; i < 2; i++)
		{
			try {
				Thread.sleep(3000);
			} catch(Exception e) {
				e.printStackTrace();
			}
			card.next(this);
		}
	}
	*/
	
	Panel p;
	Button input, exit;
	TextArea ta;
	
	public Main()
	{
		super("ActionEvent Test");
		p = new Panel();
		
		input = new Button("입력");
		exit = new Button("종료");
		ta = new TextArea();
		
		input.addActionListener(this);
		exit.addActionListener(this);
		
		p.add(input);
		p.add(exit);
		
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		setBounds(300, 300, 300, 200);
		setVisible(true);
		
		addWindowListener((WindowListener) this); // Label에서 X누르면 종료
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String name;
		name = ae.getActionCommand();
		
		if(name.equals("입력"))
		{
			ta.append("버튼이 입력되었습니다.\n");
		}
		else
		{
			ta.append("프로그램을 종료합니다.\n");
			try {
				Thread.sleep(2000);
			} catch(Exception e) {}
			System.exit(0);
		}
	}

	
	
	public void windowClosing(WindowEvent e) // Label에서 X누르면 종료
	{
		System.exit(0);
	}
	
	public void windowActivated(WindowEvent e) {} // WindowListener가 인터페이스라 메소드를 사용해서 이벤트 사용가능
	public void windowClosed(WindowEvent e) {} // WindowListener가 인터페이스라 메소드를 사용해서 이벤트 사용가능
	public void windowDeactivated(WindowEvent e) {} // WindowListener가 인터페이스라 메소드를 사용해서 이벤트 사용가능
	public void windowDeiconified(WindowEvent e) {} // WindowListener가 인터페이스라 메소드를 사용해서 이벤트 사용가능
	public void windowIconfied(WindowEvent e) {} // WindowListener가 인터페이스라 메소드를 사용해서 이벤트 사용가능
	public void windowOpened(WindowEvent e) {} // WindowListener가 인터페이스라 메소드를 사용해서 이벤트 사용가능
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	
/*		
		Frame f = new Frame();
		
		f.setTitle("Frame Test");
		
		f.setSize(300, 300);
		f.setVisible(true);
		
*/
/*
		Frame f = new Frame("버튼 테스트");
		
		Panel p = new Panel();
		
		Button b1 = new Button();	
		Button b2 = new Button("출력");
		Button b3 = new Button("정렬");
		Button b4 = new Button("순위");
		
		b1.setLabel("입력");
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		
		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 300);
		f.setVisible(true);
*/
	/*
		Frame f = new Frame("텍스트필드 테스트");
		Panel p = new Panel();
		
		TextField tf1 = new TextField("아이디 입력", 12);
		TextField tf2 = new TextField("암호 입력", 10);
		
		tf1.selectAll();
		tf2.selectAll();
		
		tf2.setEchoChar('*');
		
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);
		
		f.setSize(300, 100);
		f.setVisible(true);
	*/
	/*		
 		Main clt = new Main();
		
		clt.setBounds(200, 200, 200, 100);
		clt.setVisible(true);
		
		clt.rotate();
*/	
	}
	
	
}
