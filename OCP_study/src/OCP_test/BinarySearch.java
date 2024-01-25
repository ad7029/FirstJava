package OCP_test;

public class BinarySearch {
	//二元搜尋法

    // has to return boxed integer in order to comfort to interface defined in the book
    private static Integer binarySearch(int[] list, int item) {
        //搜尋範圍
    	int low = 0;
        int high = list.length - 1;

        while (low <= high) {//還沒縮小範圍到只剩一個元素時就檢查中間數
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] myList = {1, 3, 5, 7, 9};

        System.out.println(binarySearch(myList, 5)); // 1
        System.out.println(binarySearch(myList, -1)); // null
    }
}
