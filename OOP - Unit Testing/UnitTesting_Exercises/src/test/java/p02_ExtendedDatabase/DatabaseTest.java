package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(new Person(1, "Jenny"),
                new Person(2, "Kari"),
                new Person(3, "Teddy"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_addPersonShouldReturnEx() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_addPersonShouldWorkProperly() throws OperationNotSupportedException {
        Person person = new Person(4, "Kotic");
        int expectedLength = database.getElements().length + 1;
        database.add(person);
        assertEquals(expectedLength, database.getElements().length);
        assertEquals(person, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_removePersonShouldReturnEx() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void test_removePersonShouldWorkProperly() throws OperationNotSupportedException {
        int expectedLength = database.getElements().length - 1;
        database.remove();
        assertEquals(expectedLength, database.getElements().length);
    }

    @Test
    public void test_getElementsShouldWorkProperly() {
        Person[] expected = new Person[]{new Person(1, "Jenny"),
                new Person(2, "Kari"),
                new Person(3, "Teddy")};
        Person[] actual = database.getElements();
        assertArrayEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldReturnExIfNameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldReturnExIfDuplicate() throws OperationNotSupportedException {
        database.add(new Person(5, "Kari"));
        database.findByUsername("Kari");
    }

    @Test
    public void findByUsernameShouldWorkProperly() throws OperationNotSupportedException {
        Person expected = new Person(2, "Kari");
        Person actual = database.findByUsername("Kari");
        assertEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldReturnExIfNoMatch() throws OperationNotSupportedException {
        database.findById(5);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldReturnExIfDuplicate() throws OperationNotSupportedException {
        database.add(new Person(2, "Mecho"));
        database.findById(2);
    }

    @Test
    public void findByIdShouldWorkProperly() throws OperationNotSupportedException {
        Person expected = new Person(2, "Kari");
        Person actual = database.findById(2);
        assertEquals(expected, actual);
    }
}