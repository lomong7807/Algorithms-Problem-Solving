import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp < x) {
                sb.append(temp).append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}