package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество ферзей и размерность доски:");
        int n = scanner.nextInt();

        Logic.print(n);


    }
}
