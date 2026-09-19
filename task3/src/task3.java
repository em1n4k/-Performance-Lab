import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class task3 {

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("Пожалуйста, укажите пути: values.json tests.json report.json");
            return;
        }

        // Чтение файлов как текст
        String valuesText = Files.readString(Path.of(args[0]));
        String testsText = Files.readString(Path.of(args[1]));

        // Процесс разбора текста JSON GSON
        JsonObject valuesRoot = JsonParser.parseString(valuesText).getAsJsonObject();
        JsonObject testsRoot = JsonParser.parseString(testsText).getAsJsonObject();

        Map<Long, String> results = new HashMap<>();

        for (JsonElement element : valuesRoot.getAsJsonArray("values")) {
            JsonObject item = element.getAsJsonObject();

            long id = item.get("id").getAsLong();
            String value = item.get("value").getAsString();

            results.put(id, value);
        }

        // Заполнение тестов и вложенных проверок
        fillValues(testsRoot.getAsJsonArray("tests"), results);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Files.writeString(Path.of(args[2]), gson.toJson(testsRoot));
    }

    private static void fillValues(
            JsonArray tests,
            Map<Long, String> results
    ) {
        for (JsonElement element : tests) {
            JsonObject test = element.getAsJsonObject();
            long id = test.get("id").getAsLong();

            if (test.has("value") && results.containsKey(id)) {
                test.addProperty("value", results.get(id));
            }

            if (test.has("values")) {
                fillValues(test.getAsJsonArray("values"), results);
            }
        }
    }
}