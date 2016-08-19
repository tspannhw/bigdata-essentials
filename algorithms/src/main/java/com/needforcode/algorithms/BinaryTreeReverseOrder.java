package com.needforcode.algorithms;

import com.needforcode.adt.MyStack;
import com.needforcode.queue.MyQueueSinglyLL;
import com.needforcode.stack.MyStackLL;

/**
 *        1
 *      2   3
 *    4   5
 *  Output: 4 5 2 3 1
 */
public class BinaryTreeReverseOrder {

    public static void reverseOrder(Node root) {

        if(root == null) {
            return;
        }

        MyQueueSinglyLL<Node> queue = new MyQueueSinglyLL();

        MyStack<Integer> stack = new MyStackLL<Integer>();

        queue.EnQueue(root);

        while(!queue.isEmpty()) {

            Node temp = queue.DeQueue();

            if(temp.right != null) queue.EnQueue(temp.right);

            if(temp.left != null) queue.EnQueue(temp.left);

            stack.push(temp.data);
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        BinaryTreeReverseOrder.reverseOrder(root);

    }
}
