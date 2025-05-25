package Chapter4;

public class SquareMatrixMultiplyRecursive {
    private static int[][] give_index(int n){
        int[][] index=new int[2][n];
        for (int i = 0; i < n; i++) {
            index[0][i]=i;
            index[1][i]=i;
        }
        return index;
    }

    /**
     * 函数和原伪代码不一样的地方：
     * 第22行和第23行：数组下标为0。
     * Java初始化数组为0，省略原伪代码赋值为0的一步。
     */
    private static int[][] SQUARE_MATRIX_MULTIPLY(int[][] A,int[][] B){
        int n=A[0].length;
        int [][] C=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }

    private static int[][] SQUARE_MATRIX_MULTIPLY_RECURSIVE(int[][] A, int[][] B, int[][] a, int[][] b){
        int n=a[0].length;
        int [][] C=new int[n][n];
        if(n==1){
            C[0][0]=A[a[0][0]][a[1][0]]*B[b[0][0]][b[1][0]];
        }
        else{
            int[][] list11=new int[2][n/2];
            int[][] list12=new int[2][n/2];
            int[][] list21=new int[2][n/2];
            int[][] list22=new int[2][n/2];
            for(int i=0;i<n/2;i++){//用来填1
                list11[0][i]=i;
                list11[1][i]=i;
                list12[0][i]=i;
                list21[1][i]=i;
            }
            for(int i=n/2;i<n;i++){//用来填2
                list12[1][i-n/2]=i;
                list21[0][i-n/2]=i;
                list22[0][i-n/2]=i;
                list22[1][i-n/2]=i;
            }
            matrix_add(SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,list11,list11),SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,list12,list21),C,list11);
            matrix_add(SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,list11,list12),SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,list12,list22),C,list12);
            matrix_add(SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,list21,list11),SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,list22,list21),C,list21);
            matrix_add(SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,list21,list12),SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,list22,list22),C,list22);
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] s_index=give_index(2);
        int[][] A={{1,2},{3,4}};
        int[][] B={{1,3},{2,4}};
        int[][] C=SQUARE_MATRIX_MULTIPLY_RECURSIVE(A,B,s_index,s_index);
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.println(C[i][j]);
            }
        }
    }

    private static void matrix_add(int[][] A, int[][] B,int[][] C,int[][] c) {
        int n=A[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                C[c[0][i]][c[1][j]]=A[i][j]+B[i][j];
            }
        }
    }

}
