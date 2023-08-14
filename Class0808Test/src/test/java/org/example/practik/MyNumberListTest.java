package org.example.practik;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MyNumberListTest {
private Test2 test2;
private static final Integer CAPACITY=10;
private static final Integer SIZE=5;
@BeforeEach
void setup(){
    Integer []integers=new  Integer[]{1,2,3,4,5,null,null,null,null,null};
    test2 = new Test2(integers,CAPACITY,SIZE);
}
@AfterEach
void tearDoun(){
    test2=null;
}

    @Test
    void add() {
    test2.add(6);
        long size = Arrays.stream(test2.getNumbers())
                .filter(Objects::nonNull)
                .count();
        Assertions.assertEquals(6, size);
    }

    @Test
    void remove() {
    test2.remove(4);
        Integer []integers=new  Integer[]{1,2,4,5,null,null,null,null,null,null};
Assertions.assertArrayEquals(integers,test2.getNumbers());
    }
    @Test
    void removePositiveCaseTest() {
      test2 .remove(3);
        Integer[] expected = new Integer[]{1, 2, 3, 5, null, null, null, null, null, null};
        Assertions.assertArrayEquals(expected, test2.getNumbers());
    }

    @Test
    void removeSizeEqualsTest() {
        test2.remove(3);
        long size = Arrays.stream(test2.getNumbers())
                .filter(Objects::nonNull)
                .count();
        Assertions.assertEquals(4, size);
    }

    @Test
    void removeReturnNumberTest() {
        Assertions.assertEquals(4, test2.remove(3));
    }

}