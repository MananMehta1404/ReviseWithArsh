package goldman_sachs;

import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_Element_Query {
    
    private static int findMin(List<String> lst1, int k){
        int n = lst1.size();
        int[] vis = new int[n];

        int finalIdx = -1;
        String temp = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        // for(int m = 0; m < lst1.get(0).length(); m++) temp += '9';

        for(int i = 0; i < k; i++) {
            int minIdx = -1;
            String minVal = temp;

            for(int j = 0; j < n; j++) {
                if(vis[j] == 1) continue;
                if(minVal.compareTo(lst1.get(j)) > 0) {
                    minVal = lst1.get(j);
                    minIdx = j;
                }
            }

            vis[minIdx] = 1;
            finalIdx = minIdx;
        }

        return finalIdx;
    }

    private static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;

        int result[] = new int[n];

        for(int i = 0; i < n; i++){
            int k = queries[i][0];
            int trim = queries[i][1];

            List<String> l1 = new ArrayList<>();
            int len = nums[0].length();
            for(int j = 0; j < nums.length; j++){
                String trimmed = nums[j].substring(len - trim, len);
                l1.add(trimmed);
            }
            // System.out.println(l1);

            result[i] = findMin(l1, k); 
        }

        return result;
    }

    public static void main(String[] args) {
        String[] nums = {"102","473","251","814"};
        int[][] queries = {{1,1}, {2,3}, {4,2}, {1,2}};

        int[] result = smallestTrimmedNumbers(nums, queries);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
