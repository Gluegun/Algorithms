import org.junit.Assert;
import org.junit.Test;
import rabin_karp.RabinKarpExtended;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpTests {

    private String text = "abracadabra";
    private String pattern;
    private List<Integer> expected = new ArrayList<>();
    private RabinKarpExtended rk = new RabinKarpExtended(text);

    @Test
    public void searchTest() {

        pattern = "bra";

        List<Integer> actual = rk.search(pattern);
        expected.add(1);
        expected.add(8);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchTest2() {

        pattern = "a";
        List<Integer> actual = rk.search(pattern);
        expected.add(0);
        expected.add(3);
        expected.add(5);
        expected.add(7);
        expected.add(10);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void nonExistedSearch() {

        pattern = "hello";
        List<Integer> actual = rk.search(pattern);

        int actualSize = actual.size();
        int expectedSize = 0;
        
        Assert.assertEquals(actualSize, expectedSize);


    }


}
