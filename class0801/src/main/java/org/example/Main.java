package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //   String s = "ABCD ABCD ANCDDFGGHJKL";
        String s = "QABTWERTJDKFLGZNCBX";
        //Pattern pattern= Pattern.compile("[AGTR.]");
        Pattern pattern= Pattern.compile("[A[0-9A-Z]T.]");
        Matcher matcher= pattern.matcher(s);
        while (matcher.find()){
          //  System.out.println(matcher.group());
            System.out.println("Pos:"+matcher.start()+":"+ matcher.group());
        }
    }
}