import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KthElementInTwoSortedArrays{

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int ans = -1;

        int [] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }

        int [] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = sc.nextInt();
        }

        int low = 0;
        int high = n;

        while(low<=high){
            int mid = low + (high - low)/2;

            int cut1 = mid;
            int cut2 = k - mid;

            int l1 = arr1[cut1 - 1];
            int l2 = arr2[cut2 - 1];

            int r1 = arr1[cut1];
            int r2 = arr2[cut2];

            if(l1<=r2 && l2<=r1){
                ans = Math.max(l1, l2);
                break;
            }
            else if(l1 > r2){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        System.out.println(ans);


	}
}