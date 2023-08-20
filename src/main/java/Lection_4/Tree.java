package Lection_4;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    public boolean exist(int value) {
        if (root != null) {
            Node node = findByPassInDepth(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    private Node findByPassInDepth(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) {
                Node result = findByPassInDepth(child, value);
                return result;
            }
        }
        return null;
    }

    private Node findByPassInBreadth(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);

        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);

            }
            line = nextLine;
        }
        return null;
    }


    public class Node {
        int value;
        List<Node> children;
    }
}
