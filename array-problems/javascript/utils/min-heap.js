export class MinHeap {
  constructor() {
    this.heap = [];
  }

  // Swap helper
  swap(i, j) {
    [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
  }

  // Insert a new value
  insert(val) {
    this.heap.push(val);
    this.bubbleUp(this.heap.length - 1);
  }

  // Move the value at index up to maintain heap property
  bubbleUp(index) {
    let parent = Math.floor((index - 1) / 2);
    while (index > 0 && this.heap[index] < this.heap[parent]) {
      this.swap(index, parent);
      index = parent;
      parent = Math.floor((index - 1) / 2);
    }
  }

  // Extract the min value
  extractMin() {
    if (this.heap.length === 0) return null;
    if (this.heap.length === 1) return this.heap.pop();

    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);
    return min;
  }

  // Move the value at index down to maintain heap property
  bubbleDown(index) {
    let left = 2 * index + 1;
    let right = 2 * index + 2;
    let smallest = index;

    if (left < this.heap.length && this.heap[left] < this.heap[smallest]) {
      smallest = left;
    }
    if (right < this.heap.length && this.heap[right] < this.heap[smallest]) {
      smallest = right;
    }
    if (smallest !== index) {
      this.swap(index, smallest);
      this.bubbleDown(smallest);
    }
  }

  peek() {
    return this.heap.length > 0 ? this.heap[0] : null;
  }

  size() {
    return this.heap.length;
  }
}
