package com.example.demo.codility_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
//samuel.t.whitehouse@aviva.com
public class MaxCounters2 {

    @Test
    void MaxCounters2Test1(){
        int A [] = {3, 4, 4, 6, 1, 4, 4};
        Assertions.assertThat(solution(5, A)).containsExactly(3, 2, 2, 4, 2);
    }

    void MaxCounters2Test2(){

    }

    void MaxCounters2Test3(){

    }

    void MaxCounters2Test4(){

    }

    int[] solution(int N, int[] A){
        final int NUMBER_OF_COUNTERS = N;
        int counters[] = new int[NUMBER_OF_COUNTERS];
        //need to track max
        int globalMax = 0;
        int localMax = 0;
        for(int i = 0; i < A.length; ++i){
            int positionOfCounter = A[i];
            if( positionOfCounter <= NUMBER_OF_COUNTERS){
                if(counters[positionOfCounter - 1] < globalMax ){
                    counters[positionOfCounter - 1] = globalMax;
                }
                ++counters[positionOfCounter - 1];
                localMax = Math.max(globalMax, counters[positionOfCounter-1]);
            } else if (positionOfCounter == NUMBER_OF_COUNTERS + 1){//condition for updating all to max value.
                //this triggers update
                globalMax = localMax;
            }
        }
        for(int i = 0; i < counters.length; ++i){
            counters[i] = Math.max(counters[i], globalMax);
        }
        return counters;
    }
}
