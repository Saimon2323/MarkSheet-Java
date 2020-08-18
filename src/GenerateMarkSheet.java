import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GenerateMarkSheet {
    public static void main(String[] args) {


        //File file = new File("/home/saimon/workspace/saimon-project/Generate_Mark_Sheet/src/marks.txt");
        File file = new File("src/marks.txt");
        String[] subjects = new String[10];
        boolean firstRow = true;

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                if (firstRow) {
                    firstRow = false;
                    String firstRowData = myReader.nextLine();
                    subjects = firstRowData.split(",");
                    continue;
                }
                String data = myReader.nextLine();
                String[] studentData = data.split(",");

                double banglaGp = getGp(studentData[2]);
                double englishGp = getGp(studentData[3]);
                double mathGp = getGp(studentData[4]);
                double religionGp = getGp(studentData[5]);

                String outputFile = "src/" + studentData[0] + "-" + studentData[1] + ".txt";

                try {
                    PrintWriter outputStream = new PrintWriter(outputFile);
                    outputStream.format("%nName: %s. Student Roll: %s %n %n", studentData[1], studentData[0]);
                    outputStream.println("----------------------------------------------");
                    outputStream.format("%-8s | %-8s | %-8s | %-8s | %n", "Subject", "Marks", "Grade Point", "Grade");
                    outputStream.println("----------------------------------------------");
                    outputStream.format("%-8s | %-8s | %-11.1f | %-8s | %n", subjects[2], studentData[2], banglaGp, getGrade(banglaGp));
                    outputStream.println("----------------------------------------------");
                    outputStream.format("%-8s | %-8s | %-11.1f | %-8s | %n", subjects[3], studentData[3], englishGp, getGrade(englishGp));
                    outputStream.println("----------------------------------------------");
                    outputStream.format("%-8s | %-8s | %-11.1f | %-8s | %n", subjects[4], studentData[4], mathGp, getGrade(mathGp));
                    outputStream.println("----------------------------------------------");
                    outputStream.format("%-8s | %-8s | %-11.1f | %-8s | %n", subjects[5], studentData[5], religionGp, getGrade(religionGp));
                    outputStream.println("----------------------------------------------");
                    double gpa = getGpa(banglaGp, englishGp, mathGp, religionGp);
                    outputStream.format("%-9s  %-8s | %-11.2f | %-8s | %n", "", "GPA", gpa, getGrade(gpa));
                    outputStream.println("----------------------------------------------");

                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static double getGpa(double banglaGp, double englishGp, double mathGp, double religionGp) {
        return (banglaGp + englishGp + mathGp + religionGp) / 4;
    }

    private static String getGrade(double gp) {

        if (gp < 1.0) {
            return "F";
        }
        else if (gp < 2.0) {
            return "D";
        } else if (gp < 3.0) {
            return "C";
        } else if (gp < 3.5) {
            return "B";
        } else if (gp < 4.0) {
            return "A-";
        } else if (gp < 5.0) {
            return "A";
        } else {
            return "A+";
        }
    }

    private static double getGp(String num) {
        int number = Integer.parseInt(num);
        if (number < 33) {
            return 0;
        }
        else if (number < 40) {
            return 1;
        } else if (number < 50) {
            return 2;
        } else if (number < 60) {
            return 3;
        } else if (number < 70) {
            return 3.5;
        } else if (number < 80) {
            return 4;
        } else {
            return 5;
        }
    }
}

