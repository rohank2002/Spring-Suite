import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<User> result = new ArrayList<>();
        result.add(new User("rohan",24));
        result.add(new User("ram",30));
        result.add(new User("ramesh",45));
        result.add(new User("rita",60));
////    result.sort((u1,u2)->u1.getId()-u2.getId());
////    result.forEach(user -> System.out.println(user.getName()));
//
////        Function <Integer, Double>ctof = (celcius) -> new Double((celcius*9/5)+32);
////        System.out.println(ctof.apply(36));
////        User user = new User("rohan",2);
////        Predicate<User> userAbove21 = u->u.getId()>21;
////        System.out.println(userAbove21.test(user));
//        Supplier<User> supplier = () ->{
//            return new User("John Smith",20);
//        };
//
//        User user = supplier.get();

        //Lamba
//        List<Integer> res = Arrays.asList(1,2,3,4,5,6,7);
//        res.forEach(number -> main.print(number));
//        // Method reference
//        res.forEach(main::print);
//        User user = new User("rohan",34);
////
//        Optional<User> userOptional = Optional.ofNullable(user);
//        userOptional.ifPresent(name -> userOptional.get().getName());
    result.stream()
            .filter(u -> u.getId()>21)
            .map(u -> u.getName())
            .forEach(u -> System.out.println(u));


    }
    public static  void print(final int number){
        System.out.println(" i am printing "+number);
    }
}
