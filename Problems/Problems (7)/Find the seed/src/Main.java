import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minSeedLimit = scanner.nextInt();
        int maxSeedLimit = scanner.nextInt();
        int numOfOutput = scanner.nextInt();
        int maxValue = scanner.nextInt();

        int largest = 0;
        int seedVal = 0;
        int[] maxValuesArr = new int[maxSeedLimit - minSeedLimit];
        int[] maxSeedsArr = new int[maxSeedLimit - minSeedLimit];

        for (int i = minSeedLimit; i < maxSeedLimit; i++) {
            Random random = new Random(i);

            for (int j = 0; j < numOfOutput; j++) {
                int current = random.nextInt(maxValue);

                if (current > largest) {
                    largest = current;
                }
            }

            maxValuesArr[i - minSeedLimit] = largest;
            maxSeedsArr[i - minSeedLimit] = i;
            largest = 0;
        }

        largest = Integer.MAX_VALUE;

        for (int i = 0; i < (maxSeedLimit - minSeedLimit); i++) {
            if (maxValuesArr[i] < largest) {
                largest = maxValuesArr[i];
                seedVal = maxSeedsArr[i];
            }
        }

        System.out.println(seedVal);
        System.out.println(largest);
    }
}