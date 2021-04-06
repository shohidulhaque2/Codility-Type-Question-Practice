package com.shohidulhaque.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountDiv {

    @Test
    public void CountDivTest(){
        final int A = 6;
        final int B = 11;
        final int K = 2;
        Assertions.assertThat(solution(A, B, K)).isEqualTo(3);
    }

    @Test
    public void CountDivTest2(){
        final int A = 6;
        final int B = 11;
        final int K = 2;
        Assertions.assertThat(solution2(A, B, K)).isEqualTo(3);
    }

    public int solution2(int A, int B, int K){
        double min = A;

        if(A == 0){
            min = K;
        }

        min = Math.floor((A + (K - 1)) / K) * K;

        if(min > B){
            return 0;
        }
        return (int)((B - min) / K + 1);
    }

    public int solution(int A, int B, int K){

        int LOWER_BOUND = A;
        int UPPER_BOUND = B;

        int COUNT = 0;

        if(A == 0){
            LOWER_BOUND = 0 + K;
            if(LOWER_BOUND > UPPER_BOUND){
                return 0;
            }
            else if(LOWER_BOUND == UPPER_BOUND){
                return 1;
            }
        }
        else if(A % K == 0){
            LOWER_BOUND = A;
        }
        else if(A % K != 0){
            int remainder =  A % K;
            LOWER_BOUND = A + remainder;
        }
        //lower bound is already divisible
        ++COUNT;

        if(B == 0){
            return 0;
        }
        else if(B % K == 0){
            UPPER_BOUND = B;
        }
        else if(B % K != 0){
            int remainder = B % K;
            UPPER_BOUND = UPPER_BOUND - remainder;
        }

        if(LOWER_BOUND > UPPER_BOUND){
            return COUNT;
        }

        if(LOWER_BOUND == UPPER_BOUND){
            return COUNT;
        }

        if(LOWER_BOUND < UPPER_BOUND){
            COUNT = COUNT  + (UPPER_BOUND - LOWER_BOUND == 0 ? 1: (UPPER_BOUND - LOWER_BOUND) / K);
        }

        return COUNT;
    }
}
