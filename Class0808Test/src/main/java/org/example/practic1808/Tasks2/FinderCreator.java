package org.example.practic1808.Tasks2;

public class FinderCreator {

    public static Finder createFinder(String filePath) throws ParsedCsv.IncorrectPathException {
        ParsedCsv parsedCsv = CsvReader.readCsvFile(filePath);
        return new Finder(parsedCsv);
    }
}