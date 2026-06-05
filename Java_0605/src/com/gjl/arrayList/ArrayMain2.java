package src.com.gjl.arrayList;

import java.util.ArrayList;

public class ArrayMain2 {
    public static void main(String[] args) {

        ArrayList<Integer> scores = new ArrayList<>();

        scores.add(80);
        scores.add(90);
        scores.add(70);
        scores.add(100);

        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        double avg = (double)sum / scores.size();

        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);

    }
}
