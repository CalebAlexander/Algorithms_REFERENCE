import java.util.Comparator;
import java.util.ArrayList;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Caleb Alexander
 * @userid calexander49
 * @GTID 903133971
 * @version 1.0
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     *  in-place
     *  stable
     *  adaptive
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("Cannot"
                    + " sort null data in the array.");
        } else {
            boolean keepSorting = true;
            int finalIndex = arr.length - 1;
            while (keepSorting) {
                keepSorting = false;
                for (int i = 0; i < finalIndex; i++) {
                    if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                        T temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        keepSorting = true;
                    }
                }
                finalIndex--;
            }
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     *  in-place
     *  stable
     *  adaptive
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("Cannot"
                    + " sort null data in the array.");
        } else {
            int j;
            for (int i = 1; i < arr.length; i++) {
                j = i;
                while (j > 0 && comparator.compare(arr[j - 1], arr[j]) > 0) {
                    T temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    j--;
                }
            }
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(n log n)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * You can create more arrays to run mergesort, but at the end,
     * everything should be merged back into the original T[]
     * which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("Cannot"
                    + " sort null data in the array.");
        } else {
            if (arr.length > 1) {
                int length = arr.length;
                int mid = length / 2;
                T[] leftArray = copyArray(arr, 0, mid - 1);
                T[] rightArray = copyArray(arr, mid, length - 1);

                mergeSort(leftArray, comparator);
                mergeSort(rightArray, comparator);

                int leftIndex = 0;
                int rightIndex = 0;
                int currentIndex = 0;
                while (leftIndex < leftArray.length
                        && rightIndex < rightArray.length) {
                    if (comparator.compare(
                            leftArray[leftIndex],
                            rightArray[rightIndex]) <= 0) {
                        arr[currentIndex] = leftArray[leftIndex];
                        leftIndex++;
                    } else {
                        arr[currentIndex] = rightArray[rightIndex];
                        rightIndex++;
                    }
                    currentIndex++;
                }
                while (leftIndex < leftArray.length) {
                    arr[currentIndex] = leftArray[leftIndex];
                    currentIndex++;
                    leftIndex++;
                }
                while (rightIndex < rightArray.length) {
                    arr[currentIndex] = rightArray[rightIndex];
                    currentIndex++;
                    rightIndex++;
                }
            }
        }
    }

    /**
     *  Helper function to copy sections of an array
     * @param input input array
     * @param start starting array
     * @param stop stop array
     * @param <T> Generic variable T
     * @return copied section of array
     */
    @SuppressWarnings("unchecked")
    private static <T> T[] copyArray(T[] input, int start, int stop) {
        T[] output = (T[]) new Object[stop - start + 1];
        int outputIndex = 0;
        for (int i = start; i <= stop; i++) {
            output[outputIndex] = input[i];
            outputIndex++;
        }
        return output;
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(kn)
     *
     * And a best case running time of:
     *  O(kn)
     *
     * Refer to the PDF for more information on LSD Radix Sort.
     *
     * You may use {@code java.util.ArrayList} or {@code java.util.LinkedList}
     * if you wish, but it may only be used inside radix sort and any radix sort
     * helpers. Do NOT use these classes with other sorts.
     *
     * @throws IllegalArgumentException if the array is null
     * @param arr the array to be sorted
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new java.lang.IllegalArgumentException("Cannot sort"
                    + " array with null data;");
        } else {
            ArrayList<Integer>[] bucket = new ArrayList[19];
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new ArrayList<Integer>();
            }
            boolean keepgoing = true;
            int moded = 0;
            int divisor = 1;

            while (keepgoing) {
                keepgoing = false;
                for (Integer i : arr) {
                    moded = i / divisor;
                    if (i < 0) {
                        bucket[(Math.abs(moded) % 10) + 9].add(i);
                    } else {
                        bucket[moded % 10].add(i);
                    }

                    if (!keepgoing && moded > 0) {
                        keepgoing = true;
                    }
                }

                int j = 0;
                for (int i = 18; i > 9;  i--) {
                    for (Integer num : bucket[i]) {
                        arr[j] = num;
                        j++;
                    }
                    bucket[i].clear();
                }
                for (int i = 0; i < 10;  i++) {
                    for (Integer num : bucket[i]) {
                        arr[j] = num;
                        j++;
                    }
                    bucket[i].clear();
                }

                divisor = divisor * 10;
            }
        }
    }
}
