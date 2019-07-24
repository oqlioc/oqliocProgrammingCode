
public class Main {

	public static void main(String args[]) {
		String ip = "localhost";
		int port = 8000;

		CChatting controller;

		MChatting model = new MChatting();
		VChatting view = new VChatting();
		CThread chatThread = new CThread(ip, port, model, view);

		boolean setName = view.setNickName();

		if (setName) {
			if (chatThread.setSocket()) {
				view.startView();
				chatThread.tcpThread();

				controller = new CChatting(model, view, chatThread);
			} else {
				view.setError();
			}

		} else {
			view.checkNickName();
			chatThread.closeSocket();
		}

	}
}
