package binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    private ArrayList<String> list;

    public BinarySearch(ArrayList<String> list) {
        this.list = list;
    }

    public int search(String query) {
        return search(query, 0, list.size() - 1);
    }

    private int search(String query, int from, int to) {

        if (!list.contains(query)) {
            return -1;
        }

        Collections.sort(list);

        int middle = (from + to) / 2;
        int compare = query.compareTo(list.get(middle));
        if (compare == 0) {
            return middle;
        }
        if (compare > 0) {
            return search(query, middle + 1, to);
        }
        return search(query, from, middle);
    }
}

class Test {

    public static void main(String[] args) {

        List<String> list = List.of("ананас", "банан", "виноград", "груша", "дыня", "яблоко",
                "тыква", "клубника", "ежевика", "малина", "грейпфрут", "гранат");

        ArrayList<String> arrayList = new ArrayList<>(list);

        BinarySearch binarySearch = new BinarySearch(arrayList);

        System.out.println(binarySearch.search("апельсин"));
        System.out.println(binarySearch.search("тыква"));
        System.out.println(binarySearch.search("яблоко"));
        System.out.println(binarySearch.search("ананас"));

    }

}
