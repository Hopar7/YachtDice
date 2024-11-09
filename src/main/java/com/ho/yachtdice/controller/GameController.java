package com.ho.yachtdice.controller;

import com.ho.yachtdice.GameRoom.GameRoom;
import com.ho.yachtdice.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @PostMapping("/createroom")
    public GameRoom createRoom(@RequestBody String name) {
        return gameService.createRoom(name);
    }

    @GetMapping("/findroom")
    public List<GameRoom> findAllRoom() {
        return gameService.findAllRoom();
    }
}
