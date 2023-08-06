package org.example;

import java.util.stream.IntStream;

public class AlgoSum {
    public int sum(int[]values){
        return IntStream.of(values).sum();
    }
}
