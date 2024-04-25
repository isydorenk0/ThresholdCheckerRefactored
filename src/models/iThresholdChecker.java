package models;

/**
 * Interface class iThresholdChecker contains method for checking threshold
 */
public interface iThresholdChecker {
    /**
     * Method checks if two numbers are outside of a threshold
     *
     * @param value1 as double
     * @param value2 as double
     * @return true if numbers are outside of a threshold
     */
    boolean checkThreshold(double value1, double value2);

    /**
     * Method calculates absolute difference between two numbers
     *
     * @param value1 as double
     * @param value2 as double
     * @return absolute difference between two numbers
     */
    default double getAbsDifference(double value1, double value2) {
        return Math.abs(value1 - value2);
    }

    /**
     * Validate threshold must be greater than or equal to zero
     *
     * @param threshold entered threshold as double
     */
    default void validateThreshold(double threshold) {
        if (threshold < 0) throw
                new IllegalArgumentException("Threshold must be greater than or equal to zero");
    }
}
