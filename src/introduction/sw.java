
public class sw {
    public static void main(String args[]) {
        int m = 14;
        switch(m) {
            case 1,3,5,7,8,10,12: System.out.println("31"); break;
            case 4,6,9,11: System.out.println("30"); break;
            case 2: System.out.println("28"); break;
            default:
                System.out.println("Looking for month");
                break;
        }
    }
}