package linear;

/**将二叉查找树转换成双链表
 * 将一个二叉查找树按照中序遍历转换成双向链表。
 *样例
 给定一个二叉查找树：

                 4
                / \
               2   5
              / \
             1   3
 返回 1<->2<->3<->4<->5。
 *
 * Created by conleyzhu on 2018/2/26.
 * 解题思路：
 *      1）中序遍历时 LDR    12345
 *      2）创建一个队列，在中序遍历时将其添加进去，最终将其链接起来；就是一个双链表啦。
 */


import entity.DoublyListNode;
import entity.TreeNode;

public class BTreeToDoubleLinkedList {
    DoublyListNode head=new DoublyListNode(Integer.MAX_VALUE);//定义头节点
    /*
         * @param root: The root of tree
         * @return: the head of doubly list node
         */
    public DoublyListNode bstToDoublyList(TreeNode root) {

        return null;
    }

}
