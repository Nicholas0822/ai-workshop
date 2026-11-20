package com.nwhite.ai.workshop.async;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AsyncChatController {
    private final ChatClient chatClient;

    public AsyncChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/stream")
    public Flux<String> stream() {
        return chatClient.prompt()
                .user("I am visiting Velikiy Novgorod, Russia can you give me 10 places I must visit")
                .stream()
                .content();
    }
}
