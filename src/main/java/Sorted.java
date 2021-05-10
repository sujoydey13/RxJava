import io.reactivex.Observable;

import java.util.Comparator;

public class Sorted {
    public static void main(String[] args) {
//        useSorted();
//        useSortedWithOwnComparator();
        useSortedWithNonComparator();
    }

    private static void useSortedWithOwnComparator() {
        Observable.just(5,3,7,8,2,1,6)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }

    private static void useSorted() {
        Observable.just(5,3,7,8,2,1,6)
                .sorted()
                .subscribe(System.out::println);
    }

    private static void useSortedWithNonComparator() {
        Observable.just("good","bad","better","go","eleven")
                .sorted((first,second) -> Integer.compare(first.length(),second.length()))
                .subscribe(System.out::println);
    }


}
