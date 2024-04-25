package models;

/**
 * Method implements iThresholdChecker and calculates relative threshold
 */
public class RelThresholdChecker implements iThresholdChecker {

    private final double threshold;

    public RelThresholdChecker(double threshold) {
        validateThreshold(threshold);
        this.threshold = threshold;
    }

    /**
     * Method checks if two numbers are outside of a relative threshold
     *
     * @param value1 as double
     * @param value2 as double
     * @return true if numbers are outside of a relative threshold
     */
    @Override
    public boolean checkThreshold(double value1, double value2) {
        return Math.abs(getAbsDifference(value1, value2) / Math.min(value1, value2)) * 100 > threshold;
    }

    @Override
    public String toString() {
        return "Checking relative threshold " + threshold + "%";
    }
}
