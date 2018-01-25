package search;

/**
 * Created by Zhwei on 2018/1/25.
 */
public class SearchInRotated {
    public int search(int[] A, int target) {
        int low = 0;
        int high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid]==target)
                return mid;
            if(A[low]<=A[mid]){//×ó±ßÓÐÐòµÄ
                if(target>=A[low]&&target<A[mid]){
                    high = mid-1;//Íù×ó±ß×ß
                }else
                    low = mid+1;//ÍùÓÒ±ß×ß
            }else{//ÓÒ±ßÓÐÐò
                if(target>A[mid]&&target<=A[high]){
                    low = mid+1;//ÍùÓÒ±ß×ß
                }else
                    high = mid-1;//Íù×ó±ß×ß
            }
        }
        return -1;
    }

    public static void main(String[] args){
        SearchInRotated searchInRotated = new SearchInRotated();
        int[] A = {3,4,5,1,2,};
        int index = searchInRotated.search(A,1);
        System.out.print(index);
    }
}
