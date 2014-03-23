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
        assertEquals(1, results.size());
        assertEquals("test", results.get(0));
    }

    public void testMultipleReturnValues() {
        BKTree tree = new BKTree();
        tree.add("test");
        tree.add("test1");
        List<String> results = tree.search("teste", 1);
        assertEquals(2, results.size());
        assertEquals("test", results.get(0));
    }

    public void testRepeatingSameValue() {
        BKTree tree = new BKTree();
        tree.add(Arrays.asList("test", "test", "test"));
        List<String> results = tree.search("teste", 1);
        assertEquals(1, results.size());
        assertEquals("test", results.get(0));
    }
}
