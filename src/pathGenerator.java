public class pathGenerator {

	public int title;

	public int getTitle() {
		return title;
	}

	public void curveGen(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y, int cdist) {
		double rad1 = Math.atan2(p2y - p1y, p2x - p1x);
		double rad2 = Math.atan2(p2y - p3y, p2x - p3x);
		double op1x = p2x + Math.cos(rad1) * cdist;
		double op1y = p2y + Math.sin(rad1) * cdist;
		double op2x = p2x + Math.cos(rad2) * cdist;
		double op2y = p2y + Math.sin(rad2) * cdist;
		int orad = 4;
		//System.out.println((op1x) + ":" + (op1y) + ":" + (op2x) + ":" + (op2y));
	}

}
