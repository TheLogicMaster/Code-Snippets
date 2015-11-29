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
		projectile.spawnProjectile(DrawGraphics.x, DrawGraphics.y, x, y, true);
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
			yvel = ((int)(Math.random() * 3) - 1) * 5;
			yvellimit = (int)(Math.random() + 1 * 50);
			
		}
		yvelcount++;
		
		x += xvel;
		y += yvel;
		System.out.println(xvel + "; " + yvel);
		
		if(x <= 0) {
			x = 0;
			xvel = 5;
			
		}
		if(x >= CreateWindow.width + 1 - size) {
			x = CreateWindow.width + 1 - size;
			xvel = -5;
			
		}
		if(y <= 0) {
			y = 0;
			yvel = 5;
			
		}
		if(y >= CreateWindow.height - 25 - size) {
			y = CreateWindow.height - 25 - size;
			yvel = -5;
			
		}
		
	}
	
}