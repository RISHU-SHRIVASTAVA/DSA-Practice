package LinkedList.SLL;

public class deleteNodeSLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class Solution{
        static void display(Node node){
            Node temp=node;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.print("null");
        }
        static Node convertArr2SLL(int[] arr){
           Node node=new Node(arr[0]);
            Node mover=node;
            for (int i=1;i<arr.length;i++) {
                Node temp=new Node(arr[i]);
                mover.next=temp;
                mover=temp;
            }
            return node;
        }
        static Node removeHead(Node head){
            if(head==null){
                return head;
            }
            return head.next;
        }

        static Node removeTail(Node head){
            if(head==null || head.next==null){
                return null;
            }
            Node temp=head;
            while (temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
            return head;
        }
        static Node deleteKNode(Node head, int k){
            if(head==null){
                return head;
            }
            if(k==1){
                return head.next;
            }
            Node temp=head;
            Node prev=null;
            int count=0;

            while(temp!=null){
                count++;
                if(count==k){
                    prev.next=prev.next.next;
                    break;
                }
                prev=temp;
                temp=temp.next;
            }
            return head;
        }
        static Node deleteKElement(Node head, int ele){
            if(head==null){
                return head;
            }
            if(head.data==ele){
                return head.next;
            }
            Node temp=head;
            Node prev=null;

            while(temp!=null){
                if(temp.data==ele){
                    prev.next=prev.next.next;
                    break;
                }
                prev=temp;
                temp=temp.next;
            }
            return head;
        }

        static Node deleteNode(Node head,Node value){
            Node temp=head;
            if(temp==null || temp.next==null){//if LL is empty or has only one element
                return temp;
            }
            else if(temp.data==value.data){ //if the node to be deleted is first node
                return temp.next;
            }
            while(temp.next!=null){//if the node to be deleted is middle node
                if(temp.next.data==value.data){
                    temp.next=temp.next.next;
                }
                temp=temp.next;
            }
            return head;
        }

        public static void main(String[] args) {
            int[] arr ={1,2,3,4,5};
            Node addLast=convertArr2SLL(arr);
            //IntStream.range(1,arr.length).forEach(i->addLast(node,new Node(arr[i])));
            display(addLast);

            Node removeTail=removeTail(addLast);
            System.out.println("\nRemove Tail : ");
            display(removeTail);

            Node removeHead = removeHead(addLast);
            System.out.println("\nRemove Head : ");
            display(removeHead);
            System.out.println("\n\n");
            display(addLast);

            Node removeKth = deleteKNode(addLast,10);
            System.out.println("\nRemove Kth : ");
            display(removeKth);
        }

    }
}
