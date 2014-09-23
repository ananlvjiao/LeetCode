package LeetCode.MaxPointsOnALine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import LeetCode.Helper.Point;

public class Solution {

	public int maxPoints(Point[] points) {
		if (points.length < 3)
			return points.length;

		int max = 0;
		int one_count = 0;
		// loop to get slope
		for (int i = 0; i < points.length; i++) {
			List<Float> slopes = new ArrayList<Float>();
			for (int j = 0; j < points.length; j++) {
				if (j == i)
					continue;

				if (points[j].x - points[i].x == 0
						&& (points[j].y - points[i].y == 0)) {
					one_count++;
				} else if (points[j].x - points[i].x == 0) {
					// same X
					slopes.add(Float.MAX_VALUE);
				} else if (points[j].y - points[i].y == 0) {
					slopes.add(0.0f);
				} else {
					slopes.add((float) (points[j].y - points[i].y)
							/ (points[j].x - points[i].x));
				}
			}
			Collections.sort(slopes);
			int one_max = 0;
			
			if (slopes.size() > 1) {
				int temp_max = 1;
				for (int k = 1; k < slopes.size(); k++) {
					if (slopes.get(k).floatValue() == slopes.get(k - 1)
							.floatValue()) {
						temp_max++;
					} else {
						if (temp_max > one_max) {
							one_max = temp_max;
						}
						temp_max = 1;
					}
				}
				if(one_max< temp_max) 
					{one_max = temp_max;}
			}
			else
			{
				one_max = slopes.size();
			}
			one_count += one_max;
			if (one_count > max) {
				max = one_count;
			}
			one_count = 0;
		} 
		return max + 1;
	}

}
