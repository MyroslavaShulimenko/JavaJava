package org.example.practik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldCounterTest {

    @Test
    void countWordsTest() {
        String srt ="I love Java,I love Java ";
        Assertions.assertEquals(2,Test1.countWords(srt).get("Java"));
    }
    @Test
    void emptyStringTest() {
    //    String srt ="I love Java,I love Java ";
        Assertions.assertEquals(null,Test1.countWords("").get("abc"));
    }
    @Test
    void nullStringTest() {
        Assertions.assertThrows(IllegalArgumentException.class,()->Test1.countWords(null));
    }
    @Test
    void multyStringTest() {
        Assertions.assertNull(Test1.countWords("a b").get(""));
    }
    @Test
    void punktStringTest() {
        String srt ="I love Java,I love Java! ";
        Assertions.assertEquals(2,Test1.countWords(srt).get("Java"));
        }
    }

