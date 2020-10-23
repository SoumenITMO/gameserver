package com.gameserver.Controllers;

import com.gameserver.Dao.PlayerDao;
import com.gameserver.Dto.PlayerLoginDto;
import com.gameserver.Dto.LoginResponseDto;
import com.gameserver.Dto.PlayerLogoutDto;
import com.gameserver.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    PlayerDao playerDao;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(@RequestBody PlayerLoginDto playerLoginDto)
            throws NoSuchAlgorithmException {

        return new ResponseEntity<>(gameService.doLogin(playerLoginDto), HttpStatus.OK);
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResponseEntity logout(@RequestBody PlayerLogoutDto playerLogoutDto) {
        gameService.doLogout(playerLogoutDto);

        return new ResponseEntity("user has been logged out", HttpStatus.OK);
    }

    @RequestMapping(value = "updateprofiles", method = RequestMethod.POST)
    public void updatePlayerProfiles(@RequestBody List<LoginResponseDto> updatedPlayerData) {
        gameService.updatePlayerProfile(updatedPlayerData);
    }
}
