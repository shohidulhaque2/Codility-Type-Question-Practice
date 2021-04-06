package com.shohidulhaque.codility_practice;

import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinAvgTwoSlice {

    @Test
    public void MinAvgTwoSlice(){
        int [] A = {4, 2, 2, 5, 1, 5, 8};
        Assertions.assertThat(solution(A)).isEqualTo(1);
    }

    public int solution(int[] A){
        if(Objects.isNull(A) || A.length == 0 || A.length == 1){
            throw new IllegalArgumentException();
        }
        if(A.length == 2){
            return (A[0] + A[1]) / 2;
        }

        int average;
        for(int i = 0; i < A.length - 1; ++i){
            int a = A[i];
            int b = A[i+1];
            average = (a + b) / 2;
        }
        return 0;
    }
}
