package org.example.part2;

import java.time.YearMonth;

public class CardDetails {
    private final String pan;
    private final YearMonth expiration;
    private final String cvv;

    public CardDetails(String pan, YearMonth expiration, String cvv) {
        this.pan = pan;
        this.expiration = expiration;
        this.cvv = cvv;
    }
}