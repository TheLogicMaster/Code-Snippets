import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreateWindow {
	public void makeWindow() {
		JFrame frame = new JFrame("Tower Defense");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		frame.setPreferredSize(new Dimension(1920, 1080));
		System.out.println(width + ", " + height);
		
		DrawGraphics drawgraphics = new DrawGraphics();
		frame.add(drawgraphics);
		frame.setVisible(true);
		frame.pack();
		
	}
	
}
