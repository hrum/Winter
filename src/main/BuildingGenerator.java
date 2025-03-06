package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuildingGenerator {

    private static final String PATH = "C:\\Users\\Zero\\Desktop\\Game projects\\winter\\cards.csv";
    private static final int LEVELS = 5;
    private static final int LOWER_BOUND = -4;
    private static final int UPPER_BOUND = 8;
    private static final double BASE_PRICE = 2;
    private static final double STEP = 0.1;
    private static final double ERROR_RATE = 0.55;
    //three zones of risk: 15, 45, 75

    public static void main(String[] args) {
        BuildingGenerator generator = new BuildingGenerator();
        generator.read();
    }

    private void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = reader.readLine();
            while(line != null) {
                String[] lines = line.split(";");
                int price = Integer.parseInt(lines[6]);
                double compensation = Double.parseDouble(lines[4]);
                double targetRisk = Double.parseDouble(lines[5]);
                int[] solution = generate(getIncomeEV(price) + compensation, targetRisk);
                String output = "";
                for (int i = 0; i < LEVELS; i++) {
                    output += solution[i] + ";";
                }
                System.out.println(output);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private int[] generate(double targetEv, double targetRisk) {
        double targetSum = targetEv * LEVELS;
        int[] solution = new int[LEVELS];
        double bestError = 1000;
        for(int x1 = LOWER_BOUND; x1 <= UPPER_BOUND; x1++)
            for(int x2 = x1 + 1; x2 <= UPPER_BOUND; x2++)
                for(int x3 = x2 + 1; x3 <= UPPER_BOUND; x3++)
                    for(int x4 = x3 + 1; x4 <= UPPER_BOUND; x4++)
                        for(int x5 = x4 + 1; x5 <= UPPER_BOUND; x5++) {
                            if(Math.abs(x1 + x2 + x3 + x4 + x5 - targetSum) < ERROR_RATE) {
                                double curError = Math.abs(calcRisk(x1, x2, x3, x4, x5) - targetRisk);
                                if(curError < bestError) {
                                    solution[0] = x1;
                                    solution[1] = x2;
                                    solution[2] = x3;
                                    solution[3] = x4;
                                    solution[4] = x5;
                                    bestError = curError;
                                }
                            }
                        }
        return solution;
    }

    private double calcRisk(int x1, int x2, int x3, int x4, int x5) {
        double a = (double) (x1 + x2 + x3 + x4 + x5)/5;
        return (x1 - a)*(x1 - a) + (x2 - a)*(x2 - a) + (x3 - a)*(x3 - a) + (x4 - a)*(x4 - a) + (x5 - a)*(x5 - a);
    }

    private double getIncomeEV(int price) {
        double ratio = price / BASE_PRICE;
        return 0.7 * ratio * (1 - STEP * (ratio - 1)/2);
    }
}
