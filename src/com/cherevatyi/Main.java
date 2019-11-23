package com.cherevatyi;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\txt\\text.txt");
        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        String consoleName = "", consoleCity = "", sumChars = "";
        int consoleAge = 0;
        int counter = 0;
        while(buffer.available() > 0) {
            char c = (char)buffer.read();
            if (c == ';') {
                switch (counter) {
                    case 0:
                        consoleName = sumChars;
                        break;
                    case 1:
                        consoleCity = sumChars;
                        break;
                    case 2:
                        try {
                            consoleAge = Integer.parseInt(sumChars);
                        }
                        catch (Exception e) {
                            consoleAge = -1;
                        }
                        break;
                }
                sumChars = "";
                counter++;
                continue;
            }
            sumChars += c;
        }
        Human inputMan = new Human(consoleName, consoleCity, consoleAge);
        inputStream.close();
        buffer.close();
        System.out.println(inputMan);
        Human outputMan = new Human();
        System.out.println(outputMan);
        FileOutputStream outputStream = new FileOutputStream("C:\\txt\\" + outputMan.getName() + ".txt");
        BufferedOutputStream outbuffer = new BufferedOutputStream(outputStream);
        StringBuilder output =  new StringBuilder("city = ").append(outputMan.getCity())
                .append("; age = ").append(outputMan.getAge())
                .append(";");
        byte[] arr = output.toString().getBytes();
        outbuffer.write(arr);
        outbuffer.close();
        outputStream.close();
    }
}
