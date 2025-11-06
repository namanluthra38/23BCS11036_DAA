import java.util.*;

public class SubsetSum {

static int[][] dp = new int[1001][1001];

static boolean subsetSum(int index, int[] arr, int target) {

    if (target == 0) return true;
    if (index == 0) return (arr[0] == target);

    if (dp[index][target] != -1) return dp[index][target] == 1;

    boolean notPick = subsetSum(index - 1, arr, target);

    boolean pick = false;
    if (arr[index] <= target)
        pick = subsetSum(index - 1, arr, target - arr[index]);

    dp[index][target] = (pick || notPick) ? 1 : 0;
    return pick || notPick;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of elements: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.print("Enter elements: ");
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }

    System.out.print("Enter target sum: ");
    int target = sc.nextInt();

    for (int i = 0; i < 1001; i++) {
        Arrays.fill(dp[i], -1);
    }

    if (subsetSum(n - 1, arr, target))
        System.out.println("YES, subset with sum " + target + " exists.");
    else
        System.out.println("NO, subset with sum " + target + " does not exist.");

    sc.close();
}

}
