package com.code.practise;

import java.util.*;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/07/13 9:40
 */
public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> dfsList = new ArrayList<>();

    Deque<Integer> deque = new LinkedList<>();


    public List<List<Integer>> pathSum(TreeNode root, int target) {

        if(root == null){
            return new ArrayList<>();
        }

        Deque<Integer> sumDeque = new LinkedList<>();

        Deque<TreeNode> treeDeque = new LinkedList<>();

        Map<TreeNode,TreeNode> treeNodeMap = new HashMap<>();

        treeDeque.offer(root);
        sumDeque.offer(0);

        while (!treeDeque.isEmpty()){


            TreeNode node = treeDeque.pollFirst();

            int rec =  sumDeque.pollFirst() + node.val;

            if(rec == target){
                dfsList.add(getList(node,treeNodeMap));
            }

            if(node.left != null){
                treeDeque.offer(node.left);
                treeNodeMap.put(node.left,node);
                sumDeque.offerLast(rec);
            }
            if(node.right != null){
                treeDeque.offer(node.right);
                treeNodeMap.put(node.right,node);
                sumDeque.offerLast(rec);
            }

        }

        return dfsList;
    }

    private List<Integer> getList(TreeNode node, Map<TreeNode,TreeNode> treeNodeMap){

        Deque<Integer> deque = new LinkedList<>();

        while(node != null){

            deque.addFirst(node.val);

            node = treeNodeMap.get(node);

        }

        return new ArrayList<>(deque);
    }

    private void dfs(TreeNode root, int target){

        if(root == null){
            return;
        }

        deque.offer(root.val);

        if((target -= root.val) == 0 ){
            dfsList.add(new ArrayList<>(deque));
            return;
        }

        dfs(root.left,target);
        dfs(root.right,target);

        deque.pollLast();

    }


}
