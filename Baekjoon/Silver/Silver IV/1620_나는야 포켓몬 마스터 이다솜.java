import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 나는야 포켓몬 마스터 이다솜
 *  - 번호 : 1620
 *  - 링크 : https://www.acmicpc.net/problem/1620
 * 2. 풀이핵심
 *  - 집합
 *  - 맵
 * 3. 풀이후기
 *  - 입력이 문자일수도, 숫자일수도 있는 문제
 *  - n과 m 모두 범위가 1 <= n,m <= 100,000
 *  - 배열만 사용했을 때 최악의 경우 100,000 * 100,000 = 10,000,000,000 으로 무조건 시간 초과가 난다.
 *  - 그래서 Map도 같이 사용해서 입력이 문자일때는 map으로 빠르게 찾고
 *  - 입력이 숫자일때는 배열에서 바로 위치를 선택해 찾아 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[n + 1];

        for(int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            map.put(tmp, i);
            arr[i] = tmp;
        }

        for(int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if(!Character.isDigit(tmp.charAt(0))) {
                sb.append(map.get(tmp));
            }else {
                sb.append(arr[Integer.parseInt(tmp)]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}