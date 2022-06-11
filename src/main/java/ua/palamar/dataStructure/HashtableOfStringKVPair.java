package ua.palamar.dataStructure;

import ua.palamar.exception.NoElementWithSuchKeyException;

import java.util.Objects;

public class HashtableOfStringKVPair {

    private LinkedListOfStringKVPair[] table;
    private int count;
    private int threshold;
    private final float loadFactor;

    public HashtableOfStringKVPair() {
        this(11, 0.80f);
    }

    private HashtableOfStringKVPair(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.table = new LinkedListOfStringKVPair[initialCapacity];
        this.threshold = (int) (loadFactor * initialCapacity);
    }

    public void put(String key, String value) {
        if (count >= threshold) {
            rehash();
        }

        LinkedListOfStringKVPair[] tab = table;
        int hash = key.hashCode();
        int index = (hash & Integer.MAX_VALUE) % tab.length;
        if (!Objects.nonNull(tab[index])) {
            tab[index] = new LinkedListOfStringKVPair();
        }
        boolean put = tab[index].put(key, value, hash);

        if (put) {
            count++;
        }
    }

    private void rehash() {
        LinkedListOfStringKVPair[] oldTab = table;
        int oldLength = oldTab.length;
        int newLength = oldLength * 2 + 1;

        LinkedListOfStringKVPair[] newTab = new LinkedListOfStringKVPair[newLength];
        for (LinkedListOfStringKVPair list : oldTab) {
            if (Objects.nonNull(list)) {
                for (NodeOfStringKVPair current = list.getFirst(); Objects.nonNull(current); current = current.next) {
                    int hash = current.hash;
                    int index = (hash & Integer.MAX_VALUE) % newLength;

                    if (!Objects.nonNull(newTab[index])) {
                        newTab[index] = new LinkedListOfStringKVPair();
                    }
                    newTab[index].put(current);
                }
            }
        }
        threshold = (int) (newLength * loadFactor);
        table = newTab;
    }

    public String get(String key) throws NoElementWithSuchKeyException {
        LinkedListOfStringKVPair[] tab = table;

        int hash = key.hashCode();
        int index = (hash & Integer.MAX_VALUE) % tab.length;

        LinkedListOfStringKVPair linkedList = tab[index];
        if (Objects.nonNull(linkedList)) {
            for (NodeOfStringKVPair current = linkedList.getFirst(); Objects.nonNull(current); current = current.next) {
                if (hash == current.hash && key.equals(current.key)) {
                    return current.value;
                }
            }
        }

        throw new NoElementWithSuchKeyException(
                String.format("Element with key [%s] does not exist", key)
        );
    }

    public java.lang.String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedListOfStringKVPair list : table) {
            if (Objects.nonNull(list)) {
                sb.append(list).append('\n');
            }
        }
        java.lang.String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }
}
