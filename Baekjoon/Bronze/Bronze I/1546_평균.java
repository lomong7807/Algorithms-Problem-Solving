import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 평균
 *  - 번호 : 1546
 *  - 링크 : https://www.acmicpc.net/problem/1546
 * 2. 풀이핵심
 *  - 소숫점까지 평균 구하기
 * 3. 풀이후기
 *  - 딱히 어려울게 없는 문제인데 왜 브론즈1인지 모르겠음
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double[] arr = new double[N];
        
        for(int i = 0; i < N; i++) {
            double score = Double.parseDouble(st.nextToken());
            
            if(arr[0] < score && arr[0] != score) {
                arr[i] = arr[0];
                arr[0] = score;
            } else {
                arr[i] = score;
            }
        }
        
        double sum = 0;
        
        for(int i = 0; i < N; i++) {
            sum += arr[i] / arr[0] * 100;
        }
        
        System.out.print(sum / (double)N);
    }
}