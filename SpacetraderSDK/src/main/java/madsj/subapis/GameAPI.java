package madsj.subapis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import madsj.APICaller;
import madsj.deserializers.GameInfoDeserializer;
import madsj.deserializers.LeaderboardDeserializer;
import madsj.entities.GameInfo;
import madsj.entities.Leaderboard;

import java.io.IOException;
import java.net.URISyntaxException;

public class GameAPI {
    private APICaller caller;

    public GameAPI(APICaller caller) {
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

    /**
     * Get the top ten players with the most net worth
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public Leaderboard getLeaderboard() throws InterruptedException, IOException, URISyntaxException {
        String json = caller.GET("game/leaderboard/net-worth");

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Leaderboard.class, new LeaderboardDeserializer());

        Gson gson = builder.create();

        return gson.fromJson(json, Leaderboard.class);
    }
}
