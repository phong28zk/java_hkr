interface A {
    void m();
    void n(String msg);
}
class C implements A {
    public void m(){
        System.out.println("Method m() of C");
    }
    
    public void n(String msg){
        System.out.println("OOP23 " + msg);
    }
}

class D extends C{boolean d=true;}

public class elab2304 {
    public static void main(String[] args) {
            D dev = new D();
            dev.m();
            dev.n("OOP23");
            System.out.println(dev.d);
        }
    }
