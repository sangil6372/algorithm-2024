import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        
        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));
        
        for (int i = 1; i < str.length(); i++) {
            if (result.charAt(0) < str.charAt(i)) {
                result.append(str.charAt(i));
            } else {
                result.insert(0, str.charAt(i));
            }
        }
        
        System.out.println(result.toString());
    }
}