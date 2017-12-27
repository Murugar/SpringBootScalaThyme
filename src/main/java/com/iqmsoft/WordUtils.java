package com.iqmsoft;


import java.util.ArrayList;
import java.util.List;


public class WordUtils {
    public static List<Boolean> matchNum(List<String> strList) {
        List<Boolean> isNumList = new ArrayList<>();
        strList.forEach(
                (String e) -> isNumList.add(matchNum(e)));

        return isNumList;
    }

    public static boolean matchNum(String str) {
        return str.matches("^[0-9]*$");

    }
}
