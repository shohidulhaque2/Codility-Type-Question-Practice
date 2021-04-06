package com.example.demo.codility_practice;

import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxProfit {

    @Test
    public void MaxProfitTest1(){
        final int A [] = {23171, 21011, 21123, 21366, 21013, 21367};
        Assertions.assertThat(solution(A)).isEqualTo(356);
    }

    public int solution(int A[]){

        if(Objects.isNull(A) || A.length == 0){
            throw new IllegalArgumentException();
        }

        if(A.length == 1){
            return 0;
        }

        int minDay = A[0];
        int maxOProfit = 0;
        for(int i = 1; i < A.length; ++i){
            minDay = Math.min(minDay, A[i]);
            maxOProfit = Math.max(maxOProfit, A[i] - minDay);
        }
        return maxOProfit;
    }
}
