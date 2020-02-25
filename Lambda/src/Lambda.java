import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numbers = generateRandomList(10, ()->random.nextInt(100));
        printNumbers(numbers,n-> System.out.print(n+" "));
        System.out.println();

        List<Integer> oddNumbers = deleteEvenNumbers(numbers,n->n%2==1);
        printNumbers(oddNumbers,n-> System.out.print(n+" "));
    }

    private static <T> List<T> generateRandomList(int elements, Supplier<T> supplier){
        List<T> list = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    private static <T> void printNumbers(List<T> list, Consumer<T> consumer){
        for(T t: list){
            consumer.accept(t);
        }
    }

    private static <T> List<T> deleteEvenNumbers(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()){
            T element = iterator.next();
            if(predicate.test(element))
                result.add(element);
        }
        return result;
    }

}
