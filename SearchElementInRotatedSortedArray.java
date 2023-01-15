import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SearchElementInRotatedSortedArray{

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
        int target = sc.nextInt();

        int [] arr = new int [n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int low = 0;
        int high = arr.length-1 ; 
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if( arr[mid] == target){
                ans = mid;
                break;
            }

            // to check if left half sorted or not
            else if(arr[low] <= arr[mid]){

                // to check if element lies in left half or not
                if( target >= arr[low] && target <= arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

            // right half is sorted
            else{

                // to check if element lies in right half or not
                if( target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }



        }

        System.out.println(ans);


	}
}