package application;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file path: ");
        String filePath = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            Set<LogEntry> logEntrySet = new HashSet<>();
            String line = br.readLine();

            while (line != null){

                String[] fields = line.split(" ");
                String userName = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));
                logEntrySet.add(new LogEntry(userName, moment));

                line = br.readLine();
            }

            System.out.println("Total users: " + logEntrySet.size());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());;
        }

        sc.close();

    }
}
