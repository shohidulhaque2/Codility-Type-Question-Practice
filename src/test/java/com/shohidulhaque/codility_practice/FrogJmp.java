package com.shohidulhaque.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrogJmp {

    @Test
    public void frogJmpDriver(){
        final int X = 10;
        final int Y = 85;
        final int D = 30;
        Assertions.assertThat(frogJmp(X, Y, D)).isEqualTo(3);
    }

    public int frogJmp(final int X, final int Y, final int D) {
        if(X == Y){
            return 0;
        }

        int distance = Y - X;
        int numberOfJumps = distance / D;
        if(distance % D != 0){
            return ++numberOfJumps;
        } else {
            return  numberOfJumps;
        }
    }

}
