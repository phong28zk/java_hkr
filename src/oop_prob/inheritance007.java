import java.util.*;

abstract class TestQuestion {
    protected String question;
    protected abstract void readQuestion(Scanner sc);
}

class Essay extends TestQuestion {
    private int blankLines;

    @Override
    protected void readQuestion(Scanner sc) {
        blankLines = Integer.parseInt(sc.nextLine());
        question = sc.nextLine();
    }

    @Override
    public String toString() {
        return blankLines + "\n" + question;
    }
}

class MultiChoice extends TestQuestion {
    private ArrayList<String> choices;
    int numberOfChoices;

    @Override
    protected void readQuestion(Scanner sc) {
        numberOfChoices = Integer.parseInt(sc.nextLine());
        
        question = sc.nextLine();
        choices = new ArrayList<>();
        for (int i = 0; i < numberOfChoices; i++) {
            choices.add(sc.nextLine());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(question).append("\n");
        System.out.println(numberOfChoices);
        for (String choice : choices) {
            sb.append(choice).append(choice.equals(choices.get(choices.size()-1)) ? "" : "\n");
        }
        return sb.toString();
    }
}


public class inheritance007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        int tt = Integer.parseInt(t);
        System.out.println(tt);
        while(tt-->0) {
            String type = sc.nextLine();
            if (type.equals("e")) {
                System.out.println("e");
                Essay essay = new Essay();
                essay.readQuestion(sc);
                System.out.println(essay);
            } else if (type.equals("m")) {
                System.out.println("m");
                MultiChoice multiChoice = new MultiChoice();
                multiChoice.readQuestion(sc);
                System.out.println(multiChoice);
            }
        }

    }
}
