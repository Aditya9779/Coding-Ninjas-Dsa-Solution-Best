import java.util.ArrayList;
import java.util.Stack;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    public void add(String word) {
        /*We have to insert method because for sending the child attachatments
        also if the we did't make the private function then we are searching the another time in the
         root value but we have to search in the root.childern for the attachements*/
        insert(root, word);
    }

    private void insert(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.childCount++;
            root.children[childIndex] = child;
        }
        insert(child, word.substring(1));
    }

    public boolean search(String word) {
        return find(root, word);
    }

    private boolean find(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return find(child, word.substring(1));
    }

    public void remove(String word) {
        delete(root, word);
    }

    private void delete(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = false;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        delete(child, word.substring(1));
        /* From the aboue line we are just clearing the
        terminating color for the end but we are not deleting the whole value just simply remove the
        the end point of the color */

        /* Deleting steps start from here*/
        /* There are two condition that we are deleting */

        /*********************************************************************************/

        // 1- If the sentence have no another termanating value in its above for example
        // news in this there are two words that have the terminating is W and S so in this
        // we delete only the S in the letter.

        /*********************************************************************************/

        //2- Take the above example if S also have the children then we donot have to remove
        // the value NEWSATE so this we have some children of S and E has the terminating value
        // so we are not able to delete that words

        /***********************************************************************************/

       /* if (!child.isTerminating) {
            int numberOfChildren = 0;
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    numberOfChildren++;
                }
            }
            if (numberOfChildren == 0) {
                root.children[childIndex] = null;
            }
        }*/
        //There is the shortcut for writing this whole code --
        //Add the childCount in the starting and add while adding the every node
        /**********The  Short Code starts From Here*/
        if (!child.isTerminating && child.childCount == 0) {
            root.children[childIndex] = null;
            root.childCount--;
        }
        //More Understand Method is Uppward Only

    }

    /* Question For the Trie*/

    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        for (int i = 0; i < vect.size(); i++) {
            String word = vect.get(i);
            for (int j = 0; j < word.length(); j++) {
                String ans = word.substring(j);
                add(ans);
            }
        }
        return search(pattern);
    }

 /*   private boolean isPalindrome(String word) {
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
        add(sub);
    }*/



    }


