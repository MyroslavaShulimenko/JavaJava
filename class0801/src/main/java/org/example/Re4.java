package org.example;

import java.util.regex.Pattern;

public class Re4 {
    public static void main(String[] args) {
        String i1= "225.98.125.88";
        String i2= "188.98.0.78";
        Re4 re4=new Re4();
        re4.checkIP(i1);
        re4.checkIP(i2);
    }
    private void checkIP(String i1){
        String regex="((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)" +
                "(\\.)){3}" +
                "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)";
        System.out.println(i1+":"+ Pattern.matches(regex,i1));
    }
}
