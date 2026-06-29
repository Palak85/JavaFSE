package financialForecasting;

public class ForecastingTest {
    public static void test() {
        System.out.println("=== Financial Forecasting Test ===");

        double initialInvestment = 1000.00; // Present Value
        double growthRate = 0.05;          // 5% growth per period
        int periods = 10;                  // 10 years/periods

        System.out.println("Initial Present Value: $" + initialInvestment);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Period: " + periods + " periods");
        System.out.println();

        // 1. Run Recursive Calculation
        System.out.println("--- 1. Running Recursive Forecasting ---");
        double recursiveResult = Forecasting.calculateFutureValueRecursive(initialInvestment, growthRate, periods);
        System.out.printf("Future Value (Recursive): $%.2f%n", recursiveResult);
        System.out.println();

        // 2. Run Iterative Calculation
        System.out.println("--- 2. Running Iterative Forecasting (Optimized) ---");
        double iterativeResult = Forecasting.calculateFutureValueIterative(initialInvestment, growthRate, periods);
        System.out.printf("Future Value (Iterative): $%.2f%n", iterativeResult);
        System.out.println();

        // 3. Analysis and Discussion
        System.out.println("=== Analysis and Discussion ===");
        System.out.println("1. Recursion Concept:");
        System.out.println("   - Recursion is a programming technique where a method calls itself to solve a smaller subproblem.");
        System.out.println("   - It simplifies code by mirroring mathematical inductions (e.g. factorial, Fibonacci, compound interest).");
        System.out.println();
        System.out.println("2. Time and Space Complexity Analysis:");
        System.out.println("   - Time Complexity: O(n). There are exactly n method calls, each performing O(1) multiplications.");
        System.out.println("   - Space Complexity: O(n). Each recursive call pushes a stack frame onto the call stack.");
        System.out.println();
        System.out.println("3. The Risk of Large Periods (Call Stack Exhaustion):");
        System.out.println("   - In Java, the call stack size is limited (configured via -Xss).");
        System.out.println("   - If the number of periods is very large (e.g., 100,000), calling the recursive method will exhaust the call stack, throwing a `java.lang.StackOverflowError`.");
        System.out.println();
        System.out.println("4. Optimization Strategies:");
        System.out.println("   - Iterative Approach (Preferred): Converting the recursion to a simple loop eliminates the stack frame overhead, reducing space complexity to O(1).");
        System.out.println("   - Memoization: Stores results of expensive subproblems to avoid redundant calculations (highly effective for branching recursions like Fibonacci, though less needed for linear ones).");
        System.out.println("   - Tail Call Optimization (TCO): Writing the recursive call as the very last operation in the method. (Note: Java compilers do not currently optimize tail recursion natively).");
        System.out.println();
    }
}
