import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;

public class CChatting {

	private MChatting model;
	private VChatting view;
	private CThread chatThread;

	public CChatting(MChatting model, VChatting view, CThread chatThread) {
		this.model = model;
		this.view = view;
		this.chatThread = chatThread;
		this.view.getList().setModel(model.getListModel());

		btnEvent();
		textEvent();
		scrollEvent();
		closeEvent();
	}

	private void closeEvent() {
		view.getFrame().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				chatThread.closeSocket();
				System.exit(0);
			}
		});
	}

	private void scrollEvent() {
		view.getScrollPane().getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				e.getAdjustable().setValue(e.getAdjustable().getMaximum());
			}
		});
	}

	private void btnEvent() {
		view.getButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addList();
			}
		});
	}

	private void textEvent() {
		view.getTextField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addList();
			}
		});
	}

	private String getText() {
		return "[" + view.getNickName() + "] " + view.getTextField().getText();
	}

	private void addList() {
		model.addData(getText());
		chatThread.sendMsg(getText());
		view.getTextField().setText("");
	}
}
