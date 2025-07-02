import java.io.*;
import java.util.*;
/*
 * 문제: 팰린드롬(앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열)
        단, 알파벳만 가지고 검사, 대소문자를 구분하지 않음.
        즉, 알파벳 이외의 문자들 무시
 * 입력: 문자열
 * 출력: "YES", "NO"
 * 풀이후기:
 *  - 이전에 풀었던 01-07_회문 문자열에서 조건이 조금 추가된 문제였음.
 * */

public class Main {

    public static String solution(String s) {
        char[] arr = s.toCharArray();
        int lt = 0;
        int rt = arr.length - 1;

        while(lt < rt) {
            if(!Character.isAlphabetic(arr[lt])) {
                lt++;
            }else if(!Character.isAlphabetic(arr[rt])) {
                rt--;
            }else if(arr[lt] == arr[rt]) {
                lt++;
                rt--;
            }else {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(solution(str.toUpperCase()));
    }
}