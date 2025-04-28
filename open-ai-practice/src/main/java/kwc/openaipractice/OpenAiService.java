package kwc.openaipractice;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class OpenAiService {

    private final ChatModel chatModel;

    public OpenAiService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public ChatResponse foo() {
        var imageResource = new ClassPathResource("/multimodal.test.png");

        var userMessage = new UserMessage("Explain what do you see on this picture?",
                new Media(MimeTypeUtils.IMAGE_PNG, imageResource));

        ChatResponse response = chatModel.call(new Prompt(userMessage,
                OpenAiChatOptions.builder().model(OpenAiApi.ChatModel.GPT_4_O.getValue()).build()));

        return response;
    }
}
