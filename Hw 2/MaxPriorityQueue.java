public class MaxPriorityQueue {
			  MaxHeap maxHeap;
			  public MaxPriorityQueue() {
			    maxHeap = new MaxHeap();
			  }
			  public MaxPriorityQueue(Object[] data) {
			    maxHeap = new MaxHeap(data);
			  }
			  public void push(Object e) {
			    maxHeap.add(e);
			  }
			  public Object peek() {
			    return maxHeap.heap[0];
			  }
			  public Object pop() {
			    return maxHeap.remove(maxHeap.heap[0]);
			  }
			  public String toString(){
				  return maxHeap.toString();
			  }
			}