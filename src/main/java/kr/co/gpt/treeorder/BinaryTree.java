package kr.co.gpt.treeorder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinaryTree {

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data + " ");
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void levelOrder(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void levelOrderMaxCount(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int maxWidth = 0;
        int level = 0;
        int maxLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            if (levelSize > maxLevel) {
                maxWidth = levelSize;
                maxLevel = level;
            }

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            level++;
        }

        System.out.println("가장 넓은 레벨: " + maxLevel + ", 너비: " + maxWidth);
    }

    public void levelOrderSum(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        while (!queue.isEmpty()) {

            int sum = 0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                sum += current.data;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            System.out.println("level: " + level + ", sum: " + sum);
            level++;
        }
    }

    public void levelOrderAverage(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        while (!queue.isEmpty()) {

            int sum = 0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                sum += current.data;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            double average = (double) sum / levelSize;

            System.out.println("level: " + level + ", average: " + average);
            level++;
        }
    }

    public void levelOrderMaxValue(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        while (!queue.isEmpty()) {

            int maxValue = 0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                maxValue = Math.max(current.data, maxValue);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            System.out.println("level: " + level + ", maxValue: " + maxValue);
            level++;
        }
    }

    public void levelOrderRightNode(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        List<List<Node>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Node> levelValues = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

                levelValues.add(current);
            }
            result.add(levelValues);
            level++;
        }
        IntStream.range(0, result.size())
                .forEach(i -> {
                    List<Node> nodes = result.get(i);
                    int data = nodes.stream().reduce((a, b) -> b).get().data;
                    System.out.println("level: " + i + ", rightValue: " + data);
                });
    }

    public void levelOrderLastLeafNode(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        List<List<Node>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Node> levelValues = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

                levelValues.add(current);
            }
            result.add(levelValues);
            level++;
        }
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.println("level: " + i + ", lastLeafNode: " + result.get(i).stream().map(x -> x.data)
                        .collect(Collectors.toList()));
            }
        }
    }

    public void levelOrderOddNode(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data % 2 != 0) {
                System.out.print(current.data + " ");
            }

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void levelOrderEvenNode(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data % 2 == 0) {
                System.out.print(current.data + " ");
            }

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void levelOrderMinValue(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        Map<Integer, Integer> minValues = new HashMap<>();
        while (!queue.isEmpty()) {

            int minValue = Integer.MAX_VALUE;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                minValue = Math.min(current.data, minValue);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            minValues.putIfAbsent(level, minValue);
            level++;
        }
        minValues.entrySet().stream().forEach(entry -> {
            System.out.println("level: " + entry.getKey() + ", minValue: " + entry.getValue());
        });
    }

    public void levelOrderOrderedValue(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        List<List<Node>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Node> levelValues = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

                levelValues.add(current);
            }
            result.add(levelValues);
            level++;
        }
        IntStream.range(0, result.size())
                .forEach(i -> {
                    List<Node> nodes = result.get(i);
                    Stream<Integer> data = nodes.stream().map(x -> x.data).sorted();
                    System.out.println("level: " + i + ", rightValue: " + data);
                });
    }

    public void levelOrderMapLevelList(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        Map<Integer, List<Node>> totalValues = new HashMap<>();
        while (!queue.isEmpty()) {

            int minValue = Integer.MAX_VALUE;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (totalValues.get(current) == null) {
                    totalValues.putIfAbsent(level, new ArrayList<>());
                }
                totalValues.get(current).add(current);

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            level++;
        }

        totalValues.entrySet()
                .forEach(entry -> {
                    System.out.println("level: " + entry.getKey() + ", totalValues: " + entry.getValue());
                });
    }

    public void levelOrderMaxValuesLevelList(Node node) {}
}
