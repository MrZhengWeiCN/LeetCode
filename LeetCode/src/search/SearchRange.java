package search;

/**
 * Created by Zhwei on 2018/1/25.
 */
public class SearchRange {

    public int[] searchRange(int[] A, int target) {
        //典型的二分法查找
        //数组已经排序
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (target < A[0] || target > A[A.length - 1])
            return result;
        int low = 0;
        int high = A.length-1;
        //找到左边界，如果等于，就向左边界夹，high = mid-1；
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid]<target){
                low = mid+1;
            }else
                high = mid-1;
        }
        int low2 = 0;
        int high2 = A.length-1;
        //右边界，如果等于，low = mid+1，也就是向右边夹击
        while(low2<=high2){
            int mid = (low2+high2)/2;
            if(A[mid]<=target){
                low2 = mid+1;
            }else
                high2 = mid -1;
        }
        if(low <= high2)
        {
            result[0] = low;
            result[1] = high2;
        }
        return result;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] A = {3,3,3};
        int[] result = searchRange.searchRange(A, 3);
        System.out.print(result[0] + "," + result[1]);
    }
}
