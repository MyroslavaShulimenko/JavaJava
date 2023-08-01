package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Re3 {
    public static void main(String[] args) {
String s ="ABCD ABCD A1BCDRANCDERRFEANAB8CD";
        Pattern p =Pattern.compile("\\w{2}");
        Matcher matcher= p.matcher(s);
        while (matcher.find()) {
            System.out.println("Pos:"+matcher.start()+":"+ matcher.group());

        }

    }
}
