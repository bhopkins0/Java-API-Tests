import okhttp3.*;
import java.util.Scanner;

import java.io.IOException;

public class API {

    private final OkHttpClient httpClient = new OkHttpClient();

    public static void main(String[] args) throws Exception {

        API obj = new API();
        obj.sendPost();

    }

    private void sendPost() throws Exception {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an action for the API: ");
        String apiAction = keyboard.nextLine();
        System.out.println("Enter the API key: ");
        String apiKey = keyboard.nextLine();

        RequestBody formBody = new FormBody.Builder()
                .add("action", apiAction)
                .add("key", apiKey)
                .build();

        Request request = new Request.Builder()
                .url("https://api-testing.brenthopkins.me/api.php")
                .addHeader("User-Agent", "api-testing 1.0")
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            System.out.println(response.body().string());
        }

    }

}
