package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
*\A - выражение в начале стринги
 * \a
 * \B - Не граница  слова и числа
 * \b - граница слова и числа
 * \Z  - выражение в конце стринги
*/
public class Re1 {
    public static void main(String[] args) {
        String s = "Enabling this setting will require contributors to sign off" +
                " on commits made@gmail.com  22345 through GitHub’s 12 web interface. Signing off is a " +
                "way for contributors to affirm that their commit@gmail.com complies with the repository's" +
                "terms, commonly@yyoo.ru 12345 the Developer  peee" +
                "Certificate of Origin (DCO). Learn more about signing off on commits";
      //  Pattern p =Pattern.compile("\\b\\d{5}\\b");
      //  Pattern p =Pattern.compile("\\+\\d{5}");
     //   Pattern p =Pattern.compile("\\w+@\\w+\\.(ru|com)");
       // Pattern p =Pattern.compile("p(e)?");
        Pattern p =Pattern.compile("p(e)*");
        Matcher matcher= p.matcher(s);
        while (matcher.find()) {
            System.out.println("Pos:"+matcher.start()+":"+ matcher.group());

        }


    }
}
