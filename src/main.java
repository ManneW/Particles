
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui = new GUI();
		System.out.println("GUI created");
		World.instance().setWorldPanel(gui.getWorldPanel());
	}

}
