package madsj.subapis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import madsj.ApiCaller;
import madsj.deserializers.UserDeserializer;
import madsj.entities.Account;

import java.io.IOException;
import java.net.URISyntaxException;

public class AccountAPI {

    private ApiCaller caller;

    public AccountAPI(ApiCaller caller) {
        this.caller = caller;
    }

    /**
     * Gets info about the account
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public Account getAccountInfo() throws InterruptedException, IOException, URISyntaxException {
        String json = caller.GET("my/account");

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Account.class, new UserDeserializer());

        Gson gson = builder.create();

        return gson.fromJson(json, Account.class);
    }
}
