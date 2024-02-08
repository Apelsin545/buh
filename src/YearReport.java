import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class YearReport {
    private int year;
    ArrayList<YearlyReportOne> yearReportData = new ArrayList<>();

    public YearReport(int year) {
        this.year = year;
    }

    public void readCSVFile(File file) {
        Scanner scanner;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNext()) {
            YearlyReportOne lineToWrite;
            boolean isExp;

            String line = scanner.nextLine();
            String[] splitLine = line.split(",");

            if (Objects.equals(splitLine[2], "TRUE")) isExp = true;
            else isExp = false;

            lineToWrite = new YearlyReportOne(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), isExp);
            yearReportData.add(lineToWrite);
        }

    }

    public void showInfo() {
        System.out.println("year: " + year);

        for (YearlyReportOne rep : yearReportData) {
            System.out.println(rep.getMonth() + "," + rep.getAmount() + "," + rep.isExpense());
        }
    }


}
