import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        while (testCaseCount-- > 0) {
            int totalDrafts = scanner.nextInt();
            int requiredPosts = scanner.nextInt();

            long[] absurdityRatings = new long[totalDrafts];
            for (int i = 0; i < totalDrafts; i++) {
                absurdityRatings[i] = scanner.nextLong();
            }
            if (requiredPosts == 1) {
                long maxSingleScore = Long.MIN_VALUE;
                for (int i = 0; i < totalDrafts; i++) {
                    maxSingleScore = Math.max(maxSingleScore, absurdityRatings[i]);
                }
                System.out.println(maxSingleScore);
                continue;
            }
            PriorityQueue<Long> smallestPrefixElements = new PriorityQueue<>(Collections.reverseOrder());
            long sumOfSmallestPrefixElements = 0;

            for (int i = 0; i < requiredPosts - 1; i++) {
                smallestPrefixElements.add(absurdityRatings[i]);
                sumOfSmallestPrefixElements += absurdityRatings[i];
            }
            long maximumPillScore = Long.MIN_VALUE;
            for (int lastIndex = requiredPosts - 1; lastIndex < totalDrafts; lastIndex++) {
                long currentLastRating = absurdityRatings[lastIndex];
                long currentScore = (long) requiredPosts * currentLastRating - sumOfSmallestPrefixElements;
                maximumPillScore = Math.max(maximumPillScore, currentScore);
                if (currentLastRating < smallestPrefixElements.peek()) {
                    long largestAmongSmallest = smallestPrefixElements.poll();
                    sumOfSmallestPrefixElements -= largestAmongSmallest;

                    smallestPrefixElements.add(currentLastRating);
                    sumOfSmallestPrefixElements += currentLastRating;
                }
            }
            System.out.println(maximumPillScore);
        }
    }
}