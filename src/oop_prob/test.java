class HAHA
{
    private int x;
    public HAHA(int x)
    {
        this.x = x;
    }
    public int solve(int a)
    {
        this.x *= a;
        System.out.println(this.x);
    }
    public int solve()
    {
        return this.x*10;
    }
}

public class test
{
    public static void main(String[] args) 
    {
        HAHA h = new HAHA(5);
        h.solve(100);
        System.out.println(h.solve());
    }
}