public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        char[] charOfNum1 = num1.toCharArray();
        char[] charOfNum2 = num2.toCharArray();

        int num1Length = charOfNum1.length;
        int num2Length = charOfNum2.length;

        int[] multiplies = new int[num1Length + num2Length];

        for (int i = num1Length - 1; i > -1; i--) {
            int number1 = toInt(charOfNum1[i]);

            for (int j = num2Length - 1; j > -1; j--) {
                int number2 = toInt(charOfNum2[j]);

                int multiply = number1 * number2;

                int valOne = multiply % 10;
                int valTwo = multiply / 10;

                int placeIndexOne = (num1Length - 1 - i) + (num2Length - 1 - j);
                int placeIndexTwo = placeIndexOne + 1;

                int valOneAfterUpdate = multiplies[placeIndexOne] + valOne;
                if (valOneAfterUpdate > 9) {
                    multiplies[placeIndexOne] = valOneAfterUpdate % 10;
                    multiplies[placeIndexTwo] += 1;
                } else {
                    multiplies[placeIndexOne] = valOneAfterUpdate;
                }

                int valTwoAfterUpdate = multiplies[placeIndexTwo] + valTwo;
                while (valTwoAfterUpdate > 9) {
                    multiplies[placeIndexTwo] = valTwoAfterUpdate % 10;

                    placeIndexTwo++;

                    multiplies[placeIndexTwo] += 1;
                    valTwoAfterUpdate = multiplies[placeIndexTwo];
                }
                multiplies[placeIndexTwo] = valTwoAfterUpdate;
            }
        }

        StringBuilder builder = new StringBuilder();
        boolean start = false;
        for (int i = multiplies.length - 1; i > -1; i--) {
            if (!start) {
                if (multiplies[i] != 0) {
                    start = true;
                    builder.append(multiplies[i]);
                }
            } else {
                builder.append(multiplies[i]);
            }
        }

        return builder.toString();
    }

    private int toInt(char character) {
        return character - 48;
    }


    public static void main(String[] args) {
        MultiplyStrings handler = new MultiplyStrings();
        System.out.println(handler.multiply("123", "456"));
    }

}
