import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Xu string searching JUnits.
 *
 * @author Mary Xu
 * @version 1.0
 */
public class XuSearchingTests {
    private List<Integer> notThereList;

    private String threeX; // returns 3xLists
    private String threeXSeparated; // returns 3xSepLists
    private String tooShort; // returns notThereList
    private String notThere; // returns notThereList
    private String randomEverything; // returns RandomLists
    private String randomEverythingNotThere; // returns notThereList
    private String mixThere; // returns mixThereList


    private List<Integer> ababa3xList;
    private List<Integer> ababa3xSepList;
    private List<Integer> ababaRandomList;

    private List<Integer> num3xList;
    private List<Integer> num3xSepList;
    private List<Integer> numRandomList;

    private List<Integer> ascii3xList;
    private List<Integer> ascii3xSepList;
    private List<Integer> asciiRandomList;

    private List<Integer> orz3xList;
    private List<Integer> orz3xSepList;
    private List<Integer> orzRandomList;

    private List<Integer> mixThereList;

    private String ababa;
    private String asciis;
    private String nums;
    private String orz;
    private String mix;

    private CharacterComparator comparator;

    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        notThereList = new ArrayList<>();

        ababa = "ababa";
        asciis = "(>_>)(>_>)";
        nums = "1331331";
        orz = "orzorz";
        mix = "! l0^3 c4t$";

        //                  1         2         3         4         5
        //        012345678901234567890123456789012345678901234567890123
        threeX = "ababababa(>_>)(>_>)(>_>)(>_>)1331331331331orzorzorzorz";
        //                           1         2         3         4         5         6         7         8
        //                 012345678901234567890123456789012345678901234567890123456789012345678901234567890123
        threeXSeparated = "ababa(>_>)(>_>)1331331orzorzababa(>_>)(>_>)1331331orzorzababa(>_>)(>_>)1331331orzorz";
        tooShort = "oops";
        notThere = "abbabbabaa ozrorzozr 133131331 (>_>)(<_<)(>_>) ! l0^3c4t$ "
                + "all the strings are having an existential crisis in this one";
        //                            1         2         3         4
        //                  0123456789012345678901234567890123456789012345
        randomEverything = "=+= ababa @.@ (>_>)(>_>) (: 1331331 *v* orzorz";
        randomEverythingNotThere = "=+= (>_>) @.@ aba (: nothing here to see :) orz *v* 1331";
        //                    1         2         3         4         5
        //          012345678901234567890123456789012345678901234567890123
        mixThere = "^^$^%79fsf! l0^3 c4t$ 675g9487ak*&^7587 ! l0^3 c4t$";

        ababa3xList = new ArrayList<>();
        ababa3xList.add(0);
        ababa3xList.add(2);
        ababa3xList.add(4);
        ababa3xSepList = new ArrayList<>();
        ababa3xSepList.add(0);
        ababa3xSepList.add(28);
        ababa3xSepList.add(56);
        ababaRandomList = new ArrayList<>();
        ababaRandomList.add(4);

        num3xList = new ArrayList<>();
        num3xList.add(29);
        num3xList.add(32);
        num3xList.add(35);
        num3xSepList = new ArrayList<>();
        num3xSepList.add(15);
        num3xSepList.add(43);
        num3xSepList.add(71);
        numRandomList = new ArrayList<>();
        numRandomList.add(28);

        ascii3xList = new ArrayList<>();
        ascii3xList.add(9);
        ascii3xList.add(14);
        ascii3xList.add(19);
        ascii3xSepList = new ArrayList<>();
        ascii3xSepList.add(5);
        ascii3xSepList.add(33);
        ascii3xSepList.add(61);
        asciiRandomList = new ArrayList<>();
        asciiRandomList.add(14);

        orz3xList = new ArrayList<>();
        orz3xList.add(42);
        orz3xList.add(45);
        orz3xList.add(48);
        orz3xSepList = new ArrayList<>();
        orz3xSepList.add(22);
        orz3xSepList.add(50);
        orz3xSepList.add(78);
        orzRandomList = new ArrayList<>();
        orzRandomList.add(40);

