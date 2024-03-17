interface Calculator {
    long calc(long[] arr);
}

class MeanCalculator implements Calculator {
    @Override
    public long calc(long[] arr) {
        long sum = 0;
        for (long value : arr) {
            sum += value;
        }
        return sum / arr.length;
    }
}

class DistributeCalculator implements Calculator {
    @Override
    public long calc(long[] arr) {
        long mean = new MeanCalculator().calc(arr);
        long sumOfSquaredDeviations = 0;

        for (long value : arr) {
            long deviation = value - mean;
            sumOfSquaredDeviations += deviation * deviation;
        }

        return sumOfSquaredDeviations;
    }
}

class Strategy {
    static final int MEAN = 0;
    static final int DISTRIBUTION = 1;
}

class CallcFactory {
    Calculator getCalculator(int strategy) {
        if (strategy == Strategy.MEAN) {
            return new MeanCalculator();
        } else if (strategy == Strategy.DISTRIBUTION) {
            return new DistributeCalculator();
        } else {
            throw new IllegalArgumentException("Invalid strategy");
        }
    }
}

public class test {
    public static void main(String[] args) {
        long[] arr = {10, 20, 30, 55, 60, 75, 80, 95, 83, 50};

        Calculator meanCalculator = new CallcFactory().getCalculator(Strategy.MEAN);
        long meanValue = meanCalculator.calc(arr);
        System.out.println("Mean value: " + meanValue);

        Calculator distributeCalculator = new CallcFactory().getCalculator(Strategy.DISTRIBUTION);
        long distributionValue = distributeCalculator.calc(arr);
        System.out.println("Distribution value: " + distributionValue);
    }
}
