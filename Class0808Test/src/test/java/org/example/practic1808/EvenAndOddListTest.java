package org.example.practic1808;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvenAndOddListTest {
    private static final List<Integer> NUMBERS = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9, 7, 10));

    @Test
    void getEvenOddListPositiveTest() {
        List<Integer> even1 = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        List<Integer> odd1 = new ArrayList<>(Arrays.asList(1, 3, 5, 9, 7));
        EvenAndOddList exepected = new EvenAndOddList(even1, odd1);
        assertEquals(exepected, EvenAndOddList.EvenOddTask.getEvenOddList(NUMBERS));
    }

}