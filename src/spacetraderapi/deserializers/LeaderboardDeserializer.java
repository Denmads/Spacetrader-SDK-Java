    package spacetraderapi.deserializers;

import com.google.gson.*;
import spacetraderapi.entities.GameInfo;
import spacetraderapi.entities.Leaderboard;
import spacetraderapi.entities.LeaderboardEntry;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

    public class LeaderboardDeserializer implements JsonDeserializer<Leaderboard> {
    @Override
    public Leaderboard deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray topArr = jsonElement.getAsJsonObject().getAsJsonArray("netWorth");

        List<LeaderboardEntry> topPlayers = new ArrayList<>();
        for (JsonElement obj : topArr) {
            topPlayers.add(jsonToEntry(obj.getAsJsonObject()));
        }

        return new Leaderboard(topPlayers);
    }

    private LeaderboardEntry jsonToEntry(JsonObject user) {
        return new LeaderboardEntry(
                user.getAsJsonPrimitive("username").getAsString(),
                user.getAsJsonPrimitive("rank").getAsInt(),
                user.getAsJsonPrimitive("netWorth").getAsInt()
        );
    }
}
