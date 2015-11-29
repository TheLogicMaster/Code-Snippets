import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Projectile {
	double slopex = 0;
	double slopey = 0;
	double dist = 0;
	double xvel = 0;
	double yvel = 0;
	double x = 0;
	double y = 0;
	double size = 50;
	double speed = 20;
	double color = 255;
	double colvel = 3;
	boolean isEnemy = false;
	
	public void spawnProjectile(int mousex, int mousey, int playerx, int playery, boolean enemy) {
		this.isEnemy = enemy;
		if(isEnemy) {
			this.slopex = (mousex + DrawGraphics.playerw / 2 - this.size / 2) - (Enemy.x + Enemy.size / 2 - this.size / 2);
			this.slopey = (mousey + DrawGraphics.playerh / 2 - this.size / 2) - (Enemy.y + Enemy.size / 2 - this.size / 2);
		}	else {
		this.slopex = (mousex - this.size / 2) - (playerx + DrawGraphics.playerw / 2 - this.size / 2);
		this.slopey = (mousey - 24 - this.size / 2) - (playery + DrawGraphics.playerh / 2 - this.size / 2);
		
		}
		this.dist = Math.sqrt(Math.pow(this.slopex, 2) + Math.pow(this.slopey, 2));
		
		this.xvel = this.slopex / (this.dist / this.speed);
		this.yvel = this.slopey / (this.dist / this.speed);
		
		this.x = playerx + DrawGraphics.playerw / 2 - this.size / 2;
		this.y = playery + DrawGraphics.playerh / 2 - this.size / 2;
		
		
		
	}
	
	public void tick(Graphics2D g2d) {
		if(this.isEnemy) {
		g2d.setColor(new Color((int)(this.color), (int)(this.color) - 149, 0));
		}	else {
			g2d.setColor(new Color(0, (int)(this.color) - 149, (int)(this.color)));
			}
		if(color >= 255) {
			colvel = -3;
		}	else if(color <= 150) {
				colvel = 3;
			}
		color += colvel;
		this.x += this.xvel;
		this.y += this.yvel;
		g2d.setStroke(new BasicStroke(3));
		g2d.drawOval((int)this.x, (int)this.y, (int)size, (int)size);
		
	}
	
}
