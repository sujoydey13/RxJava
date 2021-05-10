import io.reactivex.Observable;

public class FromCallable {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.fromCallable(() -> {
            System.out.println("Calling getNumbers");
            return getNumber();});
        observable.subscribe(System.out::println,error -> System.out.println("Exception occured: "+error.getLocalizedMessage()));
    }

    public static int getNumber(){
        System.out.println("Generating Value");
        return 5/0;
    }
}
