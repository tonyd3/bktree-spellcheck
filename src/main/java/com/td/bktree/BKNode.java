package com.td.bktree;

import java.util.*;

public class BKNode {
    public final String value;
    private final Map<Integer, BKNode> children = new HashMap<Integer, BKNode>();

    public BKNode(String value) {
        this.value = value;
    }

    public BKNode childAtDistance(int pos) {
        return children.get(pos);
    }

    public void addChild(int pos, BKNode child) {
        children.put(pos, child);
    }

    public List<String> search(String node, int maxEditDistance) {
        List<String> matches = new ArrayList<String>();
        int distance = Utils.EditDistance(value, node);
        if (distance <= maxEditDistance) {
            matches.add(value);
        }

        if (children.size() == 0)
            return matches;

        for (int i = Math.max(1, distance - maxEditDistance); i <= distance + maxEditDistance; i++) {
            BKNode child = children.get(i);
            if (child != null) {
                matches.addAll(child.search(node, maxEditDistance));
            }
        }
        return matches;
    }

    public boolean equals(BKNode otherNode) {
        return value.equals(otherNode.value);
    }
}
