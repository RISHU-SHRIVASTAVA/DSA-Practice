package LinkedList.SLL;

public class reverseKthLL {
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

        static void reverseSLL(Node head) {
            Node temp = head;
            Node dummy = null;
            Node newHead = null;

            while (temp != null) {
                newHead = temp.next;
                temp.next = dummy;

                dummy = temp;
                temp = newHead;
            }

        }

        static Node findKthNode(Node head, int k) {
            Node temp = head;
            while (k > 1 && temp != null) {
                temp = temp.next;
                k--;
            }
            return k > 1 ? null : temp;
        }

        static Node reverseKthLL(Node head, int k) {
            Node temp = head;
            Node nextNode = null;
            Node previousNode = null;

            while (temp != null) {
                Node kthNode = findKthNode(temp, k);
                System.out.println(kthNode !=null ? kthNode.data:kthNode);
                if (kthNode == null) {
                        if(previousNode!=null){
                            previousNode.next=temp;
                            break;
                        }
                } else {
                    nextNode = kthNode.next;
                    kthNode.next = null;
                    reverseSLL(temp);

                    if (temp == head) {
                        head = kthNode;
                    } else {
                        previousNode.next = kthNode;
                    }
                }
            previousNode = temp;
            temp = nextNode;
            }
            return head;
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};

            Node LL = convertArr2SLL(arr);

            //IntStream.range(1,arr.length).forEach(i->addLast(node,new Node(arr[i])));
            display(LL);
//            Node reverse = reverseSLL(addLast);
//            System.out.println();
//            display(reverse);
//            Node temp = findKthNode(reverse, 5);
//            System.out.println("\n" + (temp != null ? temp.data : "null"));
            System.out.println();
            System.out.println();
            Node newww=reverseKthLL(LL,6);
            display(newww);


        }
    }
}
