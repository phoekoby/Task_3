package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

public class Logic {
    private static  int check(MyStack<Queen> queens, Queen cur) throws Exception {
        MyStack<Queen> auxiliaryStack  = new MyStack<>();
        while(queens.peek()!=null){
            auxiliaryStack.push(queens.pop());
            if(auxiliaryStack.peek().getX()== cur.getX()
                    && auxiliaryStack.peek().getY()==cur.getY()
                    && Math.abs(auxiliaryStack.peek().getX()- cur.getX())==Math.abs(auxiliaryStack.peek().getY()- cur.getY())){
                continue;
            }else {
                break;
            }
        }

return 1;
    }

    public static void permutation() throws Exception {
   MyStack<Queen> queens = new MyStack<>();
   int i = 0;
   while (i<8) {
       Queen current = new Queen(i, 0);
       for (int j = 0; j < 8; j++) {
           current.setY(j);
           if (check(queens, current) > 0) {
               break;
           }

           }

       }
   }


}
