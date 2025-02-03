package test;

import org.junit.jupiter.api.Test;

import static Chapter2.MergeSort.MERGE;
import static Chapter2.MergeSort.MERGE_SORT;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {
    @Test
    void simple_test1(){
        int[] A={0,0,0,0,0,0,0,0,0,2,4,5,7,1,2,3,6,0};
        MERGE(A,9,12,16);
        int[] expected={0,0,0,0,0,0,0,0,0,1,2,2,3,4,5,6,7,0};
        assertArrayEquals(expected,A);
    }

    @Test
    void simple_test2(){
        int[] A={9,8,7,6,5,4,3,2,1};
        MERGE_SORT(A,0,A.length-1);
        int[] expected={1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expected,A);
    }
}