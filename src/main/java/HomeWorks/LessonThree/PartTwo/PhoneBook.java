package HomeWorks.LessonThree.PartTwo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, ArrayList<Integer>> map = new HashMap<>();

    public void add(String name, Integer... numbers) {
        map.putIfAbsent(name, new ArrayList<>(Arrays.asList(numbers)));
    }

    public void get(String s) {
        if (map.get(s) == null) {
            System.out.println("Записей о номерах телефона, имеющихся у людей с фамилией " + s + " - не обнаружено, повторите вашу попытку ;)");
        } else {
            System.out.println("Номер(-а) телефона(-ов), из телефонной книги по фамилии " + s + " : " + map.get(s));
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Матвиенко", 5651651, 8956565);
        phoneBook.add("Бастрыкин", 4984984);
        phoneBook.add("Колокольцев", 1234568, 84984986, 4984987);
        phoneBook.add("Байден", 5651651, 8956565);
        phoneBook.add("Псаки", 8484654, 749849849);
        phoneBook.get("Матвиенко");
        phoneBook.get("Колокольцев");
        phoneBook.get("Псаки");
        phoneBook.get("Шойгу");
    }
}
