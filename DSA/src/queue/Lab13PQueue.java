package queue;

public class Lab13PQueue {

	public static void main(String[] args) {
		
		QueueADT<String> students = new PriorityQueue<String> ();
		students.add ("joseph");
		System.out.println(students);
		students.add ("mary");
		System.out.println(students);
		students.add ("jim");
		System.out.println(students);
		students.add ("jimmy");
		System.out.println(students);
		students.add ("joe");
		System.out.println(students);
		students.add ("susie");
		System.out.println(students);
		students.add ("joe");
		System.out.println(students);
		students.add ("sue");
		System.out.println(students);
		students.remove();
		System.out.println(students);
	}
}
