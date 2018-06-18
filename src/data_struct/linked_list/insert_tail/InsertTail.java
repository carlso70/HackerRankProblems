package data_struct.linked_list.insert_tail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static data_struct.linked_list.insert_tail.InsertTail.SinglyLinkedListNode.SinglyLinkedList.printSinglyLinkedList;

public class InsertTail {


    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null) return new SinglyLinkedListNode(data);

        SinglyLinkedListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
        temp.next = add;

        return head;
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        if (llist == null) return new SinglyLinkedListNode(data);

        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.next = llist;

        return node;
    }

    public static void main(String[] args) throws IOException {
        File f = new File("./src/data_struct/linked_list/insert_tail/insert-a-node-at-the-tail-of-a-linked-list" +
                "-testcases/input/input00.txt");

        Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        SinglyLinkedListNode.SinglyLinkedList llist = new SinglyLinkedListNode.SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

            llist.head = llist_head;
        }


        printSinglyLinkedList(llist.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        static class SinglyLinkedList {
            public SinglyLinkedListNode head;

            public SinglyLinkedList() {
                this.head = null;
            }


            public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
                while (node != null) {
                    bufferedWriter.write(String.valueOf(node.data));

                    node = node.next;

                    if (node != null) {
                        bufferedWriter.write(sep);
                    }
                }
            }
        }
    }
}
