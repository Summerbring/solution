package com.code.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/07/08 15:37
 */
public class BuildTree {

    public static void main(String[] args) {
        new BuildTree().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    HashMap<Integer,Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode rootNode = new TreeNode(preorder[0]);

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        int root = map.get(rootNode.val);

        build(preorder,root,inorder.length - 1 - root,1,rootNode);

        return rootNode;

    }

    public void build(int[] preorder, int left, int right,int level, TreeNode rootNode){

        System.out.println("left = " + left + " , " + "right = " + right);

        if(left > 0){
            TreeNode leftNode = new TreeNode(preorder[level]);
            rootNode.left = leftNode;

            int nextLeft = map.get(leftNode.val) - map.get(preorder[level + 1]);
            int nextRight = map.get(rootNode.val) - map.get(leftNode.val);

            build(preorder,nextLeft,nextRight,level+1,leftNode);
        }
        if(right > 0){
            TreeNode rightNode = new TreeNode(preorder[level + left]);
            rootNode.right = rightNode;

            int nextLeft = map.get(rightNode.val) - map.get(rootNode.val) - 1;
            int nextRight = map.get(preorder[level + nextLeft + 1]) - map.get(rightNode.val);

            build(preorder,nextLeft,nextRight,level+1,rightNode);
        }

    }


    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


}
