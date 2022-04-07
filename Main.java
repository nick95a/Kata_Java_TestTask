package com.company;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // enum Roman {I, II, III, IV, V, VI, VII, VIII, IX, X};
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] operations = {"+", "-", "/", "*"};
        String arithOperation;
        int[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int finalResult;
        boolean hasArabic = false;
        boolean hasRoman = false;
        boolean bothRoman = true;
        boolean bothArabic = true;


        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll("\\s+", "");
        String[] words = s.split("((?=-|\\+|\\*|/)|(?<=-|\\+|\\*|/))");

        // Подумать над тем как обработать историю с пробелами в начале и вообще с большим количеством пробелов

        try {
            if (words.length != 3) throw new Exception("The input length is not correct");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        String[] nums = {words[0], words[2]};
        arithOperation = words[1];

        for (int i = 0; i < nums.length; i++) {
            if (Arrays.asList(roman).contains(nums[i])) {
                hasRoman = true;
            } else {
                bothRoman = false;
                if (Arrays.toString(arabic).contains(nums[i])) {
                    hasArabic = true;
                } else {
                    bothArabic = false;
                }
            }
        }
        
        try {
            if(bothArabic) {
                if(Integer.parseInt(nums[0]) == 0 || Integer.parseInt(nums[1]) == 0) throw new Exception("The calculator only accepts numbers from 1 to 10");
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        try {
            if (!Arrays.asList(operations).contains(arithOperation)) throw new Exception("Operation is not correct");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        try {
            if (hasArabic && hasRoman) throw new Exception("Both Roman and Arabic. Not possible");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        try {
            if (bothArabic == false && hasRoman == false) throw new Exception("Not according to standards");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        try {
            if (bothRoman == false && hasArabic == false) throw new Exception("Not according to standards");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        if (bothRoman) {
            Roman romanCalc = new Roman(words);
            romanCalc.matchArabicToRoman();
        } else if (bothArabic) {
            Arabic arabicCalc = new Arabic(words);
            arabicCalc.evaluateArabic();
        }
    }

}
