package com.needforcode.algorithms;

import com.needforcode.queue.MyQueueSinglyLL;

/**
 * This is done using Level Order Traversal.
 * We insert a dummy Node in queue for each level.
 * Once dummy is encoutnered we increment height.
 */
public class BinaryTreeHeightUsingIteration {

    public static int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        MyQueueSinglyLL<Node> queue = new MyQueueSinglyLL();
        int height = 0; // declare initial height as zero

        queue.EnQueue(root);

        Node dummy = new Node(Integer.MIN_VALUE, null, null);
        queue.EnQueue(dummy); // insert dummy value after root since first level done.

        while (!queue.isEmpty()) {
            Node temp = queue.DeQueue();

            // if each level end is reached, increase height.
            if (temp.data.equals(Integer.MIN_VALUE)) {
                height++;
                if (!queue.isEmpty()) {
                    queue.EnQueue(dummy); // add dummy to end of new level.
                }
            }

            if (temp.left != null) {
                queue.EnQueue(temp.left);
            }
            if (temp.right != null) {
                queue.EnQueue(temp.right);
            }
        }
        return height - 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(getHeight(root));
    }

}


class Node {

    Integer data;
    Node left;
    Node right;

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
