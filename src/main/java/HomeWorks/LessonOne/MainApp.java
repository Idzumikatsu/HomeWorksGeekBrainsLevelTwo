package HomeWorks.LessonOne;

public class MainApp {

    public static void main(String[] args) {
        Participant[] participants = {
                new Cat("Мурзик"),
                new Human("Иван"),
                new Robot("Федор")
        };

        Barrier[] barriers = {
                new Wall(1),
                new Track(50),
                new Wall(2),
                new Track(150),
                new Wall(3),
                new Track(550)
        };

        for (Participant participant : participants) {
            for (Barrier barrier : barriers) {
                participant.cross(barrier);
            }
        }

        System.out.println("-----------------WINNERS-----------------");
        for (Participant participant : participants) {
            if (participant instanceof Cat && Cat.isPlay()) {
                System.out.println("Кот " + ((Cat) participant).getName() + " победил.");
            } else if (participant instanceof Human && Human.isPlay()) {
                System.out.println("Человек " + ((Human) participant).getName() + " победил.");
            } else if (participant instanceof Robot && Robot.isPlay()) {
                System.out.println("Робот " + ((Robot) participant).getName() + " победил.");
            }
        }
    }
}
