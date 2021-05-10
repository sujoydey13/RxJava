import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        createObservableWithJust();
        createObservableUsingIterable();
        createObservableFromCreate();

    }

    private static void createObservableFromCreate() {
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            observableEmitter.onNext(13);
            observableEmitter.onNext(07);
            observableEmitter.onNext(98);
            observableEmitter.onNext(null);
            observableEmitter.onNext(21);
            observableEmitter.onNext(06);
            observableEmitter.onComplete();
        });
        observable.subscribe(item -> System.out.println(item),
                error -> System.out.println(error.getLocalizedMessage()),
                () -> System.out.println("Completed"));
    }

    private static void createObservableUsingIterable() {
        List<Integer> list = Arrays.asList(12,34,56,78,89);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(item -> System.out.println(item));

    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.subscribe(item -> System.out.println(item));
    }
}
