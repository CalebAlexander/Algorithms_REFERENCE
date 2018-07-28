import org.junit.Test;
        import static org.junit.Assert.assertTrue;
        import static org.junit.Assert.assertArrayEquals;

        import java.util.Comparator;
        import java.util.Random;

/**
 * Tests for sorting algorithms
 *
 * @author Mary Xu
 * @version 1.0
 */
public class XuSortingTests {
    private Integer[] nums = new Integer[20];
    private ComparatorInt<Integer> comp = new ComparatorInt<>();
    private static final int TIMEOUT = 200;

    //---------------------------------------------------------------
    //------------------------- Bubble Sort -------------------------
    //---------------------------------------------------------------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsBubbleNullArr() {
        Sorting.bubbleSort(null, comp);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsBubbleNullComparator() {
        Sorting.bubbleSort(nums, null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsBubbleNullBoth() {
        Sorting.bubbleSort(null, null);
    }

    @Test(timeout = TIMEOUT)
    public void testBubbleSort() {
        for (int j = 0; j < 1000; j++) {
            Random rand = new Random();
            for (int i = 0; i < 20; i++) {
                nums[i] = rand.nextInt(1000);
            }
            Sorting.bubbleSort(nums, comp);
            for (int i = 0; i < 19; i++) {
                String track = "";
                for (int k = 0; k < nums.length; k++) {
                    track += nums[k] + ", ";
                }
                assertTrue("Failed array: " + i + ": " + track, nums[i] <= nums[i + 1]);
            }
        }
    }

    @Test(timeout = TIMEOUT)
    public void testBubbleSortStable() {
        ComparatorNewInt<Integer> comp2 = new ComparatorNewInt<>();
        NewInt[] nums = new NewInt[15];
        nums[0] = new NewInt(new Integer(5), 0);
        nums[1] = new NewInt(new Integer(976), 0);
        nums[2] = new NewInt(new Integer(333), 0);
        nums[3] = new NewInt(new Integer(54), 0);
        nums[4] = new NewInt(new Integer(5), 1);
        nums[5] = new NewInt(new Integer(15), 0);
        nums[6] = new NewInt(new Integer(5), 2);
        nums[7] = new NewInt(new Integer(497), 0);
        nums[8] = new NewInt(new Integer(17), 0);
        nums[9] = new NewInt(new Integer(239), 0);
        nums[10] = new NewInt(new Integer(672), 0);
        nums[11] = new NewInt(new Integer(333), 1);
        nums[12] = new NewInt(new Integer(1234), 0);
        nums[13] = new NewInt(new Integer(976), 1);
        nums[14] = new NewInt(new Integer(888), 0);

        NewInt[] sortedNums = new NewInt[15];
        sortedNums[0] = nums[0];
        sortedNums[1] = nums[4];
        sortedNums[2] = nums[6];
        sortedNums[3] = nums[5];
        sortedNums[4] = nums[8];
        sortedNums[5] = nums[3];
        sortedNums[6] = nums[9];
        sortedNums[7] = nums[2];
        sortedNums[8] = nums[11];
        sortedNums[9] = nums[7];
        sortedNums[10] = nums[10];
        sortedNums[11] = nums[14];
        sortedNums[12] = nums[1];
        sortedNums[13] = nums[13];
        sortedNums[14] = nums[12];

        Sorting.bubbleSort(nums, comp2);
        assertArrayEquals(nums, sortedNums);
    }

    //------------------------------------------------------------------
    //------------------------- Insertion Sort -------------------------
    //------------------------------------------------------------------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsInsertionNullArr() {
        Sorting.insertionSort(null, comp);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsInsertionNullComparator() {
        Sorting.insertionSort(nums, null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsInsertionNullBoth() {
        Sorting.insertionSort(null, null);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSort() {
        for (int j = 0; j < 100; j++) {
            Random rand = new Random();
            for (int i = 0; i < 20; i++) {
                nums[i] = rand.nextInt(1000);
            }
            Sorting.insertionSort(nums, comp);
            for (int i = 0; i < 19; i++) {
                String track = "";
                for (int k = 0; k < nums.length; k++) {
                    track += nums[k] + ", ";
                }
                assertTrue("Failed array: " + i + ": " + track, nums[i] <= nums[i + 1]);
            }
        }
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSortStable() {
        ComparatorNewInt<Integer> comp2 = new ComparatorNewInt<>();
        NewInt[] nums = new NewInt[15];
        nums[0] = new NewInt(new Integer(5), 0);
        nums[1] = new NewInt(new Integer(976), 0);
        nums[2] = new NewInt(new Integer(333), 0);
        nums[3] = new NewInt(new Integer(54), 0);
        nums[4] = new NewInt(new Integer(5), 1);
        nums[5] = new NewInt(new Integer(15), 0);
        nums[6] = new NewInt(new Integer(5), 2);
        nums[7] = new NewInt(new Integer(497), 0);
        nums[8] = new NewInt(new Integer(17), 0);
        nums[9] = new NewInt(new Integer(239), 0);
        nums[10] = new NewInt(new Integer(672), 0);
        nums[11] = new NewInt(new Integer(333), 1);
        nums[12] = new NewInt(new Integer(1234), 0);
        nums[13] = new NewInt(new Integer(976), 1);
        nums[14] = new NewInt(new Integer(888), 0);

        NewInt[] sortedNums = new NewInt[15];
        sortedNums[0] = nums[0];
        sortedNums[1] = nums[4];
        sortedNums[2] = nums[6];
        sortedNums[3] = nums[5];
        sortedNums[4] = nums[8];
        sortedNums[5] = nums[3];
        sortedNums[6] = nums[9];
        sortedNums[7] = nums[2];
        sortedNums[8] = nums[11];
        sortedNums[9] = nums[7];
        sortedNums[10] = nums[10];
        sortedNums[11] = nums[14];
        sortedNums[12] = nums[1];
        sortedNums[13] = nums[13];
        sortedNums[14] = nums[12];

        Sorting.insertionSort(nums, comp2);
        assertArrayEquals(nums, sortedNums);
    }

    //--------------------------------------------------------------
    //------------------------- Merge Sort -------------------------
    //--------------------------------------------------------------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsMergeNullArr() {
        Sorting.mergeSort(null, comp);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsMergeNullComparator() {
        Sorting.mergeSort(nums, null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsMergeNullBoth() {
        Sorting.mergeSort(null, null);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeSort() {
        for (int j = 0; j < 100; j++) {
            Random rand = new Random();
            for (int i = 0; i < 20; i++) {
                nums[i] = rand.nextInt(1000);
            }
            Sorting.mergeSort(nums, comp);
            for (int i = 0; i < 19; i++) {
                String track = "";
                for (int k = 0; k < nums.length; k++) {
                    track += nums[k] + ", ";
                }
                assertTrue("Failed array: " + i + ": " + track, nums[i] <= nums[i + 1]);
            }
        }
    }

    @Test(timeout = TIMEOUT)
    public void testMergeSortStable() {
        ComparatorNewInt<Integer> comp2 = new ComparatorNewInt<>();
        NewInt[] nums = new NewInt[15];
        nums[0] = new NewInt(new Integer(5), 0);
        nums[1] = new NewInt(new Integer(976), 0);
        nums[2] = new NewInt(new Integer(333), 0);
        nums[3] = new NewInt(new Integer(54), 0);
        nums[4] = new NewInt(new Integer(5), 1);
        nums[5] = new NewInt(new Integer(15), 0);
        nums[6] = new NewInt(new Integer(5), 2);
        nums[7] = new NewInt(new Integer(497), 0);
        nums[8] = new NewInt(new Integer(17), 0);
        nums[9] = new NewInt(new Integer(239), 0);
        nums[10] = new NewInt(new Integer(672), 0);
        nums[11] = new NewInt(new Integer(333), 1);
        nums[12] = new NewInt(new Integer(1234), 0);
        nums[13] = new NewInt(new Integer(976), 1);
        nums[14] = new NewInt(new Integer(888), 0);

        NewInt[] sortedNums = new NewInt[15];
        sortedNums[0] = nums[0];
        sortedNums[1] = nums[4];
        sortedNums[2] = nums[6];
        sortedNums[3] = nums[5];
        sortedNums[4] = nums[8];
        sortedNums[5] = nums[3];
        sortedNums[6] = nums[9];
        sortedNums[7] = nums[2];
        sortedNums[8] = nums[11];
        sortedNums[9] = nums[7];
        sortedNums[10] = nums[10];
        sortedNums[11] = nums[14];
        sortedNums[12] = nums[1];
        sortedNums[13] = nums[13];
        sortedNums[14] = nums[12];

        Sorting.mergeSort(nums, comp2);
        assertArrayEquals(nums, sortedNums);
    }

    //--------------------------------------------------------------
    //------------------------- Radix Sort -------------------------
    //--------------------------------------------------------------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsRadixPositives() {
        Sorting.lsdRadixSort(null);
    }

    @Test(timeout = TIMEOUT)
    public void testLsdRadixSort() {
        for (int j = 0; j < 100; j++) {
            Random rand = new Random();
            int[] nums = new int[20];
            for (int i = 0; i < 20; i++) {
                nums[i] = rand.nextInt(10000);
            }
            Sorting.lsdRadixSort(nums);
            for (int i = 0; i < 19; i++) {
                String track = "";
                for (int k = 0; k < nums.length; k++) {
                    track += nums[k] + ", ";
                }
                assertTrue("Failed array: " + i + ": " + track, nums[i] <= nums[i + 1]);
            }
        }
    }

    @Test(timeout = TIMEOUT)
    public void testRadixSortNegatives() {
        int[] nums = new int[15];
        nums[0] = 5;
        nums[1] = -976;
        nums[2] = -333;
        nums[3] = 54;
        nums[4] = -5;
        nums[5] = 15;
        nums[6] = 5;
        nums[7] = -497;
        nums[8] = 17;
        nums[9] = 239;
        nums[10] = -672;
        nums[11] = 333;
        nums[12] = -1234;
        nums[13] = 976;
        nums[14] = 888;

        int[] sortedNums = new int[15];
        sortedNums[0] = nums[12];
        sortedNums[1] = nums[1];
        sortedNums[2] = nums[10];
        sortedNums[3] = nums[7];
        sortedNums[4] = nums[2];
        sortedNums[5] = nums[4];
        sortedNums[6] = nums[0];
        sortedNums[7] = nums[6];
        sortedNums[8] = nums[5];
        sortedNums[9] = nums[8];
        sortedNums[10] = nums[3];
        sortedNums[11] = nums[9];
        sortedNums[12] = nums[11];
        sortedNums[13] = nums[14];
        sortedNums[14] = nums[13];

        Sorting.lsdRadixSort(nums);

        String track = "";
        for (int k = 0; k < nums.length; k++) {
            track += nums[k] + ", ";
        }
        assertArrayEquals("Your end array: " + track, nums, sortedNums);
    }

    @Test(timeout = TIMEOUT)
    public void testRadixSortAllMinValue() {
        int[] nums = {Integer.MIN_VALUE + 6, Integer.MIN_VALUE + 2,
                Integer.MIN_VALUE + 8, Integer.MIN_VALUE + 3, Integer.MIN_VALUE + 10,
                Integer.MIN_VALUE + 5, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 9,
                Integer.MIN_VALUE + 7, Integer.MIN_VALUE, Integer.MIN_VALUE + 4};
        int[] sortedNums = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1,
                Integer.MIN_VALUE + 2, Integer.MIN_VALUE + 3, Integer.MIN_VALUE + 4,
                Integer.MIN_VALUE + 5, Integer.MIN_VALUE + 6, Integer.MIN_VALUE + 7,
                Integer.MIN_VALUE + 8, Integer.MIN_VALUE + 9, Integer.MIN_VALUE + 10};
        Sorting.lsdRadixSort(nums);
        String track = "";
        for (int k = 0; k < nums.length; k++) {
            track += nums[k] + ", ";
        }
        assertArrayEquals("Your end array: " + track, nums, sortedNums);
    }

    @Test(timeout = TIMEOUT)
    public void testRadixSortAllMaxValue() {
        int[] nums = {Integer.MAX_VALUE - 6, Integer.MAX_VALUE - 2,
                Integer.MAX_VALUE - 8, Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 10,
                Integer.MAX_VALUE - 5, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 9,
                Integer.MAX_VALUE - 7, Integer.MAX_VALUE, Integer.MAX_VALUE - 4};
        int[] sortedNums = {Integer.MAX_VALUE - 10, Integer.MAX_VALUE - 9,
                Integer.MAX_VALUE - 8, Integer.MAX_VALUE - 7, Integer.MAX_VALUE - 6,
                Integer.MAX_VALUE - 5, Integer.MAX_VALUE - 4, Integer.MAX_VALUE - 3,
                Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        Sorting.lsdRadixSort(nums);
        String track = "";
        for (int k = 0; k < nums.length; k++) {
            track += nums[k] + ", ";
        }
        assertArrayEquals("Your end array: " + track, nums, sortedNums);
    }

    //-----------------------------------------------------------------
    //------------------------- Inner Classes -------------------------
    //-----------------------------------------------------------------

    private class NewInt {
        private Integer value;
        private int tag;

        /**
         * The constructor method
         *
         * @param value the value set
         * @param tag the tag set
         */
        public NewInt(Integer value, int tag) {
            this.value = value;
            this.tag = tag;
        }

        /**
         * Method to get the tag
         *
         * @return the tag
         */
        public int getTag() {
            return tag;
        }

        /**
         * Method to get the value
         *
         * @return the value
         */
        public Integer getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "" + value + "[" + tag + "]";
        }
    }

    private class ComparatorNewInt<T> implements Comparator<NewInt> {
        /**
         * Compares two objects
         *
         * @param a object 1
         * @param b object 2
         * @return whether a is greater than, equal to, or less than b
         */
        public int compare(NewInt a, NewInt b) {
            return a.getValue() - b.getValue();
        }
    }

    private class ComparatorInt<T> implements Comparator<T> {
        /**
         * Compares two integers
         *
         * @param a the first integer
         * @param b the second integer
         * @return shows which integer is larger
         */
        public int compare(T a, T b) {
            return (Integer) a - (Integer) b;
        }
    }
}