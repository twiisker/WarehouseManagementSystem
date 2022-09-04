import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StockOperationsTest extends StockOperations {

    HashMap<String, Integer> testMap = new HashMap<>();

    String pens = "Pens";
    String chairs = "Chairs";
    int val60 = 60;
    int val112 = 112;

    int valTotal = val60 + val112;
    int maxExpected = 600;

    int totalValue = 0;

    @BeforeEach
    void setUp() {
        assertEquals(maxExpected, maxStock);
        storageMap.putIfAbsent("Pens", 60);
        storageMap.putIfAbsent("Chairs", 112);
        testMap.putIfAbsent(pens, val60);
        testMap.putIfAbsent(chairs, val112);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testAddObject() {
        assertEquals(pens, "Pens");
        assertEquals(val60, 60);
    }

    @Test
    void testShowAll() {
    }

    @Test
    void testShow() {
        storageMap.putIfAbsent("Pens", 60);
        assertEquals(testMap, storageMap);
    }

    @Test
    void testKeys() {
        assertEquals(testMap.size(), storageMap.size());
    }

    @Test
    void testSpareRoom() {
        assertEquals(maxExpected - valTotal , spareRoom());
    }

    @Test
    void testNumValues() {
        int total = 0;

        for (int value : storageMap.values()) {
            total += value;
        }

        for (int value : testMap.values()) {
            totalValue += value;
        }

        assertEquals(totalValue, total);

    }

    @Test
    void testChangeStock() {
        assertEquals(val60, storageMap.get(pens));

        int newVal = 55;
        storageMap.replace("Pens", 55);

        testMap.replace(pens, newVal);
        assertEquals(newVal, storageMap.get(pens));
        assertNotNull(testMap);
        assertNotNull(storageMap);
    }

    @Test
    void testRemoveEntry() {
        assertTrue(storageMap.containsKey("Pens"));
        assertTrue(testMap.containsKey(pens));

        storageMap.clear();
        testMap.remove(pens);

        assertTrue(storageMap.isEmpty());
        assertFalse(testMap.isEmpty());
    }

    @Test
    void test1() {

    }

    @Test
    void testGetValue() {
        int valExpected = 60;
        assertEquals(valExpected, 60);
    }
}