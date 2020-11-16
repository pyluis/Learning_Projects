package JavaProjects;
import java.util.*;


public class TrieNode {

    // Word for this Node
    private String string;
    // pointers to the next nodes
    private HashMap<String, TrieNode> children = new HashMap<String,TrieNode>(); 
    // Phrase Terminator 
    private boolean isPhrase;
    
    //contructor
    public TrieNode(){
    }
    // constructor
    public TrieNode(String string, boolean isPhrase){
        this.string = string;
        this.isPhrase = isPhrase;
    }
    //returns children of Node
    public HashMap<String, TrieNode> getChildren(){
        return this.children;
    }

    //returns isPhrase parameter to check if this is the last node in a phrase
    public boolean isPhrase(){
        return isPhrase; 
    }

    // Adds child to HashMap
    public void addChild(String word, boolean isPhrase){
        
        TrieNode node = new TrieNode(word, isPhrase);
        // Check whether this node has the word in its children already
        if (!children.containsKey(word)){
            this.children.put(word,node);
        }

    }

    public void setString(String word){
        this.string = word;
    }

    public void setIsPhrase(boolean b){
        this.isPhrase = b;
    }

    public String getString(){
        return this.string;
    }
}
