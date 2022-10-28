package jobScheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job{
	
	Job(String id, int deadline, int profit){
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
	
	protected String id;
	protected int deadline;
	protected int profit;
}

public class JobSchedule extends Job{
	
	JobSchedule(String id, int deadline, int profit) {
		super(id, deadline, profit);
	}

	static public void schedule(int size, JobSchedule[] input) {
		
		//sort input array according to profit in descending order
		Arrays.sort(input, 
				new Comparator<JobSchedule>() {
					public int compare(JobSchedule o1, JobSchedule o2)
	                {
	                    if (o1.profit == o2.profit)
	                    {
	                        return 0;
	                    }
	                    else if (o1.profit < o2.profit)
	                    {
	                        return 1;
	                    }
	                    return -1;
	                }
	            });
		System.out.println("Descending Order of Profit: ");
		for(int i=0; i<size; i++) {
			System.out.println(input[i].profit);
		}
		System.out.println();
		
		//set result array size to max deadline
		int maxDeadline = input[0].deadline;
		for(int i=1; i<size-1; i++) {
			if(input[i].deadline>maxDeadline) {
				maxDeadline = input[i].deadline;
			}
		}
		JobSchedule[] result = new JobSchedule[maxDeadline];
		Arrays.fill(result, new JobSchedule("", 0, 0));
		System.out.println("Max Deadline: " + maxDeadline);
		System.out.println();
		
		//placing jobs one by one according to deadline
		for(int i=0; i<maxDeadline; i++) {
			int temp = input[i].deadline;
			for(int j=temp-1; j>=0; j--) {
				if(result[j].id.isEmpty()) {
					result[j] = input[i];
					break;
				}
			}
		}
		
		System.out.println("Optimal Schedule: ");
		for(int i=0; i<maxDeadline; i++) {
			System.out.print(result[i].id + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Max Profit Earned: ");
		int sum=0;
		for(JobSchedule item : result) {
			sum = sum + item.profit;
		}
		System.out.println(sum);
		
	}
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
		
//		int n;
//		ArrayList<Object> input = new ArrayList<>();
//		
//		System.out.println("Enter number of jobs: ");
//		n = sc.nextInt();
//		
//		for(int i=0; i<n; i++) {
//			System.out.println(i + ". ID: ");
//			int id = sc.nextInt();
//			System.out.println(i + ". Deadline: ");
//			int deadline = sc.nextInt();
//			System.out.println(i + ". Profit: ");
//			int profit = sc.nextInt();
//			input.add(new JobSchedule(id, deadline, profit));
//		}
		
		JobSchedule[] input = new JobSchedule[6];
		
		input[0] = new JobSchedule("J1", 5, 200);
		input[1] = new JobSchedule("J2", 3, 180);
		input[2] = new JobSchedule("J3", 3, 190);
		input[3] = new JobSchedule("J4", 2, 300);
		input[4] = new JobSchedule("J5", 4, 120);
		input[5] = new JobSchedule("J6", 2, 100);
		
		schedule(6, input);
		
	}

}

