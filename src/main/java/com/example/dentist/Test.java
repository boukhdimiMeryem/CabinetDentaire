package com.example.dentist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[]args) throws FileNotFoundException {
        StringBuffer buffer = new StringBuffer();
        File file1 = new File("C:\\Users\\hp\\Desktop\\CabinetDentaire\\CabinetDentaire-main\\src\\main\\java\\com\\example\\dentist\\new.txt");
        Scanner s = new Scanner(file1);
        String data = buffer.toString();
        while (s.hasNextLine()) {
            data = s.nextLine();
            String[] m = data.split("\t");
            if(m[0]=="omar"){
                System.out.println("true");
            }
            else data=s.nextLine();
            System.out.println(data);
            s.close();
            System.out.println(m[0]);
        }

    }




}
