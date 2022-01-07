package day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private int bound;
    private int count;

    public Lottery(int bound, int count) {
        if (bound < count) {
            throw new IllegalArgumentException("Bound can not be smaller than count!");
        }
        this.bound = bound;
        this.count = count;
    }

    public List<Integer> startLottery() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        while (result.size() < count) {
            int randInt = random.nextInt(bound);
            if (!result.contains(randInt)) {
                result.add(randInt);
            }
        }
        return result;
    }

    public int getBound() {
        return bound;
    }

    public int getCount() {
        return count;
    }
}
