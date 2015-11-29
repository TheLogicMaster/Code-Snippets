import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {
	public static int x = 100;
	public static int y = 100;
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
		
	}
	
	
}