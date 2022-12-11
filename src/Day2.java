import java.io.BufferedReader;
import java.io.FileReader;

public class Day2 {

    public static void main(String[] args )throws Exception{

        String strategy = """
                A Y
                B X
                C Z""";

        BufferedReader reader = new BufferedReader(new FileReader("input/input2.txt"));

        int Xvalue = 1;
        int Yvalue = 2;
        int Zvalue = 3;

        int winValue = 6;
        int drawValue = 3;

        int myScore = 0;

        String line;

        while((line = reader.readLine()) != null) {
            //for(String line : strategy.split("\n")){

            String[] currentStrategy = line.trim().split(" ");

            if (currentStrategy[0].equals("A") && currentStrategy[1].equals("X")) {
                myScore += Zvalue;
            }

            if (currentStrategy[0].equals("A") && currentStrategy[1].equals("Y")) {
                myScore += drawValue + Xvalue;
            }

            if (currentStrategy[0].equals("A") && currentStrategy[1].equals("Z")) {
                myScore += winValue + Yvalue;
            }

            if (currentStrategy[0].equals("B") && currentStrategy[1].equals("X")) {
                myScore += Xvalue;
            }

            if (currentStrategy[0].equals("B") && currentStrategy[1].equals("Y")) {
                myScore += drawValue + Yvalue;
            }

            if (currentStrategy[0].equals("B") && currentStrategy[1].equals("Z")) {
                myScore += winValue + Zvalue;
            }

            if (currentStrategy[0].equals("C") && currentStrategy[1].equals("X")) {
                myScore += Yvalue;
            }

            if (currentStrategy[0].equals("C") && currentStrategy[1].equals("Y")) {
                myScore += drawValue + Zvalue;
            }

            if (currentStrategy[0].equals("C") && currentStrategy[1].equals("Z")) {
                myScore += winValue + Xvalue;
            }

        }
        System.out.println(myScore);

        }

    }

