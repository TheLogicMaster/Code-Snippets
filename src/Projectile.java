import java.awt.Color;
import java.awt.Graphics2D;

public class Projectile {
	static double slopex = 0;
	static double slopey = 0;
	static double dist = 0;
	static double xvel = 0;
	static double yvel = 0;
	static double x = 0;
	static double y = 0;
	static double size = 50;
	static double speed = 10;
	
	public void spawnProjectile(int mousex, int mousey, int playerx, int playery) {
		slopex = (mousex - size / 2) - (playerx + DrawGraphics.imgw / 2 - size / 2);
		slopey = (mousey - 24 - size / 2) - (playery + DrawGraphics.imgh / 2 - size / 2);
		dist = Math.sqrt(Math.pow(slopex, 2) + Math.pow(slopey, 2));
		
		xvel = slopex / (dist / speed);
		yvel = slopey / (dist / speed);
		
		x = playerx + DrawGraphics.imgw / 2 - size / 2;
		y = playery + DrawGraphics.imgh / 2 - size / 2;
		
		
		
	}
	
	public void tick(Graphics2D g2d) {
		g2d.setColor(new Color(255, 0, 0));
		if(x < CreateWindow.width && x > 0 && y < CreateWindow.height && y > 0) {
			x += xvel;
			y += yvel;
			g2d.fillRect((int)x, (int)y, 50, 50);
			
		}
		
	}
	
}
