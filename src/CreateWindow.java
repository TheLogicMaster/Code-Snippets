import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreateWindow {
	public static int width = 0;
	public static int height = 0;
	JFrame frame = new JFrame("Tower Defense");
	public void makeWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		width = (int)screenSize.getWidth();
		height = (int)screenSize.getHeight();
		System.out.println(width + ", " + height);
		frame.setPreferredSize(new Dimension(width, height));
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		DrawGraphics drawgraphics = new DrawGraphics();
		frame.add(drawgraphics);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
}
