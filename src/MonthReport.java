import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MonthReport {
    int month;
    int year;
    ArrayList<MonthlyReportOne> monthReportData = new ArrayList<>();

    public MonthReport(int month, int year) {
        this.month = month;
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
            MonthlyReportOne lineToWrite;
            boolean isExp;

            String line = scanner.nextLine();
            String[] splitLine = line.split(",");

            if (Objects.equals(splitLine[1], "TRUE")) isExp = true;
            else isExp = false;

            lineToWrite = new MonthlyReportOne(splitLine[0], isExp, Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
            monthReportData.add(lineToWrite);
        }

    }


}
