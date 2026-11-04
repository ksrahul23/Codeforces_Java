import java.util.Scanner;

public class numbersOnTheBoad_2283A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (l > 0) {
                System.out.println(r - l);
            } else if (r < 0) {
                System.out.println(r - l);
            } else {
                System.out.println(Math.max(0, Math.abs(l + r) - 1));
            }
        }
    }
}