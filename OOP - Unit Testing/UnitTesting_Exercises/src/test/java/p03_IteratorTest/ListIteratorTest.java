package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void init() throws OperationNotSupportedException {
        listIterator = new ListIterator("Jenny", "Kari");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_ConstructorShouldReturnEx() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void test_ConstructorShouldWorkProperly(){
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void test_MoveShouldReturnEx() {
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void test_MoveShouldReturnTrue() {
        assertTrue(listIterator.move());
    }

    @Test
    public void test_HasNextShouldReturnFalse(){
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void test_HasNextShouldReturnTrue(){
        assertTrue(listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void test_PrintShouldReturnEx() throws IllegalStateException, OperationNotSupportedException {
       ListIterator listIterator = new ListIterator();
       listIterator.print();
    } //?

    @Test
    public void test_PrintShouldWorkProperly(){
       String expected = "Jenny";
       String actual = listIterator.print();
       assertEquals(expected, actual);
    }
}