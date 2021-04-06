package com.example.demo.codility_practice;

import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassingCars {

    @Test
    public void PassingCarsTest1(){
        int A [] = {0, 1, 0, 1, 1};
        Assertions.assertThat(solution(A)).isEqualTo(5);
    }

    @Test
    public void PassingCarsTest2(){
        int A [] = {0, 1, 0, 1, 1, 1};
        Assertions.assertThat(solution(A)).isEqualTo(7);
    }

    @Test
    public void PassingCarsTest3(){
        int A [] = {0, 1, 0, 1, 1, 1, 0, 0, 1};
        Assertions.assertThat(solution(A)).isEqualTo(11);
    }


    public int solution(int [] A){
        if(Objects.isNull(A) || A.length == 0){
            throw new IllegalArgumentException();
        }

        if(A.length == 1 ){
            return 0;
        }

        int B[] = new int [A.length + 1];

        final int EAST = 0;
        final int WEST = 1;

        boolean eastHasBeenSeen = false;
        int countOfPairs = 0;

        for(int i = 0; i < A.length; ++i){
            if(!eastHasBeenSeen && A[i] == EAST){
                eastHasBeenSeen = true;
            }
            else if(eastHasBeenSeen && A[i] == WEST){
                ++countOfPairs;
            }
            else if(eastHasBeenSeen && A[i] == EAST){
                B[i-1] = countOfPairs;
                countOfPairs = 0;
            }
        }

        if(eastHasBeenSeen){
            B[B.length-1] = countOfPairs;
        }

        int i = B.length - 1;
        for( ; i >= 0 && B[i] == 0; --i ){

        }

        int totalCount  = i >= 0 ? B[i] : 0;
        --i;

        for(;i >= 0; --i){
            if(B[i] != 0){
                totalCount = (B[i] + totalCount) + totalCount;
            }
        }
        return totalCount > 1000000000 ? -1 : totalCount;
    }


}
