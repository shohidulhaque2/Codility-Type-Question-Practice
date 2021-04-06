package com.example.demo.codility_practice;

import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PermCheck {

    @Test
    public void PermCheckTest1(){
        int A [] = {4, 1, 3, 2};
        Assertions.assertThat(solution1(A)).isEqualTo(1);
    }

    @Test
    public void PermCheckTest2(){
        int A [] = {4, 1, 3, 2};
        Assertions.assertThat(solution2(A)).isEqualTo(1);
    }

    @Test
    public void PermCheckTest3(){
        int A [] = {4, 1, 3, 2};
        Assertions.assertThat(solution3(A)).isEqualTo(1);
    }

    public int solution1(int[] A){
        //OUT OF HABIT
        if(Objects.isNull(A) || A.length == 0){
            throw new IllegalArgumentException();
        }

        //DEAL WITH THE MOST OBVIOUS AND SIMPLEST CASE
        if(A.length == 1){
            if(A[0] == 1){
                return 1;
            } else {
                return 0;
            }
        }

        //DEAL WITH ALL OTHER CASES
        final int SUM =  (A.length * (A.length + 1)) / 2;
        int arraySum = 0;
        for(int i = 0; i < A.length; ++i){
            arraySum += A[i];
        }
        if(arraySum == SUM){
            return 1;
        } else {
            return 0;
        }
    }

    public int solution2(int[] A){
        //OUT OF HABIT
        if(Objects.isNull(A) || A.length == 0){
            throw new IllegalArgumentException();
        }

        //DEAL WITH THE MOST OBVIOUS AND SIMPLEST CASE
        if(A.length == 1){
            if(A[0] == 1){
                return 1;
            } else {
                return 0;
            }
        }

        //DEAL WITH ALL OTHER CASES
        int permBitPattern = 0;
        for(int i = 1; i < A.length + 1; ++i){
            permBitPattern ^= i;
        }

        int arrayBitPattern = 0;
        for(int i = 0; i < A.length; ++i){
            arrayBitPattern ^= A[i];
        }
        if(permBitPattern == arrayBitPattern){
            return 1;
        } else {
            return 0;
        }
    }

    public int solution3(int[] A){
        //OUT OF HABIT
        if(Objects.isNull(A) || A.length == 0){
            throw new IllegalArgumentException();
        }

        //DEAL WITH THE MOST OBVIOUS AND SIMPLEST CASE
        if(A.length == 1){
            if(A[0] == 1){
                return 1;
            } else {
                return 0;
            }
        }

        //DEAL WITH ALL OTHER CASES
        int permBitPattern = 0;
        int arrayBitPattern = 0;
        for(int i = 0; i < A.length; ++i){
            permBitPattern ^= i + 1;
            arrayBitPattern ^= A[i];
        }
        if(permBitPattern == arrayBitPattern){
            return 1;
        } else {
            return 0;
        }
    }

}
