package goldman_sachs;

public class Find_Missing_Repeating {

    private static int[] findMissingAndRepeating(int[] arr, int n) {
        int[] exist = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            exist[arr[i]]++;
        }
        
        int result[] = new int[2];
        for(int i = 1; i < n + 1; i++) {
            if(exist[i] == 2) result[0] = i;
            if(exist[i] == 0) result[1] = i;
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 3, 1, 4, 5, 3, 7, 8, 6 };
        int[] result = findMissingAndRepeating(arr, 9);

        System.out.println(result[0] + " " + result[1]);
    }
}
