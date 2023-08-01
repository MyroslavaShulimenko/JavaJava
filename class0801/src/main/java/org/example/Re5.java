package org.example;

public class Re5 {
    public static void main(String[] args) {
        String s="The default branch is   considered the “base” branch in your   repository," +
                " against which all pull requests and code commits are automatically made," +
                " unless you specify a different branch.";
     //   s.replace("your","code");
     // String s1=  s.replace("your","code");
      String s1=  s.replaceAll(" {2,}","#");
        System.out.println(s1);
    }
}
