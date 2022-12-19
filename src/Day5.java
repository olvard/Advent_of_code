import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Day5 {

    private static void dump(List<ArrayList<String>> stacks) {
        for (ArrayList<String> stack : stacks) {
            for (String s : stack) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        ArrayList<String> stack1 = new ArrayList<String>();
        stack1.add("R"); stack1.add("P"); stack1.add("C"); stack1.add("D"); stack1.add("B"); stack1.add("G");

        ArrayList<String> stack2 = new ArrayList<String>();
        stack2.add("H"); stack2.add("V"); stack2.add("G");

        ArrayList<String> stack3 = new ArrayList<String>();
        stack3.add("N"); stack3.add("S"); stack3.add("Q"); stack3.add("D"); stack3.add("J"); stack3.add("P"); stack3.add("M");

        ArrayList<String> stack4 = new ArrayList<String>();
        stack4.add("P"); stack4.add("S"); stack4.add("L"); stack4.add("G"); stack4.add("D"); stack4.add("C"); stack4.add("N"); stack4.add("M");

        ArrayList<String> stack5 = new ArrayList<String>();
        stack5.add("J"); stack5.add("B"); stack5.add("N"); stack5.add("C"); stack5.add("P"); stack5.add("F"); stack5.add("L"); stack5.add("S");

        ArrayList<String> stack6 = new ArrayList<String>();
        stack6.add("Q"); stack6.add("B"); stack6.add("D"); stack6.add("Z"); stack6.add("V"); stack6.add("G"); stack6.add("T"); stack6.add("S");

        ArrayList<String> stack7 = new ArrayList<String>();
        stack7.add("B"); stack7.add("Z"); stack7.add("M"); stack7.add("H"); stack7.add("F"); stack7.add("T"); stack7.add("Q");

        ArrayList<String> stack8 = new ArrayList<String>();
        stack8.add("C"); stack8.add("M"); stack8.add("D"); stack8.add("B"); stack8.add("F");

        ArrayList<String> stack9 = new ArrayList<String>();
        stack9.add("F"); stack9.add("C"); stack9.add("Q"); stack9.add("G");

        List<ArrayList<String>> stacks = new ArrayList<>();
        stacks.add(stack1); stacks.add(stack2); stacks.add(stack3); stacks.add(stack4);
        stacks.add(stack5); stacks.add(stack6); stacks.add(stack7); stacks.add(stack8); stacks.add(stack9);

        BufferedReader reader = new BufferedReader(new FileReader("input/input5.txt"));

        //----------------------------------test--------------------------------------------

        ArrayList<String> t1 = new ArrayList<String>();
        t1.add("Z"); t1.add("N");
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("M"); t2.add("C"); t2.add("D");
        ArrayList<String> t3 = new ArrayList<String>();
        t3.add("P");

        List<ArrayList<String>> test = new ArrayList<>();
        test.add(t1); test.add(t2); test.add(t3);

        String sample= """
                move 1 from 2 to 1
                move 3 from 1 to 3
                move 2 from 2 to 1
                move 1 from 1 to 2""";

        dump(stacks);

        //------------------------------------------------------------------------------------

        String line;

        while((line = reader.readLine()) != null){
        //for(String line : sample.split("\n")){
            System.out.println(line);

            String[] instr = line.split(" ");

            int move = Integer.parseInt(instr[1]);
            int from = Integer.parseInt(instr[3])-1;
            int to = Integer.parseInt(instr[5])-1;


            System.out.println(move + " " + from + " " + to);

            ArrayList<String> temp = new ArrayList<>();

            for(int v = 0; v < move; v++){
                temp.add(stacks.get(from).get(stacks.get(from).size()-1));
                stacks.get(from).remove(stacks.get(from).size()-1);
            }

            for(int j = 0; j < move; j++){
                stacks.get(to).add(temp.get(temp.size()-1));
                temp.remove(temp.size()-1);
            }

            /*for(int j = 0; j < move; j++){
                test.get(to).add(test.get(from).get(test.get(from).size()-1));
                test.get(from).remove(test.get(from).size()-1);
            }*/

        }


      for(int k = 0; k < 9; k++){
           System.out.println(stacks.get(k).get(stacks.get(k).size()-1));
       }

      System.out.println("stacks: ");

      dump(stacks);

       /*for(int k = 0; k < 9; k++){
           System.out.println(test.get(k).get(test.get(k).size()-1));
       }*/



    }
}
