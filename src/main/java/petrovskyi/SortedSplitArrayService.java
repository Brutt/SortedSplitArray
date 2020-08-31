package petrovskyi;

public class SortedSplitArrayService {
    public int findElem(int[] arr, int value) {
        int edge = findEdge(arr, 0, arr.length);

        if (arr[edge] == value) {
            return edge;
        }
        if (arr[0] <= value) {
            return binarySearch(arr, 0, edge, value);
        }

        return binarySearch(arr, edge + 1, arr.length, value);
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

    int binarySearch(int arr[], int startIndex, int finishIndex, int value) {
        if (finishIndex < startIndex) {
            return -1;
        }

        int middle = (startIndex + finishIndex) / 2;
        if (value == arr[middle]) {
            return middle;
        }
        if (value > arr[middle]) {
            return binarySearch(arr, (middle + 1), finishIndex, value);
        }

        return binarySearch(arr, startIndex, (middle - 1), value);
    }
}
