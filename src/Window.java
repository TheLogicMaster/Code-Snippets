import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Window() {
		this.setName("Tower Defense");
		this.setSize(800, 800);
		this.setLocation(100, 100);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setSize(700,700);
		this.add(panel);
	}
	
}
