package spacetraderapi;

import spacetraderapi.entities.Token;
import spacetraderapi.subapis.AccountAPI;
import spacetraderapi.subapis.GameAPI;
import spacetraderapi.subapis.SystemAPI;
import spacetraderapi.subapis.UserAPI;

import java.io.IOException;
import java.net.URISyntaxException;

public class SpaceTraderAPI {

    private SpaceTraderAPI() {}

    private static AccountAPI accountAPI = null;
    private static GameAPI gameAPI = null;
    private static SystemAPI systemAPI = null;
    private static UserAPI userAPI = new UserAPI(new APICaller());


    public static AccountAPI Account() throws Exception {
        if (accountAPI == null) {
            throw new Exception("Please set token or create user'");
        }

        return accountAPI;
    }

    public static GameAPI Game() throws Exception {
        if (gameAPI == null) {
            throw new Exception("Please set token or create user'");
        }

        return gameAPI;
    }

    public static SystemAPI Systems() throws Exception {
        if (systemAPI == null) {
            throw new Exception("Please set token or create user'");
        }

        return systemAPI;
    }

    public static UserAPI User() throws Exception {
        return userAPI;
    }



    public static void setToken(String token) {
        APICaller caller = new APICaller(token);
        accountAPI = new AccountAPI(caller);
        gameAPI = new GameAPI(caller);
        systemAPI = new SystemAPI(caller);
    }

    public static String createUser(String username) throws InterruptedException, IOException, URISyntaxException {
        Token token = userAPI.createUser(username);

        setToken(token.token);
        return token.token;
    }
}
