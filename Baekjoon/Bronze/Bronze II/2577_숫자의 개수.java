import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 숫자의 개수
 *  - 번호 : 2577
 *  - 링크 : https://www.acmicpc.net/problem/2577
 * 2. 풀이핵심
 *  - 연산 후 결과의 숫자 개수 세기
 * 3. 풀이후기
 *  - 10자리의 배열 생성 후 배열의 index를 0~9까지의 숫자라고 생각하고 1씩 더하면 됨
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] arr = new int[10];
        String str = String.valueOf(
                            Integer.parseInt(br.readLine()) 
                            * Integer.parseInt(br.readLine()) 
                            * Integer.parseInt(br.readLine())
                                        );
        
        for(int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i)-'0';
            arr[temp] += 1;
        }
        
        for(int n : arr) {
            sb.append(n).append("\n");
        }
        
        System.out.print(sb);
    }
}