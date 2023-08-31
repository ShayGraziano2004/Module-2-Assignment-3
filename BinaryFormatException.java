public class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the input string is a valid binary string
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        // Convert binary string to decimal
        int decimal = 0;
        int power = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        String binaryString = "101010";
        try {
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal value of " + binaryString + " is: " + decimalValue);
        } catch (BinaryFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
