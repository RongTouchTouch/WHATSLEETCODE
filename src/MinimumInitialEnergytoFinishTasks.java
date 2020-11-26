import java.util.Arrays;

public class MinimumInitialEnergytoFinishTasks {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (a[1]-a[0])-(b[1]-b[0]));
        int result = 0;
        for (int[] task : tasks) {
            result = Math.max(task[1], result + task[0]);
        }
        return result;
    }

    public static void main(String[] args){
        int[][] tasks = {{1,9},{2,9},{3,10},{4,5}};
        MinimumInitialEnergytoFinishTasks solution = new MinimumInitialEnergytoFinishTasks();
        int result = solution.minimumEffort(tasks);
        System.out.println(result);
    }
}
