import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : Hashing
 *  - 번호 : 15829
 *  - 링크 : https://www.acmicpc.net/problem/15829
 * 2. 풀이핵심
 *  - Hashing
 *  - 정수 범위
 * 3. 풀이후기
 *  - 해당 문제에서는 최대 31의 50제곱의 수가 나올 수 있는데, 해당 정수는 long의 범위를 벗어난다.
 *  - 그래서 BigInteger를 사용하는 방법이 있고, 문제에 나와있는 1234567891을 활용한 방법이 있다.
 *  - 1234567891은 소수이고, 알파벳의 자리수에 따라 제곱하는 수가 다르므로 해시충돌 없이 long 범위의 수를 추출할 수 있다.
 *  - 문제에서는 정확한 수의 추출이 아닌 해시 함수를 통한 값의 추출을 원하고 있으므로 1234567891을 나눴을 때 나머지 값을 구하면 된다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        long sum = 0;
        long pow = 1;
        
        for(int i = 0; i < L; i++) {
            sum += ((int)str.charAt(i) - 96) * pow;
            pow = (pow * 31) % 1234567891;
        }
        
        System.out.print(sum % 1234567891);
    }
}