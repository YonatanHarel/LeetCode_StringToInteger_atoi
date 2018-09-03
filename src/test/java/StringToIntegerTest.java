import org.junit.Test;

import static org.junit.Assert.*;

public class StringToIntegerTest {

    @Test
    public void convert_PositiveTest() throws Exception {
        String str = "32842this is a test";
        StringToInteger sti = new StringToInteger();
        int num = sti.convert(str);
        assertEquals(32842, num);
    }

    @Test
    public void convert_NegativeTest() throws Exception {
        String str = " s 32842this is a test";
        StringToInteger sti = new StringToInteger();
        int num = sti.convert(str);
        assertEquals(0, num);
    }

    @Test
    public void convert_postivieOverflow() throws Exception {
        String str = "91283472332";
        StringToInteger sti = new StringToInteger();
        int num = sti.convert(str);
        assertEquals(Integer.MAX_VALUE, num);
    }

    @Test
    public void convert_negativeOverflow() throws Exception {
        String str = "-91283472332";
        StringToInteger sti = new StringToInteger();
        int num = sti.convert(str);
        assertEquals(Integer.MIN_VALUE, num);
    }

    @Test
    public void isNumeric_Minus() throws Exception {
        char ch = '-';
        StringToInteger sti = new StringToInteger();
        assertEquals(false, sti.isNumeric(ch));
    }

    @Test
    public void isNumeric_Plus() throws Exception {
        char ch = '+';
        StringToInteger sti = new StringToInteger();
        assertEquals(false, sti.isNumeric(ch));
    }

    @Test
    public void isNumeric_Digit() throws Exception {
        char ch = '4';
        StringToInteger sti = new StringToInteger();
        assertEquals(true, sti.isNumeric(ch));
    }

    @Test
    public void isNumeric_Letter() throws Exception {
        char ch = 'S';
        StringToInteger sti = new StringToInteger();
        assertEquals(false, sti.isNumeric(ch));
    }

    @Test
    public void isValidPrefix_Digit() throws Exception {
        char ch = '3';
        StringToInteger sti = new StringToInteger();
        assertEquals(true, sti.isInvalidPrefix(ch));
    }

    @Test
    public void isValidPrefix_Minus() throws Exception {
        char ch = '-';
        StringToInteger sti = new StringToInteger();
        assertEquals(true, sti.isInvalidPrefix(ch));
    }

    @Test
    public void isValidPrefix_Plus() throws Exception {
        char ch = '+';
        StringToInteger sti = new StringToInteger();
        assertEquals(true, sti.isInvalidPrefix(ch));
    }

    @Test
    public void isValidPrefix_Letter() throws Exception {
        char ch = 'f';
        StringToInteger sti = new StringToInteger();
        assertEquals(false, sti.isInvalidPrefix(ch));
    }

    @Test
    public void parseIntTest() throws Exception {
        String str = "-91283472332";
        int num = Integer.parseInt(str);
    }
}