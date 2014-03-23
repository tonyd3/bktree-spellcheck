package com.td.bktree;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class BKTreeTest extends TestCase {
    public void testBaseCase() {
        BKTree tree = new BKTree();
        tree.add("test");
        tree.add("free");
        List<String> results = tree.search("teste", 1);
        assertTrue(results.size() == 1);
        assertTrue(results.get(0) == "test");
    }

    public void testMultipleReturnValues() {
        BKTree tree = new BKTree();
        tree.add("test");
        tree.add("test1");
        List<String> results = tree.search("teste", 1);
        assertTrue(results.size() == 2);
        assertTrue(results.get(0) == "test");
    }

    public void testRepeatingSameValue() {
        BKTree tree = new BKTree();
        tree.add(Arrays.asList("test", "test", "test"));
        List<String> results = tree.search("teste", 1);
        assertTrue(results.size() == 1);
        assertTrue(results.get(0) == "test");
    }
}
