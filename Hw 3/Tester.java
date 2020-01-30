 import java.util.Random;

public class Tester {
	public static Object[] createArray (int size) 
    {
		Random rand = new Random();
		Object[] A = new Object[size];
        int num = 0;
		for (int i = 0; i < size; i++) {
        	if(num == 100001) {
        		num++;
        	}
			A[i] = num;
        }
        return A;
    }
	
	public static void main(String[] args) {
		System.out.println("---------- PART 1 ----------");
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert("Bryce Canyon NP");
		bst.insert("Yosemite NP");
		bst.insert("Joshua Tree NP");
		bst.insert("Zion NP");
		bst.insert("Redwoods NP");
		bst.insert("Lassen Volcanic NP");
		System.out.println("\n(II). ");
		bst.printInorder();
		System.out.println("\n(IV)");
		bst.delete("Redwoods NP");
		bst.printPreorder();
		try {
			bst.delete("Yellowstone NP");
		}
		catch (Exception e) {
			System.out.println("\n(V) Couldn't find Yellowstone NP.");
		}
		
		System.out.println("\n---------- PART 2 ----------");
		Object[] data = {2,4,1,5,9,7,10};
		BinarySearchTree bst2 = new BinarySearchTree(data);
		bst2.insert(11);
		bst2.insert(-1);
		System.out.println("\n(II)");
		bst2.printPostorder();
		bst2.delete(2);
		System.out.println("\n(IV)");
		bst2.printInorder();
		
		System.out.println("\n---------- PART 3 ----------");
		Object[] ten = createArray(10000);
		BinarySearchTree bstten = new BinarySearchTree(ten);
		long start1 = System.nanoTime();
		bstten.find(100001);
		long end1 = System.nanoTime();
        long runTime1 = (end1 - start1);
        System.out.println("Time for 10000: "+runTime1+" nanoseconds.");
        
        Object[] twenty = createArray(20000);
		BinarySearchTree bsttwenty = new BinarySearchTree(twenty);
		long start2 = System.nanoTime();
		bsttwenty.find(100001);
		long end2 = System.nanoTime();
        long runTime2 = (end2 - start2);
        System.out.println("Time for 20000: "+runTime2+" nanoseconds.");
        
        Object[] forty = createArray(40000);
		BinarySearchTree bstforty = new BinarySearchTree(forty);
		long start3 = System.nanoTime();
		bstforty.find(100001);
		long end3 = System.nanoTime();
        long runTime3 = (end3 - start3);
        System.out.println("Time for 40000: "+runTime3+" nanoseconds.");
        
        Object[] eighty = createArray(80000);
		BinarySearchTree bsteighty = new BinarySearchTree(eighty);
		long start4 = System.nanoTime();
		bsteighty.find(100001);
		long end4 = System.nanoTime();
        long runTime4 = (end4 - start4);
        System.out.println("Time for 80000: "+runTime4+" nanoseconds.");
        
        Object[] hundred = createArray(100000);
		BinarySearchTree bsthundred = new BinarySearchTree(hundred);
		long start5 = System.nanoTime();
		bsthundred.find(100001);
		long end5 = System.nanoTime();
        long runTime5 = (end5 - start5);
        System.out.println("Time for 100000: "+runTime5+" nanoseconds.");
        
	}

}
