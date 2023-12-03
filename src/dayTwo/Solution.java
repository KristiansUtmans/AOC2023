package dayTwo;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static int solvePartOne() throws IOException {
        return solve(true);
    }

    public static int solvePartTwo() throws IOException {
        return solve(false);
    }

    private static int solve(Boolean partOne) throws IOException {
        int result = 0;
        String[] input = inputHelper.Input.getInput("dayTwo");

        Pattern rxGame = Pattern.compile("\\d+");
        Pattern rxRed = Pattern.compile("(\\d+)(?=\\sred)");
        Pattern rxGreen = Pattern.compile("(\\d+)(?=\\sgreen)");
        Pattern rxBlue = Pattern.compile("(\\d+)(?=\\sblue)");

        // Initially I misunderstood the task, I assumed the values should be summed, then compared
        for (String val : input) {
            Matcher matchGameId = rxGame.matcher(val);
            Matcher matchRed = rxRed.matcher(val);
            Matcher matchGreen = rxGreen.matcher(val);
            Matcher matchBlue = rxBlue.matcher(val);
            int maxRed = 0;
            int maxGreen = 0;
            int maxBlue = 0;
            // I know this is quite stupid, but this removes the necessity to parse string to int twice
            int currentRed;
            int currentGreen;
            int currentBlue;

            matchGameId.find();
            int gameId = Integer.parseInt(matchGameId.group());

            while (matchRed.find()) {
                currentRed = Integer.parseInt(matchRed.group());
                if (currentRed > maxRed) {
                    maxRed = currentRed;
                }
            }
            while (matchGreen.find()) {
                currentGreen = Integer.parseInt(matchGreen.group());
                if (currentGreen > maxGreen) {
                    maxGreen = currentGreen;
                }
            }
            while (matchBlue.find()) {
                currentBlue = Integer.parseInt(matchBlue.group());
                if (currentBlue > maxBlue) {
                    maxBlue = currentBlue;
                }
            }
            if (partOne) {
                if (maxRed <= 12 && maxGreen <= 13 && maxBlue <= 14) {
                    result += gameId;
                }
            } else {
                result += maxRed * maxGreen * maxBlue;
            }
        }

        return result;
    }
}
