package com.gameserver.Services;

import com.gameserver.Dao.PlayerDao;
import com.gameserver.Dto.PlayerLoginDto;
import com.gameserver.Dto.LoginResponseDto;
import com.gameserver.Dto.PlayerLogoutDto;
import com.gameserver.Entitiy.Player;
import com.gameserver.Helper.HelperMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private HelperMethods helperMethods;

    private final Logger logger = LoggerFactory.getLogger(GameService.class);

    List<String> loggedInPlayersUsername = new ArrayList<>();
    List<String> loggedInPlayersName = new ArrayList<>();

    public LoginResponseDto doLogin(PlayerLoginDto playerLoginDto) throws NoSuchAlgorithmException {

        Player playerDetails = playerDao.getFirstByUsernameAndPassword(playerLoginDto.getUsername(),
                helperMethods.MD5(playerLoginDto.getPassword()));

        if(playerDetails != null) {
            if(!loggedInPlayersUsername.contains(playerDetails.getUsername())) {
                loggedInPlayersUsername.add(playerDetails.getUsername());
                loggedInPlayersName.add(playerDetails.getClientName());
            }
            logger.info(playerDetails.getClientName().concat(" - LOGGED IN ->> "));
            return new LoginResponseDto(playerDetails.getUsername(), playerDetails.getClientName(),
                    playerDetails.getWalletBalance().floatValue(), playerDetails.getBetAmountLimit(), playerDetails.getProfileStatus());
        }
        else {
            logger.error(" --> LOGIN FAILED. <-- ");
            return new LoginResponseDto();
        }
    }

    public void doLogout(PlayerLogoutDto playerLogoutDto) {

        Player loggedOutuser = playerDao.getFirstByUsername(playerLogoutDto.getPlayerUsername());
        loggedInPlayersName.remove(loggedOutuser.getClientName());
        loggedInPlayersUsername.remove(loggedOutuser.getUsername());
        logger.info(loggedOutuser.getClientName().concat(" - LOGGED OUT <<- "));
    }

    public void updatePlayerProfile(List<LoginResponseDto> updatedPlayerData) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        updatedPlayerData.forEach(getPlayerProfileData -> {
            playerDao.updatePlayerProfile(getPlayerProfileData.getPlayerUsername(),
                    new BigDecimal(decimalFormat.format(getPlayerProfileData.getWalletBalance())));
        });
    }
}
