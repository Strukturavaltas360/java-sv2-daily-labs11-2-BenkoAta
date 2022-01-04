package day02;

import java.util.List;

public class Hiking {
    public double getPlusElevation(List<Double> altitudes) {
        if (altitudes == null || altitudes.size() < 2) {
            throw new IllegalArgumentException("Invalid input data!");
        }
        double plusElevation = 0;
        for (int i = 0; i < altitudes.size() - 1; i++) {
            double diff = altitudes.get(i + 1) - altitudes.get(i);
            if (diff > 0) {
                plusElevation += diff;
            }
        }
        return plusElevation;
    }
}
