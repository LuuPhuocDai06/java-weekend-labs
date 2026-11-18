import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // hàm đếm số từ.
    static int countWords(String text){
        if (text.trim().isEmpty()) return 0;
        return text.trim().split("\\s+").length;
    }

    // hàm đảo chuỗi.
    static String reverse(String text){
        StringBuilder sbd = new StringBuilder(text);
        return sbd.reverse().toString();
    }

    // hàm palindrome.
    static boolean palindrome(String text){
        StringBuilder sbd = new StringBuilder(text);
        if (sbd.reverse().toString().equalsIgnoreCase(text)){
            return true;
        }
        return false;
    }

    // hàm sắp xếp chuỗi.
    static String sortText(String text){
        char[] c = text.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    // hàm anagram.
    static boolean anagram(String text1, String text2){
        if (text1.length() != text2.length()) return false;
        if (sortText(text1).equalsIgnoreCase(sortText(text2))){
            return true;
        }
        return false;
    }


    // hàm parse.
    static List<String> parse(String text){
        List<String> hop = new ArrayList<>();
        StringBuilder coc = new StringBuilder();

        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);

            if (c == ','){
                hop.add(coc.toString().trim());
                coc.setLength(0);
            }
            else {
                coc.append(c);
            }
        }
        hop.add(coc.toString().trim());

        return hop;
    }

    // hàm check hợp lệ.
    static void check(String input, Object desire, Object result){
        System.out.println((desire.equals(result)) ? "PASS: "+input : "FAIL: "+input+" mong muốn: "+desire+" - kết quả: "+result);
    }

    // hàm main.
    public static void main(String[] args){
        String text1 = "Xin chào đây là năm 2026";
        System.out.println("số từ :"+countWords(text1));
        System.out.println("chuỗi sau khi đảo ngược: "+reverse(text1));

        String text2 = "tat";
        String text3 = "tta";
        String text4 = "cho";
        System.out.println("Palindrome: "+palindrome(text2));
        System.out.println("Palindrome: "+palindrome(text3));
        System.out.println("Kiểm tra anagram: "+anagram(text2, text3));
        System.out.println("Kiểm tra anagram: "+anagram(text4, text3));

        // check kết quả.
        System.out.println("\nKiểm tra tính hợp lệ.");
        check("đếm từ 'a b c'",        countWords("a b c"), 3);
        check("đếm từ nhiều khoảng trắng", countWords("  a   b  "), 2);
        check("đếm từ chỉ chứa dấu space: ",           countWords("   "), 0);
        check("đếm từ rỗng",           countWords(""), 0);
        check("đảo 'abc'",             reverse("abc"), "cba");
        check("đảo rỗng",              reverse(""), "");
        check("palindrome madam",      palindrome("madam"), true);
        check("palindrome abca",       palindrome("abca"), false);
        check("anagram listen/silent", anagram("listen", "silent"), true);
        check("anagram khác độ dài",   anagram("aab", "ab"), false);
        check("anagram hai chuỗi rỗng", anagram("", ""), true);
        check("parse a,b,c",           parse("a,b,c"), Arrays.asList("a", "b", "c"));
        check("parse a,b, (ô cuối trống)", parse("a,b,"), Arrays.asList("a", "b", ""));
        check("parse rỗng",            parse(""), Arrays.asList(""));


    }
}