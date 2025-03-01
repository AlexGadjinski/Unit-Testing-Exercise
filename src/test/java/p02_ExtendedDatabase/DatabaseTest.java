package p02_ExtendedDatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private Database database;
    private Person person;

    @BeforeEach
    public void setUp() throws OperationNotSupportedException {
        person = new Person(134242, "John");
        database = new Database(person);
    }

    @Test
    public void test_findByUsername_WhenUsernameNull_Throws() {
        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername(null));
    }

    @Test
    public void test_findByUsername_WhenPersonWithUsernameDoesNotExistInDatabase_Throws() {
        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername("Gosho"));
    }

    @Test
    public void test_findByUsername_WhenPersonWithUsernameExistsInDatabase_ReturnsPerson() throws OperationNotSupportedException {
        assertEquals(person, database.findByUsername("John"));
    }

    @Test
    public void test_findById_WhenPersonWithIdDoesNotExistInDatabase_Throws() {
        assertThrows(OperationNotSupportedException.class, () -> database.findById(42));
    }

    @Test
    public void test_findById_WhenPersonWithIdExistsInDatabase_ReturnsPerson() throws OperationNotSupportedException {
        assertEquals(person, database.findById(134242));
    }
}
