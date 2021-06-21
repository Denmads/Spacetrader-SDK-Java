package madsj.subapis;

import com.google.gson.Gson;
import madsj.ApiCaller;
import madsj.entities.Token;

import java.io.IOException;
import java.net.URISyntaxException;

public class UserAPI {
    private ApiCaller caller;

    public UserAPI(ApiCaller caller) {
        this.caller = caller;
    }

    /**
     * Creates a new user, if the username is not already in use
     * @param username
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public Token createUser(String username) throws InterruptedException, IOException, URISyntaxException {
        String json = caller.GET("users/" + username + "/claim");

        Gson gson = new Gson();

        return gson.fromJson(json, Token.class);
    }
}
