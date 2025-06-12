import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 아스키 코드
 *  - 번호 : 11654
 *  - 링크 : https://www.acmicpc.net/problem/11654
 * 2. 풀이핵심
 *  - char를 ASCII code로 변환
 *  - 조건에 맞춰 구현
 * 3. 풀이후기
 *  - char를 아스키 코드로 변환하는 방법은 여러가지 있지만, 여기선 그냥 int로 형변환 처리
 *  - 그 외 
 *  - char - '0': char에 아스키 코드값 0 을 빼서 해당 char의 아스키코드값 추출
 *  - Character.getNumericValue(char);
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print((int)br.readLine().charAt(0));
    }
}