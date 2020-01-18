package james.example.todolist.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class STATUSTest {

    @Test
    public void testConvertFromCodeToEnum() {
        assertEquals(STATUS.convertFromCodeToEnum(1), STATUS.PLANNING);
        assertEquals(STATUS.convertFromCodeToEnum(2), STATUS.DOING);
        assertEquals(STATUS.convertFromCodeToEnum(9), STATUS.COMPLETE);
        assertEquals(STATUS.convertFromCodeToEnum(3), null);
        assertEquals(STATUS.convertFromCodeToEnum(0), null);
    }
}
