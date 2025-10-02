public class D0925_DoWhile {
    public static void main(String[] args) {
        char startChar = 'a';

        do {
            System.out.print(startChar + " ");
            startChar++;
        }while(startChar <= 'z');
    }
}
