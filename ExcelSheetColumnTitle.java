public class ExcelSheetColumnTitle {
    private long number;




    public String convertToTitle(long number) {
        StringBuilder title = new StringBuilder();

        while (number > 0) {
            number--;
            int remainder = (int) (number % 26);
            title.append((char) ('A' + remainder));
            number /= 26;
        }
        return title.reverse().toString();
    }



}
