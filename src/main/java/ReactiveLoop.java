import io.reactivex.Observable;

public class ReactiveLoop {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(5,15);
        observable.subscribe(System.out::println);
    }
}
