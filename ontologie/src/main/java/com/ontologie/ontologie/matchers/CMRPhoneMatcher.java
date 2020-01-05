package com.ontologie.ontologie.matchers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CMRPhoneMatcher {

	static final String regex = "^(\\+237)\\s6\\s?[2356789]\\d(\\s?\\d{2}){3}$";
    static Pattern pattern;
    static Matcher matcher;
    static{
        pattern = Pattern.compile(regex);
    }
    
    public static boolean validate(String phoneNumber){
        matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }
}
