
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        String[] input;

        input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);
        int k=Integer.parseInt(input[2]);

        int[] reqApartmentSizes=new int[n];
        int[] givenApartmentSizes=new int[m];

        input=br.readLine().split(" ");
        for (int i=0;i<n;i++)
            reqApartmentSizes[i]=Integer.parseInt(input[i]);

        input=br.readLine().split(" ");
        for (int i=0;i<m;i++)
            givenApartmentSizes[i]=Integer.parseInt(input[i]);

        Solution solution=new Solution();
        solution.solve(reqApartmentSizes,givenApartmentSizes,n,m,k,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] reqApartmentSizes,int[] givenApartmentSizes,int n,int m,int k,PrintWriter out) {
        int[][] reqAparmentSizeRanges=new int[n][2];
        int res=0;

        for (int i=0;i<n;i++) {
            reqAparmentSizeRanges[i][0]=reqApartmentSizes[i]-k;
            reqAparmentSizeRanges[i][1]=reqApartmentSizes[i]+k;
        }

        Arrays.sort(givenApartmentSizes);
        Arrays.sort(reqAparmentSizeRanges,(a,b)->(Integer.compare(a[0], b[0])));

        int i=0; //reqApartments
        int j=0; //givenApartments

        while (i<n && j<m) {
            if (givenApartmentSizes[j]>=reqAparmentSizeRanges[i][0] && givenApartmentSizes[j]<=reqAparmentSizeRanges[i][1]) {
                res++;
                i++;
                j++;

                continue;
            }

            if (givenApartmentSizes[j]<reqAparmentSizeRanges[i][0]) {
                j++;
                continue;
            }

            if (givenApartmentSizes[j]>=reqAparmentSizeRanges[i][1]) {
                i++;
            }
        }

        out.println(res);
    }
}