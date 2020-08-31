package petrovskyi;

public class SortedSplitArrayService {
    public int findElem(int[] arr, int value) {
        return 0;
    }

    int findEdge(int arr[], int startIndex, int finishIndex) {
        if (startIndex == finishIndex) {
            return startIndex;
        }

        int middle = (startIndex + finishIndex) / 2;
        if (middle < finishIndex && arr[middle] > arr[middle + 1]) {
            return middle;
        }
        if (middle > startIndex && arr[middle] < arr[middle - 1]) {
            return (middle - 1);
        }
        if (arr[startIndex] >= arr[middle]) {
            return findEdge(arr, startIndex, middle - 1);
        }

        return findEdge(arr, middle + 1, finishIndex);
    }
}
