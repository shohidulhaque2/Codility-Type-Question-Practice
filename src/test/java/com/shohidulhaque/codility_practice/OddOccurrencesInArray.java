package com.shohidulhaque.codility_practice;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OddOccurrencesInArray {

    @Test
    public void oddOccurrencesInArrayDriver1(){
        final int A [] = {9, 3, 9, 3, 9, 7, 9};
        Assertions.assertThat(oddOccurrencesInArray2(A)).isEqualTo(7);
    }

    @Test
    public void oddOccurrencesInArrayDriver2(){
        final int A [] = {9};
        Assertions.assertThat(oddOccurrencesInArray2(A)).isEqualTo(9);
    }

    @Test
    public void oddOccurrencesInArrayDriver3(){
        final int A [] = {9, 9, 9};
        Assertions.assertThat(oddOccurrencesInArray2(A)).isEqualTo(9);
    }

    @Test
    public void oddOccurrencesInArrayDriver4(){
        final int A [] = {9, 3, 9};
        Assertions.assertThat(oddOccurrencesInArray2(A)).isEqualTo(3);
    }

    @Test
    public void oddOccurrencesInArrayDriver5(){
        final int A [] = {9, 3, 2, 1, 2, 3, 9};
        Assertions.assertThat(oddOccurrencesInArray2(A)).isEqualTo(1);
    }

    @Test
    public void oddOccurrencesInArrayDriver6(){
        final int A [] = {9, 1, 9};
        Assertions.assertThat(oddOccurrencesInArray2(A)).isEqualTo(1);
    }

    public int oddOccurrencesInArray(int[] A){

        if(A.length == 1){
            return A[0];
        }

        Set<Integer> set = new HashSet<>(A.length, 1);
        for(int i = 0; i < A.length; ++i){
            if(set.contains(A[i])){
                set.remove(A[i]);
            }
            else {
                set.add(A[i]);
            }
        }
        return (Integer) set.toArray()[0];
    }

    public int oddOccurrencesInArray2(int[] A){

        if(A.length == 1){
            return A[0];
        }

        int value = A[0];

        for(int i = 1; i < A.length; ++i){
            value ^= A[i];
        }
        return value;
    }
}
