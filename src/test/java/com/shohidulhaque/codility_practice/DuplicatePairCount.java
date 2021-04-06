package com.shohidulhaque.codility_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DuplicatePairCount {

    @Test
    public void duplicatePairCountDriver2(){
        int a [] = {4, 6, 6,4, 3};
        Assertions.assertThat(duplicatePairCount(a)).isFalse();
    }

    @Test
    public void duplicatePairCountDriver(){
        int a [] = {4, 6, 6,4};
        Assertions.assertThat(duplicatePairCount(a)).isTrue();

    }

    public boolean duplicatePairCount(int a []){
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for(int v : a){
            if(Objects.isNull(frequencyCount.get(v))){
                frequencyCount.put(v, 1);
            } else {
                int frequency = frequencyCount.get(v);
                frequencyCount.put(v, ++frequency);
            }
        }
        for(int key : frequencyCount.keySet()){
            int frequency = frequencyCount.get(key);
            if((frequency % 2) != 0){
                return false;
            }
        }
        return true;
    }

}
