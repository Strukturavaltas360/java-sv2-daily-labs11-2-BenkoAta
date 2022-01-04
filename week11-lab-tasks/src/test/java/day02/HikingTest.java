package day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {
    Hiking hiking = new Hiking();

    @Test
    void getPlusElevationInvalidDataTest() {
        assertThrows(IllegalArgumentException.class, () -> hiking.getPlusElevation(null));
        assertThrows(IllegalArgumentException.class, () -> hiking.getPlusElevation(Arrays.asList(1.0)));
    }

    @Test
    void getPlusElevationSinkingTest() {
        assertEquals(0.0, hiking.getPlusElevation(Arrays.asList(200.0, 150.0, 120.0, 120.0, 100.0)));
    }

    @Test
    void getPlusElevationTest() {
        assertEquals(200.0, hiking.getPlusElevation(Arrays.asList(10.0, 100.0, 120.0, 150.0, 210.0)));
        assertEquals(340.0, hiking.getPlusElevation(Arrays.asList(10.0, 160.0, 120.0, 150.0, 50.0, 210.0)));
    }
}