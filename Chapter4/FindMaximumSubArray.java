package Chapter4;

public class FindMaximumSubArray {
    public static int[] FIND_MAX_CROSSING_SUBARRAY(int[] A,int low,int mid,int high){
        int sum=0;
        int left_sum=Integer.MIN_VALUE;
        int max_left=-1;
        for(int i=mid;i>=low;i--){
            sum+=A[i];
            if(sum>left_sum){
                left_sum=sum;
                max_left=i;
            }
        }
        sum=0;
        int right_sum=Integer.MIN_VALUE;
        int max_right=-1;
        for(int j=mid+1;j<=high;j++){
            sum+=A[j];
            if(sum>right_sum){
                right_sum=sum;
                max_right=j;
            }
        }
        return new int[] {max_left,max_right,left_sum+right_sum};
    }

    public static int[] FIND_MAXIMUM_SUBARRAY(int[] A,int low, int high){
        if(high==low){
            return new int[] {low,high,A[low]};
        }
        else{
            int mid=(int)Math.floor((double) (low + high) /2);
            int[] temp_left=FIND_MAXIMUM_SUBARRAY(A, low, mid);
            int left_low=temp_left[0];
            int left_high=temp_left[1];
            int left_sum=temp_left[2];
            int[] temp_right=FIND_MAXIMUM_SUBARRAY(A, mid+1, high);
            int right_low=temp_right[0];
            int right_high=temp_right[1];
            int right_sum=temp_right[2];
            int[] temp_mid=FIND_MAX_CROSSING_SUBARRAY(A,low,mid,high);
            int cross_low=temp_mid[0];
            int cross_high=temp_mid[1];
            int cross_sum=temp_mid[2];
            if(left_sum>=right_sum&&left_sum>=cross_sum){
                return new int[] {left_low,left_high,left_sum};
            }
            else if(right_sum>=left_sum&&right_sum>=cross_sum){
                return new int[] {right_low,right_high,right_sum};
            }
            else{
                return new int[] {cross_low,cross_high,cross_sum};
            }
        }
    }


}
