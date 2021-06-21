package madsj.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import madsj.entities.GameInfo;

import java.lang.reflect.Type;

public class GameInfoDeserializer implements JsonDeserializer<GameInfo> {
    @Override
    public GameInfo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new GameInfo(
                jsonElement.getAsJsonObject().getAsJsonPrimitive("status").getAsString()
        );
    }
}
