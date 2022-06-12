package ua.palamar.dataStructure;

import java.util.Objects;

public class LinkedListOfStringKVPair {

    private NodeOfStringKVPair first;
    private NodeOfStringKVPair last;

    public boolean put(NodeOfStringKVPair nodeOfStringKVPair) {
        return put(nodeOfStringKVPair.key, nodeOfStringKVPair.value, nodeOfStringKVPair.hash);
    }

    public boolean put(String key, String value, int hash) {
        NodeOfStringKVPair nodeOfStringKVPair = new NodeOfStringKVPair(hash, key, value);
        if (!Objects.nonNull(first)) {
            first = last = nodeOfStringKVPair;
            return true;
        } else if (replaceDuplicateIfExists(nodeOfStringKVPair)){
            return false;
        } else {
            last.next = nodeOfStringKVPair;
            last = last.next;
            return true;
        }
    }

    private boolean replaceDuplicateIfExists(NodeOfStringKVPair nodeOfStringKVPair) {
        for (NodeOfStringKVPair current = first; Objects.nonNull(current); current = current.next) {
            if (current.hash == nodeOfStringKVPair.hash && current.key.equals(nodeOfStringKVPair.key)) {
                current.value = nodeOfStringKVPair.value;
                return true;
            }
        }

        return false;
    }

    public java.lang.String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (NodeOfStringKVPair current = first; Objects.nonNull(current); current = current.next) {
            sb.append(
                    java.lang.String.format("{ key: %s, value: %s } ",current.key, current.value)
            );
        }
        sb.append("]");
        return sb.toString();
    }

    public NodeOfStringKVPair getFirst() {
        return first;
    }
}
