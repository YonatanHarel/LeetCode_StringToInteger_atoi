public class StringToInteger {
    final static char MINUS = '-';
    final static char PLUS = '+';

    public int convert(String str) {
        int converted = 0;
        StringBuilder numericString = new StringBuilder();

        String cleanString = str.trim();
        int index = 0;

        //The first non-whitespace character is not a numerical
        //digit or a +/- sign. Therefore no valid conversion could be performed.
        if (isInvalidPrefix(cleanString.charAt(index))) {
            return converted;
        } else {
            numericString.append(Character.toString(cleanString.charAt(index)));
            index++;
        }

        while (index < cleanString.length()) {
            char ch = cleanString.charAt(index);
            if (isNumeric(ch)) {
                numericString.append(Character.toString(ch));
            } else {
                break;
            }
            index++;
        }

        if (null != numericString) {
            boolean positive = isPositive(numericString.charAt(0));

            try {
                converted = Integer.parseInt(numericString.toString());
            } catch (NumberFormatException ex) {
                return (positive ? Integer.MAX_VALUE : Integer.MIN_VALUE);
                }
            }

        return converted;
    }

    public boolean isNumeric(char ch) {
        return Character.isDigit(ch);
    }

    public boolean isPositive(char ch) {
        return Character.isDigit(ch) || ch == PLUS;
    }

    //valid prefix can be Plus/Minus sign or digit
    public boolean isInvalidPrefix(char ch) {
        return !((Character.isDigit(ch)) || (ch == PLUS) || (ch == MINUS));
    }

//    // Remove all whitespace characters (space, tab, return etc.)
//    private static String removeWhiteSpaces(String input) {
//        return input.replaceAll("\\s+", "");
//    }
}
