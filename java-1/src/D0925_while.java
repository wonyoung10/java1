import java.util.Scanner;

public class D0925_while {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0, sum = 0 ,n=0;
        System.out.println("정수를 입력하고 마지막에 0을 입력하세요 : ");
        while((n = sc.nextInt()) != 0) {
            count++;
            sum += n;
        }
        System.out.println("입력한 정수의 개수: " + count);
        System.out.println("입력한 정수의 합: " + sum);
        System.out.println("입력한 정수의 평균: " + sum/count);
        sc.close();
        
    }   
}
