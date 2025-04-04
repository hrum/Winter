package main;

import java.util.*;

public class BuildingGenerator {

    private static final int LEVELS = 5;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 12;
    private static final double ERROR_RATE = 0.55;

    public static void main(String[] args) {
        BuildingGenerator generator = new BuildingGenerator();
        /*for(int price = 2; price <= 12; price +=2) {
            TreeMap<Double, List<Integer>> solutions = generator.generate(generator.getIncomeEV(price));
            generator.select(solutions, 6);
            System.out.println();
        }*/
        TreeMap<Double, List<Integer>> solutions = generator.generate(7);
        generator.select(solutions, 18);
    }

    private TreeMap<Double, List<Integer>> generate(double ev) {
        double targetSum = ev * LEVELS;
        TreeMap<Double, List<Integer>> solutions = new TreeMap<>();
        double key = 0;
        for(int x1 = LOWER_BOUND; x1 <= UPPER_BOUND; x1++)
            for(int x2 = x1 + 1; x2 <= UPPER_BOUND; x2++)
                for(int x3 = x2 + 1; x3 <= UPPER_BOUND; x3++)
                    for(int x4 = x3 + 1; x4 <= UPPER_BOUND; x4++)
                        for(int x5 = x4 + 1; x5 <= UPPER_BOUND; x5++) {
                            if(Math.abs(x1 + x2 + x3 + x4 + x5 - targetSum) < ERROR_RATE) {
                                key += 0.001;
                                double risk = (x1 - ev)*(x1 - ev) + (x2 - ev)*(x2 - ev) + (x3 - ev)*(x3 - ev) + (x4 - ev)*(x4 - ev) + (x5 - ev)*(x5 - ev);
                                List<Integer> solution = new ArrayList<>();
                                solution.add(x1);
                                solution.add(x2);
                                solution.add(x3);
                                solution.add(x4);
                                solution.add(x5);
                                //if(solutions.containsKey(risk))
                                 //   System.out.println("overwriting solution");
                                solutions.put(risk, solution);
                            }
                        }
        return solutions;
    }

    private void select(TreeMap<Double, List<Integer>> solutions, int number) {
        for(int i = 0; i < number; i++) {
            List<Integer> solution = solutions.pollFirstEntry().getValue();
            System.out.println(solution);
        }
    }

    private double getIncomeEV(int price) {
        return 0.5 * price - 1;
    }

}
