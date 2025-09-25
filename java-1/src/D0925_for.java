public class D0925_for {
    public static void main(String[] args) {
        int i =0, sum = 0, max = 0;
        max = 10;
        for(i = 1;i <= max; i++) {
            sum += i;
            System.out.print(i);
            if(i <= max-1) {
                System.out.print(" + ");
            } 
            else {
                System.out.print(" = " + sum);
            }
        }
    }
}
