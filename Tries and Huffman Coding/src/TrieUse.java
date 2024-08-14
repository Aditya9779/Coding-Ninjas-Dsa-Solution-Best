public class TrieUse {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("world");
        System.out.println(trie.search("hello") + ": " + trie.search("world"));
        trie.remove("world");
        System.out.println(trie.search("world") + ": " + trie.search("hello"));
    }
}
