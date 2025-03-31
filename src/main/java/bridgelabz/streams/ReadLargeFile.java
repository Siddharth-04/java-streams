package bridgelabz.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {

    public static void main(String[] args) {
        String fileLocation = "D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\input.txt";

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileLocation));

            String currentLine;

            int lineCounter = 0;

            while ((currentLine = fileReader.readLine()) != null) {
                lineCounter++;

                String lowerCaseLine = currentLine.toLowerCase();

                if (lowerCaseLine.contains("error")) {
                    System.out.println("Line " + lineCounter + ": " + currentLine);
                }
            }

            fileReader.close();
            System.out.println("All done! Checked " + lineCounter + " lines.");
        } catch (IOException e) {
            System.out.println("Oops! Something went wrong:");
            e.printStackTrace();
        }
    }
}
//All done! Checked 3 lines.