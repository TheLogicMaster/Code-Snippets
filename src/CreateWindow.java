import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreateWindow {
	JFrame frame = new JFrame("Tower Defense");
	public void makeWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		System.out.println(width + ", " + height);
		frame.setPreferredSize(new Dimension(width, height));
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		DrawGraphics drawgraphics = new DrawGraphics();
		frame.add(drawgraphics);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
}
