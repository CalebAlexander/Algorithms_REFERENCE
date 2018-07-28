import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * JUnits for a few short cases.
 *
 * @author JDulle
 * @version 1.37
 */
public class TestShortLong {

    private String longPattern;
    private String emptyPattern;
    private String onePattern;

    private String shortText;

    private CharacterComparator comparator;

    private List<Integer> emptyList;
    private Map<Character, Integer> emptyMap;
    private int[] emptyArray;

    private Map<Character, Integer> singleMap;
    private int[] singleArray;

    public static final int TIMEOUT = 200;

    @Before
    public void getTheShowOnTheRoad() {
        //get a pattern, text, and comparator
        longPattern = "supercalifragilisticexpialidocious";
        emptyPattern = "";
        onePattern = "J";

        shortText = "eva";

        comparator  = new CharacterComparator();

        //empties to compare to method outputs
        emptyList = new ArrayList<>();
        emptyMap = new HashMap<>(); //last table
        emptyArray = new int[] {};  //failure table

        //singles to compare to method outputs
        singleMap = new HashMap<>(); //last table
        singleMap.put(onePattern.charAt(0), 0);
        singleArray = new int[] {0};  //failure table
    }

    @Test(timeout = TIMEOUT)
    public void patternLongerThanText() {
        //if pattern is longer than the text, no match; return list w/o indexes
        assertEquals(emptyList, PatternMatching.boyerMoore(longPattern, shortText, comparator));

        assertEquals(emptyList, PatternMatching.kmp(longPattern, shortText, comparator));

        assertEquals(emptyList, PatternMatching.rabinKarp(longPattern, shortText, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void emptyPatternTables() {
        //if the pattern is empty, return an empty map/array
        assertEquals(emptyMap, PatternMatching.buildLastTable(emptyPattern));

        assertArrayEquals(emptyArray, PatternMatching.buildFailureTable(emptyPattern, comparator));
    }

    @Test(timeout = TIMEOUT)
    public void singlePatternTables() {
        //if the pattern is single character, return a map/array with 0
        assertEquals(singleMap, PatternMatching.buildLastTable(onePattern));

        assertArrayEquals(singleArray, PatternMatching.buildFailureTable(onePattern, comparator));
    }
}