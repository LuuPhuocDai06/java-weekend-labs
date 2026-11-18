import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // Viết hàm static String[] parseCsvLine(String line) tách dòng theo dấu phẩy,
    // bỏ khoảng trắng thừa đầu và cuối mỗi trường, và giữ lại cả các trường rỗng ở cuối.
    public static List<String> parseCsvLine(String line){
        List<String> hop = new ArrayList<>();
        StringBuilder coc = new StringBuilder();

        for (int i = 0; i < line.length(); i++){
            char text = line.charAt(i);

            if (text == ','){
                hop.add(coc.toString().trim());
                coc.setLength(0);
            }
            else {
                coc.append(text);
            }
        }
        hop.add(coc.toString().trim());
        return hop;
    }

    // Viết hàm static boolean isPalindrome(String s) kiểm tra chuỗi đối xứng,
    // không phân biệt hoa thường và bỏ qua khoảng trắng.
    public static boolean isPalindrome(String s){
        String text = s.replaceAll("\\s+", "").trim();
        StringBuilder sbd = new StringBuilder(text);
        if (sbd.reverse().toString().equalsIgnoreCase(text)){
            return true;
        }
        return false;
    }

    // hàm check.
    public static void check(String ten, Object thucTe, Object mongMuon){
        System.out.println((thucTe.equals(mongMuon)) ? "PASS: "+ten : "FAIL: "+ten+" - mong muốn: "+mongMuon+" - thực tế: "+thucTe);
    }

    // hàm main.
    public static void main(String[] args){

        check("Ghi thừa dấu cách", parseCsvLine("an    , 20,    HCM"), Arrays.asList("an", "20", "HCM"));
        check("In ra 4 phần tử", parseCsvLine("a, b,  ,  "), Arrays.asList("a", "b", "", ""));
        check("In ra 5 phần tử", parseCsvLine(",a,b,,"), Arrays.asList("", "a", "b", "", ""));
        check("Danh sách rỗng", parseCsvLine(""), Arrays.asList(""));

        check("Chuỗi có chứa in hoa", isPalindrome("Madam"), true);
        check("Không tính khoảng trắng", isPalindrome("A man a plan a canal Panama"), true);
        check("Chuỗi sai", isPalindrome("Java"), false);
        check("Chuỗi rỗng", isPalindrome(""), true);
        check("Chuỗi chứa space", isPalindrome("   "), true);
        check("Chuỗi Chứa in hoa và space", isPalindrome("Never odd or even"), true);
        check("Chuỗi sai", isPalindrome("A man, a plan"), false);
    }
}