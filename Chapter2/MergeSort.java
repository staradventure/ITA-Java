package Chapter2;

import java.util.Arrays;

public class MergeSort {
    /**
     * Merge函数来自于第2章算法基础，2.3.1分治法。
     * MERGE函数和原伪代码不一样之处：
     * 第15行和第18行：原伪代码中的L和R数组下标从1开始，这里改为从0开始。
     * 第19行：A的下标引用在原伪代码的基础上加了1。
     * 第23行和第24行：原伪代码中的i和j的初始值是1，这里为了与下标匹配，减1。
     */
    public static void MERGE(int[] A, int p, int q, int r){
        int n1=q-p+1;
        int n2=r-q;
        int[] L=new int[n1+1];
        int[] R=new int[n2+1];
        for(int i=0;i<n1;i++){
            L[i]=A[p+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=A[q+j+1];
        }
        L[n1]=Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;
        int i=1-1;
        int j=1-1;
        for(int k=p;k<=r;k++){
            if(L[i]<=R[j]){
                A[k]=L[i];
                i++;
            }
            else{
                A[k]=R[j];
                j++;
            }
        }
    }

    public static void MERGE_SORT(int[] A, int p, int r){
        if(p<r){
            int q=(int)Math.floor((double) (p + r) /2);
            MERGE_SORT(A,p,q);
            MERGE_SORT(A,q+1,r);
            MERGE(A,p,q,r);
        }
    }
}
