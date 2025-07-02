import java.io.*;
import java.util.*;
/*
 * 문제: 문자열을 입력받아 뒤집어서 출력.
        단, 특수문자는 자기 자리에 그대로 있음.
 * 입력: 문자열
 * 출력: 문자열만 뒤집힌 문자열
 * 풀이후기:
 *  - 문제가 좀 모호했는데, 결국 이것도 내가 이해를 좀 잘 못해서 그런거 같다. 문제를 꼼꼼히 읽자.
 *  - 처음에는 while문 내부에서 lt와 rt를 증감하는 while문을 또 돌렸는데
 *    그것보단 그냥 조건문으로 하나의 while문에서 돌게끔 하는게 더 가독성이 좋은거 같다.
 *  - 그리고 알파벳인지 체크하는 Character.isAlphabetic()함수가 있는지 몰라서 구현했는데, 있더라
 * */

public class Main {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int lt = 0;
        int rt = arr.length - 1;

        while(lt < rt) {
            if(!Character.isAlphabetic(arr[lt])) {
                lt++;
            }else if(!Character.isAlphabetic(arr[rt])) {
                rt--;
            }else {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(arr);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.print(solution(s));
    }
}