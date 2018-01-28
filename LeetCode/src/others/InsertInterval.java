package others;

import java.util.ArrayList;

/**
 * Created by Zhwei on 2018/1/28.
 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> newIntervalList = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			newIntervalList.add(newInterval);
			return newIntervalList;
		}
		int insertIndex = 0;
		Interval insertInterval = newInterval;
		for (Interval thisInterval : intervals) {
			if (thisInterval.end < newInterval.start) {
				newIntervalList.add(thisInterval);
				insertIndex++;
			}
			else if(thisInterval.start > newInterval.end){
				newIntervalList.add(thisInterval);
			}
			else{
				insertInterval.start = Math.min(insertInterval.start, thisInterval.start);
				insertInterval.end = Math.max(thisInterval.end, insertInterval.end);
			}
		}
		newIntervalList.add(insertIndex, insertInterval);
		return newIntervalList;
	}
}
