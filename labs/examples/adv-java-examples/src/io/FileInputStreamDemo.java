package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("./input/input.txt")){
            System.out.println(in);

            int value = in.read();
            while(value!=-1){
                System.out.print((char) value);
                value = in.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
