package search;

/**
 * Created by Zhwei on 2018/1/24.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int clos = matrix[0].length;
        boolean first_rows = false;
        boolean first_clos = false;
        for (int i = 0; i < rows; i++) {
            if(matrix[i][0]==0){
                first_clos = true;
            }
        }
        for (int j = 0; j < clos; j++) {
            if(matrix[0][j]==0){
                first_rows = true;
            }
        }
        //遍历矩阵，用第一行和第一列记录0的位置
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < clos; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < clos; j++)
                if (0 == matrix[i][0] || 0 == matrix[0][j])
                    matrix[i][j] = 0;
        if(first_rows){
            for (int j = 0; j < clos; j++) {
                matrix[0][j] = 0;
            }
        }
        if(first_clos){
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
