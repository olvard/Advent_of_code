import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class Day4 {

    public static void main(String[] args) throws Exception {

        String sample = """
                2-4,6-8
                2-3,4-5
                5-7,7-9
                2-8,3-7
                6-6,4-6
                2-6,4-8""";

        BufferedReader reader = new BufferedReader(new FileReader("input/input4.txt"));

        int count = 0;

        int all = 0;
        int no_overlap_count = 0;
        int overlap_count = 0;

        String line;

        while((line = reader.readLine()) != null){
        //for(String line : sample.split("\n")){


            System.out.println(line);
            String[] str = line.split("[, \n]");
            String[] str2 = str[0].split("-");
            String[] str3 = str[1].trim().split("-");

            /*System.out.println(str2[0]);
            System.out.println(str2[1]);
            System.out.println(str3[0]);
            System.out.println(str3[1]);*/

            int first1 = Integer.parseInt(str2[0]);
            int first2 = Integer.parseInt(str2[1]);

            int second1 = Integer.parseInt(str3[0]);
            int second2 = Integer.parseInt(str3[1]);

            if((Integer.parseInt(str2[0]) <= Integer.parseInt(str3[0])) && (Integer.parseInt(str2[1]) >= Integer.parseInt(str3[1]))){
                count+=1;
            } else if((Integer.parseInt(str2[0]) >= Integer.parseInt(str3[0])) && (Integer.parseInt(str2[1]) <= Integer.parseInt(str3[1]))){
                count+=1;
            }


            //Part 2

            HashSet<Integer> intersection1 = new HashSet<Integer>();
            HashSet<Integer> intersection2 = new HashSet<Integer>();

            for(int i = first1; i < first2; i++){
                intersection1.add(i);
            }
            intersection1.add(first2);

            for(int j = second1; j < second2; j++){
                intersection2.add(j);
            }
            intersection2.add(second2);

            intersection1.retainAll(intersection2);
            intersection2.retainAll(intersection1);

            if(intersection1.size() > 0){
                overlap_count++;
            } else if(intersection2.size() > 0){
                overlap_count++;
            }


            all++;

        }

        System.out.println(count);
        System.out.println(all);
        System.out.println(overlap_count);
    }
}
