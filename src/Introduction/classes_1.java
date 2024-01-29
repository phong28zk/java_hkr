class Normal { 
    private String msg;
    private String poly;

    // constructor
    /**
     * @param msg
     * @param poly
     */

    public Normal(String msg, String poly) {
        this.msg = msg;
        this.poly = poly;
    }
}

public class classes_1 {
    public static void main(String[] args) {
        Normal normal = new Normal("Hello", "World");
        System.out.println(normal);

        Normal normal2 = new Normal("Hello", "World");
        System.out.println(normal2);
    }

}