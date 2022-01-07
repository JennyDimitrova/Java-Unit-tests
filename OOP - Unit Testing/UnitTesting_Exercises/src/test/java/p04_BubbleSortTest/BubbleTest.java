package p04_BubbleSortTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    private Bubble bubble;

    @Before
    public void init() {
        bubble = new Bubble();
    }

    @Test
    public void test_sortWorksFine() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = {1, 2, 5, 4, 3};
        bubble.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_sortIncorrect() {
        int[] actual = {1, 2, 5, 4, 3};
        int[] expected = {1, 3, 2, 4, 5};
        bubble.sort(actual);
        assertNotEquals(expected, actual);
    }
}