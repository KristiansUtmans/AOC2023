import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Day 1
        int dayOnePartOneSolution = dayOne.Solution.solvePartOne();
        int dayOnePartTwoSolution = dayOne.Solution.solvePartTwo();
        System.out.println("Day 1 part 1 solution: " + dayOnePartOneSolution);
        System.out.println("Day 1 part 2 solution: " + dayOnePartTwoSolution);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        // Day 2
        int dayTwoPartOneSolution = dayTwo.Solution.solvePartOne();
        int dayTwoPartTwoSolution = dayTwo.Solution.solvePartTwo();
        System.out.println("Day 2 part 1 solution: " + dayTwoPartOneSolution);
        System.out.println("Day 2 part 2 solution: " + dayTwoPartTwoSolution);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        // Day 3
        int dayThreePartOneSolution = dayThree.Solution.solvePartOne();
        System.out.println("Day 3 part 1 solution: " + dayThreePartOneSolution);
        int dayThreePartTwoSolution = dayThree.Solution.solvePartTwo();
        System.out.println("Day 3 part 2 solution: " + dayThreePartTwoSolution);
    }
}