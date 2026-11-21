import java.util.*;
public class youmuKonpakuAndTheDuel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int moves = 0;
            while (true) {
                moves++;
                long maxDamage = 0;
                for (int c = 0; c <= moves; c++) {
                    int attacks = moves - c;
                    long dmg = 0;
                    int stacks = c;
                    int power = 1 + c;

                    for (int a = 0; a < attacks; a++) {
                        dmg += power;
                        if (stacks > 0) {
                            stacks--;
                            power--;
                        }
                    }

                    if (dmg > maxDamage) {
                        maxDamage = dmg;
                    }
                }

                if (maxDamage >= x) {
                    System.out.println(moves);
                    break;
                }
            }
        }
    }
}