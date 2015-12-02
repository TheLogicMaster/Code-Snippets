import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {
	public static int x = 100;
	public static int y = 100;
	public static int xvel = 0;
	public static int yvel = 0;
	public static int xvelcount = 0;
	public static int yvelcount = 0;
	public static int xvellimit = 0;
	public static int yvellimit = 0;
	public static int size = 50;
	public static int shoot = 0;
	public static int shootlimit = (int)(Math.random() * 50) + 20;
	
	public static void drawEnemy(Graphics2D g2d) {
		g2d.setColor(new Color(255, 0, 0));
		g2d.drawRect(x, y, size, size);
		if(shoot == shootlimit) {
		Projectile projectile = new Projectile();
		DrawGraphics.projectiles.add(projectile);
		projectile.spawnProjectile(DrawGraphics.x, DrawGraphics.y, x, y, true, "normal");
		shoot = 0;
		shootlimit = (int)(Math.random() * 50) + 20;
		}
		shoot++;
		
		if(xvelcount == xvellimit) {
			xvelcount = 0;
			xvel = ((int)(Math.random() * 3) - 1) * 5;
			xvellimit = (int)(Math.random() + 1 * 50);
			
		}
		xvelcount++;
		
		if(yvelcount == yvellimit) {
			yvelcount = 0;
			yvel = ((int)(Math.random() * 3) - 1) * 10;
			yvellimit = (int)(Math.random() + 1 * 50);
			
		}
		yvelcount++;
		
		x += xvel;
		y += yvel;
		
		if(x <= 0) {
			x = 0;
			xvel = 10;
			
		}
		if(x >= CreateWindow.width - 3 - size) {
			x = CreateWindow.width - 3 - size;
			xvel = -10;
			
		}
		if(y <= 0) {
			y = 0;
			yvel = 10;
			
		}
		if(y >= CreateWindow.height - 3 - size) {
			y = CreateWindow.height - 3 - size;
			yvel = -10;
			
		}
		
	}
	
}