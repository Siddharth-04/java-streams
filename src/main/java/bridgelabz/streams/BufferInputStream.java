package bridgelabz.streams;

import java.io.*;

class FileHandler2 {
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

    void copyFileUnbuffered(String sourcePath, String destinationPath) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("Unbuffered file copy completed.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourcePath);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        System.out.println("Unbuffered Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}

class BufferInputStream {
    public static void main(String[] args) {
        FileHandler2 fileHandler = new FileHandler2();
        fileHandler.copyFileBuffered("D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\input.txt", "\"D:\\\\8th sem\\\\bridgelabz.workspace\\\\java-streams\\\\src\\\\main\\\\java\\\\bridgelabz\\\\streams\\destination_buffered.txt");
    }
}

//Source file not found: D:\8th sem\bridgelabz.workspace\java-streams\src\main\java\bridgelabz\streams\input.txt
//Buffered Copy Time: 3 ms
