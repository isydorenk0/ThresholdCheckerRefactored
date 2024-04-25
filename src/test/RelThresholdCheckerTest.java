package test;

import models.RelThresholdChecker;
import models.iThresholdChecker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RelThresholdCheckerTest {

    static iThresholdChecker thresholdChecker;

    @BeforeAll
    public static void setUpBeforeClass() {
        thresholdChecker = new RelThresholdChecker(10);
    }

    @Test
    @DisplayName("Test init with a neg threshold, throws exception")
    public void testNegativeThreshold() {
        assertThrows(IllegalArgumentException.class, () -> new RelThresholdChecker(-10));
    }

    @Test
    @DisplayName("Test REL threshold, positive values, returns false")
    public void testRelThreshold_InThreshPos() {
        assertFalse(thresholdChecker.checkThreshold(100, 105));
    }

    @Test
    @DisplayName("Test REL threshold, negative values, returns false")
    public void testRelThreshold_InThreshNeg() {
        assertFalse(thresholdChecker.checkThreshold(-100, -105));
    }

    @Test
    @DisplayName("Test REL threshold, positive values, returns true")
    public void testRelThreshold_OutThreshPos() {
        assertTrue(thresholdChecker.checkThreshold(100, 115));
    }

    @Test
    @DisplayName("Test REL threshold, negative values, returns true")
    public void testRelThreshold_OutThreshNeg() {
        assertTrue(thresholdChecker.checkThreshold(-100, -115));
    }

    @Test
    @DisplayName("Test REL threshold, pos and neg values, returns true")
    public void testRelThreshold_InThreshPosNeg() {
        assertTrue(thresholdChecker.checkThreshold(-1, 5));
    }
}
