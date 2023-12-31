package goldman_sachs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

class Employee_Priority_System {

    private static boolean isHighAccess(List<String> times) {
        if(times.size() < 3) return false;

        Collections.sort(times);
        int n = times.size();
        for(int i = 0; i < n - 2; i++) {
            String time1 = times.get(i);
            int hr1 = Integer.parseInt(time1.substring(0, 2));
            int min1 = Integer.parseInt(time1.substring(2, 4));
            int totmin1 = (hr1 * 60) + min1;

            String time2 = times.get(i + 2);
            int hr2 = Integer.parseInt(time2.substring(0, 2));
            int min2 = Integer.parseInt(time2.substring(2, 4));
            int totmin2 = (hr2 * 60) + min2;

            if(totmin2 - totmin1 < 60) return true;
        }

        return false;
    }

    private static List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> ans = new ArrayList<>();

        int n = access_times.size();
        Hashtable<String, List<String>> ht = new Hashtable<>();
        for(int i = 0; i < n; i++) {
            String name = access_times.get(i).get(0);
            String time = access_times.get(i).get(1);

            if(ht.containsKey(name)) {
                List<String> temp = ht.get(name);
                temp.add(time);
                ht.put(name, temp);
            }
            else {
                List<String> times = new ArrayList<>();
                times.add(time);
                ht.put(name, times);
            }
        }

        for(String key: ht.keySet()) {
            List<String> times = ht.get(key);
            if(isHighAccess(times)) ans.add(key);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[][] arr = {{"a","0549"}, {"b","0457"}, {"a","0532"}, {"a","0621"}, {"b","0540"}};

        List<List<String>> access_times = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            List<String> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            access_times.add(temp);
        }

        List<String> ans = findHighAccessEmployees(access_times);  
        System.out.println(ans);
    }
}