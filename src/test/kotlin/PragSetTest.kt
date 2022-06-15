import io.michael.PragSet
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*

class PragSetTest {
    var subject = PragSet()

    @AfterEach()
    fun after() {
        subject = PragSet()
    }

    @Test
    fun `init`() {
        assertTrue(subject.isEmpty())
        assertFalse(subject.contains(5))
        assertEquals(subject.size(), 0)
    }

    @Test
    fun `insert items and remove`() {
        subject.insert(1)
        subject.insert(2)
        subject.insert(3)
        subject.insert(4)
        subject.insert(5)
        subject.insert(6)
        subject.insert(7)

        assertFalse(subject.isEmpty())
        assertEquals(subject.size(), 7)
        assertTrue(subject.contains(1))
        assertTrue(subject.contains(2))
        assertTrue(subject.contains(7))

        subject.remove(1)

        assertEquals(subject.size(), 6)
        assertEquals(subject.findIndex(7), 0)
        assertEquals(subject.findIndex(1), -1)

        subject.remove(7)

        assertEquals(subject.size(), 5)
        assertEquals(subject.findIndex(7), -1)
        assertEquals(subject.findIndex(6), 0)
    }

    @Test
    fun `insert items and clear then add items`() {
        subject.insert(5)
        subject.insert(6)
        subject.insert(7)
        subject.insert(8)
        subject.insert(9)
        subject.insert(10)

        assertEquals(subject.size(), 6)
        assertTrue(subject.contains(5))
        assertTrue(subject.contains(10))

        subject.clear()

        assertTrue(subject.isEmpty())
        assertEquals(subject.size(), 0)
        assertEquals(subject.findIndex(5), -1)
        assertEquals(subject.findIndex(10), -1)

        subject.insert(22)

        assertEquals(subject.size(), 1)
        assertEquals(subject.findIndex(22), 0)
    }

    @Test
    fun `insert duplicate`() {
        subject.insert(3)
        subject.insert(3)

        assertEquals(subject.size(), 1)
    }

    @Test
    fun `find item`() {
        subject.insert(3)
        subject.insert(5)
        subject.insert(1)
        subject.insert(2)
        subject.insert(4)

        assertEquals(subject.findIndex(3), 0)
        assertEquals(subject.findIndex(5), 1)
        assertEquals(subject.findIndex(1), 2)
        assertEquals(subject.findIndex(2), 3)
        assertEquals(subject.findIndex(4), 4)
    }
}