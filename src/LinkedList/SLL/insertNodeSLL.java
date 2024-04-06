package LinkedList.SLL;

public class insertNodeSLL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
        Node(int data,Node next) {
            this.data = data;
            this.next = next;
        }
    }

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
    static Node insertFirst(Node head,Node newNode){
//        Node temp=head;
//        if(head==null){
//            return newNode;
//        }
//        newNode.next=temp;
//        head=newNode;
        return new Node(newNode.data,head);
    }
    static Node insertLast(Node head,int val){
        Node temp=head;
        if(head==null){
            return new Node(val);
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(val);
        return head;
    }
    static Node insertAtKthPosition(Node head,int val,int k){
        Node temp=head;
        if(head==null){
            if(k==1){
                return new Node(val);
            }
            else{
                return null;
            }
        }
        if(k==1){
            Node temp2=new Node(val,head);
            return temp2;
        }
        int count=0;
        while(temp!=null){
            count++;
            if(count==k-1){
                Node between=new Node(val);
                between.next=temp.next;
                temp.next=between;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    static Node insertBeforeValue(Node head,int val,int ele){
        Node temp=head;
        if(head==null){
                    return null;

        }
        while(temp.next!=null){
            if(temp.next.data==val){
                Node between=new Node(ele,temp.next);
                temp.next=between;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    public static class Solution {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            Node newLL = convertArr2SLL(arr);
            //IntStream.range(1,arr.length).forEach(i->addLast(node,new Node(arr[i])));
            display(newLL);
            System.out.println("\n");

            Node addFirst=insertFirst(newLL,new Node(5));
            display(addFirst);


            System.out.println("\n");
            Node addLast=insertLast(newLL,8);
            display(addLast);

            System.out.println("\n");
            Node between= insertAtKthPosition(newLL,9,1);
            display(between);

            System.out.println("\n");
            Node before= insertBeforeValue(newLL,5,5);
            display(between);

        }
    }
}
