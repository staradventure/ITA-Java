import java.util.Arrays;

public class InsertionSort {
    /**
     * 函数和源代码不一样之处：
     * 由于列表下标从0开始，所以：
     * 第2行range函数起始值为1；
     * 第6行i>0改为i>=0。
     */
    private static void INSERTION_SORT(int[] A){
        for(int j=2-1;j<=A.length-1;j++){
            int key=A[j];
            int i=j-1;
            while(i>=0&&A[i]>key){
                A[i+1]=A[i];
                i=i-1;
            }
            A[i+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] A={5,2,4,6,1,3};
        INSERTION_SORT(A);
        System.out.println(Arrays.toString(A));//[1, 2, 3, 4, 5, 6]
    }
}
