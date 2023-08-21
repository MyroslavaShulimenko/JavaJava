package org.example.practic1808.Tasks2;

public class Finder {  private final ParsedCsv parsedCsv;

    public Finder(ParsedCsv parsedCsv) {
        this.parsedCsv = parsedCsv;
    }

    public Integer find(String fieldName, String value) {
        return parsedCsv.getParsedData().get(fieldName).get(value);
    }
}
