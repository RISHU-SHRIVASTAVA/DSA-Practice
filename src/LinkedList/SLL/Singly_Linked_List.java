package LinkedList.SLL;

public class Singly_Linked_List {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Solution{
        public static void display(Node node){
            Node temp=node;
            while(temp != null){
                System.out.print(temp.data +"->");
                temp=temp.next;
            }
            System.out.print("null");
        }
        public static void main(String[] args) {
            Node node=new Node(5);
            Node node1=new Node(6);

            node.next=node1;
            display(node);
        }
    }
}
