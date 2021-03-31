package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

public class Logic {
    private static boolean check(MyStack<Queen> queens, Queen cur, int count) throws Exception {
        int counts = count;
        MyStack<Queen> auxiliaryStack = new MyStack<>();
        boolean result = true;
        while (counts != 0 &&queens.peek() != null) {
            counts --;
            auxiliaryStack.push(queens.pop());
            if (auxiliaryStack.peek().getX() == cur.getX()
                    || auxiliaryStack.peek().getY() == cur.getY()
                    || Math.abs(auxiliaryStack.peek().getX() - cur.getX()) == Math.abs(auxiliaryStack.peek().getY() - cur.getY())) {
                result = false;
            }

        }
        while (counts<count && auxiliaryStack.peek() != null) {
            queens.push(auxiliaryStack.pop());
            counts++;
        }
        if (result)
            queens.push(cur);
        //   System.out.println(result);
        return result;
    }

    public static void permutation(MyStack<Queen> queens, int k ) throws Exception {
        int i = 1;
        boolean can = false;
        queens.push(new Queen(0,k));
        Queen current = new Queen(i, 0);
        while (i < 8) {
            for (int j = current.getY(); j < 8; j++) {
                current.setY(j);
                if (check(queens, current, i)) {
                    can=true;
                    break;
                }else {
                    can=false;
                }
                //  System.out.println(j);
            }
            if(can){

                i++;
                current = new Queen(i, 0);

            }else{
                current = queens.pop();
                current.setY(current.getY()+1);
                i--;
            }

        }
    }


}
