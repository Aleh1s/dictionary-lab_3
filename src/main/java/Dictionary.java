import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Dictionary {

    private final Hashtable hashtable;
    private final String DEFAULT_DICTIONARY_PATH;

    public Dictionary() {
        DEFAULT_DICTIONARY_PATH = Property
                .getInstance()
                .getProperties()
                .getProperty("default.dictionary.path");
        hashtable = loadContent();
    }

    public Hashtable loadContent() {
        Hashtable hashtable = new Hashtable();
        List<String> content = IOStream.readLines(DEFAULT_DICTIONARY_PATH);

        for (String definition : content) {
            String key = definition.substring(0, definition.indexOf(";"));
            hashtable.put(key.toLowerCase(), definition);
        }

        return hashtable;
    }

    public String findDefinition(String key) {
        key = key.toLowerCase();
        return hashtable.get(key);
    }

    public String[] findDefinitions(String str) {
        if (!Objects.nonNull(str)) {
            return null;
        }

        if (Objects.equals(str, "")) {
            return null;
        }

        str = str.replaceAll("[,!?():{}\\[\\]]", " ");
        String[] words = str.split(" +");

        for (int i = 0; i < words.length; i++) {
            words[i] = findDefinition(words[i]);
        }

        return words;
    }
}
