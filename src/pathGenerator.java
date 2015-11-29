public class pathGenerator {

	public void curveGen(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y, int cdist) {
		double rad1 = Math.atan2(p2y - p1y, p2x - p1x); // determines direction
		double rad2 = Math.atan2(p2y - p3y, p2x - p3x);// of vertex to
		double op1x = p2x + Math.cos(rad1) * cdist; // intersecting points
		double op1y = p2y + Math.sin(rad1) * cdist;// determines intersecting
		double op2x = p2x + Math.cos(rad2) * cdist;// points of curve based on
		double op2y = p2y + Math.sin(rad2) * cdist;// predefined distance
		double vrad = Math.atan2(p2y, p2x);
		double vdist = Math.sqrt(Math.pow(p2x, 2) + Math.pow(p2y, 2));
	    double vpdist = Math.sqrt(Math.pow(p1x - p2x, 2) + Math.pow(p1y - p2y, 2));
		double pdist = Math.sqrt(Math.pow(p3x - p2x, 2) + Math.pow(p3y - p2y, 2));
		double irad1_1 = Math.atan2(op1y, op1x) - vrad;
		double irad1_2 = Math.atan2(op2y, op2x) - vrad;;
		double irad2 = Math.abs(irad1_1 - irad1_2);
		if ()
		double cp1x = Math.cos(-irad2) * vpdist;
		double cp1y = Math.sin(-irad2) * vpdist + vdist;
		double cp2x = Math.cos(irad2) * vpdist;
		double cp2y = Math.sin(irad2) * vpdist + vdist;
		double a = (cp1y+vdist)/Math.pow(cp1x,2);
		System.out.println(cp1x);
		System.out.println(cp1y);
		System.out.println(Math.toDegrees(irad2));
	}
}