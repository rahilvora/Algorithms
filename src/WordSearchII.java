import java.util.List;

/**
 * Created by rahilvora on 11/30/16.
 */
public class WordSearchII {
    public static void main(String args[]){
        String[] words = {"abcd", "abc", "abd","dvx"};
        new WordSearchII().buildTrie(words);
    }
//    public List<String> findWords(char[][] board, String[] words) {
//
//    }
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode p = root;
            for(char c : word.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
    private class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
