/*

import java.util.ArrayList;

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numBuckets;

    public Map(K key, V value) {
        numBuckets = 5;
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
        size = 0;
    }

    public Map() {

    }

    private int getIndexForKey(K key) {// This function is known as hashcode methods
        int hashKey = key.hashCode(); //This line is used for making the hashcode function
        return Math.abs(hashKey) % numBuckets;  // This line is for generating the compact form to adjust in array
    }

    public void insert(K givenKey, V givenValue) {
        int bucketIndex = getIndexForKey(givenKey);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(givenKey)) {  // If we get the same value then update the value
                head.value = givenValue;
                return;
            }
            head = head.next; // This step in which head comes to null
        }
        head = buckets.get(bucketIndex); // Restart the head because we reach in the above expressiono to null
        MapNode<K, V> newNode = new MapNode<>(givenKey, givenValue); // This line if no node is present then we have to create the node
        size++;
        newNode.next = head; // New node give the head to the next one
        buckets.set(bucketIndex, newNode); // Set the newnode as the index of the arraylist
//       double LoadFactor=(1.0)*size/numBuckets; // we have to multiply by 1.0 because int / int so we are calculating in double
//        if (LoadFactor > 0.7) {
//            rehasing();
//        }
        double loadFactor = (1.0 * size) / numBuckets;
        if (loadFactor > 0.7) {
            rehasing();
        }
    }

    public double loafFactor() {
        return (1.0 * size) / numBuckets;
    }
    private void rehasing() {
        System.out.println("Rehashing: buckets: " + numBuckets + "size: " + size);
        ArrayList<MapNode<K, V>> temp = buckets;
        numBuckets *= 2;
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }

        size = 0;
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }

    }

    public int size() {
        return size;
    }

    public V getValue(K givenkey) {
        int bucketIndex = getIndexForKey(givenkey);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(givenkey)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeValue(K givenkey) {
        int bucketIndex = getIndexForKey(givenkey);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(givenkey)) {
                size--;
                if (prev == null) {
                    buckets.set(bucketIndex, head.next);
                } else {
                    prev.next = head.next;
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }


}
*/
// Up code is not working but it has the explanation of the below code

import java.util.ArrayList;

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numBuckets;
    double loadFactorThreshold = 0.7;

    public Map() {
        numBuckets = 5; // Initial number of buckets
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
        size = 0;
    }

    private int getIndexForKey(K key) {
        int hashKey = key.hashCode();
        return Math.abs(hashKey) % numBuckets;
    }

    public double loafFactor() {
        return (1.0 * size) / numBuckets;
    }

    public void insert(K givenKey, V givenValue) {
        int bucketIndex = getIndexForKey(givenKey);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(givenKey)) {
                head.value = givenValue; // Update value if key already exists
                return;
            }
            head = head.next;
        }
        MapNode<K, V> newNode = new MapNode<>(givenKey, givenValue);
        head = buckets.get(bucketIndex);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        size++;
        if (loadFactor() > loadFactorThreshold) {
            rehashing();
        }
    }

    public double loadFactor() {
        return (1.0 * size) / numBuckets;
    }

    private void rehashing() {
        ArrayList<MapNode<K, V>> temp = buckets;
        numBuckets *= 2; // Double the number of buckets
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
        size = 0;
        for (MapNode<K, V> node : temp) {
            while (node != null) {
                insert(node.key, node.value); // Re-insert each key-value pair
                node = node.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public V getValue(K givenkey) {
        int bucketIndex = getIndexForKey(givenkey);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(givenkey)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeValue(K givenkey) {
        int bucketIndex = getIndexForKey(givenkey);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(givenkey)) {
                size--;
                if (prev == null) {
                    buckets.set(bucketIndex, head.next);
                } else {
                    prev.next = head.next;
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
}

