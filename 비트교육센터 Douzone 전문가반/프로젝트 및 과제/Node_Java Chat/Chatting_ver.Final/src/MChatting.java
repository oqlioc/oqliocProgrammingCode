import javax.swing.DefaultListModel;

public class MChatting {
	private DefaultListModel list_model;

	public MChatting() {
		list_model = new DefaultListModel<String>();
	}

	public void addData(String data) {
		list_model.addElement(data);
	}

	public DefaultListModel getListModel() {
		return list_model;
	}
}
