package ua.palamar.dataStructure;

import java.util.Objects;

public class Hashtable {

    private Entry[] table;
    private int threshold;
    private int count;
    private int initialCapacity;
    private float loadFactor;

    static class Entry {
        String key;
        String value;
        int hash;
        Entry next;

        public Entry(String key, String value, int hash, Entry next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }

    public Hashtable(int initialCapacity, float loadFactor) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException(String.format("Invalid capacity %d", initialCapacity));

        if (loadFactor <= 0)
            throw new IllegalArgumentException(String.format("Invalid load factor %f", loadFactor));

        this.table = new Entry[initialCapacity];
        this.threshold = (int) (initialCapacity * loadFactor);
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
    }

    public Hashtable(int initialCapacity) {
        this(initialCapacity, 0.80f);
    }

    public Hashtable(float loadFactor) {
        this(11, loadFactor);
    }

    public Hashtable() {
        this(11, 0.80f);
    }

    public String put(String key, String value) {
        Entry[] tab = table;
        if (!Objects.nonNull(key)) {
            throw new NullPointerException("Key can not be null");
        }

        if (!Objects.nonNull(value)) {
            throw new NullPointerException("Value can not be null");
        }

        int hash = key.hashCode();
        int index = (hash & Integer.MAX_VALUE) % tab.length;
        Entry entry = tab[index];
        for (; entry != null; entry = entry.next) {
            if (hash == entry.hash && key.equals(entry.key)) {
                String oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        addEntry(key, hash, value, index);
        return null;
    }

    private void addEntry(String key, int hash, String value, int index) {
        Entry[] tab = table;
        if (count >= threshold) {
            rehash();

            tab = table;
            hash = key.hashCode();
            index = (hash & Integer.MAX_VALUE) % tab.length;
        }

        Entry entry = tab[index];
        tab[index] = new Entry(key, value, hash, entry);
        count++;
    }

    private void rehash() {
        int oldCapacity = table.length;
        Entry[] oldTable = table;

        int newCapacity = (oldCapacity * 2) + 1;
        Entry[] newHashtable = new Entry[newCapacity];

        threshold = (int) (newCapacity * loadFactor);
        table = newHashtable;

        for (Entry entry : oldTable) {
            for (Entry old = entry; old != null; ) {
                Entry e = old;
                old = old.next;

                int index = (e.hash & Integer.MAX_VALUE) % newCapacity;
                e.next = table[index];
                table[index] = e;
            }
        }
    }

    public String get(String key) {
        int hash = key.hashCode();
        int index = (hash & Integer.MAX_VALUE) % table.length;

        for (Entry e = table[index]; e != null; e = e.next) {
            if (e.hash == hash && Objects.equals(e.key, key)) {
                return e.value;
            }
        }

        return null;
    }
}
