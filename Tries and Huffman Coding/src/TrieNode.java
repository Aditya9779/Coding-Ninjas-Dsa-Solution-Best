public class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode[] children;
     int childCount;

    public TrieNode(char data) {
        this.data = data;
        children = new TrieNode[26];
        isTerminating = false;
        childCount = 0;
    }


}

//This is the  TrieNode class which has the data and the terminating point and the array of
// Letters of 26 alphabet
// IsTerminating is used for the letter is end or not

