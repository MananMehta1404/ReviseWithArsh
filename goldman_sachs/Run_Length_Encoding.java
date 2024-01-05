package goldman_sachs;

public class Run_Length_Encoding {
    private static String encode(String str)
	{
          //Your code here
          int n = str.length();
          
          String result = "";
          for(int i = 0; i < n; i++) {
              char ch = str.charAt(i);
              result += ch;
              int cnt = 1;
              while(i < n -1 && str.charAt(i + 1) == ch) {
                  cnt++;
                  i++;
              }
              result += cnt;
          }
          
          return result;
	}

    public static void main(String[] args) {
        String str = "aaaabbbccc";
        System.out.println(encode(str));
    }
}
