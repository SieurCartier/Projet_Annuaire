import Fabrics.MySQLConnection;
import IHM.MainWindow;

public class Main {

	public static void main(String[] args) {

		MySQLConnection co = MySQLConnection.getInstanceOf();
		co.setUp("routierp", "routierp", "az78qs45");

		MainWindow window = new MainWindow();
		window.setVisible(true);

		try {

		} catch (Exception e) {

		}
	}
}
