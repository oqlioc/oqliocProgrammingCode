import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class VChatting extends JFrame {
	public VChatting() {
	}

	private JFrame frame_room;
	private JPanel pn_content;
	private JPanel pn_input;
	private JScrollPane scrpane_content;
	private JList list_content;
	private JTextField tf_input;
	private JButton btn_send;
	private String nickname;

	// View 생성
	public void startView() {
		initFrame();
		initContentPanel();
		initInputPanel();
		setView();
	}

	private void initFrame() {
		frame_room = new JFrame("BIT 2조 채팅 프로그램");
		frame_room.setSize(450, 600);
		ImageIcon img = new ImageIcon("chat.png");
		frame_room.setIconImage(img.getImage());
		frame_room.setResizable(false);
		frame_room.setLocationRelativeTo(null);
	}

	private void initContentPanel() {
		pn_content = new JPanel();

		// content panel 정의 (scrollpane, list 포함)
		pn_content.setBorder(new EmptyBorder(5, 5, 5, 5));
		pn_content.setLayout(new BoxLayout(pn_content, BoxLayout.Y_AXIS));
		frame_room.getContentPane().add(pn_content, "Center");

		// ==========================
		// scrollpane 생성
		scrpane_content = new JScrollPane();
		scrpane_content.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		scrpane_content.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// ==========================
		// list 생성
		list_content = new JList();
		scrpane_content.setViewportView(list_content);
		pn_content.add(scrpane_content);
	}

	private void initInputPanel() {
		pn_input = new JPanel();

		// input panel 정의 (button, input textfield)
		pn_input.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		tf_input = new JTextField();
		tf_input.setColumns(30);
		pn_input.add(tf_input);

		btn_send = new JButton("전송");
		pn_input.add(btn_send);
		frame_room.getContentPane().add(pn_input, "South");
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean setNickName() {
		setLookAndFeel();

		nickname = JOptionPane.showInputDialog("닉네임을 입력하세요!");

		if (nickname.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public JList getList() {
		return list_content;
	}

	public JFrame getFrame() {
		return frame_room;
	}

	public JButton getButton() {
		return btn_send;
	}

	public JTextField getTextField() {
		return tf_input;
	}

	public JScrollPane getScrollPane() {
		return scrpane_content;
	}

	public String getNickName() {
		return nickname;
	}

	public void setError() {
		JOptionPane.showMessageDialog(null, "연결이 원활하지 않습니다.");
	}

	public void checkNickName() {
		JOptionPane.showMessageDialog(null, "닉네임이 올바르지 않습니다.");
	}

	public void setView() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame_room.setVisible(true);
			}
		});
	}
}
