package petrovskyi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedSplitArrayTest {

    @Test
    @DisplayName("Should find element in array and return index")
    public void searchElementInArrayAndReturnIndex() {
        int[] arr = new int[]{5, 6, 1, 2, 3, 4};
        int value = 3;

        SortedSplitArrayService service = new SortedSplitArrayService();
        int index = service.findElem(arr, value);

        assertEquals(4, index); //number 3 has 4th index
    }

    @Test
    @DisplayName("Should find element in array and return index")
    public void searchAbsentElementInArray() {
        int[] arr = new int[]{5, 6, 1, 2, 3, 4};
        int value = 7;

        SortedSplitArrayService service = new SortedSplitArrayService();
        int index = service.findElem(arr, value);

        assertEquals(-1, index); //number 7 is absent in array
    }

    @Test
    @DisplayName("Should find element in array with 1M elements and return index")
    public void searchElementInArrayWith1M() {
        int[] arr1 = IntStream.range(0, 699_999).toArray();
        int[] arr2 = IntStream.range(700_000, 1_000_000).toArray();

        int[] concatenatedArray = new int[arr1.length + arr2.length];
        System.arraycopy(arr2, 0, concatenatedArray, 0, arr2.length);
        System.arraycopy(arr1, 0, concatenatedArray, arr2.length, arr1.length);

        SortedSplitArrayService service = new SortedSplitArrayService();

        int index = service.findElem(concatenatedArray, 568_123);
        assertEquals(868123, index);

        index = service.findElem(concatenatedArray, 700_050);
        assertEquals(50, index);

        index = service.findElem(concatenatedArray, 699_998);
        assertEquals(999_998, index);
    }

    @Test
    @DisplayName("Should find a leftmost element on the border of split array parts and return index")
    public void searchLeftmostBorderElementAndReturnIndex() {
        int[] arr = new int[]{5, 6, 7, 1, 2, 3, 4};

        SortedSplitArrayService service = new SortedSplitArrayService();

        int startIndex = 0;
        int finishIndex = arr.length - 1;
        int index = service.findEdge(arr, startIndex, finishIndex);

        assertEquals(2, index); //number 7 has 1st index
    }

    @Test
    @DisplayName("Should find an element in sorted array using binary search and return index")
    public void searchElementWithBinarySearch() {
        int[] arr = new int[]{1, 2, 3, 4, 8, 9, 10, 20, 100, 188};

        SortedSplitArrayService service = new SortedSplitArrayService();

        int startIndex = 0;
        int finishIndex = arr.length - 1;
        int index = service.binarySearch(arr, startIndex, finishIndex, 20);

        assertEquals(7, index); //number 20 has 7th index
    }

    @Test
    @DisplayName("Should return -1 for the element that is not in the array")
    public void searchAbsentElementWithBinarySearch() {
        int[] arr = new int[]{1, 2, 3, 4, 8, 9, 10, 20, 100, 188};

        SortedSplitArrayService service = new SortedSplitArrayService();

        int startIndex = 0;
        int finishIndex = arr.length - 1;
        int index = service.binarySearch(arr, startIndex, finishIndex, 99);

        assertEquals(-1, index); //number 99 is not in the array
    }
}
