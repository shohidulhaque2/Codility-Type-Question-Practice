package com.example.demo.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrogJmp2 {

    @Test
    public void Driver(){
        final int X = 10;
        final int Y = 85;
        final int D = 30;
        Assertions.assertThat(solution(X, Y, D)).isEqualTo(3);
    }

    public int solution(final int X, final int Y, final int D){

        if(X == Y){
            return 0;
        }
        //ONLY ONE POSSIBLE WAY FOR THIS
        if(X + 1 == Y){
            return 1;
        }

        //NEED TO DO SOME MATHS FOR THE REST OF CASES
        final int StartPosition = X;
        final int Distance  = Y - StartPosition;
        final int Multiple = Distance / D;
        int numberOfAdditions = Multiple;
        if(StartPosition + (Multiple * D) < Y){
            numberOfAdditions += 1;
        }
        return numberOfAdditions;
    }
}
