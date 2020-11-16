package JavaProjects;
@SuppressWarnings("unchecked")
public class ClassTest {
    public static void main(String[] args) {
        
        Trie t =  new Trie();

        String[] phrases = {"This is Luis", "This is cool","Hi my name is Luis",  "I like cake", "Soccer is awesome", "words are cool"};

        t.insertPhrases(phrases);

        String body1 = "This is luis";

        boolean response1 = t.search(body1);

        System.out.println(response1);

        
    }
}
