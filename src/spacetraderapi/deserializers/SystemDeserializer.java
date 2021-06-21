package spacetraderapi.deserializers;

import com.google.gson.*;
import spacetraderapi.entities.GameInfo;
import spacetraderapi.entities.System;

import java.lang.reflect.Type;

public class SystemDeserializer implements JsonDeserializer<System> {
    @Override
    public System deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject systemObj = jsonElement.getAsJsonObject();

        return new System(
                systemObj.getAsJsonPrimitive("name").getAsString(),
                systemObj.getAsJsonPrimitive("symbol").getAsString()
        );
    }
}
