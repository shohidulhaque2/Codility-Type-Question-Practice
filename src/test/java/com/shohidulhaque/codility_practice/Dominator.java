package com.example.demo.codility_practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Dominator {

    @Test
    public void DominatorTest1(){
        int A [] = {3 ,4 ,3 ,2 , 3 ,-1, 3 ,3};
        Assertions.assertThat(solution(A)).isIn(0, 2, 4, 6, 7);
    }

    public int solution(int A[]){
        if(Objects.isNull(A) || A.length == 0 || A.length % 2 == 1){
            throw new IllegalArgumentException();
        }
        if(A.length == 1){
            return 0;
        }
        if(A.length == 2){
            return 0;
        }
        if(A.length == 3){
            return A[0] == A[1] ? 0 : 2;
        }

        Deque<Integer> stack = new LinkedList<>();

        int index = 0;
        stack.push(A[0]);
        for(int i  = 1; i < A.length; ++i){
            if(stack.isEmpty()){
                stack.push(A[i]);
                index = i;
            }
            else if(A[i] != stack.peek()){
                stack.pop();
                --index;
            } else {
                stack.push(A[i]);
                index = i;
            }
        }
        return index;
    }
}
