package com.shohidulhaque.codility_practice;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxCounters {

  @Test
  public void maxCountersDriver(){
    final int A[] = {3 ,4, 4, 6, 1, 4, 4};
    final int N = 5;
    Assertions.assertThat(maxCounter(N, A)).containsExactly(3, 2, 2, 4, 2);
    maxCounter(N, A);
  }

  public int [] maxCounter(int N, int[] A){
    int C[] = new int[N];
    int MAX  = 0;
    int LAST_MAX = MAX;
    for(int index = 0; index < A.length; ++index){
      if (1 <= A[index] && A[index] <= CountingLengthOfArray(C)){
        if(C[To_IndexNumber(A[index])] < LAST_MAX){
          C[To_IndexNumber(A[index])] = LAST_MAX;
         ++C[To_IndexNumber(A[index])];
        } else {
          ++C[To_IndexNumber(A[index])];
          MAX = Math.max(MAX, C[To_IndexNumber(A[index])]);
        }
      }
      else if(A[index] == CountingLengthOfArray(C) + 1){
        LAST_MAX = MAX;
      }
      print(C);
    }
    for(int i = 0; i < C.length; ++i){
      C[i] =  Math.max(C[i], LAST_MAX);
    }
    return C;
  }

  private static int maxValue(int[] chars) {
    int max = chars[0];
    for (int ktr = 0; ktr < chars.length; ktr++) {
      if (chars[ktr] > max) {
        max = chars[ktr];
      }
    }
    return max;
  }
//
//  private static int updateAll(int[] chars) {
//    int max = chars[0];
//    for (int ktr = 0; ktr < chars.length; ktr++) {
//      if (chars[ktr] > max) {
//        max = chars[ktr];
//      }
//    }
//    return max;
//  }

  private int CountingLengthOfArray(int a[]){
    return a.length;
  }
  private int To_CountingNumber(int indexNumber){
    return ++indexNumber;
  }
  private int To_IndexNumber(int countingNumber){
    return  --countingNumber;
  }
  private void print(int [] array){
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    Arrays.stream(array).forEach( x -> stringBuilder.append(x + ","));
    stringBuilder.append("]");
    System.out.println(stringBuilder);
  }
}
