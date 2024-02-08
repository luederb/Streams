package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

// import the students.csv file from the resources folder
// and print the content of the file


public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = List.of(1,2, 3, 4, 5);
        System.out.println(numbers);

        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .sorted((a, b) -> b - a)
                .toList();
        System.out.println(evenNumbers);

        int sumOfAllNumbers = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of all numbers = " + sumOfAllNumbers);

         numbers.stream()
                .forEach(number -> System.out.println(number));

         List<Integer> processedNumbers = numbers.stream()
                .collect(Collectors.toList());
        System.out.println(processedNumbers);



        Files.lines(Path.of("src/main/resources/students.csv"))
                .forEach(student -> System.out.println(student));

        System.out.println();
        System.out.println("Students without header");
        Files.lines(Path.of("src/main/resources/students.csv"))
                .skip(1)
                .forEach(student -> System.out.println(student));

        // Convert each line into the Student class

        List<Student> students = Files.lines(Path.of("src/main/resources/students.csv"))
                .skip(1)
                .filter(line -> !line.isEmpty())
                .map(line -> {
                    String[] parts = line.split(",");
                    return new Student(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                })
                .distinct()
                .toList();
        students.forEach(student -> System.out.println(student));
    }
}