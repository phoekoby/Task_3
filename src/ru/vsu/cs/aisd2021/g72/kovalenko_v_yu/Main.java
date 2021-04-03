package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

import ru.vsu.cs.util.SwingUtils;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);


        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
/*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество ферзей и размерность доски:");
        int n = scanner.nextInt();

        Logic.print(n);


 */

    }
}
