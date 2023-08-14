package org.example.practik;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//// Посчитать количество слов в предложении
public class Test1 {
    public static void main(String[] args) {
       String srt ="I love Java,I love Java ";
        System.out.println(countWords(srt));
    }
public static Map<String,Integer>countWords(String str){
        if (str==null){
            throw new IllegalArgumentException();
        }
 //   return   Arrays.stream(str.split("[,.\\s]"))
    return   Arrays.stream(str.split("[\\s\\p{Punct}]+"))
                .collect(Collectors.toMap(s->s,s->1,Integer::sum));

}
}
