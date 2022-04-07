package com.company;
import java.util.*;




class Arabic {

    int num1, num2;
    String operator;
    String[] arr;

    Arabic(String[] arr) {

        this.arr = arr;
        this.num1 = Integer.parseInt(arr[0]);
        this.num2 = Integer.parseInt(arr[2]);
        this.operator = arr[1];

    }

    public int sumArabic() {
        return this.num1 + this.num2;
    }

    public int diffArabic() {
        return this.num1 - this.num2;
    }

    public int multArabic() {
        return this.num1 * this.num2;
    }

    public int divArabic() {
        return this.num1 / this.num2;
    }

    public void evaluateArabic() {
        switch (this.operator) {
            case "+":
                System.out.println(sumArabic());
                break;
            case "-":
                System.out.println(diffArabic());
                break;
            case "/":
                System.out.println(divArabic());
                break;
            case "*":
                System.out.println(multArabic());
                break;
            default:
                break;
        }
    }
}

class Roman {

    String[] romanNumerics = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    int[] arabicNumerics = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String rom1, rom2, romanResult;
    int n1, n2, arabicResult;
    String romOperator;
    String finalResult = "";
    String[] a;

    Roman(String[] a) {
        this.a = a;
        this.rom1 = a[0];
        this.rom2 = a[2];
        this.romOperator = a[1];
    }

    public void matchRomanToArabic() {
        n1 = arabicNumerics[Arrays.asList(romanNumerics).indexOf(this.rom1)];
        n2 = arabicNumerics[Arrays.asList(romanNumerics).indexOf(this.rom2)];
    }

    public void sumRoman() {
        this.arabicResult = this.n1 + this.n2;
    }

    public void diffRoman() {
        try {
            if (this.n1 <= this.n2) throw new Exception("Wrong result. Should be >= 1");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.arabicResult = this.n1 - this.n2;
    }

    public void multRoman() {
        this.arabicResult = this.n1 * this.n2;
    }

    public void divRoman() {
        this.arabicResult = this.n1 / this.n2;
    }

    public void evaluateRoman() {
        switch (this.romOperator) {
            case "+":
                sumRoman();
                break;
            case "-":
                diffRoman();
                break;
            case "/":
                divRoman();
                break;
            case "*":
                multRoman();
                break;
            default:
                break;
        }
    }


    public void matchArabicToRoman() {

        matchRomanToArabic();
        evaluateRoman();
        String[] arr1;
        int index;

        if (this.arabicResult > 10 && this.arabicResult < 40) {
            romanResult = Integer.toString(arabicResult);
            arr1 = romanResult.split("");
            finalResult += "X".repeat(Integer.parseInt(arr1[0]));
            for (int i = 0; i < arabicNumerics.length; i++) {
                if (Integer.parseInt(arr1[1]) == arabicNumerics[i]) {
                    index = i;
                    finalResult += romanNumerics[index];
                }
            }
        } else if (this.arabicResult >= 40 && this.arabicResult < 50) {
            romanResult = Integer.toString(arabicResult);
            arr1 = romanResult.split("");
            finalResult += "XL";
            for (int i = 0; i < arabicNumerics.length; i++) {
                if (Integer.parseInt(arr1[1]) == arabicNumerics[i]) {
                    index = i;
                    finalResult += romanNumerics[index];
                }
            }
        } else if (this.arabicResult > 50 && this.arabicResult < 90) {
            romanResult = Integer.toString(arabicResult);
            finalResult += "L";
            arr1 = romanResult.split("");
            finalResult += "X".repeat(Integer.parseInt(arr1[0]) - 5);
            for (int i = 0; i < arabicNumerics.length; i++) {
                if (Integer.parseInt(arr1[1]) == arabicNumerics[i]) {
                    index = i;
                    finalResult += romanNumerics[index];
                }
            }
        } else if (this.arabicResult >= 90 && this.arabicResult < 100) {
            romanResult = Integer.toString(arabicResult);
            finalResult += "XC";
            arr1 = romanResult.split("");
            for (int i = 0; i < arabicNumerics.length; i++) {
                if (Integer.parseInt(arr1[1]) == arabicNumerics[i]) {
                    index = i;
                    finalResult += romanNumerics[index];
                }
            }
        } else if (this.arabicResult == 100) {
            finalResult = "C";
        } else {
            romanResult = Integer.toString(arabicResult);
            for (int i = 0; i < arabicNumerics.length; i++) {
                if (Integer.parseInt(romanResult) == arabicNumerics[i]) {
                    index = i;
                    finalResult += romanNumerics[index];
                }
            }
        }
        System.out.println(finalResult);
    }
}