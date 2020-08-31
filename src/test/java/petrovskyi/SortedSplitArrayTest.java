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
}
