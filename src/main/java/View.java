import java.util.Objects;
import java.util.Queue;

public class View {

    public void showDefinitions(Queue<DefinitionResponse> definitions) {
        DefinitionResponse response;
        while (Objects.nonNull(response = definitions.poll())) {
            if (!Objects.nonNull(response.getDefinition())) {
                System.out.printf("CAN NOT FIND DEFINITION FOR WORD [%s]\n", response.getQuery());
            } else {
                System.out.printf("Definition for query [%s]: %s\n",response.getQuery(), response.getDefinition());
            }
        }
    }
}
