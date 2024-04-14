package LinkedList.DLL;

public class deleteNodeDLL {
    static class DLL {
        int data;
        DLL next;
        DLL prev;

        public DLL(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public DLL(int data, DLL next, DLL prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    static DLL convertArrayToDLL(int[] arr) {
        DLL head = new DLL(arr[0]);
        DLL prev = head;

        for (int i = 1; i < arr.length; i++) {
            DLL temp = new DLL(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    static void display(DLL head) {
        if (head == null) {
            return;
        }
        DLL temp = head;
        while (temp.next != null) {
            System.out.println("Current: " + temp.data + " " + (temp.prev == null ? "Prev : null" : "Prev : " + temp.prev.data));
            temp = temp.next;
        }
    }

    static DLL deleteFirstNode(DLL head) {
        if (head == null || head.next == null) {
            return head;
        }
        DLL prev = head;
        head = head.next;

        head.prev = null;
        prev.next = null;

        return head;

    }
    static DLL deleteTailNode(DLL head) {
        if(head==null || head.next==null){
            return null;
        }
        DLL tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        DLL newTail=tail.prev;
        newTail.next=null;
        tail.prev=null;

        return head;
    }

    private static DLL deleteKthNode(DLL head,int k) {
        if(head==null){
            return null;
        }
        int count=0;
        DLL kNode=head;
        while(kNode!=null){
            count++;
            if(count==k) break;
            kNode=kNode.next;
        }
        DLL prev=kNode.prev;
        DLL front=kNode.next;

        if(prev==null && front==null){
            return null;
        }
        else if(prev==null){
            return deleteFirstNode(head);
        }
        else if(front==null){
            return deleteTailNode(head);
        }
        prev.next=front;
        front.prev=prev;

        return head;
    }

    static void deleteNode(DLL node){
        DLL prev=node.prev;
        DLL front=node.next;

        if(front==null){
            prev.next=null;
            node.prev=null;
        }
        prev.next=front;
        front.prev=prev;
        
        node.next=node.prev=null;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,6,7,8,9};

        DLL head = convertArrayToDLL(arr);
        display(head);
        System.out.println();

        DLL head2= deleteFirstNode(head);
        display(head2);
        System.out.println();

        DLL head3= deleteTailNode(head2);
        display(head3);
        System.out.println();

        DLL head4= deleteKthNode(head3,1);
        display(head4);

    }




}


