package com.example.demo.codility_practice;

import org.junit.jupiter.api.Test;

public class MaxDoubleSum {

  @Test
  public void MaxDoubleSum(){
    int A[]  = new int[] {3, 2, 6, -1, 4, 5, -1, 2};
    System.out.println(solution(A));

    int A2[]  = new int[] {0,     -1,     0,    -1,       0};
                        // x   (x+1,y-1)  y   (y+1, z-1)  z    z < A2.length
   System.out.println(solution(A2));

    int A3[]  = new int[] { -2 -3, 4, -1, -2, 1, 5, -3};
    System.out.println(solution(A3));

    int A4 [] = new int []{ 1, 2, 3 };
    System.out.println(solution(A4));
    }


  int SmallestMiddleElement(int n){
    return  n + 1;
  }

  int BiggestMiddleElement(int n){
    return n - 1;
  }

  public int solution(int[] A) {

    final int SMALLEST_START_RANGE = 1;
    final int BIGGEST_END_RANGE = A.length - 2;

    int maxLeft[] = new int[A.length];
    int maxRight[] = new int[A.length];

    int MAX = Integer.MIN_VALUE;
    int COUNT = 0;
    for(int i = SMALLEST_START_RANGE; i < BiggestMiddleElement(BIGGEST_END_RANGE); i++){
      COUNT += A[i];
      if(COUNT > MAX){
        MAX = COUNT;
      }
      maxLeft[i] = COUNT;
      if(COUNT < 0){
        COUNT = 0;
      }
    }

    MAX = Integer.MIN_VALUE;
    COUNT = 0;
    for(int i = BIGGEST_END_RANGE; i > SmallestMiddleElement(SMALLEST_START_RANGE); i--){
      COUNT += A[i];
      if(COUNT > MAX){
        MAX = COUNT;
      }
      maxRight[i] = COUNT;
      if(COUNT < 0){
        COUNT = 0;
      }
    }

    int maxDoubleSlice = Integer.MIN_VALUE;
    boolean arraysMayOverlap = true;
    for(int i = SmallestMiddleElement(SMALLEST_START_RANGE); i <= BiggestMiddleElement(BIGGEST_END_RANGE); i++){
      arraysMayOverlap = false;
      if(maxLeft[i-1] + maxRight[i+1] > maxDoubleSlice)
        maxDoubleSlice = maxLeft[i-1] + maxRight[i+1];
    }

    return arraysMayOverlap ? 0 : maxDoubleSlice;
  }

}
