package bridgelabz.streams;

import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class ByteArray {
    public static void convertByteArrayToImage(byte[] array,String output) {
        try(ByteArrayInputStream bais = new ByteArrayInputStream(array)){
            FileOutputStream fos = new FileOutputStream(output);
            byte [] buffer = new byte[array.length];
            int bytes;
            while((bytes=bais.read(buffer))!=-1){
                fos.write(buffer,0,bytes);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] convertImageToByteArray(String inputImage) {
        byte[] output = new byte[1024];

        try(FileInputStream fis = new FileInputStream(inputImage)){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            int byteReader;

            while((byteReader = fis.read(output)) !=-1){
                bos.write(output,0,byteReader);
            }
            return bos.toByteArray();

        }catch (IOException e){
            e.printStackTrace();
        }
        return output;
    }
    public static void main(String[] args) {
        String inputImage = "D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\dog.png";
        String outputImage = "D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\converted.png";

        byte[] imageBytes = convertImageToByteArray(inputImage);
        System.out.println(imageBytes.length);
        //convertByteArrayToImage(imageBytes,outputImage);

    }
}
