public class Utilities {
    public static int toIntIfValid(String numbers) {
        int result;
        if (!numbers.isEmpty()) {
            try {
                result = Integer.parseInt(numbers);
            } catch (NumberFormatException nfe) {
                result = 0;
            }
        }else {
                result = 0;
        }
        return result;
    }
}
