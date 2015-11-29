import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
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
	public static int playerw = 0;
	public static int playerh = 0;
	public static boolean click = false;
	public static int mousex = 0;
	public static int mousey = 0;
	public static int mousexnow = 0;
	public static int mouseynow = 0;
	public static LinkedList<Projectile> projectiles = new LinkedList<Projectile>();
	public static int health = 100;
	public static int score = 0;
	public static boolean gameover = false;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BufferedImage img = null;
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/centurygothic.ttf"));
		}	catch(IOException|FontFormatException e) {
				
			}
		Font font15 = font.deriveFont(Font.PLAIN, 15);
		Font font25 = font.deriveFont(Font.PLAIN, 25);
		
		try {
			img = ImageIO.read(new File("resources/thing.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		playerw = 50;
		playerh = 50;
		
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(0, 0, CreateWindow.width, CreateWindow.height);
		g2d.setColor(new Color(0, 0, 255));
		g2d.drawRect(x, y, playerw, playerh);
		g2d.setColor(new Color(0, 0, 255));
		mousexnow = (int)MouseInfo.getPointerInfo().getLocation().getX();
		mouseynow = (int)MouseInfo.getPointerInfo().getLocation().getY();
		Enemy.drawEnemy(g2d);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(255, 255, 255));
		g2d.drawLine(mousexnow, mouseynow  - 24 - 15, mousexnow, mouseynow  - 24 + 15);
		g2d.drawLine(mousexnow - 15, mouseynow  - 24, mousexnow + 15, mouseynow  - 24);
		g2d.setFont(font15);
		g2d.drawString("Health: " + health, 5, 20);
		g2d.drawString("Score: " + score, 5, 35);
		if(health == 0) gameover = true;
		if(gameover) {
			g2d.drawLine(1920 / 2, 0, 1920 / 2, 1080);
			g2d.setColor(new Color(0, 0, 0));
			g2d.fillRect(0, 0, CreateWindow.width, CreateWindow.height);
			g2d.setColor(new Color(255, 255, 255));
			g2d.setFont(new Font("Impact", Font.PLAIN, 60));
			g2d.drawString("GAME OVER", CreateWindow.width / 2 - 140, CreateWindow.height / 4);
			g2d.setFont(font25);
			g2d.drawString("Score: " + score, CreateWindow.width / 2 - 50, CreateWindow.height / 4 + 65);
		
		}
		if(gameover == false) {
			if(click) {
				click = false;
				Projectile projectile = new Projectile();
				projectiles.add(projectile);
				projectile.spawnProjectile(mousex, mousey, x, y, false);
				
			}
			for(int i = 0; i < projectiles.size(); i++) {
				if(projectiles.get(i).x < CreateWindow.width + projectiles.get(i).size + 5 && projectiles.get(i).x > 0 - projectiles.get(i).size - 5 && projectiles.get(i).y < CreateWindow.height + projectiles.get(i).size + 5 && projectiles.get(i).y > 0 - projectiles.get(i).size - 5) {
					projectiles.get(i).tick(g2d);
					
				}	else {
						projectiles.remove(i);
						
					}
				
				if(projectiles.get(i).x + projectiles.get(i).size / 2 < x + playerw + projectiles.get(i).size / 2 && projectiles.get(i).x + projectiles.get(i).size / 2 > x - projectiles.get(i).size / 2 && projectiles.get(i).y < y + playerh + projectiles.get(i).size / 2 && projectiles.get(i).y > y - projectiles.get(i).size / 2 && projectiles.get(i).isEnemy) {
					projectiles.remove(i);
					health -= 5;
					
				}
				
				if(projectiles.get(i).x + projectiles.get(i).size / 2 < Enemy.x + Enemy.size + projectiles.get(i).size / 2 && projectiles.get(i).x + projectiles.get(i).size / 2 > Enemy.x - projectiles.get(i).size / 2 && projectiles.get(i).y < Enemy.y + Enemy.size + projectiles.get(i).size / 2 && projectiles.get(i).y > Enemy.y - projectiles.get(i).size / 2 && projectiles.get(i).isEnemy == false) {
					projectiles.remove(i);
					score += 5;
					
				}
				
			}
			
		}
		
	}

	public void tick() {
		x  += xvel;
		y  += yvel;
		if(x < 0) x = 0;
		if(x > CreateWindow.width - playerw - 1) x = CreateWindow.width - playerw  - 1;
		if(y < 0) y = 0;
		if(y > CreateWindow.height - playerh - 25) y = CreateWindow.height - playerh - 25;
		
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
