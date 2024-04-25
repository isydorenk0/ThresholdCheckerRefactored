import models.AbsThresholdChecker;
import models.RelThresholdChecker;
import models.iThresholdChecker;

public class Main {
    public static void main(String[] args) {

        iThresholdChecker absThresholdChecker = new AbsThresholdChecker(10);
        iThresholdChecker relThresholdChecker = new RelThresholdChecker(50);

        checkThreshold(absThresholdChecker);
        checkThreshold(relThresholdChecker);
    }

    private static void checkThreshold(iThresholdChecker thresholdChecker) {
        System.out.println(thresholdChecker + " : " + thresholdChecker.checkThreshold(100, 105));
        System.out.println(thresholdChecker + " : " + thresholdChecker.checkThreshold(100, 170));
    }
}