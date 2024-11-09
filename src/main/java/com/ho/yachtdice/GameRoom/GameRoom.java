package com.ho.yachtdice.GameRoom;

import com.ho.yachtdice.DTO.GameMessage;
import com.ho.yachtdice.service.GameService;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
public class GameRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public GameRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handlerActions(WebSocketSession session, GameMessage gameMessage, GameService chatService) {
        if (gameMessage.getType().equals(GameMessage.MessageType.ENTER)) {
            sessions.add(session);
            gameMessage.setMessage(gameMessage.getSender() + "님이 입장했습니다.");
        }
        sendMessage(gameMessage, chatService);

    }

    private <T> void sendMessage(T message, GameService chatService) {
        sessions.parallelStream()
                .forEach(session -> chatService.sendMessage(session, message));
    }
}
