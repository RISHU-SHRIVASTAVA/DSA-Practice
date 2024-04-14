package LinkedList.SLL;

public class reverseSLL {
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
        static Node reverseSLL(Node head) {
            Node temp = head;
            Node dummy = null;
            Node newHead = null;

            while (temp != null) {
                newHead = temp.next;
                temp.next = dummy;

                dummy = temp;
                temp = newHead;
            }
            return dummy;
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};

            Node addLast = convertArr2SLL(arr);

            //IntStream.range(1,arr.length).forEach(i->addLast(node,new Node(arr[i])));
            display(addLast);
            Node reverse = reverseSLL(addLast);
            System.out.println();
            display(reverse);
        }
    }
}


