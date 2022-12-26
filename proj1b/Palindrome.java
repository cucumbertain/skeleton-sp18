import java.nio.charset.StandardCharsets;

public class Palindrome {
    /** Make a LinkedListDeque made by characters given. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i += 1) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    private boolean helperIsPalindrome(Deque d) {
        if(d.size() <= 1) {
            return true;
        } else {
            return(d.removeFirst() == d.removeLast()) && helperIsPalindrome(d);
        }
    }

    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        return helperIsPalindrome(d);
    }

    private boolean helperIsPalindrome(Deque d, CharacterComparator cc) {
        if(d.size() <= 1) {
            return true;
        } else {
            return cc.equalChars((char)d.removeFirst(), (char)d.removeLast()) && helperIsPalindrome(d);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return helperIsPalindrome(d, cc);
    }
}
