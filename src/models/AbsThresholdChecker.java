package models;

/**
 * Method implements iThresholdChecker and calculates absolute threshold
 */
public class AbsThresholdChecker implements iThresholdChecker {

    private final double threshold;

    public AbsThresholdChecker(double threshold) {
        validateThreshold(threshold);
        this.threshold = threshold;
    }

    /**
     * Method checks if two numbers are outside of an absolute threshold
     *
     * @param value1 as double
     * @param value2 as double
     * @return true if numbers are outside of an absolute threshold
     */
    @Override
    public boolean checkThreshold(double value1, double value2) {
        return getAbsDifference(value1, value2) > threshold;
    }

    @Override
    public String toString() {
        return "Checking absolute threshold " + threshold;
    }
}
