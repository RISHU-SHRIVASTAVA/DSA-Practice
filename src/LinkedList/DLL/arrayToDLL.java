package LinkedList.DLL;

public class arrayToDLL {
    static class DLL{
        int data;
        DLL next;
        DLL prev;

        public DLL(int data) {
            this.data = data;
            this.next=null;
            this.prev=null;
        }

        public DLL(int data, DLL next, DLL prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    static DLL convertArrayToDLL(int[] arr){
        DLL head=new DLL(arr[0]);
        DLL prev=head;

        for(int i=1;i<arr.length;i++){
            DLL temp=new DLL(arr[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }

    static void display(DLL head){
        if(head==null){
            return;
        }
        DLL temp=head;
        while(temp.next!=null){
            System.out.println("Current: " + temp.data + " " + (temp.prev == null ? "Prev : null" : "Prev : " + temp.prev.data));
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};

        DLL head=convertArrayToDLL(arr);
        display(head);

    }
}
