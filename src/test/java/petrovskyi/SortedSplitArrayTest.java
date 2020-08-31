package petrovskyi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedSplitArrayTest {

    @Test
    @DisplayName("Should find element in array and return index")
    public void searchElementInArrayAndReturnIndex() {
        int[] arr = new int[]{5, 6, 1, 2, 3, 4};
        int value = 3;

        SortedSplitArrayService service = new SortedSplitArrayService();
        int index = service.findElem(arr, value);

        assertEquals(4, index);
    }

    @Test
    @DisplayName("Should find a leftmost element on the border of split array parts and return index")
    public void searchLeftmostBorderElementAndReturnIndex() {
        int[] arr = new int[]{5, 6, 7, 1, 2, 3, 4};

        SortedSplitArrayService service = new SortedSplitArrayService();

        int startIndex = 0;
        int finishIndex = arr.length-1;
        int index = service.findEdge(arr, startIndex, finishIndex);

        assertEquals(2, index); //number 7 has 1st index
    }
}
