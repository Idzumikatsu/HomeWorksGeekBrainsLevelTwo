package HomeWorks.LessonTwo;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"7", "8", "4", "7"},   // для теста эксепшнов нужно удалить любой из элементов
                {"2", "8", "4", "3"},   // или изменить любое значение на символ
                {"5", "3", "3", "4"},
                {"5", "4", "5", "4"}
        };
        checkArrayIndex(array);
        convertToIntAndCalcArraySum(array);
    }

    private static void checkArrayIndex(String[][] array) throws MyArraySizeException {
        int outside = array.length;
        for (String[] strings : array) {
            int inside = strings.length;
            indexChecker(inside, outside);
        }
    }

    private static void indexChecker(int inside, int outside) throws MyArraySizeException {
        if (outside != 4 || inside != 4) {
            throw new MyArraySizeException("Программа принимает на вход двумерный массив только с размерностью [4][4]. Описание ошибки: ");
        }
    }

    private static void convertToIntAndCalcArraySum(String[][] array) throws MyArrayDataException {
        int countInside = 0, countOutside = 0;
        try {
            int number = 0, sum = 0;
            for (String[] strings : array) {
                countOutside++;
                countInside = 0;
                for (int j = 0; j < array[0].length; j++) {
                    countInside++;
                    number = Integer.parseInt(strings[j]);
                    sum = sum + number;
                }
            }
            System.out.println(sum);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Ячейка массива [" + countOutside + ", " + countInside + "] не может быть преобразована в INT, возникла ошибка: ");
        }
    }
}
