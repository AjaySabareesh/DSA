package datastructures.matrix;

//https://leetcode.com/problems/rotate-image/
//Refer this for 90,-90,180 rotations: https://leetcode.com/problems/rotate-image/solutions/401356/rotate-90-clockwise-anti-clockwise-and-rotate-180-degree/
public class RotateMatrix {
    //this solution works only for n*n matrix
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //swap/reverse elements in each row horizontally
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                //swap(matrix[i][j], matrix[i][n-1-j]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
    //1 + 2 = clockwise rotation
    //1 + 3 = anti-clockwise rotation
    //2 + 3 = 180 degree rotation
//    int n;
//    public void rotate(int[][] matrix) {
//        n = matrix.length;
//        transpose(matrix);
//        reverseColumns(matrix);
//    }
//
//    //1 transpose
//    private void transpose(int[][] matrix) {
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }
//
//    //2 reverse elements in each row
//    private void reverseColumns(int[][] matrix) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n / 2; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[i][n - 1 - j];
//                matrix[i][n - 1 - j] = temp;
//            }
//        }
//    }
//
//    //3 reverse elements in each columns
//    private void reverseRows(int[][] matrix) {
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n / 2; i++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - i][j];
//                matrix[n - 1 - i][j] = temp;
//            }
//        }
//    }

}
