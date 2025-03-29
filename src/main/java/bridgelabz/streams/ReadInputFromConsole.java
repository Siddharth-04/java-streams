package bridgelabz.streams;

import java.io.*;

class FileHandler3 {
    void copyFileBuffered(String sourcePath, String destinationPath) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationPath))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered file copy completed.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourcePath);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        System.out.println("Buffered Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    void readUserInputAndWriteToFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filePath)) {
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            writer.write("Name: " + name + "\nAge: " + age + "\nFavorite Language: " + language + "\n");
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

class ReadInputFromConsole {
    public static void main(String[] args) {
        FileHandler3 fileHandler = new FileHandler3();
        fileHandler.readUserInputAndWriteToFile("D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\input.txt");
    }
}
//Enter your name: Siddharth
//Enter your age: 23
//Enter your favorite programming language: hindi
//User data saved successfully.
