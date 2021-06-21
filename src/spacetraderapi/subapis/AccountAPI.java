package spacetraderapi.subapis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spacetraderapi.APICaller;
import spacetraderapi.deserializers.UserDeserializer;
import spacetraderapi.entities.User;

import java.io.IOException;
import java.net.URISyntaxException;

public class AccountAPI {

    private APICaller caller;

    public AccountAPI(APICaller caller) {
        this.caller = caller;
    }

    /**
     * Gets info about the account
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public User getAccountInfo() throws InterruptedException, IOException, URISyntaxException {
        String json = caller.GET("my/account");

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(User.class, new UserDeserializer());

        Gson gson = builder.create();

        return gson.fromJson(json, User.class);
    }
}
