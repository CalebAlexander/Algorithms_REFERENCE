
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;



public class HromiakSortingAdditionalTests {
    private static final int TIMEOUT = 200;

    @Test(timeout = TIMEOUT)
    public void testLSDRadixNegatives() {
        int[] unsortedArray = new int[] {-54, 28, 580, -84, 20, -1220, 3};
        int[] sortedArray = new int[] {-1220, -84, -54, 3, 20, 28, 580};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test(timeout = TIMEOUT)
    public void testSorted() {
        int[] unsortedArray = new int[] {-100, -9, -8, -7, 7, 8, 9, 10};
        int[] sortedArray = new int[] {-100, -9, -8, -7, 7, 8, 9, 10};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test(timeout = TIMEOUT)
    public void captnCrunchOopsAllNegatives() {
        int[] unsortedArray = new int[] {-30, -45, -14056, -33, -1, Integer.MIN_VALUE};
        int[] sortedArray = new int[] {Integer.MIN_VALUE, -14056, -45, -33, -30, -1};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }


    @Test(timeout = TIMEOUT)
    public void testLSDRadixMinValue() {
        int[] unsortedArray = new int[] {-54, 28, 58, -840, 20,
                Integer.MIN_VALUE, 85, 3};
        int[] sortedArray = new int[] {Integer.MIN_VALUE, -840, -54, 3, 20, 28,
                58, 85};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }



}
