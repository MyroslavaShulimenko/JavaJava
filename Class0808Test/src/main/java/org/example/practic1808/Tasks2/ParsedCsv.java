package org.example.practic1808.Tasks2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParsedCsv {
    private final Map<String, Map<String, Integer>> parsedData;

    public ParsedCsv(Map<String, Map<String, Integer>> parsedData) {
        this.parsedData = parsedData;
    }

    public Map<String, Map<String, Integer>> getParsedData() {
        return parsedData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedCsv parsedCsv = (ParsedCsv) o;
        return Objects.equals(parsedData, parsedCsv.parsedData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parsedData);
    }

    @Override
    public String toString() {
        return "ParsedCsv{" +
                "parsedData=" + parsedData +
                '}';
    }

    public static class IncorrectPathException extends Throwable {
    }
}
