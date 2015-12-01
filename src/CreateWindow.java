import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class CreateWindow {
	public static int width = 0;
	public static int height = 0;
	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static JFrame frame = new JFrame("Tower Defense");
	public static void makeWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		width = (int)screenSize.getWidth();
		height = (int)screenSize.getHeight();
		System.out.println(width + ", " + height);
/*		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension (width, height));
		frame.setMaximumSize(new Dimension (width, height));
*/		
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


		frame.setUndecorated(true);
		try {
			gd.setFullScreenWindow(frame);
			
		}	finally {

			} 	
		
		DrawGraphics drawgraphics = new DrawGraphics();
		frame.add(drawgraphics);
		
		
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor");
		frame.getContentPane().setCursor(blankCursor);
		frame.setVisible(true);
		
	}
	
}
