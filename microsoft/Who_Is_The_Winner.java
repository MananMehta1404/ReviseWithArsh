package microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class Who_Is_The_Winner {
    private static int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) q.add(i);

        int count = 0;
        while(q.size() > 1) {
            int val = q.poll();
            count++;
            if(count == k) {
                count = 0;
            }
            else q.add(val);
        }

        return q.poll();
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(findTheWinner(n, k));
    }
}
