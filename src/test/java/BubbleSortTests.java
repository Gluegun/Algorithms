import bubble_sort.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTests {

    int[] array = {2, 3, 6, 1, 10, -2, 15};

    @Test
    public void sort() {

        int[] sortedArray = {-2, 1, 2, 3, 6, 10, 15};
        BubbleSort.sort(array);

        Assert.assertArrayEquals(array, sortedArray);
    }

    @Test
    public void sort2() {

        int[] sortedArray = array;
        Arrays.sort(sortedArray);
        BubbleSort.sort(array);

        Assert.assertArrayEquals(array, sortedArray);

    }

    @org.junit.Test(expected = NullPointerException.class)
    public void sortWithNull() {

        array = null;
        BubbleSort.sort(array);

    }


}
