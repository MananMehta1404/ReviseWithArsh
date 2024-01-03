package goldman_sachs;

public class Find_Consec_Int_DataStream {
    int value, k, count;

    public Find_Consec_Int_DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.count = 0;
    }
    
    public boolean consec(int num) {
        if(num == value) count++;
        else count = 0;
        if(count >= k) return true;
        else return false;
    }

    public static void main(String[] args) {
        Find_Consec_Int_DataStream obj = new Find_Consec_Int_DataStream(4, 3);
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(3));
    }
}
