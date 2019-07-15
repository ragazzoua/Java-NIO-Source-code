package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {//Writing binary data
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannnel = binFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(245);
            buffer.putInt(-98765);

            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            buffer.flip();
            binChannnel.write(buffer);



//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();
//
//            int numbytes = binChannnel.write(buffer);
//            System.out.println("numbytes written was " + numbytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            numbytes = binChannnel.write(intBuffer);
//            System.out.println("numbytes written was " + numbytes);
//
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            numbytes = binChannnel.write(intBuffer);
//            System.out.println("numbytes written was " + numbytes);
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//            if (buffer.hasArray()) {
//                System.out.println("byte buffer " + new String(buffer.array()));
//            }
// Absolute read
//            intBuffer.flip();
//            numbytes = channel.read(intBuffer);
//            System.out.println(intBuffer.get(0));
//            intBuffer.flip();
//            numbytes = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.get(0));
//            System.out.println(intBuffer.getInt());


            //Relative read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            channel.close();
//            ra.close();


//            System.out.println("outputBytes = " + new String(outputBytes));


//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rw");
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//            System.out.println(new String(b));
//
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
