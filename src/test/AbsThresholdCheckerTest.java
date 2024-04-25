package test;

import models.AbsThresholdChecker;
import models.iThresholdChecker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbsThresholdCheckerTest {

    static iThresholdChecker thresholdChecker;

    @BeforeAll
    public static void setUpBeforeClass() {
        thresholdChecker = new AbsThresholdChecker(10);
    }

    @Test
    @DisplayName("Test init with a neg threshold, throws exception")
    public void testNegativeThreshold() {
        assertThrows(IllegalArgumentException.class, () -> new AbsThresholdChecker(-10));
    }

    @Test
    @DisplayName("Test ABS threshold, positive values, returns false")
    public void testAbsThreshold_InThreshPos() {
        assertFalse(thresholdChecker.checkThreshold(100, 105));
    }

    @Test
    @DisplayName("Test ABS threshold, negative values, returns false")
    public void testAbsThreshold_InThreshNeg() {
        assertFalse(thresholdChecker.checkThreshold(-100, -105));
    }

    @Test
    @DisplayName("Test ABS threshold, positive values, returns true")
    public void testAbsThreshold_OutThreshPos() {
        assertTrue(thresholdChecker.checkThreshold(100, 115));
    }

    @Test
    @DisplayName("Test ABS threshold, negative values, returns true")
    public void testAbsThreshold_OutThreshNeg() {
        assertTrue(thresholdChecker.checkThreshold(-100, -115));
    }

    @Test
    @DisplayName("Test ABS threshold, pos and neg values, returns false")
    public void testAbsThreshold_InThreshPosNeg() {
        assertFalse(thresholdChecker.checkThreshold(-1, 5));
    }

    @Test
    @DisplayName("Test ABS threshold, pos and neg values, returns true")
    public void testAbsThreshold_OutThreshPosNeg() {
        assertTrue(thresholdChecker.checkThreshold(-1, 15));
    }

}
