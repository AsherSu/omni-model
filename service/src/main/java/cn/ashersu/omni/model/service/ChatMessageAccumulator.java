package cn.ashersu.omni.model.service;

import cn.ashersu.omni.model.completion.chat.ChatFunctionCall;
import cn.ashersu.omni.model.completion.chat.SimpleChatMessage;

/**
 * Class that accumulates chat messages and provides utility methods for
 * handling message chunks and function calls within a chat stream. This
 * class is immutable.
 *
 * @author [Your Name]
 */
public class ChatMessageAccumulator {

    private final SimpleChatMessage messageChunk;
    private final SimpleChatMessage accumulatedMessage;

    /**
     * Constructor that initializes the message chunk and accumulated message.
     *
     * @param messageChunk The message chunk.
     * @param accumulatedMessage The accumulated message.
     */
    public ChatMessageAccumulator(SimpleChatMessage messageChunk, SimpleChatMessage accumulatedMessage) {
        this.messageChunk = messageChunk;
        this.accumulatedMessage = accumulatedMessage;
    }

    /**
     * Checks if the accumulated message contains a function call.
     *
     * @return true if the accumulated message contains a function call, false otherwise.
     */
    public boolean isFunctionCall() {
        return getAccumulatedMessage().getFunctionCall() != null && getAccumulatedMessage().getFunctionCall().getName() != null;
    }

    /**
     * Checks if the accumulated message contains a chat message.
     *
     * @return true if the accumulated message contains a chat message, false otherwise.
     */
    public boolean isChatMessage() {
        return !isFunctionCall();
    }

    /**
     * Retrieves the message chunk.
     *
     * @return the message chunk.
     */
    public SimpleChatMessage getMessageChunk() {
        return messageChunk;
    }

    /**
     * Retrieves the accumulated message.
     *
     * @return the accumulated message.
     */
    public SimpleChatMessage getAccumulatedMessage() {
        return accumulatedMessage;
    }

    /**
     * Retrieves the function call from the message chunk.
     * This is equivalent to getMessageChunk().getFunctionCall().
     *
     * @return the function call from the message chunk.
     */
    public ChatFunctionCall getChatFunctionCallChunk() {
        return getMessageChunk().getFunctionCall();
    }

    /**
     * Retrieves the function call from the accumulated message.
     * This is equivalent to getAccumulatedMessage().getFunctionCall().
     *
     * @return the function call from the accumulated message.
     */
    public ChatFunctionCall getAccumulatedChatFunctionCall() {
        return getAccumulatedMessage().getFunctionCall();
    }
}
