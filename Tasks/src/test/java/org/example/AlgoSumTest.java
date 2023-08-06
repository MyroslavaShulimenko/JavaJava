package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgoSumTest {
    private final AlgoSum algoSum=new AlgoSum();
@Test
    void firstTest6(){
    int sum = algoSum.sum(new int[]{1,2,3});
    assertEquals(6,sum);
}
    @Test
    void firstTest10(){
        int sum = algoSum.sum(new int[]{1,2,3,4});
        assertEquals(10,sum);
    }

}