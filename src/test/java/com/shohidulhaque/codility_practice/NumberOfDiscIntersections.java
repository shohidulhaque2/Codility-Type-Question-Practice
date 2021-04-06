package com.shohidulhaque.codility_practice;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfDiscIntersections {

    //https://www.martinkysel.com/codility-number-of-disc-intersections-2010-beta-solution/

    @Test
    public void NumberOfDiscIntersectionsDriver(){
        int A[] = { 1, 5, 2, 1, 4, 0};
        Assertions.assertThat(solution(A)).isEqualTo(11);
    }

    public int solution(int A[]){
        int discCentreAndRadius [] = A;
        int numberOfIntersectingPairs = 0;

        int rightBoundary[] = new int[A.length];
        int leftBoundary[] = new int[A.length];

        for(int discCentre = 0; discCentre < discCentreAndRadius.length; ++discCentre){
            rightBoundary[discCentre] = discCentre + discCentreAndRadius[discCentre];
            leftBoundary[discCentre] = discCentre - discCentreAndRadius[discCentre];
        }

        Arrays.sort(leftBoundary);
        Arrays.sort(rightBoundary);
        final int LENGTH = A.length;
        int count = 0;
        for(int left = 0, right = 0; left < LENGTH && right < LENGTH; ){
            if((leftBoundary[left] - rightBoundary[right]) <= 0 ){

                ++left;
            }
            else {
                ++right;
            }
        }
        return count;
    }

}
