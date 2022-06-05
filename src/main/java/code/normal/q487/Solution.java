package code.normal.q487;

import java.util.Arrays;

public class Solution {

    private final double radius;
    private final double xCenter;
    private final double yCenter;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.yCenter = y_center;
        this.xCenter = x_center;
    }

    public double[] randPoint() {
        double randomRadius = Math.sqrt(Math.random() * radius * radius);
        double angle = Math.random() * 360;
        double x = Math.sin(angle) * randomRadius + xCenter;
        double y = Math.cos(angle) * randomRadius + yCenter;
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        Solution solution = new Solution(102422.0, 1, 2);
        for (int i = 0; i < 100; i++) {
            double[] point = solution.randPoint();
            System.out.println(Arrays.toString(point));
        }
    }
}
