import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day3_2 {

    public static void main(String[] args) throws Exception {

        String testdata = """
            vJrwpWtwJgWrhcsFMMfFFhFp
            jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            PmmdzqPrVvPwwTWBwg
            wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            ttgJtRGJQctTZtZT
            CrZsJsPPZsGzwwsLwLmpwMDw
            """;

        BufferedReader reader = new BufferedReader(new FileReader("input/input3.txt"));

        String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int score = 0;
        String line;

        List<Set<Integer>> lists = new ArrayList<>();
        lists.add(new HashSet<>());
        lists.add(new HashSet<>());
        lists.add(new HashSet<>());
        int index = 0;

        while((line = reader.readLine()) != null){
            //for(String line : testdata.split("\n")){

                //System.out.println(line.length());

                for(String e : line.split("")){
                    lists.get(index).add(alphabet.indexOf(e));
                }
                index++;

                //System.out.println(index);
                if(index < 3){
                    continue;
                }


                //Make array 0 only contain the elements that are both in 0 and 1
                //Make array 0 only contain the elements that are both in 0 and 2
                lists.get(0).retainAll(lists.get(1));
                lists.get(0).retainAll(lists.get(2));

                //Sum up the array 0
                System.out.println((lists.get(0)).size());
                score += lists.get(0).stream().reduce(Integer::sum).get();


                //New sets of arrays for the next three
                lists = new ArrayList<>();
                lists.add(new HashSet<>());
                lists.add(new HashSet<>());
                lists.add(new HashSet<>());
                index = 0;

        }

        System.out.println(score);

    }
}
