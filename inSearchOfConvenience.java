import java.util.Scanner;

public class inSearc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int r = scanner.nextInt();
            int x = x0 + r;
            int y = y0;
            
            System.out.println(x + " " + y);
        }
    }
}