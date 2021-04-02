package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

public class MyStack<T> {
    private static class ListNode<T> {
        public T value;
        public ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }
    }


    private ListNode<T> head = null;
    private int count = 0;

    public void push(T value) {
        head = new ListNode<>(value, head);
        count++;
    }
    public T pop() throws Exception{
        if (count == 0) {
            throw new Exception("Stack is empty");
        }
        T value = head.value;
        head = head.next;
        count--;
        return value;
    }
    public T peek() throws Exception {
        if (count == 0) {
            throw new Exception("Stack is empty");
        }
        return head.value;
    }
    public boolean ifEmpty(){
        return count == 0;
    }



}
