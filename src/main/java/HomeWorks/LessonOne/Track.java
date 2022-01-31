package HomeWorks.LessonOne;

public class Track implements Barrier{
    private final int LENGTH;

    public Track(int LENGTH) {
        this.LENGTH = LENGTH;
    }

    public int getLENGTH() {
        return LENGTH;
    }
}
