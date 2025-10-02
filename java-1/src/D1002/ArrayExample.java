package D1002;

import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int intArray[];
        intArray = new int[5];
        // 선언과 생성을 한줄에 할 수 있다.
        // int intArray[] = new int[5];

        int max = 0; // 현재 가장 큰 수
        System.out.println("양수 5개를 입력하세요.");

        for(int i =0;i<5;i++) {
            intArray[i] = scanner.nextInt(); // 입력 받은 정수를 배열에 저장
            if(intArray[i] > max) max = intArray[i]; // max로 벼경
        }
        System.out.println("가장 큰 수는 " + max + "입니다.");
        scanner.close();
    }
}
