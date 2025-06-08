import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ChatController {
    private final AIModel aiModel;

    public ChatController() {
        this.aiModel = new AIModel();
    }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");
        String response = aiModel.getResponse(userMessage);
        
        return Map.of("response", response);
    }
} 