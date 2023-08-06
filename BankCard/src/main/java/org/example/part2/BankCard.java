package org.example.part2;

import org.example.part1.Currency;
import org.example.part1.Status;


//Создать класс Банковская карта:
//- Данные карты
//- Валюта
//- Статус
//
//(Все, что с большой буквы - это классы)
public class BankCard {

    private final Currency currency;
    private final Status status;

    private final CardDetails number;

    public BankCard(Currency currency, Status status, CardDetails number) {
        this.currency = currency;
        this.status = status;
        this.number = number;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Status getStatus() {
        return status;
    }




    @Override
    public String toString() {
        return "BankCard{" +
                "currency=" + currency +
                ", status=" + status +
                ", number=" + number +
                '}';
    }
}
