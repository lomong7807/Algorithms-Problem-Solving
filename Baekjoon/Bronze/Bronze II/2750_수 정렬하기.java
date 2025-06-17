import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 수 정렬하기
 *  - 번호 : 2750
 *  - 링크 : https://www.acmicpc.net/problem/2750
 * 2. 풀이핵심
 *  - 1000개의 수 정렬하기
 * 3. 풀이후기
 *  - Java에서 지원하는 배열의 sort 함수를 사용해도 되지만, 선택 정렬으로 구현해봄.
 *  - 선택정렬: 정렬된 영역의 가장 우측 값으로 정렬되지 않은 영역의 좌측부터 끝까지 전체 탐색.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        selectionSort(arr);
        
        for(int m : arr) {
            sb.append(m).append("\n");
        }
        
        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }
    
    public static void selectionSort(int[] arr) {
        
        for(int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}