import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class DrawGraphics extends JPanel {
	private static final long serialVersionUID = 3848437928663433161L;
	
	public static int x  = 0;
	public static int y  = 0;
	public static int xvel  = 0;
	public static int yvel  = 0;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("resources/thing.png"));
		}	catch(IOException e) {
				e.printStackTrace();
			}
		
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawImage(img, x, y, null);
		
	}
	
	public void tick() {
		x  += xvel;
		y  += yvel;
		
	}
	
	public DrawGraphics() {
		KeyListener listener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_RIGHT) {
					DrawGraphics.xvel = 5;
					
					
				}
				
				if(key == KeyEvent.VK_LEFT) {
					DrawGraphics.xvel = -5;
					
				}
				
				if(key == KeyEvent.VK_UP) {
					DrawGraphics.yvel = -5;
					
					
				}
				
				if(key == KeyEvent.VK_DOWN) {
					DrawGraphics.yvel = 5;
				
				}
				
			}
	
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				System.out.println(e);
				if(key == KeyEvent.VK_RIGHT) {
					DrawGraphics.xvel = 0;
					
					
				}
				
				if(key == KeyEvent.VK_LEFT) {
					DrawGraphics.xvel = 0;
					
				}
				
				if(key == KeyEvent.VK_UP) {
					DrawGraphics.yvel = 0;
					
					
				}
				
				if(key == KeyEvent.VK_DOWN) {
					DrawGraphics.yvel = 0;
					
				}
				
			}
	
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		addKeyListener(listener);
		setFocusable(true);

	}
	
}
