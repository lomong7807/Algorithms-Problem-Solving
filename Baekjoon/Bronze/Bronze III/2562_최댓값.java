import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 최댓값
 *  - 번호 : 2562
 *  - 링크 : https://www.acmicpc.net/problem/2562
 * 2. 풀이핵심
 *  - 최댓값 구하기
 * 3. 풀이후기
 *  - Arrays.copyOf(arr)를 사용해 기존 배열 복사
 *  - Arrays.sort(arr)를 사용해 정렬
 *  - Arrays.sort()는 해당 배열을 정렬해주는거라 순서를 찾기 위해선 기존 배열을 복사해서 정렬해야 한다.
 *  - 참고로 역순으로 정렬하려면 Collections.reverseOrder() 사용
 *  - 역정렬: Arrays.sort(arr, Collections.reverseOrder())
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] arr = new int[9];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[] sortArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortArr);
        int max = sortArr[arr.length - 1];
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == max) {
                sb.append(max).append("\n").append(i + 1);
                break;
            }
        }
        
        System.out.print(sb);
    }
}