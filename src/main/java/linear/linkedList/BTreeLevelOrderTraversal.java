package linear.linkedList;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 * 样例
 给一棵二叉树 {3,9,20,#,#,15,7} ：

 3
 / \
 9  20
 /  \
 15   7
 返回他的分层遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
 *
 * 解题思路1：
 *      1）递归遍历，先遍历左子节点，每遍历一下就创建list，把节点加入list
 *      2）再遍历右子节点，把节点加入list
 *      难点在这个递归
 *
 * 解题思路2：
 *      1）巧用队列
 *      看C++代码
 *      http://blog.csdn.net/ljlstart/article/details/48502759
 *
 * Created by conleyzhu on 2018/2/26.
 */
public class BTreeLevelOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root != null) {
            List<Integer> first = new ArrayList<Integer>();
            list.add(first);
            first.add(root.val);
            //递归调用
            traverse(list, root.left, 1);
            traverse(list, root.right, 1);
        }
        return list;
    }

    /**
     * @param list: 通过参数传递来实现访问list
     * @param node: 欲遍历的结点
     * @param level: 当前结点的level（从0开始）
     */
    private void traverse(List<List<Integer>> list, TreeNode node, int level) {
        List<Integer> temp = null;
        //注意判空，让递归有出口
        if(node != null) {
            //若list长度与当前结点所在level相同，说明该level尚未有对应ArrayList，则需创建
            //否则说明已创建，直接从list取出，并添加当前结点val
            if(list.size() == level) {
                //左节点走这里
                temp = new ArrayList<Integer>();
                list.add(temp);
            } else {
                //这里主要是右节点走这里
                temp = list.get(level);
            }
            temp.add(node.val);
            traverse(list, node.left, level + 1);
            //注意这里level传的是int类型，不是引用类型，level值不会因为遍历左子节点而改变
            traverse(list, node.right, level + 1);
        }
    }


    /**
     * 这个方法比较容易理解，利用queue
     * 解题思路：
     *      1）利用queue来存储字节点，原则上栈也是可以
     *      2）拿出queue中的子节点来遍历，放入list
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null){
            return ret;
        }
        //因为ArrayBlockingQueue是JUC的类，所以用linkedList代替
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        int len = 1;
        while(!que.isEmpty()){
            List<Integer> base = new ArrayList<Integer>();
            len = que.size();
            for(int i =0;i<len;len++){
                TreeNode tmp = que.peek();
                base.add(tmp.val);
                que.poll();
                if(tmp.left != null){
                    que.offer(tmp.left);
                }
                if(tmp.right != null){
                    que.offer(tmp.right);
                }
            }
            ret.add(base);
        }
        return ret;
    }

}
