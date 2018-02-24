package linear.linkedList;

/**给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 你应该保留两部分内链表节点原有的相对顺序。

 样例
 给定链表 1->4->3->2->5->2->null，并且 x=3
 返回 1->2->2->4->3->5->null


 * Created by conleyzhu on 2018/2/24.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        //这里leftDummy是指向left的头结点，方便返回
        ListNode leftDummy = left;
        //这里rightDummy是指向right的头结点，方便连接leftDummy
        ListNode rightDummy = right;
        while(head!=null){
            if(head.val<x){
                left.next = head;
                //这里是把left指向Head实体
                left = head;
            }else{
                right.next = head;
                //这里是把right指向Head实体
                right = head;
            }
            head = head.next;
        }
        left.next = rightDummy.next;//next就巧妙把0去掉了
        right.next = null;
        return leftDummy.next;//next就巧妙把0去掉了
    }


    public static void main(String[] args) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(1);
        ListNode leftDummy = left;
        System.out.println(leftDummy.next);
        left.next =right;
        System.out.println(leftDummy.next.val);

    }
}
