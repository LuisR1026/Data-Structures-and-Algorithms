import java.util.Random;

public class Tester {
	public static Object[] createArray (int size) 
    {
		Random rand = new Random();
		Object[] A = new Object[size];
        for (int i = 0; i < size; i++) {
        	A[i] = rand.nextInt(100000) + 1;
        }
        return A;
    }

	public static void main(String[] args) {
		System.out.println("----------PROBLEM 1----------");
		
		System.out.println("(Part 1)");
		MaxHeap heap1 = new MaxHeap();
		heap1.add("Byrce Canyon NP");
		heap1.add("Yosemite NP");  
		heap1.add("Joshua Tree NP");
		heap1.add("Zion NP");
		heap1.add("Redwoods NP");
		heap1.add("Lassen Volcanic NP");
		System.out.println("ii. "+ heap1.toString());
		heap1.remove("Redwoods NP");
		System.out.println("iv. "+ heap1.toString());
		try {
			heap1.remove("Yellowstone NP");
		}
		catch (Exception e) {
			System.out.println("v. Element not found exception.");
		}
		
		System.out.println("(Part 2)");
		Object[] data = {2,4,1,5,9,7,10};
		MaxHeap heap2 = new MaxHeap(data);
		heap2.add(11);
		heap2.add(-1);
		System.out.println("ii. "+ heap2.toString());
		heap2.remove(2);
		System.out.println("iv. "+ heap2.toString());
		heap2.remove(11);
		System.out.println("vi. "+ heap2.toString());
		
		
		System.out.println("\n----------PROBLEM 2----------");
		
		System.out.println("(Part 1)");
		MaxPriorityQueue queue1 = new MaxPriorityQueue();
		queue1.push("Byrce Canyon NP");
		queue1.push("Yosemite NP");  
		queue1.push("Joshua Tree NP");
		queue1.push("Zion NP");
		queue1.push("Redwoods NP");
		queue1.push("Lassen Volcanic NP");
		System.out.println("i. " + queue1.toString());
		queue1.pop();
		System.out.println("ii. " + queue1.toString());
		System.out.println(("iii. " + (String)queue1.peek()));
		
		System.out.println("(Part 2)");
		Object[] data2 = {2,4,1,5,9,7,10};
		MaxPriorityQueue queue2 = new MaxPriorityQueue(data);
		queue2.push(11);
		queue2.push(-1);
		System.out.println("i. " + queue2.toString());
		System.out.println("ii. ");
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		queue2.pop();
		System.out.println(queue2.toString());
		
		System.out.println("(Part 3)");
		Object[] ten = createArray(10000);
		Object[] twenty = createArray(20000);
		Object[] forty = createArray(40000);
		Object[] eighty = createArray(80000);
		Object[] hundred = createArray(100000);
		
		long start1 = 0;
        		long end1= 0;
       		long start2 = 0;
        		long end2 = 0;
        		long start3 = 0;
        		long end3 = 0;
        		long start4 = 0;
        		long end4 = 0;
				long start5 = 0;
				long end5 = 0;
        		long runTime1 = 0;
        		long runTime2 = 0;
        		long runTime3 = 0;
        		long runTime4 = 0;
				long runTime5 = 0;
        		
				
		start1 = System.nanoTime();
        MaxPriorityQueue queue3 = new MaxPriorityQueue(ten);
		end1 = System.nanoTime();
        runTime1 = (end1 - start1);
        
       	start2 = System.nanoTime();
        MaxPriorityQueue queue4 = new MaxPriorityQueue(twenty);
		end2 = System.nanoTime();
        runTime2 = (end2 - start2);
        
       	start3 = System.nanoTime();
        MaxPriorityQueue queue5 = new MaxPriorityQueue(forty);
		end3 = System.nanoTime();
        runTime3 = (end3 - start3);
        
        start4 = System.nanoTime();
        MaxPriorityQueue queue6 = new MaxPriorityQueue(eighty);
		end4 = System.nanoTime();
        runTime4 = (end4 - start4);
				
		start5 = System.nanoTime();
        MaxPriorityQueue queue7 = new MaxPriorityQueue(hundred);
		end5 = System.nanoTime();
        runTime5 = (end5 - start5);
        
        System.out.println("ii. Time in nanoseconds: \n10,000:		" 
		+ runTime1 + "\n20,000:		" + runTime2 + "\n40,000:		" + runTime3 
		+ "\n80,000:		" + runTime4 + "\n100,000:	" + runTime5);
			
		
	}

}
