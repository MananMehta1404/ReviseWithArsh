package goldman_sachs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Random_Flip_Matrix {

    static Hashtable<Integer, List<Integer>> ht;
    static int rows, cols;

    public Random_Flip_Matrix(int m, int n) {
        rows = m;
        cols = n;
        ht = new Hashtable<>();
    }
    
    public int[] flip() {
        while(true) {
            Random rd = new Random();
            int rand_row = rd.nextInt(rows - 0) + 0;
            int rand_col = rd.nextInt(cols - 0) + 0;

            if(ht.containsKey(rand_row)) {
                if(!ht.get(rand_row).contains(rand_col)) {
                    List<Integer> temp = ht.get(rand_row);
                    temp.add(rand_col);
                    ht.put(rand_row, temp);

                    int[] result = {rand_row, rand_col};
                    return result;
                }
            }
            else {
                List<Integer> l1 = new ArrayList<>();
                l1.add(rand_col);
                ht.put(rand_row, l1);

                int[] result = {rand_row, rand_col};
                return result;
            }
        }
    }
    
    public void reset() {
        ht = new Hashtable<>();
    }

    public static void main(String[] args) {
        Random_Flip_Matrix rm = new Random_Flip_Matrix(3, 2);
        int[] result1 = rm.flip();
        int[] result2 = rm.flip();
        int[] result3 = rm.flip();
        rm.reset();
        int[] result4 = rm.flip();
        int[] result5 = rm.flip();

        System.out.println(result1[0] + " " + result1[1]);
        System.out.println(result2[0] + " " + result2[1]);
        System.out.println(result3[0] + " " + result3[1]);
        System.out.println(result4[0] + " " + result4[1]);
        System.out.println(result5[0] + " " + result5[1]);
    }
}
