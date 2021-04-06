package com.example.demo.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrefixSums {

    @Test
    public void PrefixSumsTest(){
        int [] A = {1, 2, 3, 4, 5, 7};
        Assertions.assertThat(prefixSums(A)).containsExactly(0, 1, 3, 6, 10, 15, 22);
    }

    public int [] prefixSums(int [] A){
        int B [] = new int[A.length + 1];
        for(int i = 1; i < B.length; ++i){
            B[i] = B[i-1] + A[i-1];
        }
        return B;
    }

}
