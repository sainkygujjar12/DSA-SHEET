package Arrays.greedy;

public class jobSequencing {
    public static void main(String[] args) {
        int[] jobs = {1, 2, 3, 4};
        int[] deadlines = {4, 1, 1, 1};
        int[] profits = {20, 10, 40, 30};

        int maxProfit = getMaxProfit(jobs, deadlines, profits);
        System.out.println("Maximum profit: " + maxProfit);
    }

    public static int getMaxProfit(int[] jobs, int[] deadlines, int[] profits) {
        int n = jobs.length;
        Job[] jobArray = new Job[n];

        for (int i = 0; i < n; i++) {
            jobArray[i] = new Job(jobs[i], deadlines[i], profits[i]);
        }

        // Sort jobs by profit in descending order
        java.util.Arrays.sort(jobArray, (a, b) -> b.profit - a.profit);

        boolean[] slot = new boolean[n];
        int totalProfit = 0;

        for (Job job : jobArray) {
            // Find a free slot for this job (starting from the last possible slot)
            for (int j = Math.min(n - 1, job.deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true; // Mark this slot as occupied
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        return totalProfit;
    }

    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}
