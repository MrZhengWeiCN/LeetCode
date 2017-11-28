package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

public class Array8 {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if(intervals.size()<=1)
			return intervals;
		ArrayList<Interval> result = new ArrayList<Interval>();
		int star=-1;
		int end =-1;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		for (Interval interval : intervals) {
			if(star==-1){
				star = interval.start;
				end = interval.end;
			}
			if(interval.start<=end){
				if(interval.end>end)
				end = interval.end;
			}else {
				result.add(new Interval(star, end));
				star = interval.start;
				end = interval.end;
			}
		}
		result.add(new Interval(star, end));
		return result;
	}
	
	public static void main(String[] args){
		Array8 array8 = new Array8();
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2,3));
		intervals.add(new Interval(1,4));
		/*intervals.add(new Interval(15, 18));
		intervals.add(new Interval(8, 10));*/
		ArrayList<Interval> merge = array8.merge(intervals);
		for (Interval interval : merge) {
			System.out.println(interval.start+":"+interval.end);
		}
	}
}
