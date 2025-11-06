package D1106;

class Point {
    private int x = 0;
    private int y = 0;
    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

public class ObjectPro {
    public static void main(String[] args) {
        Point p = new Point(2,3);    
        System.out.println(p.getClass().getName());
        System.out.println("obj.toString():" + p.toString());
        System.out.println("obj.hashCode" + p.toString());
        System.out.println("obj.hashCod()"+p.hashCode());
    }
    
    
}
