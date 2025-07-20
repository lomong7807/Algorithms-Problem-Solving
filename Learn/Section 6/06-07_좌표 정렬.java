import java.io.*;
import java.util.*;
/*
 * 문제: N개의 평면상의 좌표 (x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램
        정렬기준은 먼저 x값에 의해서 정렬하고, x값이 같을 경우 y 값에 의해 정렬한다.
 * 입력: 첫 줄에 좌표의 개수인 N(3<=N<=100,000)
        두 번째 줄부터 N개의 좌표가 x, y 순으로 주어진다. x, y값은 양수만 입력된다.
 * 출력: N개의 좌표를 정렬하여 모두 출력
 * 풀이후기:
 *  - Comparable<> 인터페이스를 상속받아서 구현하면 되는 문제
 *  - 정렬을 할 때 기준이 있다면 해당 기준을 객체에 구현하면 된다.
 *  - Comparator로 내부 객체를 만들어서 해도 되지만, 해당 문제와 보통 코드의 가시성을 위해 객체에 Comparable을 상속받아 구현
 *  - 구현하는 방법도 그렇게 어렵지 않다.
 * */

class Point implements Comparable<Point> {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if(this.x == p.x) {
            return this.y - p.y;
        }else {
            return this.x- p.x;
        }
    }
}

public class Main {

    public static String solution(List<Point> list) {
        StringBuilder sb = new StringBuilder();

        Collections.sort(list);
        for(Point p : list) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }

        System.out.print(solution(list));
    }
}

// class Point {
//     int x;
//     int y;
//     public Point(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }

// public class Main {

//     public static String solution(List<Point> list) {
//         StringBuilder sb = new StringBuilder();

//         Collections.sort(list, comp);
//         for(Point p : list) {
//             sb.append(p.x).append(" ").append(p.y).append("\n");
//         }

//         return sb.toString();
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         List<Point> list = new ArrayList<>();

//         for(int i = 0; i < n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int x = Integer.parseInt(st.nextToken());
//             int y = Integer.parseInt(st.nextToken());
//             list.add(new Point(x, y));
//         }

//         System.out.print(solution(list));
//     }

//     public static Comparator<Point> comp = new Comparator<Point>() {
//         @Override
//         public int compare(Point o1, Point o2) {
//             if(o1.x == o2.x) {
//                 return o1.y - o2.y;
//             }else {
//                 return o1.x - o2.x;
//             }
//         }
//     };
// }