import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawGraphics extends JPanel {
	private static final long serialVersionUID = 3848437928663433161L;

	public static double x = 0;
	public static double y = 0;
	public static int speed = 1;
	public static double rad = Math.toRadians(Math.random() * 360);

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

		if (x + Math.cos(rad) >= 1000) {
			if (Math.toDegrees(rad) == 90 || Math.toDegrees(rad) == 90) {
				rad = Math.toRadians(270);
			}
			if (Math.toDegrees(rad) > 90) {
				rad = Math.toRadians(90-(Math.toDegrees(rad)-90));
			}
			if (Math.toDegrees(rad) < 90) {
				rad = Math.toRadians(90+(90-Math.toDegrees(rad)));
			}
		}
		if (x + Math.cos(rad) <= 0) {
			if (Math.toDegrees(rad) == 270 || Math.toDegrees(rad) == 270) {
				rad = Math.toRadians(90);
			}
			if (Math.toDegrees(rad) > 270) {
				rad = Math.toRadians(270-(Math.toDegrees(rad)-270));
			}
			if (Math.toDegrees(rad) < 90) {
				rad = Math.toRadians(270+(270-Math.toDegrees(rad)));
			}
		}
		if (y + Math.sin(rad) >= 1000) {
			if (Math.toDegrees(rad) == 180 || Math.toDegrees(rad) == 180) {
				rad = Math.toRadians(360);
			}
			if (Math.toDegrees(rad) > 180) {
				rad = Math.toRadians(180-(Math.toDegrees(rad)-180));
			}
			if (Math.toDegrees(rad) < 180) {
				rad = Math.toRadians(180+(180-Math.toDegrees(rad)));
			}
		}
		if (y + Math.sin(rad) <= 0) {
			if (Math.toDegrees(rad) == 0 || Math.toDegrees(rad) == 360) {
				rad = Math.toRadians(180);
			}
			if (Math.toDegrees(rad) > 0) {
				rad = Math.toRadians(0-(Math.toDegrees(rad)-0));
			}
			if (Math.toDegrees(rad) < 0) {
				rad = Math.toRadians(0+(0-Math.toDegrees(rad)));
			}
		}
		x = x + Math.cos(rad);
		y = y + Math.sin(rad);
		System.out.println((x) + ":" + (rad));
		System.out.println((y) + ":" + (rad));
	}
}
