import java.util.Random;

public class BSTTest {
    private static final Random RNG = new Random();

    private static class Trial{
        private final int height;
        private final double avgNodesPerFind;

        Trial(int height, double avgNodesPerFind){
            this.height = height;
            this.avgNodesPerFind = avgNodesPerFind;
        }

        int getHeight(){
            return height;
        }

        double getAvgNodesPerFind(){
            return avgNodesPerFind;
        }
    }

    private static Trial runTrial(int n, int k){
        BinarySearchTree tree = new BinarySearchTree();
        int[] values = new int[n];

        for (int i=0; i<n; i++){
            int v = RNG.nextInt(k) + 1; //range of 1 to k (inclusive)
            tree.insert(v);
            values[i] = v;
        }

        long totalVisited = 0;
        for (int v: values){
            FindResult r = tree.find(v);
            if (!r.getFound()){
                throw new IllegalStateException("Value " + v + " should be in the tree");
            }
            totalVisited += r.getNodesVisited();
        }
        return new Trial(tree.height(), (double) totalVisited / n);
    }

    public static void main(String[] args){
        final int trials = 10;
        final int[] counts = {100, 1000, 10000};

        System.out.printf("%7s %9s %7s %11s %15s%n", //printf used to format the strings
            "N", "K", "Trials", "Avg Height", "Avg Nodes/Find");
        System.out.println("-".repeat(55));

        for (int n : counts){
            int k = n * 100; //same ratio of numbers n to range k is maintained for each
            double heightSum = 0;
            double findSum = 0;

            for (int t = 0; t < trials; t++){
                Trial result = runTrial(n,k);
                heightSum += result.getHeight();
                findSum += result.getAvgNodesPerFind();
            }
            System.out.printf("%7d %9d %7d %11.2f %15.2f%n", //.2 rounds to two decimal places
                    n, k, trials, heightSum / trials, findSum/trials);
        }
    }
}
