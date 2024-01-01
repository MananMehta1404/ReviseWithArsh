package goldman_sachs;

import java.util.ArrayList;
import java.util.List;

public class Letter_Com_PhoneNo {

    private static String[] keypad = {".", ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // Time Complexity -> O(4^n)  {4 -> maximum length of keypad string, n -> maximum length of string of numbers}
    private static void printCombinations(String str, int idx, String combination, List<String> result){
        if(idx == str.length()){
            saveComb(combination, result);
            return;
        }

        char currChar = str.charAt(idx);
        String mapped = keypad[currChar - '0'];

        for(int i = 0; i < mapped.length(); i++){
            printCombinations(str, idx + 1, combination + mapped.charAt(i), result);
        }
    }

    private static void saveComb(String combination, List<String> result){
        if(combination == "") return;
        String newString = combination;
        result.add(newString);
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        printCombinations(digits, 0, "", result);

        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }
}
