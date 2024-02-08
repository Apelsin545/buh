import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class RunApp {

    public static void MenuOutput() {
        System.out.println("1 - enter all month");
        System.out.println("2 - enter all year");
        System.out.println("3 - Compare two");
        System.out.println("4 - show info about all month");
        System.out.println("5 - show info about all year");
        System.out.println("0 - exit");
    }


    public static void run() {
        Scanner in = new Scanner(System.in);
        MenuOutput();
        System.out.print("Enter the mode: ");
        int mode = in.nextInt();
        ArrayList<MonthReport> monthReports = new ArrayList<>();
        ArrayList<YearReport> yearReports = new ArrayList<>();

        while (mode != 0) {

            if (mode == 1) {
                System.out.print("Enter the dir, which contains monthly reports: ");
                String path = in.nextLine();
                File dirOfFiles = new File(path);

                File[] listOfFiles = dirOfFiles.listFiles();
                for (File file : listOfFiles) {
                    String fileName = file.getName();

                    if (!file.isDirectory() && fileName.charAt(0) == 'm') {
                        MonthReport monthRepToRead = new MonthReport(Integer.parseInt(fileName.substring(6, 8)),Integer.parseInt(fileName.substring(2, 6)));
                        monthRepToRead.readCSVFile(file);
                        monthReports.add(monthRepToRead);
                    }
                }

            } else if (mode == 2) {
                System.out.print("Enter the dir, which contains yearly reports: ");
                String path = in.nextLine();
                File dirOfFiles = new File(path);

                File[] listOfFiles = dirOfFiles.listFiles();
                for (File file : listOfFiles) {
                    String fileName = file.getName();

                    if (!file.isDirectory() && fileName.charAt(0) == 'y') {
                        YearReport YearReportToRead = new YearReport(Integer.parseInt(fileName.substring(2, 6)));
                        YearReportToRead.readCSVFile(file);
                        yearReports.add(YearReportToRead);
                    }
                }
            } else if (mode == 3) {

            }


            MenuOutput();
            System.out.print("Enter the mode: ");
            mode = in.nextInt();
        }
    }
}
