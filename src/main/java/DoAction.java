import io.reactivex.Observable;

public class DoAction {
    public static void main(String[] args) {
//        exDoOnSubscribe();
        exDoOnNext();
//        exDoOnComplete();
//        exDoFinally();
//        exDoOnDispose();
    }

    private static void exDoOnDispose() {
        Observable.just(1,2,3,4,5)
                .doOnDispose(() -> System.out.println("doOnDispose: called"))
                .doOnSubscribe(disposable -> disposable.dispose())
                .subscribe(System.out::println);

    }

    private static void exDoFinally() {
        Observable.just(1,2,3,4,5)
                .doFinally(() -> System.out.println("doFinally: finally called"))
                .subscribe(System.out::println,System.out::println,() -> System.out.println("Completed"));
    }

    private static void exDoOnComplete() {
        Observable.just(1,2,3,4,5)
                .doOnComplete(() -> System.out.println("Task Completed"))
                .subscribe(System.out::println,System.out::println,() -> System.out.println("Completed"));
    }

    private static void exDoOnNext() {
        Observable<Integer> ob = Observable.just(1,2,3,4,5);

        ob.doOnNext(item-> System.out.println(item))
                .map(item -> item *2)
                .doOnNext(item-> System.out.println(item)).subscribe(item-> System.out.println("On Next: "+item));

    }

    private static void exDoOnSubscribe() {
        Observable.just(1,2,3,4,5)
                .doOnSubscribe(disposable -> System.out.println("Subscribed"))
                .subscribe(System.out::println);
    }
}
