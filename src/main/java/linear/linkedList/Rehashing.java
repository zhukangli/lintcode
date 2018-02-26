package linear.linkedList;

/**
 *
 *
 * 哈希表容量的大小在一开始是不确定的。如果哈希表存储的元素太多（如超过容量的十分之一），
 * 我们应该将哈希表容量扩大一倍，并将所有的哈希值重新安排。假设你有如下一哈希表：

 size=3, capacity=4

 [null, 21, 14, null]
 ↓    ↓
 9   null
 ↓
 null
 哈希函数为：

 int hashcode(int key, int capacity) {
 return key % capacity;
 }
 这里有三个数字9，14，21，其中21和9共享同一个位置因为它们有相同的哈希值1(21 % 4 = 9 % 4 = 1)。我们将它们存储在同一个链表中。

 重建哈希表，将容量扩大一倍，我们将会得到：

 size=3, capacity=8

 index:   0    1    2    3     4    5    6   7
 hash : [null, 9, null, null, null, 21, 14, null]
 给定一个哈希表，返回重哈希后的哈希表。

 注意事项

 哈希表中负整数的下标位置可以通过下列方式计算：

 C++/Java：如果你直接计算-4 % 3，你会得到-1，你可以应用函数：a % b = (a % b + b) % b得到一个非负整数。
 Python：你可以直接用-1 % 3，你可以自动得到2。
 *
 * Created by Conley on 2018/2/25.
 * 解题思路：
 *      1）建立一个两倍大小的哈希表
 *      2）遍历原来的hash表，进行rehash，找到对应的位置即可
 *      3）注意，新的hash表也可能有冲突，要处理这种情况
 *
 */
public class Rehashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        //扩容2倍长度
        int cap = hashTable.length*2;
        ListNode[] res = new ListNode[cap];
        for (int i = 0; i < cap/2; i++) {
            ListNode cur = hashTable[i];//cur为当前的hash表位置
            //遍历哈希表当前位置上的链表，进行rehash找位置
            while (cur != null) {
                ListNode node = new ListNode(cur.val);//node为当前链表的节点
                //重新寻找位置 a % b = (a % b + b) % b
                int index = (cur.val%cap + cap)%cap;
                if (res[index] == null) {
                    res[index] = node;
                } else {
                    ListNode dummyNode =  res[index];//链表的首节点
                    while (dummyNode.next != null){
                        dummyNode = dummyNode.next;//得到链表的尾节点
                    }
                    dummyNode.next = node;//链接在尾节点上
                }
                //继续链表的下一个元素
                cur = cur.next;
            }
        }
        return res;
    }

}
