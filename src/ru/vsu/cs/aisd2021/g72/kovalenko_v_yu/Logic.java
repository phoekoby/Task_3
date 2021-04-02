package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

public class Logic {
    private static boolean check(MyStack<Queen> queens, Queen cur, int count) throws Exception {
        int counts = count;
        MyStack<Queen> auxiliaryStack = new MyStack<>();
        boolean result = true;
        while (counts != 0 && !queens.ifEmpty()) {

            auxiliaryStack.push(queens.pop());
            if (auxiliaryStack.peek().getY() == cur.getY()
                    || Math.abs(auxiliaryStack.peek().getX() - cur.getX()) == Math.abs(auxiliaryStack.peek().getY() - cur.getY())) {
                result = false;
                break;
            }
            counts--;
        }
        while (!auxiliaryStack.ifEmpty()) {
            queens.push(auxiliaryStack.pop());
            counts++;
        }
        if (result)
            queens.push(cur);
        //   System.out.println(result);
        return result;
    }

    public static void print(int n) throws Exception {
        MyStack<Queen> queens = new MyStack<>();
        MyStack<Queen> stack = new MyStack<>();
        int term = 0;
        while (permutation(queens, n)) {
            System.out.println("Номер комбинации: " + ++term);
            while (!queens.ifEmpty()) {
                System.out.println(queens.peek().getX() + " " + queens.peek().getY());
                stack.push(queens.pop());
            }
            while (!stack.ifEmpty()) {
                queens.push(stack.pop());
            }
            System.out.println("-----------------------------------------");

        }
    }

    public static boolean permutation(MyStack<Queen> queens, int count) throws Exception {

        int i;
        boolean can;
        Queen current;
        if (queens.ifEmpty()) {
            i = 1;
            can = false;
            queens.push(new Queen(0, 0));
            current = new Queen(i, 0);
        } else {
            i = count - 1;
            can = false;
         /*   if (queens.peek().getX()==count-1 || queens.peek().getY() == count - 1) {
                queens.pop();
                i--;
            }

          */
            current = new Queen(i, queens.pop().getY() + 1);
        }

        while (i < count) {
            for (int j = current.getY(); j < count; j++) {
                current.setY(j);
                if (check(queens, current, i)) {
                    can = true;
                    break;
                } else {
                    can = false;
                }
                //  System.out.println(j);
            }
            if (can) {
                i++;
                current = new Queen(i, 0);
            } else {
                if (queens.ifEmpty()) {
                    return false;
                }
                current = queens.pop();
                if (current.getY() == count - 1 && queens.ifEmpty()) {
                    return false;
                }
                current.setY(current.getY() + 1);
                i--;
            }

        }
        return true;
    }
    }
