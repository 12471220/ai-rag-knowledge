package dev.api;

import org.springframework.ai.chat.ChatResponse;
import reactor.core.publisher.Flux;

public interface IAiService {
    ChatResponse generate(String model, String messages);

    Flux<ChatResponse> generateStream(String model, String messages);
}
