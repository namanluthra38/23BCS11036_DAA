public class RabinKarp {
    public static final int d = 256;

    public static void RabinKarpSearch(String text, String pattern, int q) {
        int n = text.length();
        int m = pattern.length();
        if (n < m) return;
        int p = 0, t = 0, h = 1;
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0)
                    t = t + q;
            }
        }
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String text, pattern;
        int q;
        System.out.print("Enter the text: ");
        text = sc.nextLine();
        System.out.print("Enter the pattern: ");
        pattern = sc.nextLine();
        System.out.print("Enter a prime number for hashing: ");
        q = sc.nextInt();
        RabinKarpSearch(text, pattern, q);
        sc.close();
    }
}
