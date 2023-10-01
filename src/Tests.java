import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {

    @Test()
    public void testHex() {
        Assertions.assertEquals(Main.decoder("0x16D"), 365);
    }

    public void testHexBigX() {
        Assertions.assertEquals(Main.decoder("0X16D"), 365);
    }

    @Test()
    public void testHexSharped() {
        Assertions.assertEquals(Main.decoder("#16D"), 365);
    }

    @Test()
    public void testNegHexSharped() {
        Assertions.assertEquals(Main.decoder("-#16D"), -365);
    }

    @Test()
    public void testNegHexBigX() {
        Assertions.assertEquals(Main.decoder("-0X16D"), -365);
    }

    @Test()
    public void testNegHex() {
        Assertions.assertEquals(Main.decoder("-0x16D"), -365);
    }

    @Test()
    public void testDec() {
        Assertions.assertEquals(Main.decoder("389"), 389);
    }

    @Test()
    public void testNegDec() {
        Assertions.assertEquals(Main.decoder("-389"), -389);
    }

    @Test()
    public void testOct() {
        Assertions.assertEquals(Main.decoder("0340"), 224);
    }

    @Test()
    public void testNegOct() {
        Assertions.assertEquals(Main.decoder("-0340"), -224);
    }

    @Test()
    public void testNullException() {

        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            Main.decoder(null);
        });

        Assertions.assertEquals(NullPointerException.class, thrown.getClass());
    }

    private void check(String input) {

        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Main.decoder(input);
        });
        Assertions.assertEquals(NumberFormatException.class,thrown.getClass());
    }

    @Test()
    public void testWrongFormat() {

        check("");
        check("rfefw0");
        check("X818Ab");
        check("0xUIh1");
        check("0x#A1");
        check("09");
    }
}
