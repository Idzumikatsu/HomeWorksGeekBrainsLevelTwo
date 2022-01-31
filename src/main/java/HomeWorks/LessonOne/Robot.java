package HomeWorks.LessonOne;

public class Robot implements Runnable, Jumpable, Participant {
    private final int MAX_JUMP_HEIGHT = 5;
    private final int MAX_RUN_LENGTH = 1000;
    private String name;
    private static boolean play = true;

    public static boolean isPlay() {
        return play;
    }

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMAX_RUN_LENGTH() {
        return MAX_RUN_LENGTH;
    }

    public int getMAX_JUMP_HEIGHT() {
        return MAX_JUMP_HEIGHT;
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгнул!");
    }

    @Override
    public void run() {
        System.out.println("Робот побежал!");
    }

    @Override
    public void cross(Barrier barrier) {
        if (play) {
            if (barrier instanceof Wall) {
                jump();
                if (getMAX_JUMP_HEIGHT() < ((Wall) barrier).getHEIGHT()) {
                    System.out.println("Робот " + getName() + " не смог перепрыгнуть стену высотой " + (((Wall) barrier).getHEIGHT()) + " метра(ов) и выбыл из соревнования.");
                    play = false;
                } else {
                    System.out.println("Робот " + getName() + " перепрыгнул стену высотой " + (((Wall) barrier).getHEIGHT()) + " метра(ов).");
                }
            } else if (barrier instanceof Track) {
                run();
                if (getMAX_RUN_LENGTH() < ((Track) barrier).getLENGTH()) {
                    System.out.println("Робот " + getName() + " не смог пробежать расстояние " + ((Track) barrier).getLENGTH() + " метров и выбыл из соревнования.");
                    play = false;
                } else {
                    System.out.println("Робот " + getName() + " пробежал дорожку длиной " + ((Track) barrier).getLENGTH() + " метров.");
                }
            }
        }
    }
}
