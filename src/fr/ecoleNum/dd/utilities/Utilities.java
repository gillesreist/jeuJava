package fr.ecoleNum.dd.utilities;

public class Utilities {
    public static int toIntIfValid(String numbers) {
        int result;
        if (!numbers.isEmpty()) {
            try {
                result = Integer.parseInt(numbers);
            } catch (NumberFormatException nfe) {
                result = -1;
            }
        }else {
                result = -1;
        }
        return result;
    }
}
