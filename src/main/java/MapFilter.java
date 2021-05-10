import io.reactivex.Observable;

public class MapFilter {
    public static void main(String[] args) {
//        mapOperator();
//        mapOperatorReturnsDifferentData();
        filterOperator();
    }

    private static void filterOperator() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8,9,10);
        observable
                .filter(item -> item % 2 == 0)
                .map(item -> item*3)
                .subscribe(System.out::println);
    }

    private static void mapOperatorReturnsDifferentData() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .map(item -> "RxJava")
                .subscribe(System.out::println);
    }

    private static void mapOperator() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .map(item -> item *3)
                .subscribe(System.out::println);
    }
}
