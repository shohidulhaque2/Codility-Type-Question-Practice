package com.shohidulhaque.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TapeEquilibrium2 {

    static org.slf4j.Logger Logger = LoggerFactory.getLogger(TapeEquilibrium2.class);

    @Test
    public void TapeEquilibriumDriver(){
        int A [] = {2, 1};
        Assertions.assertThat(solution(A)).isEqualTo(1);
    }

    @Test
    public void TapeEquilibriumDriver2(){
        int A [] = {1, 2};
        Assertions.assertThat(solution(A)).isEqualTo(1);
    }

    @Test
    public void TapeEquilibriumDriver3(){
        int A [] = {3, 1, 2, 4, 3};
        Assertions.assertThat(solution(A)).isEqualTo(1);
    }

    @Test
    public void TapeEquilibriumDriver4(){
        int A [] = {3, 3, 3, 1, 2, 4};
        Assertions.assertThat(solution(A)).isEqualTo(1);
    }

    @Test
    public void TapeEquilibriumDriver5(){
        int A [] = {3, 3, 3, 1, 2, 5};
        Assertions.assertThat(solution(A)).isEqualTo(2);
    }

    public int solution(int[] A){
        if(A.length < 2){
            throw new IllegalArgumentException();
        }
        if(A.length == 2){
            return Math.abs(A[0] - A[1]);
        }


        int rightListSum = 0;
        for(int i = 0; i < A.length; ++i){
            rightListSum += A[i];
        }
        int leftListSum = 0;
        int minSumDifference = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; ++i){
            leftListSum += A[i];
            rightListSum -= A[i];
            minSumDifference = Math.min(minSumDifference, Math.abs(leftListSum - rightListSum));
        }
        Logger.info("difference = " + String.valueOf(minSumDifference));
        return minSumDifference;
    }


}
