package com.example.demo.codility_practice;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Nesting {

    @Test
    public void NestingDriver1(){
        String S = "(()(())())";
        Assertions.assertThat(solution(S)).isEqualTo(1);
    }

    @Test
    public void NestingDriver2(){
        String S = "())";
        Assertions.assertThat(solution(S)).isEqualTo(0);
    }

    int solution(String S){

        if(Objects.isNull(S)){
            throw new IllegalArgumentException();
        }

        if(S.isBlank()){
            return 1;
        }

        if(S.length() % 2 == 1){
            return 0;
        }

        Deque<Character> stack = new LinkedList();
        stack.push(S.charAt(0));
        for(int i = 1; i < S.length(); ++i){
            Character currentChar =  S.charAt(i);
            Character last = stack.peek();
            if(last == '(' &&  currentChar == ')'){
                stack.pop();
            }
            else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty() ? 1 : 0;

    }
}
