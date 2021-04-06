package com.shohidulhaque.codility_practice;

import org.assertj.core.api.Assertions;

public class Triangle {

    public void TriangleDriver(){
        int A [] = {10, 2, 5, 1, 8, 20};
        Assertions.assertThat(solution(A)).isEqualTo(1);
    }

    public void TriangleDriver2(){
        int A [] = {10, 50, 5, 1};

        Assertions.assertThat(solution(A)).isEqualTo(0);
    }




    public int solution(int[] A){
        //0 ≤ P < Q < R < N

        //A[P] + A[Q] > A[R],
        //A[Q] + A[R] > A[P],
        //A[R] + A[P] > A[Q].


        return 0;
    }
}
