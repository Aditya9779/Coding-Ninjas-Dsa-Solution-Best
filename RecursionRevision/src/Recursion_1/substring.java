package Recursion_1;

public class substring {
    public static String[] substringA(String str) {
        if (str.isEmpty()) {
            return new String[0];
        }
        String[] smallans = substringA(str.substring(1));
        String[] asn = new String[2 * smallans.length];
        int index = 0;
        for (String visit : smallans) {
            asn[index] = visit;
            index++;
        }
        for (int i = 0; i < smallans.length; i++) {
            asn[index++] = str.charAt(0) + smallans[i];
        }
        return asn;


    }

    public static void main(String[] args) {
        String str="xyz";
        String []ans=substringA(str);
        for (int i = 0; i < ans.length ; i++) {
            System.out.println(ans[i]);
        }
    }
}
