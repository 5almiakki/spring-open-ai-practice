package kwc.openaipractice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {

    private final OpenAiService openAiService;

    public OpenAIController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(openAiService.foo());
    }
}
