package DSA;

import io.cucumber.java.mk_latn.No;

public class doubleLinkedList {
    Node head;
    class Node{
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int d) { data = d; }

    }
    public void push(int data){
        Node new_node=new Node(data);
        new_node.next=head;
        new_node.prev=null;
        if(head!=null){
            head.prev=new_node;
        }
        head=new_node;

    }

    public void insertBefore(Node next_node,int data){
        if(next_node == null)
        {
            System.out.println("The given next node can not be NULL");
            return;
        }
        Node new_node=new Node(data);
        new_node.prev=next_node.prev;
        next_node.prev=new_node;
        new_node.next=next_node;
        if(new_node.prev!=null){
            new_node.prev.next=new_node;
        }
        else{
            head=new_node;
        }

    }
    public void insertAfter(Node prevNode,int data){
        if(prevNode==null){
            System.out.println("The given next node can not be NULL");
            return;
        }
        Node new_node=new Node(data);
        new_node.prev=prevNode;
        new_node.next=prevNode.next;
        prevNode.next=new_node;
        if(new_node.next!=null){
            new_node.next.prev=new_node;
        }
    }
    public void append(int data){
        Node new_node=new Node(data);
        Node last=head;
        new_node.next=null;
        if(head==null){
           new_node.prev=null;
           head=new_node;
           return;
        }
        while(last.next!=null){
            last=last.next;
        }
        last.next=new_node;
        new_node.prev=last;
    }
}
