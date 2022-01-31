package HomeWorks.LessonTwo;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException(String message) {
        super(message);
        printStackTrace();
        System.exit(1);
    }
}
