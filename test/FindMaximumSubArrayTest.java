package test;

import org.junit.jupiter.api.Test;

import static Chapter4.FindMaximumSubArray.FIND_MAXIMUM_SUBARRAY;
import static org.junit.jupiter.api.Assertions.*;

class FindMaximumSubArrayTest {
    @Test
    void okTest1(){
        int[] A={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int[] result=FIND_MAXIMUM_SUBARRAY(A,0,A.length-1);
        System.out.println(result[0]+" "+result[1]+" "+result[2]);//TODO:这里该怎么判断assert还没有写。
    }

}