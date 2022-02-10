package HomeWorks.LessonThree.PartOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordsCounter {
    public static void main(String[] args) {
        var list = new ArrayList<>(Arrays.asList("asd", "asd", "gdf", "ger", "2re", "ger"));
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            Integer num = map.getOrDefault(s, 0);
            map.put(s, num + 1);
        }
        System.out.println(map);
    }

}
