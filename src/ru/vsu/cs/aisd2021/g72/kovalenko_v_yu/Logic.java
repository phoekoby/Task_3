package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

import java.util.ArrayList;

public class Logic {
    private static int n;
    private static final MyStack<Queen> queens = new MyStack<>();
    //  private static ArrayList<ArrayList<Queen>> all = new ArrayList<>();

    /*public static ArrayList<ArrayList<Queen>> getAll() {
        return all;
    }

     */

    private static boolean check(MyStack<Queen> queens, Queen cur, int place) throws Exception {
        if (place >= n) {
            return false;
        }
        MyStack<Queen> auxiliaryStack = new MyStack<>();
        boolean result = true;
        while (!queens.ifEmpty()) {
            auxiliaryStack.push(queens.pop());
            if (auxiliaryStack.peek().getY() == cur.getY()
                    || Math.abs(auxiliaryStack.peek().getX() - cur.getX()) == Math.abs(auxiliaryStack.peek().getY() - cur.getY())) {
                result = false;
                break;
            }
        }
        while (!auxiliaryStack.ifEmpty()) {
            queens.push(auxiliaryStack.pop());
        }
        if (result)
            queens.push(cur);
        return result;
    }

    public static ArrayList<Queen> add(int n, ArrayList<Queen> combination) throws Exception {
        MyStack<Queen> stack = new MyStack<>();
        while (!queens.ifEmpty()) {
            Queen cur = new Queen(queens.peek().getX(),queens.peek().getY());
            combination.add(cur);
            stack.push(queens.pop());
        }
        while (!stack.ifEmpty()) {
            queens.push(stack.pop());
        }
        return combination;
    }

    public static int[][] toArray(int n) throws Exception {
        int[][] array = new int[n][n];
        MyStack<Queen> stack = new MyStack<>();

        while (!queens.ifEmpty()) {
            Queen queen = queens.peek();
            array[queen.getX()][queen.getY()] = 1;
            stack.push(queens.pop());
        }
        while (!stack.ifEmpty()) {
            queens.push(stack.pop());
        }
        return array;
    }


    public static int[][] toArray(int n, ArrayList<Queen> queensssss) throws Exception {
        int[][] array = new int[n][n];
        for (Queen queen : queensssss) {
//            System.out.print(queen.getX() + " " + queen.getY());
            array[queen.getX()][queen.getY()] = 1;
        }
        return array;
    }


    public static boolean permutation(int count) throws Exception {
        Logic.n = count;
        int i;
        boolean can;
        Queen current;
        can = false;
        if (queens.ifEmpty()) {
            i = 1;
            queens.push(new Queen(0, 0));
            current = new Queen(i, 0);
        } else {
            i = n - 1;
            current = new Queen(i, queens.pop().getY() + 1);
        }
        while (i < n) {
/*
         int j = current.getY();
            while(!check(queens, current,i)  &&  j<n){
                current.setY(j);
                j++;
            }
 */
            for (int j = current.getY(); j < n; j++) {
                current.setY(j);
                if (check(queens, current, i)) {
                    can = true;
                    break;
                } else {
                    can = false;
                }
            }
            if (can) {
                i++;
                current = new Queen(i, 0);
            } else {
                if (queens.ifEmpty()) {
                    return false;
                }
                current = queens.pop();
                current.setY(current.getY() + 1);
                i--;
            }
        }
        return true;
    }

   /* public static void clear() throws Exception {
        while (!queens.ifEmpty()) {
            queens.pop();
        }
        all.clear();
    }

    */
}
