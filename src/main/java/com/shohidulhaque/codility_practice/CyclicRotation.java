package com.example.demo.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CyclicRotation {

    @Test
    public void cyclicRotationDriver1(){
        final int [] A = new int [] {3, 8, 9, 7, 6};
        final int K = 3;
        Assertions.assertThat(cyclicRotation(A, K)).containsExactly(new int[] {9, 7, 6, 3, 8});
    }

    @Test
    public void cyclicRotationDriver2(){
        final int [] A = new int [] {3, 8, 9, 7, 6};
        final int K = 2;
        Assertions.assertThat(cyclicRotation(A, K)).containsExactly(new int[] {7, 6, 3, 8, 9});
    }

    @Test
    public void cyclicRotationDriver3(){
        final int [] A = new int [] {3, 8, 9, 7, 6};
        final int K = 1;
        Assertions.assertThat(cyclicRotation(A, K)).containsExactly(new int[] {6, 3, 8, 9, 7});
    }

    public int [] cyclicRotation(final int[] A, final int K){
        if(K == 0 || K % A.length == 0){
            return A;
        }
        if(A.length == 1){
            return A;
        }

        int [] rotatedArray = new int[A.length];
        for(int i = 0, j = K; i < A.length; ++i, ++j){
            rotatedArray[j % A.length] = A[i];
        }
        return rotatedArray;
    }

    @Test
    public void cyclicRotationDriver4(){
        final int [] A = new int [] {3, 8, 9, 7, 6};
        final int K = 0;
        Assertions.assertThat(cyclicRotation(A, K)).containsExactly(new int[] {3, 8, 9, 7, 6});
    }




}
