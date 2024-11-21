package io;

import javax.swing.plaf.synth.SynthLookAndFeel;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

    public static void main(String[] args) {
        String message = "Welcome to java IO";
        try (FileOutputStream fos = new FileOutputStream("./output/output.txt",true)) {
            System.out.println(message);
            //byte[] bytes = message.getBytes();
            char[] chars = message.toCharArray();
            for (char c : chars) {
                fos.write(c);
                fos.write('\n');
            }
            //fos.write(bytes);
            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}

