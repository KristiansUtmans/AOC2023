package dayThree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static int solvePartOne() throws IOException {
        String[] input = inputHelper.Input.getInput("dayThree");

        int result = 0;

        // Pretty slow solution IMO
        Pattern pattern = Pattern.compile("(\\d+)");


        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);

            while (matcher.find()) {
                if (checkSurroundingForSymbol(input, i, matcher.start() - 1, matcher.end())) {
                    result += Integer.parseInt(matcher.group());
                }
            }
        }

        return result;
    }

    public static int solvePartTwo() throws IOException {
        String[] input = inputHelper.Input.getInput("dayThree");

        int result = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                if (input[i].charAt(j) == '*') {
                    result += getSurroundingTwoNumberPower(input, i, j);

                }
            }
        }
        return result;
    }

    private static Boolean checkSurroundingForSymbol(String[] input, int middleRow, int startCol, int endCol) {
        for (int col = startCol; col <= endCol; col++) {
            for (int row = middleRow - 1; row <= middleRow + 1; row++) {
                if (row >= 0 && row < input.length && col >= 0 && col < input[row].length()) {
                    char surroundingElement = input[row].charAt(col);
                    // Checking for each symbol is faster than using regex
                    if (isSymbol(surroundingElement)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private static Boolean isSymbol(char c) {
        return (c != 46) && (c >= 33 && c <= 47) ||
                (c >= 58 && c <= 64) || (c >= 91 && c <= 96) ||
                (c >= 123 && c <= 126);
    }


    private static int getSurroundingTwoNumberPower(String[] input, int middleRow, int middleCol) {
        List<Integer> surroundingNumbers = new ArrayList<>();
        int result = 0;
        // I don't have time to think, so I'm doing this even though it's not efficient and pretty dumb
        List<String> coordinates = new ArrayList<>();
        for (int col = middleCol - 1; col <= middleCol + 1; col++) {
            for (int row = middleRow - 1; row <= middleRow + 1; row++) {
                if (row >= 0 && row < input.length && col >= 0 && col < input[row].length()) {
                    char surroundingElement = input[row].charAt(col);
                    // Checking for each symbol is faster than using regex
                    if (Character.isDigit(surroundingElement)) {
                        int startIndex = col;
                        int endIndex = col;
                        while (startIndex >= 0 && Character.isDigit(input[row].charAt(startIndex))) {
                            startIndex--;
                        }
                        while (endIndex < input[row].length() - 1 && Character.isDigit(input[row].charAt(endIndex))) {
                            endIndex++;
                        }
                        if (!coordinates.contains(String.valueOf(row) + startIndex)) {
                            surroundingNumbers.add(Integer.parseInt(input[row].substring(startIndex + 1, endIndex)));
                            coordinates.add(String.valueOf(row) + startIndex);
                        }
                    }
                }
            }
        }
        if (surroundingNumbers.size() == 2) {
            result = surroundingNumbers.get(0) * surroundingNumbers.get(1);
        }

        return result;
    }

}
