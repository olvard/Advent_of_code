import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input/input1.txt"));

        int calorie = 0;
        int topCalories = 0;

        List<Integer> calorieList = new ArrayList<Integer>();

        String line;

        while((line = reader.readLine()) != null) {
            String strCal = line.trim();

            if (strCal.isBlank()) {

                if (topCalories < calorie) {
                    topCalories = calorie;
                }

                calorieList.add(calorie);
                calorie = 0;
                continue;
            }

            calorie += Integer.parseInt(strCal);

            }

            calorieList.add(calorie);

            if(topCalories < calorie){
                topCalories = calorie;
            }


        System.out.println(topCalories);
        calorieList.sort((a,b) -> b - a);
        int tot = calorieList.get(0) + calorieList.get(1) + calorieList.get(2);
        System.out.println(tot);

    }

}
