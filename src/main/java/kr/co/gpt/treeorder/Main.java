package kr.co.gpt.treeorder;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        BinaryTree tree = new BinaryTree();
        System.out.println("===preOrder===");
        tree.preOrder(root);
        System.out.println("===inOrder===");
        tree.inOrder(root);
        System.out.println("===postOrder===");
        tree.postOrder(root);
        System.out.println("===getHeight===");
        System.out.println(tree.getHeight(root));
        System.out.println("===levelOrder===");
        tree.levelOrder(root);
        System.out.println();
        System.out.println("===levelOrderMaxCount===");
        tree.levelOrderMaxCount(root);
        System.out.println("===levelOrderSum===");
        tree.levelOrderSum(root);
        System.out.println("===levelOrderAverage===");
        tree.levelOrderAverage(root);
        System.out.println("===levelOrderMaxValue===");
        tree.levelOrderMaxValue(root);
        System.out.println("===levelOrderRightNode===");
        tree.levelOrderRightNode(root);
        System.out.println("===levelOrderLeftNode===");
        tree.levelOrderLastLeafNode(root);
    }
}
