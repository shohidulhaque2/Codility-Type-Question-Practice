package com.shohidulhaque.codility_practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leader {

    @Test
    public void LeaderTest1(){
        int a[] = {4, 6, 6, 6, 6, 8, 8};
        Assertions.assertThat(solution(a)).isEqualTo(6);
    }

    @Test
    public void LeaderTest2(){
        int a[] = {4, 6, 6, 6, 6, 8, 8};
        Assertions.assertThat(solution2(a)).isEqualTo(6);
    }
    int solution(int A[]){
        if(Objects.isNull(A)){
            throw new IllegalArgumentException();
        }
        Arrays.sort(A);
        int candiate = A[A.length/2];
        return candiate;
    }

    int solution2(int A[]){
        if(Objects.isNull(A)){
            throw new IllegalArgumentException();
        }
        if(A.length == 1){
            return A[0];
        }
        if(A.length  == 2){
            return A[0];
        }
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

        return stack.pop();
    }

}
