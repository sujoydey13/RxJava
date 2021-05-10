import io.reactivex.Observable;

public class Empty {
    public static void main(String[] args) {
        useDefaultEmpty();
        useSwitchIfEmpty();
        useScan();
    }

    private static void useSwitchIfEmpty() {
        Observable.just(1,2,3,4,5,6,7,8,9,10)
                .filter(item -> item > 10)
                .switchIfEmpty(Observable.just(11,12,13,14,4,5,7))
                .subscribe(System.out::println);
    }

    private static void useDefaultEmpty() {
        Observable.just(1,2,3,4,5,6,7,8,9,10)
                .filter(item -> item > 10)
                .defaultIfEmpty(1000)
                .subscribe(System.out::println);
    }
    private static void useScan() {
        Observable.just(1,2,3,4,5,6,7,8,9,10)
                .scan(10,(accumulator,next) -> accumulator + next)
                .subscribe(System.out::println);
    }

}
