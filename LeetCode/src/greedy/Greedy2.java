package greedy;

public class Greedy2 {

	public int maximalRectangle(int[][] matrix) {
        int top=-1,left=-1,rigth=-1,bottom=-1;
        boolean find = false;
        if(matrix==null || matrix.length==0 )
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //从上到下
        for(int i=0;i<rows;i++){
        	if(!find){
        		for(int j=0;j<cols;j++){
                    if(matrix[i][j]=='1'){
                        top = i;
                        find=true;
                        break;
                    }
                }
        	}else {
				break;
			}
        }
        find = false;
        //从下到上
        for(int i=rows-1;i>=0;i--){
        	if(!find){
        		for(int j=0;j<cols;j++){
                    if(matrix[i][j]=='1'){
                        bottom = i;
                        find=true;
                        break;
                    }
                }
        	}else {
				break;
			}
        }
        find = false;
        //左到右
        for(int j=0;j<cols;j++){
        	if(!find){
        		for(int i=0;i<rows;i++){
        			if(matrix[i][j]=='1'){
        				left = j;
        				find=true;
        				break;
        			}
        		}
        	}else {
				break;
			}
        }
        find = false;
        for(int j=cols-1;j>=0;j--){
        	if(!find){
        		for(int i=0;i<rows;i++){
        			if(matrix[i][j]=='1'){
        				rigth = j;
        				find=true;
        				break;
        			}
        		}
        	}else {
        		break;
			}
        }
        if(bottom==-1){
        	return 0;
        }
        return (bottom-top+1)*(rigth-left+1);
    }
	
	public static void main(String[] args) {
		Greedy2  greedy2 = new Greedy2();
		int[][] matrix = {{0,1,0},{0,1,1},{0,1,0}};
		System.out.println(greedy2.maximalRectangle(matrix));
	}

}
