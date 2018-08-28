import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
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

//        strs.forEach(System.out::println);
//        strs2.forEach(System.out::println);
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


    static boolean runTest() {
        assert getTest() != null;
        return getTest().equals("greg");
    }

    static String getTest() {
        return null;
    }
}
