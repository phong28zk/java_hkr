import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("all")

class Song {
    String name, author;
	int duration;

	Song(String name, String author, int duration) {
		this.name = name;
		this.author = author;
		this.duration = duration;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Song compareLine = (Song) obj;
		return name.equals(compareLine.name) && author.equals(compareLine.author) && duration == compareLine.duration;
    }

}

public class object_ref001
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			String a = sc.nextLine();
			String b = sc.nextLine();

			// Split string a and b to 3 parts: name, author and duration
			String[] aParts = a.split(" ");
			String[] bParts = b.split(" ");

			// Create 2 Song objects
			Song songA = new Song(aParts[0], aParts[1], Integer.parseInt(aParts[2]));
			Song songB = new Song(bParts[0], bParts[1], Integer.parseInt(bParts[2]));

			// Compare 2 Song objects
			System.out.println(songA.equals(songB));
			

		}


    }
} 
