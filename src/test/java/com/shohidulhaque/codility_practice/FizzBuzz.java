package com.shohidulhaque.codility_practice;

import java.util.LinkedList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzz {

    final static Logger Logger = LoggerFactory.getLogger(FizzBuzz.class);

    @Test
    public void FizzBuzzTest1(){
        final int NUMBER = 1;
        Assertions.assertThat(solution(NUMBER)).isEmpty();
    }

    @Test
    public void FizzBuzzTest2(){
        final int NUMBER = 3;
        Assertions.assertThat(solution(NUMBER)).containsExactly(new String[]{"FIZZ"});
    }


    @Test
    public void FizzBuzzTest3(){
        final int NUMBER = 5;
        Assertions.assertThat(solution(NUMBER)).containsExactly(new String[]{"FIZZ","BUZZ"});
    }


    @Test
    public void FizzBuzzTest4(){
        final int NUMBER = 3 * 5;
        Assertions.assertThat(solution(NUMBER)).containsExactly(new String[] {"FIZZ", "BUZZ", "FIZZ", "FIZZ", "BUZZ", "FIZZ", "FIZZBUZZ"});
    }

    public String[] solution(int number){
        final String FIZZ = "FIZZ";
        final String BUZZ  = "BUZZ";
        final String FIZZBUZZ = FIZZ + BUZZ;
        List<String> list = new LinkedList<>();
        for(int i = 1; i <= number; ++i){
            if(i % 3 == 0 && i % 5 == 0){
                list.add(FIZZBUZZ);
            } else {
                if(i % 3 == 0){
                    list.add(FIZZ);
                }
                if(i % 5 == 0){
                    list.add(BUZZ);
                }
            }
        }
        return list.toArray( new String[list.size()]);
    }

}
