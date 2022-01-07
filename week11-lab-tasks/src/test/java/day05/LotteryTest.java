package day05;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void startLottery() {
        Lottery lottery = new Lottery(90, 5);
        List<Integer> drawn = lottery.startLottery();
        assertEquals(lottery.getCount(), drawn.size());
        assertTrue(getMin(drawn) > 0);
        assertTrue(getMax(drawn) <= lottery.getBound());

        Set<Integer> set = new HashSet<>(drawn);
        assertEquals(lottery.getCount(), set.size());
    }

    private int getMin(List<Integer> integers) {
        Integer min = null;
        for (int i: integers) {
            if (min == null || min > i) {
                min = i;
            }
        }
        return min;
    }

    private int getMax(List<Integer> integers) {
        Integer max = null;
        for (int i: integers) {
            if (max == null || max < i) {
                max = i;
            }
        }
        return max;
    }
}