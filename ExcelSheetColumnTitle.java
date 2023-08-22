public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            title.insert(0, (char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }

        return title.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle title = new ExcelSheetColumnTitle();
        System.out.println(title.convertToTitle(1));
        System.out.println(title.convertToTitle(28));
        System.out.println(title.convertToTitle(701));
        System.out.println(title.convertToTitle(52));
    }

}
