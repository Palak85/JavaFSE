package financialForecasting;

public class Forecasting {

    // 1. Standard Recursive Algorithm to predict future value
    // Formula: FV = PV * (1 + growthRate) ^ periods
    // Time Complexity: O(n) where n is periods
    // Space Complexity: O(n) due to recursive stack memory
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        // Base Case
        if (periods == 0) {
            return presentValue;
        }
        // Recursive Step
        return calculateFutureValueRecursive(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    // 2. Optimized Iterative Algorithm (Avoids Call Stack Overhead)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }
}
