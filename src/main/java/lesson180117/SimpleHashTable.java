package lesson180117;

import static java.lang.Math.abs;

public class SimpleHashTable<K, V> {

    Entry<K, V> table[];
    int size = 0;

    @SuppressWarnings("unchecked")
    public SimpleHashTable() {
        table = (Entry<K, V>[]) new Entry[16];
    }

    public void put(K key, V value) {
        final int index = abs(key.hashCode()) % table.length;

        if (table[index] == null) {
            // base case
            table[index] = new Entry<K, V>(key, value);
        } else {
            // collision case
            Entry<K, V> cur = table[index];
            while (cur.next != null) {
                if (key.equals(cur.key)) {
                    cur.value = value;
                    size++;
                    return;
                }
                cur = cur.next;
            }
            cur.next = new Entry<K, V>(key, value);
        }
        size++;
    }

    public V get(K key) {

    }

    public V remove(K key) {

    }


    static class Entry<K, V> {
        final K key;
        V value;

        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
