package dev.trigger.http;

import dev.api.IAiService;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/ollama")
public class OllamaController implements IAiService {

    @Resource
    private OllamaChatClient chatClient;

    /**
     * http://localhost:8090/api/v1/ollama/generate?model=deepseek-r1:1.5b&messages=hello
     * 非流式生成
     * @param model 模型名称
     * @param messages 消息内容
     * @return 响应
     */
    @Override
    @RequestMapping(value = "generate", method = RequestMethod.GET)
    public ChatResponse generate(@RequestParam("model") String model, @RequestParam("messages") String messages) {
        return chatClient.call(new Prompt(messages, OllamaOptions.create().withModel(model)));
    }

    /**
     * http://localhost:8090/api/v1/ollama/generateStream?model=deepseek-r1:1.5b&messages=hello
     * 流式生成
     * @param model 模型名称
     * @param messages 消息内容
     * @return 流式响应
     */
    @Override
    @RequestMapping(value = "generateStream", method = RequestMethod.GET)
    public Flux<ChatResponse> generateStream(@RequestParam("model") String model, @RequestParam("messages") String messages) {
        return chatClient.stream(new Prompt(messages, OllamaOptions.create().withModel(model)));
    }
}
