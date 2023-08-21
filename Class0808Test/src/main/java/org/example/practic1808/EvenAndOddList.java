package org.example.practic1808;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@ToString
public class EvenAndOddList {
    private final List<Integer> even;
    private final List<Integer> odd;

    public EvenAndOddList(List<Integer> even, List<Integer> odd) {
        this.even = even;
        this.odd = odd;
    }

    public class EvenOddTask {
        public static EvenAndOddList getEvenOddList(List<Integer> nambers) {
            List<Integer> even = new ArrayList<>();
            List<Integer> odd = new ArrayList<>();
            nambers.stream()
                    .forEach(num -> {
                        if (num % 2 == 0) {
                            even.add(num);
                        } else {
                            odd.add(num);
                        }


                    });
            return new EvenAndOddList(even, odd);
        }
    }

}

