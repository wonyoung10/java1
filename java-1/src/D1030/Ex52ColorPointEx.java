package D1030;

public class Ex52ColorPointEx {
    public static void main(String[] args) {
        ColorPoint2 cp = new ColorPoint2(5,6, "blue");
        cp.showColorPoint();
    }
    static class Point2 {
        private int x,y;
        
        public Point2() {
            this.x = this.y= 0;
        }
        public Point2(int x, int y) {
            this.x= x;
            this.y = y;
        }
        public void set(int x,int y) {
            this.x = x;
            this.y = y;
        }
        public void showPoint() {
            System.out.println("("+x+","+y+")");
        }
    }
    
    static class ColorPoint2 extends Point2 {
        private String color;

        public ColorPoint2(int x,int y, String color) {
            super(x,y); // Point 의 생성자 Point(x,y) 호출
            this.color = color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public void showColorPoint() {
            System.out.println(color);
            showPoint();
        }
    }
    
}
