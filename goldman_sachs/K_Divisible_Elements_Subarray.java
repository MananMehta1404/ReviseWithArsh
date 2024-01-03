package goldman_sachs;

import java.util.HashSet;

public class K_Divisible_Elements_Subarray {
    private static int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();

            for(int j = i; j < n; j++) {
                if(nums[j] % p == 0) {
                    count++;
                }
                if(count > k) break;
                
                sb.append(nums[j] + ",");

                hs.add(sb.toString());
            }
        }

        return hs.size();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2, 2};
        int k = 2;
        int p = 2;

        System.out.println(countDistinct(nums, k, p));
    }
}
