import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AIModel {
    private Map<String, String[]> responses;
    private Map<String, String> context;
    private Random random;
    private String lastUserMessage;

    public AIModel() {
        responses = new HashMap<>();
        context = new HashMap<>();
        random = new Random();
        initializeResponses();
    }

    private void initializeResponses() {
        // Greetings
        responses.put("hello", new String[]{
            "Hello! How can I help you today?",
            "Hi there! What can I do for you?",
            "Greetings! How may I assist you?",
            "Hello! I'm your AI assistant. What would you like to know?"
        });

        // How are you
        responses.put("how are you", new String[]{
            "I'm doing well, thank you for asking! How about you?",
            "I'm great! How are you doing today?",
            "All systems operational and feeling good! How's your day going?",
            "I'm functioning perfectly! How are you feeling today?"
        });

        // Goodbye
        responses.put("bye", new String[]{
            "Goodbye! Have a great day!",
            "See you later! Take care!",
            "Bye! Come back anytime!",
            "Farewell! It was nice chatting with you!"
        });

        // Thank you
        responses.put("thank", new String[]{
            "You're welcome! Is there anything else I can help you with?",
            "My pleasure! Feel free to ask if you need anything else.",
            "Happy to help! Don't hesitate to ask more questions.",
            "Anytime! I'm here to assist you."
        });

        // Name related
        responses.put("your name", new String[]{
            "I'm AI Assistant, your friendly chatbot!",
            "You can call me AI Assistant. How can I help you today?",
            "I'm AI Assistant, and I'm here to assist you!",
            "My name is AI Assistant. Nice to meet you!"
        });

        // Help
        responses.put("help", new String[]{
            "I can help you with various tasks! Just let me know what you need.",
            "I'm here to assist you! What would you like to know?",
            "I can answer questions, provide information, or just chat. What do you need?",
            "I'm your AI assistant. How can I help you today?"
        });

        // Weather
        responses.put("weather", new String[]{
            "I'm sorry, I don't have access to real-time weather data. You might want to check a weather service for that.",
            "I can't check the weather directly, but I can suggest some weather websites or apps you can use.",
            "I don't have weather information, but I can help you find a reliable weather service."
        });

        // Time
        responses.put("time", new String[]{
            "I don't have access to real-time clock data. You might want to check your device's clock.",
            "I can't tell you the exact time, but I can help you find a reliable time service."
        });

        // Jokes
        responses.put("joke", new String[]{
            "Why don't scientists trust atoms? Because they make up everything!",
            "Why did the scarecrow win an award? Because he was outstanding in his field!",
            "What do you call a fake noodle? An impasta!",
            "How does a penguin build its house? Igloos it together!"
        });

        // Feelings
        responses.put("sad", new String[]{
            "I'm sorry to hear you're feeling down. Would you like to talk about it?",
            "That's tough. Remember that it's okay to feel sad sometimes. Is there anything I can do to help?",
            "I'm here to listen if you want to share what's bothering you."
        });

        responses.put("happy", new String[]{
            "That's wonderful to hear! I'm glad you're feeling happy!",
            "Your happiness is contagious! What's making you feel so good?",
            "That's great! I'm happy that you're happy!"
        });
    }

    public String getResponse(String input) {
        input = input.toLowerCase().trim();
        lastUserMessage = input;
        
        // Check for context-based responses
        if (context.containsKey("waiting_for_name")) {
            context.remove("waiting_for_name");
            return "Nice to meet you, " + input + "! How can I help you today?";
        }

        // Pattern matching for more complex responses
        if (Pattern.compile("my name is (.*)").matcher(input).matches()) {
            Matcher matcher = Pattern.compile("my name is (.*)").matcher(input);
            if (matcher.find()) {
                String name = matcher.group(1);
                return "Nice to meet you, " + name + "! How can I help you today?";
            }
        }

        // Check for exact matches
        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                String[] possibleResponses = responses.get(key);
                return possibleResponses[random.nextInt(possibleResponses.length)];
            }
        }

        // Handle questions
        if (input.endsWith("?")) {
            return "That's an interesting question. Let me think about it... " +
                   "I'm still learning, but I'll do my best to help you with that.";
        }

        // Handle statements
        if (input.length() > 0) {
            return "I understand you're saying: \"" + input + "\". " +
                   "Could you tell me more about that?";
        }

        // Default response
        return "I'm not sure I understand. Could you please rephrase that?";
    }

    public void setContext(String key, String value) {
        context.put(key, value);
    }

    public String getLastUserMessage() {
        return lastUserMessage;
    }
} 