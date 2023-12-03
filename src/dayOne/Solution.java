package dayOne;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private static final String partOneRegex = "(^\\D{0})*(\\d)";
    private static final String partTwoRegex = "(^\\D{0})*(\\d|(?:zero|one|two|three|four|five|six|seven|eight|nine))";

    public static int solvePartOne() throws IOException {
        return solve(true);
    }

    public static int solvePartTwo() throws IOException {
        return solve(false);
    }

    private static int solve(Boolean partOne) throws IOException {
        Map<String, String> wordToDigitMap = new HashMap<>();
        wordToDigitMap.put("zero", "0");
        wordToDigitMap.put("one", "1");
        wordToDigitMap.put("two", "2");
        wordToDigitMap.put("three", "3");
        wordToDigitMap.put("four", "4");
        wordToDigitMap.put("five", "5");
        wordToDigitMap.put("six", "6");
        wordToDigitMap.put("seven", "7");
        wordToDigitMap.put("eight", "8");
        wordToDigitMap.put("nine", "9");

        String[] input = inputHelper.Input.getInput("dayOne");

        int result = 0;

        Pattern pattern = Pattern.compile(partOne ? partOneRegex : partTwoRegex);

        for (String val : input) {
            Matcher matcher = pattern.matcher(val);
            String firstMatch = null;
            String lastMatch = null;
            while (matcher.find()) {
                if (firstMatch == null) {
                    firstMatch = matcher.group();
                    if (wordToDigitMap.containsKey(firstMatch)) {
                        firstMatch = wordToDigitMap.get(firstMatch);
                    }
                }
                lastMatch = matcher.group();
            }
            if (wordToDigitMap.containsKey(lastMatch)) {
                lastMatch = wordToDigitMap.get(lastMatch);
            }
            result += Integer.parseInt(firstMatch + lastMatch);
        }

        return result;
    }
}
