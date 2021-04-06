package com.shohidulhaque.codility_practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Distinct {

    @Test
    public void DistinctDriver() {
        int A[] = { 2, 1, 1, 2, 3, 1 };
        Assertions.assertThat(solution1(A)).isEqualTo(3);
    }

    @Test
    public void DistinctDriver2() {
        int A[] = { 2, 1, 1, 2, 3, 1 };
        Assertions.assertThat(solution2(A)).isEqualTo(3);
    }

    public int solution1(int[] A){
        if(Objects.isNull(A)){
            throw new IllegalArgumentException();
        }
        if(A.length == 1){
            return 1;
        }
        Arrays.sort(A);
        int count = 1;
        int currentValue = A[0];

        for(int i = 1; i < A.length; ++i){
            if(A[i] != currentValue){
                ++count;
                currentValue = A[i];
            }
        }
        return count;
    }

    public int solution2(int[] A){
        if(Objects.isNull(A)){
            throw new IllegalArgumentException();
        }
        if(A.length == 1){
            return 1;
        }
        Set<Integer> uniqueIntegers = new HashSet<>();
        for(int i = 0; i < A.length; ++i){
            uniqueIntegers.add(A[i]);
        }
        return uniqueIntegers.size();
    }

}
