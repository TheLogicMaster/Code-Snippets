import java.awt.BasicStroke;
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
import java.util.LinkedList;

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
	public static int mousexnow = 0;
	public static int mouseynow = 0;
	public static LinkedList<Projectile> projectiles = new LinkedList<Projectile>();
	
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
		
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(new Color(0, 0, 35));
		g2d.fillRect(0, 0, CreateWindow.width, CreateWindow.height);
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawImage(img, x, y, imgw, imgh, null);
		g2d.setColor(new Color(0, 0, 255));
		mousexnow = (int)MouseInfo.getPointerInfo().getLocation().getX();
		mouseynow = (int)MouseInfo.getPointerInfo().getLocation().getY();
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(255, 255, 255));
		g2d.drawLine(mousexnow, mouseynow  - 24 - 15, mousexnow, mouseynow  - 24 + 15);
		g2d.drawLine(mousexnow - 15, mouseynow  - 24, mousexnow + 15, mouseynow  - 24);
		
		if(click) {
			click = false;
			Projectile projectile = new Projectile();
			projectiles.add(projectile);
			projectile.spawnProjectile(mousex, mousey, x, y);
			
		}
		for(int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).x < CreateWindow.width + projectiles.get(i).size + 5 && projectiles.get(i).x > 0 - projectiles.get(i).size - 5 && projectiles.get(i).y < CreateWindow.height + projectiles.get(i).size + 5 && projectiles.get(i).y > 0 - projectiles.get(i).size - 5) {
				projectiles.get(i).tick(g2d);
				
			}	else {
					projectiles.remove(i);
					
				}
			
		}
		
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
				mousex = (int)MouseInfo.getPointerInfo().getLocation().getX();
				mousey = (int)MouseInfo.getPointerInfo().getLocation().getY();
				click = true;
								
			}
			
		};
		addKeyListener(keylistener);
		addMouseListener(mouselistener);
		setFocusable(true);

	}
	
}
