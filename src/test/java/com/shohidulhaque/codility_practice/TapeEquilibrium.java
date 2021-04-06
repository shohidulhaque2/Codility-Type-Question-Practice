package com.shohidulhaque.codility_practice;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class TapeEquilibrium {


  @Test
  public void tapeEquilibrumDriver(){

    final int A[] = new int[] {3,1,2,4,3};
    new TapeEquilibrium().tapeEquilibrium(A);

  }


  @Test()
  public void tapeEquilibrumDriver2(){

    final int A[] = new int[] {};
    Assertions.assertThrows(Exception.class, () -> {
      new TapeEquilibrium().tapeEquilibrium(A);
    });
  }

  @Test
  public void tapeEquilibrumDriver3(){

    final int A[] = new int[] {3};
    new TapeEquilibrium().tapeEquilibrium(A);

  }


  @Test
  public void tapeEquilibrumDriver4(){

    final int A[] = new int[] {3, 1};
    new TapeEquilibrium().tapeEquilibrium(A);

  }

  public int tapeEquilibrium(final int [] a){
    if(Objects.isNull(a) || a.length == 0){
      throw new IllegalArgumentException();
    }

    if(a.length == 1){
      return 0;
    }

    int leftSum  = a[0];
    int rightStartIndex = 1;
    int rightSum = 0;
    for(int i = rightStartIndex; i < a.length; ++i){
      rightSum += a[i];
    }
    int min = Math.abs(leftSum - rightSum);
    System.out.println(leftSum + "," + rightSum);
    System.out.println(min);

    for(   rightStartIndex += 1; rightStartIndex < a.length; ++rightStartIndex){
      leftSum += a[rightStartIndex - 1];
      rightSum -= a[rightStartIndex - 1];
      if(Math.abs(leftSum - rightSum) < min){
        min = Math.abs(leftSum - rightSum);
      }
      System.out.println(leftSum + "," + rightSum);
      System.out.println(Math.abs(leftSum - rightSum));
    }
    return min;
  }

}
