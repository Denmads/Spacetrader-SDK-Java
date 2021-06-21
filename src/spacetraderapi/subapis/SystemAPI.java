package spacetraderapi.subapis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spacetraderapi.APICaller;
import spacetraderapi.deserializers.SystemDeserializer;
import spacetraderapi.entities.System;
import spacetraderapi.deserializers.UserDeserializer;
import spacetraderapi.entities.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class SystemAPI {
    private APICaller caller;

    public SystemAPI(APICaller caller) {
        this.caller = caller;
    }

    /**
     * Gets info about the account
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public List<System> getListOfSystems() throws InterruptedException, IOException, URISyntaxException {
        String json = caller.GET("game/systems");

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(System.class, new SystemDeserializer());

        Gson gson = builder.create();

        return Arrays.asList(gson.fromJson(json.substring(json.indexOf("["), json.lastIndexOf("]")+1), System[].class));
    }
}
