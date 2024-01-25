//package functional;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Quicksort {
//    public static void main(String[] args) {
//        System.out.println(quicksort(Arrays.asList(10, 5, 2, 3))); // [2, 3, 5, 10]
//    }
//
//    private static List<Integer> quicksort(List<Integer> list) {
//        if (list.size() < 2) {
//            // base case, arrays with 0 or 1 element are already "sorted"
//            return list;
//        } else {
//            // recursive case
//            Integer pivot = list.get(0);
//
//            // sub-array of all the elements less than the pivot
//            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot)
//                    .collect(Collectors.toList());
//
//            // sub-array of all the elements greater than the pivot
//            List<Integer> greater = list.stream().skip(1).filter(el -> el > pivot)
//                    .collect(Collectors.toList());
//
//            return Stream.of(
//                    quicksort(less).stream(),
//                    Stream.of(pivot),
//                    quicksort(greater).stream())
//                    .flatMap(Function.identity()).collect(Collectors.toList());
//        }
//    }
//}

package functional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quicksort {

    public static void main(String[] args) {
        List<Integer> list = List.of(10, 5, 2, 3);
        System.out.println(quicksort(list)); // [2, 3, 5, 10]
    }

    /**
     * 對整數清單進行快速排序
     *
     * @param list 待排序的整數清單
     * @return 排序後的整數清單
     */
    private static List<Integer> quicksort(List<Integer> list) {
        if (list.size() < 2) {
            // 如果清單中的元素只有 0 或 1 個，那麼就已經排序好了，直接返回原清單
            return list;
        } else {
            // 選擇第一個元素作為枢軸
            Integer pivot = list.get(0);

            // 將小於等於枢軸的元素收集到 less 清單中，將大於枢軸的元素收集到 greater 清單中
            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot)
                    .collect(Collectors.toList());
            List<Integer> greater = list.stream().skip(1).filter(el -> el > pivot)
                    .collect(Collectors.toList());

            // 遞迴調用 quicksort 方法對 less 和 greater 進行排序
            List<Integer> sortedLess = quicksort(less);
            List<Integer> sortedGreater = quicksort(greater);

            // 將排序後的 less、pivot、greater 三個清單結合為一個新的清單
            return Stream.concat(Stream.concat(sortedLess.stream(), Stream.of(pivot)), sortedGreater.stream())
                    .collect(Collectors.toList());
        }
    }
}
