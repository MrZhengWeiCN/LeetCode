package search;

public class SearchInRotated2 {

	public boolean search(int[] A, int target) {
		int low = 0;
        int high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid]==target)
                return true;
            if(A[low]<=A[mid]){//��������
                if(target>=A[low]&&target<A[mid]){
                    high = mid-1;//�������
                }else
                    low = mid+1;//���ұ���
            }else{//�ұ�����
                if(target>A[mid]&&target<=A[high]){
                    low = mid+1;//���ұ���
                }else
                    high = mid-1;//�������
            }
        }
        return false;
	}
}
