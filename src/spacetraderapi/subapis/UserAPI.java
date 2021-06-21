package spacetraderapi.subapis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spacetraderapi.APICaller;
import spacetraderapi.deserializers.UserDeserializer;
import spacetraderapi.entities.Token;
import spacetraderapi.entities.User;

import java.io.IOException;
import java.net.URISyntaxException;

public class UserAPI {
    private APICaller caller;

    public UserAPI(APICaller caller) {
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
