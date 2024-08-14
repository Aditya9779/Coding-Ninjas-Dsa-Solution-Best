import java.util.ArrayList;

public class TrieQuestion {
   /* public static int CountWords(String word) {
        See the numwords because its in inteliji its not running
    }*/
    //Code
    /*
    * class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	private int numWords;

	public Trie() {
		root = new TrieNode('\0');
		numWords = 0;
	}


	public void remove(String word){
		if(remove(root, word)) {
			numWords--;
		}
	}


	private boolean remove(TrieNode root, String word) {
		if(word.length() == 0){
			if(root.isTerminating) {
				root.isTerminating = false;
				return true;
			}
			else {
				return false;
			}
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		boolean ans = remove(child, word.substring(1));
		// We can remove child node only if it is non terminating and its number of children are 0

		if(!child.isTerminating && child.childCount == 0){
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
		return ans;
	}

	private boolean add(TrieNode root, String word){
		if(word.length() == 0){
			if(root.isTerminating) {
				return false;
			}
			else {
				root.isTerminating = true;
				return true;
			}
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));
	}

	public void add(String word){
		if(add(root, word)) {
			numWords++;
		}
	}

	public int countWords() {
		// Write your code here
		return numWords;
	}

}*/

    private boolean isPalindrome(String word) {
        if (word.length() == 0) {
            return true;
        }
        if(word.charAt(0) != word.charAt(word.length()-1)) {
            return false;
        }
        return isPalindrome(word.substring(1, word.length()-1));
    }

    public boolean isPalindromePair(ArrayList<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            String sub = words.get(i);
            if (isPalindrome(sub)) {
                return true;
            }
            for (int j = i + 1; j < words.size(); j++) {
            String ans=sub.concat(words.get(j));
            String ans1=(words.get(j)).concat(sub);
            if (isPalindrome(ans) || isPalindrome(ans1)) {
                return true;
            }
            }

        }
return false;
        }
}
