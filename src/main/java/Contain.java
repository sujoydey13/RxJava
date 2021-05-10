import io.reactivex.Observable;

public class Contain {
    public static void main(String[] args) {
        Observable.just(2,3,75,4,5,6)
                .contains(75)
                .subscribe(System.out::println);
    }
}
