import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Muhammad Saimon
 * @since Aug 8/16/20 9:29 AM
 */

public class MarkSheet {
    public static void main(String[] args) {

        GenerateMarkSheet generateMarkSheet = new GenerateMarkSheet();

        List<String> studentInfo = new ArrayList<>();
        studentInfo.add("ID,Name,Bangla,English,Math,Religion");
        studentInfo.add("01,Saimon,60,65,70,85");
        studentInfo.add("02,Abid,85,90,98,90");

        File inputFileDir = generateMarkSheet.inputMarks(studentInfo);
        generateMarkSheet.precessAndGenerateMarkSheet(inputFileDir);
    }
}
