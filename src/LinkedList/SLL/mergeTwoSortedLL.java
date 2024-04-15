package LinkedList.SLL;

public class mergeTwoSortedLL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class Solution {
        static void display(Node node) {
            Node temp = node;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.print("null");
        }
        static Node convertArr2SLL(int[] arr) {
            Node node = new Node(arr[0]);
            Node mover = node;
            for (int i = 1; i < arr.length; i++) {
                Node temp = new Node(arr[i]);
                mover.next = temp;
                mover = temp;
            }
            return node;
        }

        static Node mergeTwoSortedLL(Node head1,Node head2){
            Node t1=head1;
            Node t2=head2;
            Node dummy=new Node(-1);
            Node temp=dummy;

            while(t1!=null && t2!=null){
                if(t1.data>t2.data){
                 temp.next=t2;
                 temp=t2;
                 t2=t2.next;
                }
                else {
                    temp.next=t1;
                    temp=t1;
                    t1=t1.next;
                }
            }
            if(t1!=null){
                temp.next=t1;
            }
            else{
                temp.next=t2;
            }
            return dummy.next;
        }

        public static void main(String[] args) {
            int[] arr = {3,5,8,9};
            int[] arr2 = {1,2,4,6,7,8};

            Node ll1 = convertArr2SLL(arr);
            Node ll2 = convertArr2SLL(arr2);

            //IntStream.range(1,arr.length).forEach(i->addLast(node,new Node(arr[i])));
            display(ll1);
            System.out.println();
            display(ll2);

            System.out.println();
            Node node = mergeTwoSortedLL(ll1, ll2);
            display(node);

        }
    }
}
