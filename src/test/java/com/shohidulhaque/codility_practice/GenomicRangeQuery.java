package com.shohidulhaque.codility_practice;

import java.util.Arrays;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenomicRangeQuery {
    static Logger Logger = LoggerFactory.getLogger(GenomicRangeQuery.class);

    static final int A = 1;
    static final int C = 2;
    static final int G = 3;
    static final int T = 4;



    @Test
    public void GenomicRangeQueryTest(){
        //impact factor
        //A = 1
        //C = 2
        //G = 3
        //T = 4
        String GeneticSequence = "CAGCCTA";
        int P [] = {2, 5, 0};
        int Q [] = {4, 5, 6};
        Assertions.assertThat(solution(GeneticSequence, P, Q)).containsExactly(2, 4, 1);
    }

    public int [] Convert(String S){
        int [] numberMapping = new int[S.length()];
        char [] chars = S.toCharArray();
        for(int i = 0; i < numberMapping.length; ++i){
            if(chars[i] == 'A'){
                numberMapping[i] = A;
            }
            else if(chars[i] == 'C'){
                numberMapping[i] = C;
            }
            else if(chars[i] == 'G'){
                numberMapping[i] = G;
            }
            else if(chars[i] == 'T'){
                numberMapping[i] = T;
            }
        }
        return numberMapping;
    }

    void markPosition(int [] genome, int [] genomePositionOfChars, int Code,int index){
        if(genome[index] == Code){
            genomePositionOfChars[index] = index;
        }
        else if(index > 0){
            genomePositionOfChars[index] = genomePositionOfChars[index - 1];
        }
    }

    public int[] solution(String S, int[] P, int[] Q){
        if(S == null || S.isBlank()){
            throw new IllegalArgumentException();
        }
        if(Objects.isNull(P) || Objects.isNull(Q) || Objects.isNull(P) || Objects.isNull(Q) || P.length != Q.length){
            throw new IllegalArgumentException();
        }
        final int M = P.length;
        int [] result = new int[M];
        int [] genome = Convert(S);

        int [] genomePositionOfA = new int [genome.length];
        int [] genomePositionOfC = new int [genome.length];
        int [] genomePositionOfG = new int [genome.length];
        int [] genomePositionOfT = new int [genome.length];

        for(int i = 0; i < genome.length; ++i){
            genomePositionOfA[i] = -1;
            genomePositionOfC[i] = -1;
            genomePositionOfG[i] = -1;
            genomePositionOfT[i] = -1;
        }
        for(int i = 0; i < genome.length; ++i){
            markPosition(genome, genomePositionOfA, A, i);
            markPosition(genome, genomePositionOfC, C, i);
            markPosition(genome, genomePositionOfG, G, i);
            markPosition(genome, genomePositionOfT, T, i);
        }
        for(int i = 0; i < M; ++i){
            if(genomePositionOfA[Q[i]] >= P[i]){
                result[i] = A;
            }
            else if(genomePositionOfC[Q[i]] >= P[i]){
                result[i] = C;
            }
            else if(genomePositionOfG[Q[i]] >= P[i]){
                result[i] = G;
            }
            else if(genomePositionOfT[Q[i]] >= P[i]){
                result[i] = T;
            }
        }

        return result;
    }
}
