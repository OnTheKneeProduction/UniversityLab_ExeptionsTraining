package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        PrintWriter noFile = null;
        PrintWriter badData = null;
        PrintWriter overflow = null;

        try {
            noFile = new PrintWriter(new FileWriter(new File("no_file.txt")), true);
            badData = new PrintWriter(new FileWriter(new File("bad_data.txt")), true);
            overflow = new PrintWriter(new FileWriter(new File("overflow.txt")), true);
        } catch (IOException e) {
            System.out.println("Can't create no_file.txt or bad_data.txt or overflow.txt");
        }

        double result = 0;
        int count = 0;
        int a;
        int b;

        for (int i = 10; i <= 29; i++) {
            try {
                File file = new File("txts/" + i + ".txt");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                a = Integer.parseInt(reader.readLine());
                b = Integer.parseInt(reader.readLine());
                result += Math.multiplyExact(a, b);
                count++;

            } catch (FileNotFoundException e) {
                noFile.println(i + ".txt");
            } catch (NumberFormatException e) {
                badData.println(i + ".txt");
            } catch (ArithmeticException e) {
                overflow.println(i + ".txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(result / count);
    }
}
