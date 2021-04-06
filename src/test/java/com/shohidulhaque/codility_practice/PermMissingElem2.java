package com.shohidulhaque.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PermMissingElem2 {

    @Test
    public void PermMissingElem2Driver1(){
        int A[] = { 2, 3, 1, 5 };
        Assertions.assertThat(solution(A)).isEqualTo(4);
    }

    @Test
    public void PermMissingElem2Driver2(){
        int A[] = { 2, 3, 1, 5 };
        Assertions.assertThat(solution2(A)).isEqualTo(4);
    }

    @Test
    public void PermMissingElem2Driver3(){
        int A[] = { 2, 3, 1, 5 };
        Assertions.assertThat(solution3(A)).isEqualTo(4);
    }

    public int solution(int[] A){
        if(A.length == 0){
            return 0;
        }
        final int MAX_NUMBER = A.length + 1;
        int sum = (MAX_NUMBER * (MAX_NUMBER + 1)) / 2;

        for(int i = 0; i < A.length; ++i){
            sum -= A[i];
        }
        return sum;
    }
    public int solution2(int[] A){
        if(A.length == 0){
            return 0;
        }

        int sum = 0;
        final int MAX_NUMBER = A.length + 1;

        for(int i = 1; i <= MAX_NUMBER; ++i){
            sum ^= i;
        }

        for(int i = 0; i < A.length; ++i){
            sum ^= A[i];
        }

        return sum;
    }

    public int solution3(int[] A){
        if(A.length == 0){
            return 0;
        }
        int sum = A.length + 1;
        for(int i = 0; i < A.length; ++i){
            sum = sum ^ (i + 1) ^ A[i];
        }
        return sum;
    }

}
