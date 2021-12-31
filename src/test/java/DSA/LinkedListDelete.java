package DSA;

import io.cucumber.java.mk_latn.No;

public class LinkedListDelete {
    Node head;
    static class Node{
        int data;
        Node next;
        public Node(int d){
            this.data=d;
            next=null;
        }
    }
    public void printList(){
        Node n=head;
        while(n!=null){
            System.out.print(n.data+"-->");
            n=n.next;
        }
    }
    public void delete(int key){
        Node temp=head,prev=null;

    }

    public static void main(String[] args){
        LinkedListDelete llList=new LinkedListDelete();
        llList.head=new Node(4);
        Node second=new Node(5);
        Node third=new Node(6);
        llList.head.next=second;
        second.next=third;
        llList.printList();

    }
}
