package functional;

//public class LoopSum {
//
//    private static int sum(int[] arr) {
//        int total = 0;
//        for (int x = 0; x < arr.length; x++) {
//            total += arr[x];
//        }
//
//        return total;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(sum(new int[]{1, 2, 3, 4})); // 10
//    }
//}

public class LoopSum{
	private static int LoopSum(int[] arr, int index) {
		if(index == arr.length) {
			return 0;
		}else {
			return arr[index] + LoopSum(arr, index +1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		System.out.println(LoopSum(arr, 0));
	}
	
}