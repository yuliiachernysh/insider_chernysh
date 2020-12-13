package actions;

import libs.RetrieveUtil;
import models.Pet;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PetActions {
    private static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    private static final String CONTENT_TYPE_HEADER_VALUE = "application/json";
    private static final MediaType JSON = MediaType.parse("application/json");
    private static final MediaType IMAGE = MediaType.parse("image/jpeg");
    private OkHttpClient httpClient;
    private String baseUrl;

    public PetActions(String baseUrl){
        this.httpClient = new OkHttpClient();
        this.baseUrl = baseUrl;
    }

    public Response CreatePet(Pet pet) throws IOException {
        String jsonItem = RetrieveUtil.convertResourceJson(pet);
        RequestBody body = RequestBody.create(JSON, jsonItem);
        Request request = new Request
                .Builder()
                .url(this.baseUrl)
                .addHeader(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .post(body).build();

        return httpClient.newCall(request).execute();
    }

    public Response UpdatePet(Pet pet) throws IOException {
        String jsonItem = RetrieveUtil.convertResourceJson(pet);
        RequestBody body = RequestBody.create(JSON, jsonItem);
        Request request = new Request
                .Builder()
                .url(this.baseUrl)
                .addHeader(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .put(body).build();

        return httpClient.newCall(request).execute();
    }

    public Response UpdatePetStatusAndName(Long id, String name, String status) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("status", status)
                .build();

        Request request = new Request
                .Builder()
                .url(this.baseUrl + id)
                .post(requestBody)
                .build();

        return new OkHttpClient().newCall(request).execute();
    }

    public Response DeleteById(Long id) throws IOException {
        Request request = new Request
                .Builder()
                .url(this.baseUrl + id)
                .addHeader(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .addHeader("api_key", "apiKey")
                .delete().build();

        return httpClient.newCall(request).execute();
    }

    public Response UploadPetImage(Long id, String filePath) throws IOException {
        InputStream fileStream = PetActions.class.getResourceAsStream(filePath);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "file.jpeg",
                        RequestBody.create(IMAGE, fileStream.readAllBytes()))
                .build();

        Request request = new Request
                .Builder()
                .url(this.baseUrl + id + "/uploadImage")
                .post(requestBody).build();

        return httpClient.newCall(request).execute();
    }

    public Response GetById(Long id) throws IOException {
        Request request = new Request
                .Builder()
                .url(this.baseUrl + id)
                .addHeader(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .get()
                .build();

        return httpClient.newCall(request).execute();
    }

    public Response GetByStatus(String status) throws IOException {
        Request request = new Request
                .Builder()
                .url(this.baseUrl + "findByStatus?status=" + status)
                .addHeader(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .get()
                .build();

        return httpClient.newCall(request).execute();
    }
}
