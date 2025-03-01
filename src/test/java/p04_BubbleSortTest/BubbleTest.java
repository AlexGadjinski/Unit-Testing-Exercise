package p04_BubbleSortTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleTest {

    @Test
    public void test_UnorderedArrayProvided_ReturnsOrderedArray() {
        int[] arrayToModify = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] orderedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Bubble.sort(arrayToModify);
        assertArrayEquals(orderedArr, arrayToModify);
    }
}
