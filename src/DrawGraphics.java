import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	public static int imgw = 0;
	public static int imgh = 0;
	public static boolean click = false;
	public static int mousex = 0;
	public static int mousey = 0;
	static Projectile projectile = new Projectile();
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("resources/thing.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		imgw = img.getWidth();
		imgh = img.getHeight();
		
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawImage(img, x, y, null);
		g2d.setColor(new Color(0, 0, 255));
		g2d.fillRect(mousex - 5, mousey  - 24 - 5, 10, 10);
		
		if(click) {
			click = false;
			projectile.spawnProjectile(mousex, mousey, x, y);
			
		}
		projectile.tick(g2d);
		
	}

	public void tick() {
		x  += xvel;
		y  += yvel;
		if(x < 0) x = 0;
		if(x > CreateWindow.width - imgw - 1) x = CreateWindow.width - imgw  - 1;
		if(y < 0) y = 0;
		if(y > CreateWindow.height - imgh - 25) y = CreateWindow.height - imgh - 25;
		
	}
	
	public DrawGraphics() {
		requestFocus();
		KeyListener keylistener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_RIGHT ||key == KeyEvent.VK_D) {
					DrawGraphics.xvel = 5;
					
					
				}
				
				if(key == KeyEvent.VK_LEFT ||key == KeyEvent.VK_A) {
					DrawGraphics.xvel = -5;
					
				}
				
				if(key == KeyEvent.VK_UP ||key == KeyEvent.VK_W) {
					DrawGraphics.yvel = -5;
					
					
				}
				
				if(key == KeyEvent.VK_DOWN ||key == KeyEvent.VK_S) {
					DrawGraphics.yvel = 5;
				
				}
				
			}
	
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_RIGHT ||key == KeyEvent.VK_D) {
					DrawGraphics.xvel = 0;
					
					
				}
				
				if(key == KeyEvent.VK_LEFT ||key == KeyEvent.VK_A) {
					DrawGraphics.xvel = 0;
					
				}
				
				if(key == KeyEvent.VK_UP ||key == KeyEvent.VK_W) {
					DrawGraphics.yvel = 0;
					
					
				}
				
				if(key == KeyEvent.VK_DOWN ||key == KeyEvent.VK_S) {
					DrawGraphics.yvel = 0;
					
				}
				
			}
	
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		MouseListener mouselistener = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mousex = (int)MouseInfo.getPointerInfo().getLocation().getX();
				mousey = (int)MouseInfo.getPointerInfo().getLocation().getY();
				click = true;
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		addKeyListener(keylistener);
		addMouseListener(mouselistener);
		setFocusable(true);

	}
	
}
