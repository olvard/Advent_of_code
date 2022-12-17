import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;

public class Day3 {

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

        while((line = reader.readLine()) != null){
            //for(String line : testdata.split("\n")){

            int[] chars = new int[line.length()];

            //System.out.println(line);

            //Give the letter it's corresponding number
            int i = 0;
            for (String e : line.split("")) {
                chars[i] = alphabet.indexOf(e);
                i++;
            }

            //Create two new arrays?

            int[] first = Arrays.copyOfRange(chars, 0, chars.length / 2);
            int[] second = Arrays.copyOfRange(chars, chars.length / 2, chars.length);

            //Score

            HashSet<Integer> scores = new HashSet<Integer>();

            //Add to score if found twice

            for (int value : first) {
                for (int k : second) {

                    if (value == k) {
                        scores.add(value);
                    }

                }
            }


            score += scores.stream().reduce(Integer::sum).get();

        }


        System.out.println(score);

    }

}
