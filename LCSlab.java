
package LCS;

public class LCSlab {

    public static void main(String[] args) {
        String y = "ABEJ";
        String x = "AJBCE";
        int m = x.length();
        int n = y.length();
        int c[][] = new int[m + 1][n + 1];
        int b[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }

            }

        }
        System.out.println("Length of the Longest Common Subsequence : " + c[m][n]);
        char a[] = new char[c[m][n]];
        int s = c[m][n] - 1;
        int i = m;
        int j = n;
        while (b[i][j] != 0) {
            if (b[i][j] == 1) {
                a[s] = x.charAt(i - 1);
                i = i - 1;
                j = j - 1;
                s = s - 1;

            } else if (b[i][j] == 2) {
                i = i - 1;
            } else if (b[i][j] == 3) {
                j = j - 1;
            }
        }
        System.out.print("Longest Common Subsequence : ");
        for (int l = 0; l < a.length; l++) {
            System.out.print(a[l]);
        }
        System.out.println();
    }
}
