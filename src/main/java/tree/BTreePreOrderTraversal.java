package tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出一棵二叉树，返回其节点值的前序遍历。
 * 样例
 给出一棵二叉树 {1,#,2,3},

        1
        \
         2
        /
       3
 返回 [1,2,3].
 *
 * Created by Conley on 2018/2/28.
 * 思路：前序遍历   DLR
 *  1:递归，这个应该背下来
 *  2:用栈，其实递归也是压栈的过程
 *
 */
public class BTreePreOrderTraversal {
    /*
    * @param root: A Tree
    * @return: Preorder in ArrayList which contains node values.
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if(root==null){
            //递归的出口
            return new ArrayList();
        }
        List<Integer> resultList=new ArrayList<Integer>();
        resultList.add(root.val);
        /**其实很容易理解，就没一个子节点都遵循DLR**/
        resultList.addAll(preorderTraversal(root.left));//addAll(list),list没元素就加不了
        resultList.addAll(preorderTraversal(root.right));
        return resultList;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root==null){
            return null;
        }
        List<Integer> resultList=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode tempNode=null;
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                resultList.add(root.val);
                stack.push(root);
                root=root.left;
            }else{
                tempNode=stack.pop();
                root=tempNode.right;
            }
        }
        return resultList;
    }

}
