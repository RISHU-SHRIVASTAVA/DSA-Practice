package LinkedList;

import java.util.stream.IntStream;

public class arrayToSLL {
    static class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data=data;
            this.next=null;
        }
    }
    public static class Solution{
        static void display(Node<Integer> node){
            Node<Integer> temp=node;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.print("null");
        }
        static Node convertArr2SLL(int[] arr){
            Node<Integer> node=new Node<>(arr[0]);
            Node<Integer> mover=node;
            for (int i=1;i<arr.length;i++) {
                 Node<Integer> temp=new Node<>(arr[i]);
                 mover.next=temp;
                 mover=temp;
            }
            return node;
        }

        public static void main(String[] args) {
            int[] arr ={1,2,3,4,5};

            Node<Integer> addLast=convertArr2SLL(arr);

            //IntStream.range(1,arr.length).forEach(i->addLast(node,new Node(arr[i])));
            display(addLast);
        }

    }
}
