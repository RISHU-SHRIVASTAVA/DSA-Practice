package LinkedList.SLL;

public class rotateSLL {
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

        static Node findKthNode(Node head, int k) {
            Node temp = head;
            while (k > 1 && temp != null) {
                temp = temp.next;
                k--;
            }
            return k > 1 ? null : temp;
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

        static Node rotateSLL(Node head,int k){
            if(head==null || k==0){
                return head;
            }
            Node temp=head;
            int count=1;
            while(temp.next!=null){
                temp=temp.next;
                count++;
            }
            if(k%count == 0) return head;
            k=k%count;
            temp.next=head;

            Node kthNode = findKthNode(head, count - k);

            head=kthNode.next;
            kthNode.next=null;

            return head;
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};

            Node addLast = convertArr2SLL(arr);

            //IntStream.range(1,arr.length).forEach(i->addLast(node,new Node(arr[i])));
            display(addLast);

            System.out.println();
            Node node = rotateSLL(addLast, 3);
            display(node);

        }
    }
}
