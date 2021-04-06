package com.shohidulhaque.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxGap {

    @Test
    public void maxGapDriver1(){
        int maxGap = 0b0;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(0);
    }

    @Test
    public void maxGapDriver2(){
        int maxGap = 0b1;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(0);
    }

    @Test
    public void maxGapDriver3(){
        int maxGap = 0b11;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(0);
    }

    @Test
    public void maxGapDriver4(){
        int maxGap = 0b00;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(0);
    }

    @Test
    public void maxGapDriver5(){
        int maxGap = 0b0010;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(0);
    }

    @Test
    public void maxGapDriver6(){
        int maxGap = 0b00101;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(1);
    }

    @Test
    public void maxGapDriver7(){
        int maxGap = 0b001010;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(1);
    }

    @Test
    public void maxGapDriver8(){
        int maxGap = 0b0010101;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(1);
    }

    @Test
    public void maxGapDriver9(){
        int maxGap = 0b10100101;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(2);
    }

    @Test
    public void maxGapDriver10(){
        int maxGap = 0b101001000010;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(4);
    }

    @Test
    public void maxGapDriver11(){
        int maxGap = 0b101;
        Assertions.assertThat(maxGap(maxGap)).isEqualTo(1);
    }
    public int maxGap(int binarySequence){
        if(binarySequence == 0){
            return 0;
        }
        if(binarySequence == 1){
            return 0;
        }

        boolean isLeftMostOneBit = false;
        boolean isRightMostOneBit = false;
        int localZeroCount = 0;
        int globalZeroCount = 0;
        int rightMostBit = 0;
        while(binarySequence != 0){
            rightMostBit = binarySequence % 2;
            binarySequence >>>= 1;
            if(rightMostBit == 1){
                if(isRightMostOneBit == false){
                    isRightMostOneBit = true;
                    localZeroCount = 0;
                } else if(isLeftMostOneBit == false){
                    isLeftMostOneBit = true;
                }
                else {
                    System.out.println("Error in Code.");
                }
            } else if(rightMostBit == 0){
                //could possibly be a valid zero count.
                ++localZeroCount;
            }
            if(isLeftMostOneBit && isRightMostOneBit){
                isLeftMostOneBit = false;
                globalZeroCount = Math.max(localZeroCount, globalZeroCount);
                localZeroCount = 0;
            }
        }
        return globalZeroCount;
    }
}
