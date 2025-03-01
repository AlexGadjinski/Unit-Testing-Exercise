package p01_Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private Integer[] elements;
    private Database database;

    @BeforeEach
    public void setUp() throws OperationNotSupportedException {
        elements = new Integer[]{14, 15, 16};
        this.database = new Database(elements);
    }

    @Test
    public void test_CreatingDatabase_WithMoreThanSixteenElements_Throws() {
        Integer[] elements = new Integer[17];
        assertThrows(OperationNotSupportedException.class, () -> new Database(elements));
    }

    @Test
    public void test_CreatingDatabase_WithZeroElements_Throws() {
        Integer[] elements = new Integer[0];
        assertThrows(OperationNotSupportedException.class, () -> new Database(elements));
    }

    @Test
    public void test_CreatingDatabase_WithValidNumberOfElements_CreatesDatabase() {
        assertEquals(elements.length, database.getElements().length);
        assertArrayEquals(elements, database.getElements());
    }

    @Test
    public void test_AddingElement_WhenNull_Throws() {
        assertThrows(OperationNotSupportedException.class, () -> database.add(null));
    }

    @Test
    public void test_AddingElement_WhenValid_AddAtTheEndAndIncreaseNumberOfElementsByOne() throws OperationNotSupportedException {
        database.add(30);
        assertEquals(30, database.getElements()[elements.length]);
        assertEquals(elements.length + 1, database.getElements().length);
    }

    @Test
    public void test_RemovingElement_WhenDatabaseEmpty_Throws() throws OperationNotSupportedException {
        Database databaseToReduce = new Database(5);
        databaseToReduce.remove();
        assertThrows(OperationNotSupportedException.class, databaseToReduce::remove);
    }

    @Test
    public void test_RemovingElement_WhenDatabaseNotEmpty_ReduceNumberOfElementsByOne() throws OperationNotSupportedException {
        database.remove();
        assertEquals(elements.length - 1, database.getElements().length);
    }
}
