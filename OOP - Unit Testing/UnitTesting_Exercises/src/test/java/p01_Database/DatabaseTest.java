package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(4, 5);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_SetOperationShouldReturnEx() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test
    public void test_SetOperationShouldWorkProperly() throws OperationNotSupportedException {
        Integer[] expected = database.getElements();
        Integer[] actual = new Integer[]{4, 5};
        assertArrayEquals(expected, actual);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void test_AddOperationShouldReturnEx() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_AddShouldWorkProperly() throws OperationNotSupportedException {
        Integer value = 6;
        int expectedLength = database.getElements().length + 1;
        database.add(value);
        assertEquals(expectedLength, database.getElements().length);
        assertEquals(value, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_RemoveShouldReturnEx() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void test_RemoveShouldWordProperly() throws OperationNotSupportedException {
        int expectedLength = database.getElements().length - 1;
        database.remove();
        assertEquals(expectedLength, database.getElements().length);
    }

    @Test
    public void test_GetElementsShouldWorkProperly() {
        Integer[] expected = {4, 5};
        assertArrayEquals(expected, database.getElements());
    }
}