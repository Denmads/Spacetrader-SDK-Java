    package madsj.deserializers;

import com.google.gson.*;
import madsj.entities.LeaderBoard;
import madsj.entities.LeaderBoardEntry;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

    public class LeaderboardDeserializer implements JsonDeserializer<LeaderBoard> {
    @Override
    public LeaderBoard deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray topArr = jsonElement.getAsJsonObject().getAsJsonArray("netWorth");

        List<LeaderBoardEntry> topPlayers = new ArrayList<>();
        for (JsonElement obj : topArr) {
            topPlayers.add(jsonToEntry(obj.getAsJsonObject()));
        }

        return new LeaderBoard(topPlayers);
    }

    private LeaderBoardEntry jsonToEntry(JsonObject user) {
        return new LeaderBoardEntry(
                user.getAsJsonPrimitive("username").getAsString(),
                user.getAsJsonPrimitive("rank").getAsInt(),
                user.getAsJsonPrimitive("netWorth").getAsInt()
        );
    }
}
