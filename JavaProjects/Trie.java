package JavaProjects; 
import java.util.HashMap;

public class Trie{
    private TrieNode root;
    // constructor
    public Trie(){
        // set a root node
        this.root = new TrieNode();;
    }

    public void insertPhrase(String phrase){
        HashMap<String, TrieNode> children = root.getChildren();
        // split phrase into an array of strings
        String[] words = phrase.split(" ");

        for(int i = 0; i<words.length;i++){
            // clean up the word and remove non-alphanumeric values
            String s = words[i].replaceAll("[^a-zA-Z0-9]", "").toLowerCase().trim();
            // Instantiate a variable to hold a TrieNode Variable
            TrieNode node;
            // check if the word is in the children of the current node
            if(children.containsKey(s)){
                //if it is move to the pointer to the next node 
                node = children.get(s);
            }else{
                // if it is not set the node to a new TrieNode variable
                node = new TrieNode();
                // set the data component of the variable
                node.setString(s);
                //all add this node to the children 
                children.put(s, node);
            }
            // move pointer to next set of children 
            children = node.getChildren();
            // check if this is the last word in a phrase 
            if(i==words.length-1){
                // if it is set the terminator to true 
                node.setIsPhrase(true);
            }
        }
        
    }

    // Inserts a list of phrases we want have stored in our Trie.
    public void insertPhrases(String[] phrases){
        // iterate over the array of phrases
        for(int i = 0; i<phrases.length;i++){
            // get the phrase from the array at the ith element and remove no alphanumerica values 
            String phrase = phrases[i];
            insertPhrase(phrase);
        }
    }

    public boolean search(String phrase){
        // search tree to see if nodes exist
        TrieNode node = searchNode(phrase);
        // if node is not equal to the root node & the node is a terminator than phrase is found else no
        if(node!=this.root && node.isPhrase())
            return true;
        else
            return false; 
         
    }

    public TrieNode searchNode(String phrase){
        // set the 
        HashMap<String, TrieNode> children = root.getChildren();
        // set the current node to the root
        TrieNode node = this.root;
        // split phrase string into an array of strings
        String[] words = phrase.split(" ");
        // loop through the array of words
        for(int i=0;i<words.length;i++){
            // get word in the ith index position 
            String s = words[i];
            // clean up word
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().trim();
            // check if current node contains the word as a child
            if(children.containsKey(s)){
                // move the pointer to the words node
                node = children.get(s);
                // set children variable to new nodes children
                children = node.getChildren();
            }else{
                // if the word was not found check the nodes w
                if(!node.isPhrase()){
                    // reset children back to root node
                    children = root.getChildren();
                    // check if the current word is a child in the root node
                    if(children.containsKey(s)){
                        // set the node to that child
                        node = children.get(s);
                        // set the children to that node's children
                        children = node.getChildren();
                    }
                }   
            }

        }
        return node; 
    }   

    

}