package Recursion_1;

public class Main {
    public static String[] substringA(String str) {
        if (str.isEmpty()) {
            return new String[]{""};
        }
        String[] smallans = substringA(str.substring(1));
        String[] fin = new String[2 * smallans.length];
        int index = 0;
        for (String visit : smallans) {
            fin[index++] = visit;
            
        }
        for (String visit : smallans) {
            fin[index++] = str.charAt(0) + visit;
        }
        return fin;


    }
 public static  void PrintSubsequence(String str){
String outputPrint="";


        PrintSubsequence(str,outputPrint);
 }

    private static void PrintSubsequence(String str, String outputPrint) {
        if(str.length()==0){
            System.out.println(outputPrint);
            return;
        }
        PrintSubsequence(str.substring(1),outputPrint);
        PrintSubsequence(str.substring(1),str.charAt(0)+outputPrint);
    }


    public static void main(String[] args) {
        String str="xyz";
//        String []ans=substringA(str);
//        for (String an : ans) {
//            System.out.println(an);
//        }
PrintSubsequence(str);
    }
}
