public class pathGenerator {

	public void curveGen(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y, int cdist) {
		double rad1 = Math.atan2(p2y - p1y, p2x - p1x); // determines direction
														// (in radians) of
														// vertex to
														// intersecting points
		double rad2 = Math.atan2(p2y - p3y, p2x - p3x);
		double op1x = p2x + Math.cos(rad1) * cdist; // determines intersecting
													// points of curve based on
													// predefined distance
		double op1y = p2y + Math.sin(rad1) * cdist;
		double op2x = p2x + Math.cos(rad2) * cdist;
		double op2y = p2y + Math.sin(rad2) * cdist;
		double vrad = Math.atan2(p2y, p2x);
		double vdist = Math.sqrt(Math.pow(p2x, 2) + Math.pow(p2y, 2));
		double irad1_1 = Math.atan2(op1y, op1x) - vrad;
		double irad1_2 = Math.atan2(op2y, op2x) - vrad;
		if (Math.abs(irad1_1) != Math.abs(irad1_2)) { // checks which radian is greater and rotates accordingly
			if (Math.abs(irad1_1) > Math.abs(irad1_2)) {
				//double irad2_1 = ;
				//double irad2_2 = ;
			} else {
				//double irad2_1 = ;
				//double irad2_2 = ;
			}
		} else {
				//double irad2_1 = ;
				//double irad2_2 = ;
		}
	}

}
