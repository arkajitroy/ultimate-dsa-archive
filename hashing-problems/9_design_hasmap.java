class Entry {
    int key;
    int value;
    Entry next;
    Entry(int K, int V){
        this.key = K;
        this.value = V;
    }
}

class MyHashMap {
    private final int SIZE = 1000;
    private Entry[] table;

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new Entry(key, value);
        } else {
            Entry current = table[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value; // update existing key
                    return;
                }
                current = current.next;
            }

            // Key not found, insert at head
            Entry newEntry = new Entry(key, value);
            newEntry.next = table[index];
            table[index] = newEntry;
        }
    }

    public int get(int key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }

        return -1; // key not found
    }

    public void remove(int key) {
        int index = hash(key);
        Entry current = table[index];
        Entry prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next; // removing head
                } else {
                    prev.next = current.next;
                }
                return;
            }

            prev = current;
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

class Main {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1)); // 10
        System.out.println(map.get(3)); // -1

        map.put(2, 30);
        System.out.println(map.get(2)); // 30

        map.remove(2);
        System.out.println(map.get(2)); // -1
    }
}
