import java.util.*;
import java.io.*;

class Main {
  public static long[] Tree; 
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    st = new StringTokenizer(br.readLine()," ");
    int N = Integer.parseInt(st.nextToken());
    long M = Long.parseLong(st.nextToken());
    Tree = new long[N];
    st = new StringTokenizer(br.readLine()," ");
    for(int i=0;i<N;i++){
      Tree[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(Tree);
    System.out.println(cut_tree(Tree[N-1],N,M));
    
  }
  public static long cut_tree(long max, int num,long total){
    long start = 0;
    long end = max; 
    long mid, sum;
    while (start <= end) {
      mid = (start + end) / 2;
      sum = 0;
      for (int i=0;i<num;i++) {
        if (Tree[i] > mid) {
          sum += Tree[i] - mid;
        }
      }

      if (sum >= total) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return end;
  }
  
} 