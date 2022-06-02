import java.util.Queue;

public class Model {

    private final Dictionary dictionary;

    public Model() {
        this.dictionary = new Dictionary();
    }

    public Queue<DefinitionResponse> findDefinitions(String str) {
        return dictionary.findDefinitions(str);
    }

}
