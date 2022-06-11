package ua.palamar.dataStructure;

class NodeOfStringKVPair {

    int hash;
    String key;
    String value;
    NodeOfStringKVPair next;

    public NodeOfStringKVPair(
            int hash,
            String key,
            String value
    ) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = null;
    }
}