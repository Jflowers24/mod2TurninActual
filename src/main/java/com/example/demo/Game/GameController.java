package com.example.demo.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> GetGames(){
        return gameService.GetGames();

    }

    @GetMapping(path = "{gameserialNum}")
    public Optional<Game> SearchGame(@PathVariable("gameserialNum") Long gameserialNum){
        return gameService.SearchGame(gameserialNum);
    }

    @PostMapping
    public void registerNewGame(@RequestBody Game game){
        gameService.addNewGame(game);
    }
    @DeleteMapping(path = "{gameserialNum}")
    public void deleteGame(@PathVariable(
            "gameserialNum") Long gameserialNum){
        gameService.deleteGame(gameserialNum);
    }
    @PutMapping(path = "{gameserialNum}")
    public void UpdateGame(
            @PathVariable("gameserialNum") Long gameserialNum,
            @RequestParam(required = false) String Title,
            @RequestParam(required = false) String Genre) {
        gameService.updateStudent(gameserialNum, Title, Genre);

}
}

