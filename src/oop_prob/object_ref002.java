import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("all")

class SimpleDate {
    int day, month, year;

    SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SimpleDate compareDay = (SimpleDate) obj;
        return day == compareDay.day && month == compareDay.month && year == compareDay.year;
    }

}

public class object_ref002
{
	public static void main(String[] args) 
	{
		SimpleDate d = new SimpleDate(1, 2, 2020);
        System.out.println(d.equals("heh"));
        System.out.println(d.equals(new SimpleDate(5, 2, 2012)));
        System.out.println(d.equals(new SimpleDate(1, 2, 2020)));


    }
} 
