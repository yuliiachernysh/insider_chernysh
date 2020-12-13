package libs;

import com.google.gson.Gson;
import okhttp3.Response;

import java.io.IOException;

public class RetrieveUtil {
    public static <T> T retrieveResourceFromResponse(Response response, Class<T> clazz)
            throws IOException {

        Gson gson = new Gson();
        String jsonFromResponse = response.body().string();
        return gson.fromJson(jsonFromResponse, clazz);
    }

    public static String convertResourceJson(Object resource)
            throws IOException {

        Gson gson = new Gson();
        String json = gson.toJson(resource);
        return json;
    }
}
