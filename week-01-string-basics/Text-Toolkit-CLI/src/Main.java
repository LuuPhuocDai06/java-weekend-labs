import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static void check(String ten, Object thucTe, Object mongDoi) {
        if (thucTe.equals(mongDoi)) {
            System.out.println("PASS: " + ten);
        } else {
            System.out.println("FAIL: " + ten + " | mong đợi: " + mongDoi + " | thực tế: " + thucTe);
        }
    }

    public static List<String> parse(String line) {
        List<String> hop = new ArrayList<>();
        StringBuilder coc = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == ',') {
                hop.add(coc.toString());
                coc.setLength(0);
            } else {
                coc.append(c);
            }
        }
        hop.add(coc.toString());
        return hop;
    }

    // Hàm đếm số từ trong chuỗi.
    public static int countWords(String text){
        String t = text.trim();
        if (t.isEmpty()) return 0;
        return t.split("\\s+").length;
    }

    // hàm đảo ngược chuỗi.
    public static String reverseText(String text){
        StringBuilder stb = new StringBuilder(text);
        return stb.reverse().toString();
    }

    // Hàm kiểm tra chuỗi xuôi ngược đều giống nhau.
    public static boolean palindrome(String text){
        StringBuilder stb = new StringBuilder(text);
        if (stb.reverse().toString().equals(text)){
            return true;
        }
        return false;
    }

    // hàm sắp xếp ký tự.
    public static String sortText(String text){
        char[] arr = text.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    // hàm kiểm tra phép đảo chữ vd listen = silent = true.
    public static boolean anagram(String text1, String text2){
        if (text1.length() != text2.length()) return false;
        else if (sortText(text1).equals(sortText(text2))) return true;
        return false;
    }

    // hàm main.
    public static void main(String[] args){
        // Cho chuỗi.
        String s1 = "Order#2024@Shop! okok";
        System.out.println("Ta có chuỗi: "+s1);
        System.out.println("Số từ trong chuỗi là: "+countWords(s1));
        System.out.println("Đảo ngược chuỗi: "+reverseText(s1));

        String s2 = "tất";
        System.out.println("\nKiem tra palindrome của chuỗi s2: "+palindrome(s2));

        // Kiểm tra anagram.
        String s3 = "tinhToan";
        String s4 = "tianTonh";
        System.out.println("\nKiem tra anagram của hai chuỗi "+s3+" và chuỗi "+s4+": "+anagram(s3, s4));


        check("đếm từ 'a b c'",        countWords("a b c"), 3);
        check("đếm từ nhiều khoảng trắng", countWords("  a   b  "), 2);
        check("đếm từ rỗng",           countWords(""), 0);
        check("đảo 'abc'",             reverseText("abc"), "cba");
        check("đảo rỗng",              reverseText(""), "");
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