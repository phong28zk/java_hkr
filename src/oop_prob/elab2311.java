import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class A{
    public int x=0x1a;
    public void display(){
        System.out.println(x);
    }
}
class B extends A{
    public int x=0x1b;
}

public class elab2311{
    public static void main(String[] args){
        
	A b = new B();
        b.display();
    }
} 
