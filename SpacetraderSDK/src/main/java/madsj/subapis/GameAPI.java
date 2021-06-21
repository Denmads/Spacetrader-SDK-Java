package madsj.subapis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import madsj.ApiCaller;
import madsj.deserializers.GameInfoDeserializer;
import madsj.entities.GameInfo;
import madsj.entities.Token;

import java.io.IOException;
import java.net.URISyntaxException;

public class GameAPI {
    private ApiCaller caller;

    public GameAPI(ApiCaller caller) {
        this.caller = caller;
    }

    /**
     * Get info about wether or not the service is up and running
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public GameInfo getGameInfo() throws InterruptedException, IOException, URISyntaxException {
        String json = caller.GET("game/status");

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(GameInfo.class, new GameInfoDeserializer());

        Gson gson = builder.create();

        return gson.fromJson(json, GameInfo.class);
    }
}
