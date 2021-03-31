package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

public class Main {

    public static void main(String[] args) throws Exception {

        MyStack<Queen> queens = new MyStack<>();
        for(int i = 0; i < 8;i++) {
            Logic.permutation(queens,i);
            int j = 0;
            while (j < 8 && queens.peek() != null) {
                System.out.println(queens.peek().getX() + " " + queens.pop().getY());
                j++;
            }
            System.out.println("-----------------------------------------");

        }

    }
}
