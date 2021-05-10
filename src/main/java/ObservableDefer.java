import io.reactivex.Observable;

public class ObservableDefer {

    private static int start = 5, count = 3;

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.defer(() -> Observable.range(start,count));
        observable.subscribe(item -> System.out.println("Observer 1: "+item));
        count = 5;
        observable.subscribe(item -> System.out.println("Observer 2: "+item));
    }
}
