import java.util.Scanner;

public class B_MonacarpAndProjects_2260 {
    private static long sumOfNumbers(long start, long end) {
        if (start > end) return 0;
        long count = end - start + 1;
        return (start + end) * count / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long k = sc.nextLong();

            long extraProjects = b - a;
            if (extraProjects == 0) {
                System.out.println(0);
                continue;
            }
            long startEmployees = a;
            long endEmployees = a + k - 1;
            long totalProjectsDoneByMonocarp = 0;

            long maxEmployeesInGroup = Math.min(endEmployees, extraProjects);
            long currentEmployees = startEmployees;

            while (currentEmployees <= maxEmployeesInGroup) {
                long quotient = extraProjects / currentEmployees;
                long lastEmployeeInGroup = extraProjects / quotient;
                long groupEnd = Math.min(maxEmployeesInGroup, lastEmployeeInGroup);

                long monthsInThisGroup = groupEnd - currentEmployees + 1;
                long employeeSum = sumOfNumbers(currentEmployees, groupEnd);
                totalProjectsDoneByMonocarp += (monthsInThisGroup * extraProjects) - (quotient * employeeSum);
                currentEmployees = groupEnd + 1;
            }
            if (endEmployees > extraProjects) {
                long firstMonthAbove = Math.max(startEmployees, extraProjects + 1);
                long remainingMonths = endEmployees - firstMonthAbove + 1;
                totalProjectsDoneByMonocarp += remainingMonths * extraProjects;
            }
            System.out.println(totalProjectsDoneByMonocarp);
        }
    }
}