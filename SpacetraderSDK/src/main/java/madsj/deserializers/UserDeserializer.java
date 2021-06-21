package madsj.deserializers;

import com.google.gson.*;
import spacetraderapi.entities.User;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDeserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject userObj = jsonElement.getAsJsonObject().getAsJsonObject("user");

        return new User(
                userObj.getAsJsonPrimitive("username").getAsString(),
                userObj.getAsJsonPrimitive("credits").getAsInt(),
                userObj.getAsJsonPrimitive("shipCount").getAsInt(),
                userObj.getAsJsonPrimitive("structureCount").getAsInt(),
                LocalDateTime.parse(userObj.getAsJsonPrimitive("joinedAt").getAsString(), DateTimeFormatter.ISO_DATE_TIME)
        );
    }
}
