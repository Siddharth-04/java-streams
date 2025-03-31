package bridgelabz.streams;

import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        String input = "D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\uppercase.txt";
        String output = "D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\lowercase.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));){

            String line;
            while ((line = br.readLine()) != null) {
                writer.write(line.toLowerCase());
            }
            System.out.println("Converted to lowercase");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
//Converted to lowercase