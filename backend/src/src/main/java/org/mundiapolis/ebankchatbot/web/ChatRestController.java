package org.mundiapolis.ebankchatbot.web;
import org.mundiapolis.ebankchatbot.services.ChatAiService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/chat")
public class ChatRestController {
    private ChatAiService chatAiService;

    public ChatRestController(ChatAiService chatAiService){

        this.chatAiService = chatAiService;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String question){

        return chatAiService.ragChat(question);
    }
}