        mixThereList = new ArrayList<>();
        mixThereList.add(10);
        mixThereList.add(40);

        comparator = new CharacterComparator();
    }



    //---------------------------------------------------------------
    //----------------------------- KMP -----------------------------
    //---------------------------------------------------------------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsKMPNullPattern() {
        PatternMatching.kmp(null, threeX, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsKMPPatternLengthZero() {
        PatternMatching.kmp("", threeX, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsKMPNullText() {
        PatternMatching.kmp(ababa, null, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsKMPNullComp() {
        PatternMatching.kmp(ababa, threeX, null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsFailureTableNullPattern() {
        PatternMatching.buildFailureTable(null, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsFailureTableNullComp() {
        PatternMatching.buildFailureTable(ababa, null);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTable() {
        int[] ababaFailureTable = PatternMatching
                .buildFailureTable(ababa, comparator);
        int[] asciisFailureTable = PatternMatching
                .buildFailureTable(asciis, comparator);
        int[] numsFailureTable = PatternMatching
                .buildFailureTable(nums, comparator);
        int[] orzFailureTable = PatternMatching
                .buildFailureTable(orz, comparator);
        int[] mixFailureTable = PatternMatching
                .buildFailureTable(mix, comparator);

        int[] ababaExpected = {0, 0, 1, 2, 3};
        int[] asciisExpected = {0, 0, 0, 0, 0, 1, 2, 3, 4, 5};
        int[] numsExpected = {0, 0, 0, 1, 2, 3, 4};
        int[] orzExpected = {0, 0, 0, 1, 2, 3};
        int[] mixExpected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertArrayEquals("Failure Table: "
                + ababaFailureTable.toString(), ababaExpected, ababaFailureTable);
        assertArrayEquals("Failure Table: "
                + asciisFailureTable.toString(), asciisExpected, asciisFailureTable);
        assertArrayEquals("Failure Table: "
                + numsFailureTable.toString(), numsExpected, numsFailureTable);
        assertArrayEquals("Failure Table: "
                + orzFailureTable.toString(), orzExpected, orzFailureTable);
        assertArrayEquals("Failure Table: "
                + mixFailureTable.toString(), mixExpected, mixFailureTable);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPababaThere() {
        assertEquals(ababa3xList,
                PatternMatching.kmp(ababa, threeX, comparator));
        assertEquals(ababa3xSepList,
                PatternMatching.kmp(ababa, threeXSeparated, comparator));
        assertEquals(ababaRandomList,
                PatternMatching.kmp(ababa, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPnumsThere() {
        assertEquals(num3xList,
                PatternMatching.kmp(nums, threeX, comparator));
        assertEquals(num3xSepList,
                PatternMatching.kmp(nums, threeXSeparated, comparator));
        assertEquals(numRandomList,
                PatternMatching.kmp(nums, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPasciisThere() {
        assertEquals(ascii3xList,
                PatternMatching.kmp(asciis, threeX, comparator));
        assertEquals(ascii3xSepList,
                PatternMatching.kmp(asciis, threeXSeparated, comparator));
        assertEquals(asciiRandomList,
                PatternMatching.kmp(asciis, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPorzThere() {
        assertEquals(orz3xList,
                PatternMatching.kmp(orz, threeX, comparator));
        assertEquals(orz3xSepList,
                PatternMatching.kmp(orz, threeXSeparated, comparator));
        assertEquals(orzRandomList,
                PatternMatching.kmp(orz, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPababaNotThere() {
        assertEquals(notThereList,
                PatternMatching.kmp(ababa, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(ababa, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(ababa, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPnumsNotThere() {
        assertEquals(notThereList,
                PatternMatching.kmp(nums, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(nums, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(nums, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPasciiNotThere() {
        assertEquals(notThereList,
                PatternMatching.kmp(asciis, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(asciis, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(asciis, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPorzNotThere() {
        assertEquals(notThereList,
                PatternMatching.kmp(orz, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(orz, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(orz, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPMixNotThere() {
        assertEquals(notThereList,
                PatternMatching.kmp(mix, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(mix, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.kmp(mix, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPMixThere() {
        assertEquals(mixThereList,
                PatternMatching.kmp(mix, mixThere, comparator));
    }


    //---------------------------------------------------------------
    //------------------------- Boyer Moore -------------------------
    //---------------------------------------------------------------


    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsBoyerMooreNullPattern() {
        PatternMatching.boyerMoore(null, threeX, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsBoyerMoorePatternLengthZero() {
        PatternMatching.boyerMoore("", threeX, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsBoyerMooreNullText() {
        PatternMatching.boyerMoore(ababa, null, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsBoyerMooreNullComp() {
        PatternMatching.boyerMoore(ababa, threeX, null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsLastTableNullPattern() {
        PatternMatching.buildLastTable(null);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildLastTable() {
        Map<Character, Integer> ababaLastTable = PatternMatching.
                buildLastTable(ababa);
        Map<Character, Integer> ababaExpected = new HashMap<>();
        ababaExpected.put('a', 4);
        ababaExpected.put('b', 3);

        Map<Character, Integer> numsLastTable = PatternMatching.
                buildLastTable(nums);
        Map<Character, Integer> numsExpected = new HashMap<>();
        numsExpected.put('1', 6);
        numsExpected.put('3', 5);

        Map<Character, Integer> asciiLastTable = PatternMatching.
                buildLastTable(asciis);
        Map<Character, Integer> asciiExpected = new HashMap<>();
        asciiExpected.put('(', 5);
        asciiExpected.put('>', 8);
        asciiExpected.put('_', 7);
        asciiExpected.put(')', 9);

        Map<Character, Integer> orzLastTable = PatternMatching.
                buildLastTable(orz);
        Map<Character, Integer> orzExpected = new HashMap<>();
        orzExpected.put('o', 3);
        orzExpected.put('r', 4);
        orzExpected.put('z', 5);

        Map<Character, Integer> mixLastTable = PatternMatching.
                buildLastTable(mix);
        Map<Character, Integer> mixExpected = new HashMap<>();
        mixExpected.put('!', 0);
        mixExpected.put(' ', 6);
        mixExpected.put('l', 2);
        mixExpected.put('0', 3);
        mixExpected.put('^', 4);
        mixExpected.put('3', 5);
        mixExpected.put('c', 7);
        mixExpected.put('4', 8);
        mixExpected.put('t', 9);
        mixExpected.put('$', 10);

        assertEquals(ababaExpected, ababaLastTable);
        assertEquals(numsExpected, numsLastTable);
        assertEquals(asciiExpected, asciiLastTable);
        assertEquals(orzExpected, orzLastTable);
        assertEquals(mixExpected, mixLastTable);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreababaThere() {
        assertEquals(ababa3xList,
                PatternMatching.boyerMoore(ababa, threeX, comparator));
        assertEquals(ababa3xSepList,
                PatternMatching.boyerMoore(ababa, threeXSeparated, comparator));
        assertEquals(ababaRandomList,
                PatternMatching.boyerMoore(ababa, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoorenumsThere() {
        assertEquals(num3xList,
                PatternMatching.boyerMoore(nums, threeX, comparator));
        assertEquals(num3xSepList,
                PatternMatching.boyerMoore(nums, threeXSeparated, comparator));
        assertEquals(numRandomList,
                PatternMatching.boyerMoore(nums, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreasciisThere() {
        assertEquals(ascii3xList,
                PatternMatching.boyerMoore(asciis, threeX, comparator));
        assertEquals(ascii3xSepList,
                PatternMatching.boyerMoore(asciis, threeXSeparated, comparator));
        assertEquals(asciiRandomList,
                PatternMatching.boyerMoore(asciis, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreorzThere() {
        assertEquals(orz3xList,
                PatternMatching.boyerMoore(orz, threeX, comparator));
        assertEquals(orz3xSepList,
                PatternMatching.boyerMoore(orz, threeXSeparated, comparator));
        assertEquals(orzRandomList,
                PatternMatching.boyerMoore(orz, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreababaNotThere() {
        assertEquals(notThereList,
                PatternMatching.boyerMoore(ababa, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(ababa, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(ababa, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoorenumsNotThere() {
        assertEquals(notThereList,
                PatternMatching.boyerMoore(nums, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(nums, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(nums, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreasciiNotThere() {
        assertEquals(notThereList,
                PatternMatching.boyerMoore(asciis, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(asciis, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(asciis, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreorzNotThere() {
        assertEquals(notThereList,
                PatternMatching.boyerMoore(orz, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(orz, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(orz, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreMixNotThere() {
        assertEquals(notThereList,
                PatternMatching.boyerMoore(mix, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(mix, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.boyerMoore(mix, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreMixThere() {
        assertEquals(mixThereList,
                PatternMatching.boyerMoore(mix, mixThere, comparator));
    }



    //----------------------------------------------------------------------
    //----------------------------- Rabin Karp -----------------------------
    //----------------------------------------------------------------------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsRabinKarpNullPattern() {
        PatternMatching.rabinKarp(null, threeX, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsRabinKarpPatternLengthZero() {
        PatternMatching.rabinKarp("", threeX, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsRabinKarpNullText() {
        PatternMatching.rabinKarp(ababa, null, comparator);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testIllegalArgsRabinKarpNullComp() {
        PatternMatching.rabinKarp(ababa, threeX, null);
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpababaThere() {
        assertEquals(ababa3xList,
                PatternMatching.rabinKarp(ababa, threeX, comparator));
        assertEquals(ababa3xSepList,
                PatternMatching.rabinKarp(ababa, threeXSeparated, comparator));
        assertEquals(ababaRandomList,
                PatternMatching.rabinKarp(ababa, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpnumsThere() {
        assertEquals(num3xList,
                PatternMatching.rabinKarp(nums, threeX, comparator));
        assertEquals(num3xSepList,
                PatternMatching.rabinKarp(nums, threeXSeparated, comparator));
        assertEquals(numRandomList,
                PatternMatching.rabinKarp(nums, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpasciisThere() {
        assertEquals(ascii3xList,
                PatternMatching.rabinKarp(asciis, threeX, comparator));
        assertEquals(ascii3xSepList,
                PatternMatching.rabinKarp(asciis, threeXSeparated, comparator));
        assertEquals(asciiRandomList,
                PatternMatching.rabinKarp(asciis, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarporzThere() {
        assertEquals(orz3xList,
                PatternMatching.rabinKarp(orz, threeX, comparator));
        assertEquals(orz3xSepList,
                PatternMatching.rabinKarp(orz, threeXSeparated, comparator));
        assertEquals(orzRandomList,
                PatternMatching.rabinKarp(orz, randomEverything, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpababaNotThere() {
        assertEquals(notThereList,
                PatternMatching.rabinKarp(ababa, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(ababa, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(ababa, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpnumsNotThere() {
        assertEquals(notThereList,
                PatternMatching.rabinKarp(nums, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(nums, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(nums, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpasciiNotThere() {
        assertEquals(notThereList,
                PatternMatching.rabinKarp(asciis, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(asciis, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(asciis, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarporzNotThere() {
        assertEquals(notThereList,
                PatternMatching.rabinKarp(orz, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(orz, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(orz, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpMixNotThere() {
        assertEquals(notThereList,
                PatternMatching.rabinKarp(mix, tooShort, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(mix, notThere, comparator));
        assertEquals(notThereList,
                PatternMatching.rabinKarp(mix, randomEverythingNotThere, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpMixThere() {
        assertEquals(mixThereList,
                PatternMatching.rabinKarp(mix, mixThere, comparator));
    }
}