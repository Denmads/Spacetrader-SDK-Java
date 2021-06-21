package madsj.subapis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import madsj.ApiCaller;
import madsj.deserializers.LeaderboardDeserializer;
import madsj.entities.LeaderBoard;

import java.io.IOException;
import java.net.URISyntaxException;

public class LeaderBoardAPI {
    private ApiCaller caller;

    public LeaderBoardAPI(ApiCaller caller) {
        this.caller = caller;
    }

    /**
     * Get the top ten players with the most net worth
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public LeaderBoard getLeaderBoard() throws InterruptedException, IOException, URISyntaxException {
        String json = caller.GET("game/leaderboard/net-worth");

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LeaderBoard.class, new LeaderboardDeserializer());

        Gson gson = builder.create();

        return gson.fromJson(json, LeaderBoard.class);
    }
}
