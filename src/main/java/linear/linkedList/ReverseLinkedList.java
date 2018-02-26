package linear.linkedList;

import entity.ListNode;

/**
 * 翻转一个链表
 * 样例
 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 *
 *
 * 原理其实就是把node.next 改为 node.prev即可，最后返回prev的指针
 * Created by conleyzhu on 2018/2/24.
 */
public class ReverseLinkedList {
    /*
        * @param head: n
        * @return: The new head of reversed linked list.
        */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        while (head != null) {
            //把当前节点的下一节点存到temp
            ListNode temp = head.next;
            //改变下一节点为前节点
            head.next = prev;
            //移动prev指针的位置，指示头位置方便返回
            prev = head;
            //继续遍历下一个节点
            head = temp;//可以替换为head = head.next
        }
        return prev;
    }




    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        System.out.println("翻转链表前=====================>");
        ListNode node = node1;
        while(node.next != null){
            System.out.print(node.val + ">");
            node= node.next;
        }
        System.out.println("\n翻转链表后=====================>");

        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode newNode = rll.reverse(node1);
        while(newNode.next != null) {
            System.out.print(newNode.val + ">");
            newNode = newNode.next;
        }

    }

}
