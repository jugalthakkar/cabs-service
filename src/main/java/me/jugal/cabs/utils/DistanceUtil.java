package me.jugal.cabs.utils;

import java.util.List;

public class DistanceUtil {
    public static int findNearest(List<Position> options, Position target) {
        // TODO: use google map api for shortest time from driver to customer
        double shortestPath = Double.MAX_VALUE, x1 = target.getLatitude(), y1 = target.getLongitude();
        int bestMatch = -1;
        for (int i = 0; i < options.size(); i++) {
            Position option = options.get(i);
            double x2 = option.getLatitude(),
                    y2 = option.getLongitude(),
                    squaredDistance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
            if (squaredDistance < shortestPath) {
                shortestPath = squaredDistance;
                bestMatch = i;
            }
        }
        return bestMatch;
    }
}
