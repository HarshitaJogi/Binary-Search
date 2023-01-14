import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MedianOfSortedArray{

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

        int [][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int positionofMed = (n*m + 1)/2;
        int low = 1;
        int high = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low + (high - low)/2;
            int count = 0;

            for(int i=0; i<n; i++){
                int l = 0;
                int h = m-1;
                while(l<=h){
                    int mi = l + (h-l)/2;
                    if(arr[i][mi]>mid){
                        h = mi-1;
                    }
                    else{
                        l = mi+1;
                    }
                }
                count = count + l;
            }

            if(count>positionofMed){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        System.out.println(low);

	}
}