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
<<<<<<< HEAD
	
	public static int x  = 0;
	public static int y  = 0;
	public static int xvel  = 0;
	public static int yvel  = 0;
	
=======
	public static int mcount;
	public static double x = 0;
	public static double y = 0;
	static int count = 0;
	public static int speed = 10;
	public static double rad = Math.toRadians(Math.random() * 360);

>>>>>>> origin/master
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File("resources/thing.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g2d.setColor(new Color(0, 0, 0));
		g2d.drawImage(img, (int) x, (int) y, null);

	}

	public void tick() {
<<<<<<< HEAD
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
	
=======
		if (count >= 10000) {
			count = 0;
			if (x + Math.cos(rad) >= 1000) {
				if (Math.toDegrees(rad) == 90 || Math.toDegrees(rad) == 90) {
					rad = Math.toRadians(270);
				}
				if (Math.toDegrees(rad) > 90) {
					rad = Math.toRadians(90 - (Math.toDegrees(rad) - 90));
				}
				if (Math.toDegrees(rad) < 90) {
					rad = Math.toRadians(90 + (90 - Math.toDegrees(rad)));
				}
			}
			if (x + Math.cos(rad) <= 0) {
				if (Math.toDegrees(rad) == 270 || Math.toDegrees(rad) == 270) {
					rad = Math.toRadians(90);
				}
				if (Math.toDegrees(rad) > 270) {
					rad = Math.toRadians(270 - (Math.toDegrees(rad) - 270));
				}
				if (Math.toDegrees(rad) < 90) {
					rad = Math.toRadians(270 + (270 - Math.toDegrees(rad)));
				}
			}
			if (y + Math.sin(rad) >= 500) {
				if (Math.toDegrees(rad) == 180 || Math.toDegrees(rad) == 180) {
					rad = Math.toRadians(360);
				}
				if (Math.toDegrees(rad) > 180) {
					rad = Math.toRadians(180 + (Math.toDegrees(rad) - 180));
				}
				if (Math.toDegrees(rad) < 180) {
					rad = Math.toRadians(180 + (180 - Math.toDegrees(rad)));
				}
			}
			if (y + Math.sin(rad) <= 0) {
				if (Math.toDegrees(rad) == 0 || Math.toDegrees(rad) == 360) {
					rad = Math.toRadians(180);
				}
				if (Math.toDegrees(rad) < 0) {
					rad = Math.toRadians(0 - (Math.toDegrees(rad) - 0));
				}
				if (Math.toDegrees(rad) > 0) {
					rad = Math.toRadians(0 + (0 - Math.toDegrees(rad)));
				}
			}
			x = x + Math.cos(rad);
			y = y + Math.sin(rad);
			//System.out.println((x) + ":x:" + (rad));
			//System.out.println((y) + ":y:" + (Math.toDegrees(rad)));
		}
		count += 1;
	}
>>>>>>> origin/master
}
