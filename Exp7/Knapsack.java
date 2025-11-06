import java.util.*;

public class Knapsack {
    static int[][] dp;

    static int knapsack(int index, int W, int[] w, int[] v) {
        if (index < 0 || W == 0) return 0;
        if (dp[index][W] != -1) return dp[index][W];

        int notPick = knapsack(index - 1, W, w, v);
        int pick = 0;
        if (w[index] <= W)
            pick = v[index] + knapsack(index - 1, W - w[index], w, v);

        dp[index][W] = Math.max(pick, notPick);
        return dp[index][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] w = new int[n];
        int[] v = new int[n];
        System.out.print("Enter weights: ");
        for (int i = 0; i < n; i++) w[i] = sc.nextInt();
        System.out.print("Enter profits: ");
        for (int i = 0; i < n; i++) v[i] = sc.nextInt();

        System.out.print("Enter maximum capacity of knapsack: ");
        int W = sc.nextInt();

        dp = new int[n][W + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        int maxProfit = knapsack(n - 1, W, w, v);

        System.out.println("Maximum Profit = " + maxProfit);

        ArrayList<Integer> itemsPicked = new ArrayList<>();
        int remainingW = W;
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                if (dp[i][remainingW] > 0) itemsPicked.add(i + 1);
                break;
            }
            if (dp[i][remainingW] != dp[i - 1][remainingW]) {
                itemsPicked.add(i + 1);
                remainingW -= w[i];
            }
        }

        System.out.print("Items picked (1-based index): ");
        Collections.reverse(itemsPicked);
        for (int id : itemsPicked) System.out.print(id + " ");
        sc.close();
    }
}
