import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 영화감독 숌
 *  - 번호 : 1436
 *  - 링크 : https://www.acmicpc.net/problem/1436
 * 2. 풀이핵심
 *  - 브루트포스 알고리즘
 * 3. 풀이후기
 *  - 666이 포함된 숫자일때마다 count를 증가시켜서 시리즈를 찾아냄
 *  - 문제가 이해가 가지 않아서 조건을 찾아봤다...
 *  - 그리고 다른 풀이 방식도 많았는데, 다 너무 보기 불편한 방식으로 구현이 돼있었음
 *  - 성능 차이가 좀 나긴 하는데, 현재 조건에 문제 없이 돌아가고 코드의 복잡도가 너무나도 심해 그냥 브루트포스로 구현
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int num = 666;
        int count = 1;
        
        while(count != N) {
            num++;
            
            if(String.valueOf(num).contains("666")) {
                count++;
            }
        }
        
        System.out.print(num);
    }
}