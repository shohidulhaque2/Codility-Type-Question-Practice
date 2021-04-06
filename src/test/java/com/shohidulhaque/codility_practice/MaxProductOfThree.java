package com.example.demo.codility_practice;

import java.util.Arrays;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxProductOfThree {

    @Test
    public void MaxProductOfThreeTest(){
        int A [] = { -3, 1, 2, -2, 5, 6};
        Assertions.assertThat(solution(A)).isEqualTo(60);
    }

    public int solution(int[] A){
        if(Objects.isNull(A) || A.length < 3){
            throw new IllegalArgumentException();
        }

        Arrays.sort(A);

        int v1 = A[0] * A[1] * A[2];
        int v2 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        return Math.max(v1, v2);
    }
}
