import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 좌표 정렬하기 2
 *  - 번호 : 11651
 *  - 링크 : https://www.acmicpc.net/problem/11651
 * 2. 풀이핵심
 *  - 2차원 배열
 *  - Comparable 커스텀
 * 3. 풀이후기
 *  - 11650_좌표 정렬하기와 다른 내용이 없었으나 이번에는 배열로 구현해봤다.
 *  - Map으로 구현했을 때
 *    메모리: 66950KB
 *    시간: 592ms
 *  - 배열으로 구현했을 때
 *    메모리: 52564KB
 *    시간: 656ms
 *  - 확실히 배열으로 구현한게 오버헤드가 적어 메모리를 덜 쓰는걸 볼 수 있다.
 *  - 그리고 구현도 Map과 비교했을 때 그다지 보기 어렵거나 하지 않음
 * 
 *  - Comparable을 공부하고 바로 구현해봤는데 어렵지 않았다. 예전에는 왜 그렇게 어렵게 느껴졌는지 모르겠다.
 *    근데 성능은 딱히 차이가 없음
 */

// implements Comparable<>
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Point[] arr = new Point[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            sb.append(arr[i].x).append(" ").append(arr[i].y).append("\n");
        }

        System.out.print(sb);
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.y == o.y) {
            return this.x - o.x;
        }else {
            return this.y - this.y;
        }
    }
}

// lambda
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }else {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for(int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        
        System.out.print(sb);
    }
    
}