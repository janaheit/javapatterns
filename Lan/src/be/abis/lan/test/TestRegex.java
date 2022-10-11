package be.abis.lan.test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String regexSplitSentence = "(?<=[.,?!]\\s)";
        Pattern p = Pattern.compile(regexSplitSentence);
        String[] strings=  p.split("Hello, I am trying to . split this String!");
        for(String s:strings){
            System.out.println(s);
        }
    }
}
