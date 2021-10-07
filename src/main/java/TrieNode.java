public class TrieNode {

    private final static int R = 26;

    private boolean isEnd;
    private TrieNode[] links;

    public TrieNode() {
        this.links = new TrieNode[TrieNode.R];
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }

}

