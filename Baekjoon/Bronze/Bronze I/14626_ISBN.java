import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : ISBN
 *  - 번호 : 14626
 *  - 링크 : https://www.acmicpc.net/problem/14626
 * 2. 풀이핵심
 *  - 브루트 포스 알고리즘
 * 3. 풀이후기
 *  - 문제를 읽어도 조건을 제대로 이해 못해서 한참을 해맸다.
 *  - 처음 조건대로 코드를 쭉 만들어봤는데, 코드의 길이가 엄청나게 길었다.
 *  - 이걸 리팩토링하니까 코드의 길이가 절반이 됨.
 *  - 구현이 됐다면 리팩토링을 잘해보자.
 *  - 그리고 문제의 조건을 꼼꼼하게 읽어서 정확하게 이해해보자.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int m = s.charAt(s.length() - 1) - '0';

        int sum = 0;
        int errMultiple = 0;

        for(int i = 0; i < 12; i++) {
            int multiple = i % 2 == 0 ? 1 : 3;
            if(s.charAt(i) == '*') {
                errMultiple = multiple;
            }else {
                sum += (s.charAt(i) - '0') * multiple;
            }
        }

        for(int i = 0; i < 10; i++) {
            if((sum + errMultiple * i + m) % 10 == 0) {
                System.out.print(i);
                break;
            }
        }
    }
}