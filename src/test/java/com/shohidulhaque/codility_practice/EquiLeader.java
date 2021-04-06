package com.shohidulhaque.codility_practice;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquiLeader {

    @Test
    public void EquiLeaderTest1(){
        int [] A = {4, 3, 4, 4, 4, 2};
        Assertions.assertThat(solution(A)).isEqualTo(2);
    }

    @Test
    public void EquiLeaderTest2(){
        int [] A = {4, 3, 4, 4, 4, 2};
        Assertions.assertThat(solution2(A)).isEqualTo(2);
    }

    @Test
    public void EquiLeaderTest3(){
        int [] A = {4, 3, 4, 4, 4, 2};
        Assertions.assertThat(solution3(A)).isEqualTo(2);
    }
    
    public int solution(int A[]){
        if(Objects.isNull(A) || A.length == 0 || A.length % 2 == 1){
            throw new IllegalArgumentException();
        }
        if(A.length == 1){
            return 1;
        }
        if(A.length == 2){
            return 1;
        }
        if(A.length == 3){
            return 1;
        }

        //=============================================================
        //find a leader
        Deque<Integer> stack = new LinkedList<>();
        stack.push(A[0]);
        for(int i  = 1; i < A.length; ++i){
            if(stack.isEmpty()){
                stack.push(A[i]);
            }
            else if(A[i] != stack.peek()){
                stack.pop();
            } else {
                stack.push(A[i]);
            }
        }

        int leader = stack.pop();

        if(leader == 0){
            return 0;
        }

        //=============================================================
        //calculate prefix sum and postfix sum.
        int [] prefixSum = new int [A.length];
        int [] postfixSum = new int [A.length];
        if(A[0] == leader){
            prefixSum[0] = 1;
        }
        if(A[A.length - 1] == leader){
            postfixSum[A.length - 1] = 1;
        }

        for(int i = 1; i < A.length; ++i){
            prefixSum[i] = prefixSum[i - 1];
            if(A[i] == leader){
                ++prefixSum[i];
            }

//            if(A[i] == leader){
//                ++prefixSum[i];
//            }
//            else {
//                prefixSum[i] = prefixSum[i - 1];
//            }

            postfixSum[(A.length - 1) - i] = postfixSum[(A.length - 1) - i + 1];

            if(A[(A.length - 1) - i] == leader){
                ++postfixSum[(A.length - 1) - i];
            }


//            if(A[(A.length - 1) - i] == leader){
//                postfixSum[(A.length - 1) - i] = postfixSum[(A.length - 1) - i + 1] + 1;
//            }
//            else {
//                postfixSum[(A.length - 1) - i] = postfixSum[(A.length - 1) - i + 1];
//            }
        }
        //=============================================================
        int numberOfLeaderCount  = 0;

        if(prefixSum[0] != 0 && postfixSum[1] > (A.length - 1) / 2){
            ++numberOfLeaderCount;
        }

        for(int i  = 1; i < A.length - 1; ++i){
            if( prefixSum[i] > (i + 1) / 2
                &&
                postfixSum[i+1] > ((A.length - ( i + 1 + 1)) + 1)  / 2){
                ++numberOfLeaderCount;
            }
        }
        //=============================================================
        return numberOfLeaderCount;
    }

    public int solution2(int A[]){
        if(Objects.isNull(A) || A.length == 0 || A.length % 2 == 1){
            throw new IllegalArgumentException();
        }
        if(A.length == 1){
            return 1;
        }
        if(A.length == 2){
            return 1;
        }
        if(A.length == 3){
            return 1;
        }

        //=============================================================
        //find a leader
        Deque<Integer> stack = new LinkedList<>();
        stack.push(A[0]);
        for(int i  = 1; i < A.length; ++i){
            if(stack.isEmpty()){
                stack.push(A[i]);
            }
            else if(A[i] != stack.peek()){
                stack.pop();
            } else {
                stack.push(A[i]);
            }
        }
        int leader = stack.pop();
        //=============================================================
        //calculate prefix sum and postfix sum.
        int [] prefixSum = new int [A.length];
        int [] postfixSum = new int [A.length];
        if(A[0] == leader){
            prefixSum[0] = 1;
        }
        for(int i = 1; i < A.length; ++i){
            if(A[i] == leader){
                prefixSum[i] = prefixSum[i - 1] + 1;
            }
            else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }
        if(A[A.length - 1] == leader){
            postfixSum[A.length - 1] = 1;
        }
        for(int j = A.length - 2; j >= 0; --j){
            if(A[j] == leader){
                postfixSum[j] = postfixSum[j+1] + 1;
            }
            else {
                postfixSum[j] = postfixSum[j+1];
            }
        }
        //=============================================================
        int numberOfLeaderCount  = 0;

        if(prefixSum[0] != 0 && postfixSum[1] > (A.length - 1) / 2){
            ++numberOfLeaderCount;
        }

        for(int i  = 1; i < A.length - 1; ++i){
            if( prefixSum[i] > (i + 1) / 2
                &&
                postfixSum[i+1] > RemainingLength(A.length, i + 1)  / 2){
                ++numberOfLeaderCount;
            }
        }
        //=============================================================
        return numberOfLeaderCount;
    }

    public int solution3(int A[]){
        if(Objects.isNull(A) || A.length == 0 || A.length % 2 == 1){
            throw new IllegalArgumentException();
        }
        if(A.length == 1){
            return 1;
        }
        if(A.length == 2){
            return 1;
        }
        if(A.length == 3){
            return 1;
        }

        //=============================================================
        //find a leader
        Deque<Integer> stack = new LinkedList<>();
        stack.push(A[0]);
        for(int i  = 1; i < A.length; ++i){
            if(stack.isEmpty()){
                stack.push(A[i]);
            }
            else if(A[i] != stack.peek()){
                stack.pop();
            } else {
                stack.push(A[i]);
            }
        }

        int leader = stack.pop();

        if(leader == 0){
            return 0;
        }

        //=============================================================
        //calculate prefix sum and postfix sum.
        int [] prefixSum = new int [A.length];
        int [] postfixSum = new int [A.length];
        if(A[0] == leader){
            prefixSum[0] = 1;
        }
        if(A[A.length - 1] == leader){
            postfixSum[A.length - 1] = 1;
        }

        for(int i = 1; i < A.length; ++i){
            prefixSum[i] = prefixSum[i - 1];
            if(A[i] == leader){
                ++prefixSum[i];
            }

            postfixSum[(A.length - 1) - i] = postfixSum[(A.length - 1) - i + 1];

            if(A[(A.length - 1) - i] == leader){
                ++postfixSum[(A.length - 1) - i];
            }
        }
        //=============================================================
        int numberOfLeaderCount  = 0;

        if(prefixSum[0] != 0 && postfixSum[1] > (A.length - 1) / 2){
            ++numberOfLeaderCount;
        }

        for(int i  = 1; i < A.length - 1; ++i){
            if( prefixSum[i] > (i + 1) / 2
                &&
                postfixSum[i+1] > ((A.length - ( i + 1 + 1)) + 1)  / 2){
                ++numberOfLeaderCount;
            }
        }
        //=============================================================
        return numberOfLeaderCount;
    }

    static int RemainingLength(int length, int index){
        return (length - (index + 1)) + 1;
    }

}
