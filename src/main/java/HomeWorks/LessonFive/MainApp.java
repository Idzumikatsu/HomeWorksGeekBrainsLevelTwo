package HomeWorks.LessonFive;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        Object mon = new Object();
        float[] arrLeft = new float[size / 2];
        float[] arrRight = new float[size / 2];
        float[] mergedArr = new float[size];

        Thread thread1 = new Thread(() -> {
                System.arraycopy(arr, 0, arrLeft, 0, size / 2);
                for (int i = 0; i < arrLeft.length; i++) {
                    arrLeft[i] = (float) (arrLeft[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(arrLeft, 0, mergedArr, 0, size / 2);
                System.out.println("First thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
        });

        Thread thread2 = new Thread(() -> {

                System.arraycopy(arr, size / 2, arrRight, 0, size / 2);
                for (int i = 0; i < arrRight.length; i++) {
                    arrRight[i] = (float) (arrRight[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(arrRight, 0, mergedArr, size / 2, size / 2);
                System.out.println("Second thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

}
