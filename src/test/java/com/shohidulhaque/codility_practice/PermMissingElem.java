package com.example.demo.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PermMissingElem {

    @Test
    public void permMissingElemDriver(){
        final int [] A = {2, 3, 1, 5};
        Assertions.assertThat(permMissingElem(A)).isEqualTo(4);
    }

    public int permMissingElem(int[] A){

        final int NumberOfElements = A.length + 1;
        int sumOfNumbers = (NumberOfElements * (NumberOfElements + 1)) / 2;

        for(int i  = 0; i < A.length; ++i){
            sumOfNumbers -= A[i];
        }
        return sumOfNumbers;
    }
}
