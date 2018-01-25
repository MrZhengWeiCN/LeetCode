package search;

/**
 * Created by Zhwei on 2018/1/25.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        for (int i = 0; i < A.length; i++)
            if (A[i] == target) return i;
        if(target<A[0]) return  0;
        if(target>A[A.length-1]) return A.length;
        for (int i = 0; i < A.length-1; i++) {
            if(A[i]<target&&target<A[i+1])
                return  i+1;
        }
        return 0;
    }
    public static void main(String[] args){
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] A = {1,3,5,6};
        System.out.print(searchInsertPosition.searchInsert(A,0));
    }
}
