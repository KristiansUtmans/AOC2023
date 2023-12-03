import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Day 1
        int dayOnePartOneSolution = dayOne.Solution.solvePartOne();
        int dayOnePartTwoSolution = dayOne.Solution.solvePartTwo();
        System.out.println("Day One Part 1 solution: " + dayOnePartOneSolution);
        System.out.println("Day One Part 2 solution: " + dayOnePartTwoSolution);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        // Day 2
        int dayTwoPartOneSolution = dayTwo.Solution.solvePartOne();
        int dayTwoPartTwoSolution = dayTwo.Solution.solvePartTwo();
        System.out.println("Day Two Part 1 solution: " + dayTwoPartOneSolution);
        System.out.println("Day Two Part 2 solution: " + dayTwoPartTwoSolution);
    }
}