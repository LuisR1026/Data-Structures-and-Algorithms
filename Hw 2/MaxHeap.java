import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap {
	//heap array
	Object[] heap;
	int size;
	//set high max size to prevent going out of bound
	int maxSize = 10000000;
	
	//creates an empty array of size 0
	public MaxHeap () {
		heap = new Object[maxSize];
		size = 0;
	}
	//gets array and organizes as heap
	public MaxHeap (Object[] data) {
		heap = data;
		size = data.length;
		buildMaxHeap(data);
	}
	
	public void add(Object e) {
		if (size >= heap.length) {
			throw new ArrayIndexOutOfBoundsException("Max size reached.");
		}
		heap[size] = e;
		size++;
		heapifyUp();
	}
	//helper methods
	public boolean hasParent(int i) {
		if (getParentIndex(i) >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean hasLeftChild(int i) {
		if (getLeftIndex(i) >= 0 && getLeftChild(i) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean hasRightChild(int i) {
		if (getRightIndex(i) >= 0 && getRightChild(i) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Object getParent(int i) {
		return heap[getParentIndex(i)];
	}
	
	public Object getLeftChild(int i) {
		return heap[getLeftIndex(i)];	
	}
	
	public Object getRightChild(int i) {
		return heap[getRightIndex(i)];
	}
	//formula that mathematically gets the index of current node's parent
	public int getParentIndex(int i) {
		return (i - 1)/2;
	}
	//gets the index of current node's left child
	public int getLeftIndex(int i) {
		return (2 * i) + 1;
	}
	//gets the index of current node's right child
	public int getRightIndex(int i) {
		return (2 * i) + 2;
	}
	//swap elements at index i and j
	public void swap(int i, int j) {
		Object temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	//compare the current nodes position with the parent
	public void heapifyUp() {
		int i = size - 1;
		if (heap[0] instanceof Integer) {
			while(hasParent(i) && (int)getParent(i) < (int)heap[i]) {
				swap(getParentIndex(i), i);
				i = getParentIndex(i);
			}
		}
		else if (heap[0] instanceof String) {
			while(hasParent(i) && ((String)getParent(i)).compareToIgnoreCase((String)heap[i]) < 0) {
				swap(getParentIndex(i), i);
				i = getParentIndex(i);
			}
		}
		
	}
	
	//compare the current nodes position and adjusts accordingly
	public void heapifyDown(int i) {
		while(hasLeftChild(i)) {
			int largerChildIndex = getLeftIndex(i);
			if(hasRightChild(i)) {
				if(heap[0] instanceof Integer) {
					if((int)getRightChild(i) > (int)getLeftChild(i)) {
						largerChildIndex = getRightIndex(i);
					}
				}
				else if(heap[0] instanceof String) {
					if(((String)getRightChild(i)).compareToIgnoreCase((String)getLeftChild(i)) > 0) {
						largerChildIndex = getRightIndex(i);
					}
				}
				
			}
			if(heap[0] instanceof Integer) {
				if ((int)heap[i] < (int)heap[largerChildIndex]) {
					swap(largerChildIndex, i);
					}
				else {
					break;
				}
			}
			else if(heap[0] instanceof String) {
				if (((String)heap[i]).compareToIgnoreCase((String)heap[largerChildIndex]) < 0) {
					swap(largerChildIndex, i);
					}
				else {
					break;
				}
			}
			i = largerChildIndex;
		}
	}
	
	//removes element
	public Object remove(Object e) {
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				Object cur = heap[i];
				
				if(cur instanceof Integer) {
					if ((int)cur == (int)e) {
						heap[i] = null;
						swap(i, size-1);
						size--;
						heapifyDown(i);
						return cur;
					}
				}
				else if(cur instanceof String) {
					if (((String)cur).equals((String)e)) {
						heap[i] = null;
						swap(i, size-1);
						size--;
						heapifyDown(i);
						return cur;
					}
				}
			}
		}
		throw new NoSuchElementException ("Element isn't in the heap.");
	}
	
	//base case for adjusting an array of random data
	public void buildMaxHeap(Object[] data) {
		heap = new Object[maxSize];
		size = data.length;
		for (int i = 0; i < data.length; i++) {
			heap[i] = data[i];
		}
		for (int i = data.length/2; i >= 0; i--) {
			maxHeapify(data, i);
		}
	}
	
	//recursive step
	public void maxHeapify(Object[] data, int i) {
		int cur = i;
		if (heap[i] instanceof Integer) {
			if (hasLeftChild(i) && (int)getLeftChild(i) > (int)heap[cur]) {
				cur = getLeftIndex(i);
			}
			if (hasRightChild(i) && (int)getRightChild(i) > (int)heap[cur]) {
				cur = getRightIndex(i);
			}
		}
		else if (heap[i] instanceof String) {
			if (hasLeftChild(i) && ((String)getLeftChild(i)).compareToIgnoreCase((String)heap[cur]) > 0) {
				cur = getLeftIndex(i);
			}
			if (hasRightChild(i) && ((String)getRightChild(i)).compareToIgnoreCase((String)heap[cur]) > 0) {
				cur = getRightIndex(i);
			}
		}
		if (cur != i) {
			swap(i, cur);
			maxHeapify(heap, cur);
		}
	}
	
	//returns arr as string
	public String toString() {
		Object[] shortenedCopy = Arrays.copyOfRange(heap, 0, size);
		return Arrays.toString(shortenedCopy);
	}
}

