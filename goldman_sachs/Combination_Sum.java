package goldman_sachs;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {

    private static void findCombinations(int i, int k, int n, List<List<Integer>> result, List<Integer> l1){
        // Base Case
        if(k == 0 && n == 0){
            result.add(new ArrayList<>(l1));
            return;
        }
        // Second Base Case
        if(k < 0 || i > 9 || i > n) return;

        // We have two options -> either we pick i or don't pick
        // First case
        l1.add(i);
        findCombinations(i + 1, k - 1, n - i, result, l1);
        l1.remove(l1.size() - 1);
        // Second Case
        findCombinations(i + 1, k, n, result, l1);
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(1, k, n, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;

        List<List<Integer>> result = combinationSum3(k, n);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
