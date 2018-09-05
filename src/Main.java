import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        testLambda();
//        testLambda2();
//        testOptional();
        testMapAndMapFlat();
    }

    private static void testMapAndMapFlat() {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("greg");
        strs.add("borris");
        strs.add("saliou");
        strs.add("risana");
        strs.add("mimoud");
        strs.add("mourad");
        strs.add("tao");

//        strs.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        Stream<String> strsTmp = null;
//        Stream.
//        strs.stream().reduce((String st, String st2) -> {
//            System.out.println(st);
//            System.out.println(st2);
//            return st + " " + st2;
//            // return st.toUpperCase();
//        });

        Stream<Integer> ints = Stream.of(1000, 2560, 1250, 90, 100);
        Optional<Integer> in = ints.reduce((a, b) -> {
            System.out.println(a + "====");
            System.out.println(b + "=====");
           return a;
        });
        System.out.println(in.get());
        // System.out.println(ints.reduce((n1, n2) -> n1 * n2).get());
//        int max;
//        int index = 0;
        AtomicInteger index = new AtomicInteger(0);
        AtomicInteger min = new AtomicInteger(0);
        String str;
//        Consumer<Integer> consumer = (Integer i) -> {
////            System.out.println(atomicInteger.get());
//        };

//        consumer.accept(index);
//        ints.forEach((Integer i) -> {
//            if (index.get() == 0) {
//                min.set(i);
//            } else if (min.get() > i){
//                min.set(i);
//            }
//            index.incrementAndGet();
//        });

        System.out.println(min.get());
        // strs2.forEach(System.out::println);


//        Stream<String> s = Stream.of("G", "A");
    }

    private static void testOptional() {
        User user = new User("Greg", "Greg");
        Optional<String> def = Optional.of("Pas de nom");
        Optional<User> userOptional = Optional.ofNullable(user);
//        System.out.println(userOptional.isPresent());
        Optional<String> str = userOptional.map((User u) -> {
//            u.setLastName("Toto");
            return u.getFirstName();
        });

        Optional<String> optionalS = Optional.ofNullable("Greggg");
        String st = optionalS.map(string -> string.toUpperCase()).orElse(def.get());
        System.out.println(optionalS.orElseGet(() -> "Test".toUpperCase()));

        System.out.println(st);
//        if() {
//
//        }
//        userOptional.
    }


    static boolean runTest() {
        assert getTest() != null;
        return getTest().equals("greg");
    }

    static String getTest() {
        return null;
    }

    static void testLambda2() {
        User user1 = new User("Greg", "Test");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);

//        users.forEach((User user) -> System.out.println(user.getFirstName() + " " + user.getLastName()));
        users.stream().map((User user) -> {
            User user2 = user.duplicate();
            user2.setFirstName("G2");
            return user2;
        }).forEach((User user) -> {
//            System.out.println(user.getFirstName());
        });
        Consumer<String> consumer = (String str) -> System.out.println(str + " =="); // Prend un argument est retourne void
        Consumer<String> consumer2 = (String str) -> System.out.println(str.toUpperCase()); // Prend un argument est retourne void
        Function<String, String> function = (String str) -> str + " =="; // prend un argument est return une valeur
        Function<String, String> function2 = (String str) -> str.toUpperCase(); // prend un argument est return une valeur

//        consumer.andThen(consumer2).accept("GReg");
//        System.out.println(function.andThen(function2).apply("Greg"));
//        System.out.println(function.compose(function2).apply("Test"));

        Function<Integer, Integer> func1 = (Integer number) -> {
            Integer result = number * 2;
            System.out.println("Param 1 = " + number + " result = " + result);
            return result;
        };

        Function<Integer, Integer> func2 = (Integer number) -> {
            Integer result = number * number;
            System.out.println("Param 2 = " + number + " result = " + result);
            return result;
        };

        Predicate<String> isEmpty = (String str) -> {
            if (str == null) return true;
            return str.isEmpty();
        };

        BiPredicate<String, String> startsWith = (str, startWith) -> {
            if (str != null) {
                return str.startsWith(startWith);
            }

            return false;
        };

        System.out.println(func1.compose(func2).apply(4));
        System.out.println(func1.andThen(func2).apply(4));
        String str = "Greg";
        if (isEmpty.negate().test(str)) {
            System.out.println(startsWith.test(str, "g"));
        }
//        System.out.println(isEmpty.or(startsWith).test("Greg"));


//        users.forEach((User user) -> System.out.println(user.getFirstName() + " " + user.getLastName()));
    }

    static void testLambda() {
        TestEqualsAndHasCode testEqualsAndHasCode = new TestEqualsAndHasCode(1, "Greg");
        TestEqualsAndHasCode testEqualsAndHasCode2 = new TestEqualsAndHasCode(1, "Greg");
//        System.out.println(testEqualsAndHasCode.hashCode() + "  " + testEqualsAndHasCode2.hashCode());
//        System.out.println(testEqualsAndHasCode.equals(testEqualsAndHasCode2));
        Object t = null;
        TestEqualsAndHasCode t2 = (TestEqualsAndHasCode) t;
//        System.out.println(t2 instanceof TestEqualsAndHasCode);
        ArrayList<String> strs = new ArrayList<>();
        strs.add("greg");
        strs.add("borris");
        strs.add("saliou");
        strs.add("risana");
        strs.add("mimoud");
        strs.add("mourad");
        strs.add("tao");
        List<String> strs2 = strs.stream()
                .map((String str) -> str.toUpperCase())
                .sorted((String str1, String str2) -> str2.compareTo(str1))
//                .filter((String str) -> str.startsWith("G"))
                .collect(Collectors.toList());

        strs.forEach(System.out::println);
        strs2.forEach(System.out::println);
        // String::isEmpty;
        Predicate<String> estVide = n -> {
            if (n == null) return true;
            return n.isEmpty();
        };
//        System.out.println(estVide.test(""));
        Function<Integer, String> toString = n -> String.valueOf(n);
        Function<String, Integer> toInteger = s -> Integer.valueOf(s);
        System.out.println(estVide.negate().test(""));
//        System.out.println(toString.apply(10) instanceof String);
        //assert getTest() != null; // "4".equals(toString.apply(4));
//        runTest();
//        Optional<String> str = new Optional<>("GReg");
    }
}
