package com.example.demo.codility_practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoneWall {

    @Test
    public void StoneWallDriver(){
        int [] wall = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        Assertions.assertThat(solution(wall)).isEqualTo(7);
    }

    public int solution(int[] H){

        if(Objects.isNull(H) || H.length == 0){
            throw new IllegalArgumentException();
        }

        Deque<Integer> stack = new LinkedList<>();
        stack.push(H[0]);
        int count = 1;
        int totalHeight = H[0];

        for(int i = 1; i < H.length; ++i){
            int currentWallHeight = H[i];
            if(totalHeight == currentWallHeight){
                //do nothing
            }
            else if(currentWallHeight > totalHeight){
                int k = currentWallHeight - totalHeight;
                stack.push(k);
                totalHeight = currentWallHeight;
                ++count;
            }
            else if(currentWallHeight < totalHeight){
                while(currentWallHeight < totalHeight){
                    int v = stack.pop();
                    if((totalHeight - v) <= currentWallHeight){
                        int h = currentWallHeight - (totalHeight - v);
                        if(h  == 0){
                            //do nothing
                        }
                        else if(h != 0){
                            stack.push(h);
                            ++count;
                        }
                        totalHeight = currentWallHeight;
                    } else {
                        totalHeight -= v;
                    }
                }
            }
        }
        return count;
    }

}
