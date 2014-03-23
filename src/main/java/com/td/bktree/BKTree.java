package com.td.bktree;

import java.util.List;


public class BKTree {
    private BKNode root;

    public List<String> search(String str, int maxEditDistance) {
        return root.search(str, maxEditDistance);
    }

    public void add(String node) {
        if (node == null || node.isEmpty()) {
            return;
        }
        BKNode newNode = new BKNode(node);
        if (root == null) {
            root = newNode;
        } else {
            add(root, newNode);
        }
    }

    public void add(List<String> nodes) {
        for (String node : nodes) {
            add(node);
        }
    }

    private void add(BKNode srcNode, BKNode newNode) {
        if (srcNode.equals(newNode)) {
            return;
        }

        int distance = Utils.EditDistance(srcNode.value, newNode.value);
        BKNode bkNode = srcNode.childAtDistance(distance);
        if (bkNode == null) {
            srcNode.addChild(distance, newNode);
        } else {
            add(bkNode, newNode);
        }
    }
}
