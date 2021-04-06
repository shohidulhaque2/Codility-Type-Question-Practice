package com.example.demo.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSliceSum {

    @Test
    public void MaxSliceSumTest1(){
        final int [] A = {3, 2, -6, 4, 0};
        Assertions.assertThat(solution(A)).isEqualTo(5);

    }

    public int solution(int A[]){

        int localSum = 0;
        int globalSum = 0;

        for(int i = 0; i < A.length; ++i){
            localSum += A[i];
            if(localSum < A[i]){
                localSum = A[i];
            }
            if(localSum > globalSum){
                globalSum = localSum;
            }
        }
        return globalSum;
    }

}
