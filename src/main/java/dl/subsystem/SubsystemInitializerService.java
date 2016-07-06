package dl.subsystem;

import dl.Behavior.Behavior;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SubsystemInitializerService {

    @NotNull
    public static Set<Class<? extends Behavior>> initialize(@NotNull final String configJSONPath) {
        FileReader reader = null;
        try {
            reader = new FileReader(configJSONPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        JSONArray requiredComponents = (JSONArray) jsonObject.get("requiredComponents");

//        for (Object aLang : lang) {
//            JSONObject innerObj = (JSONObject) aLang;
//            System.out.println("language " + innerObj.get("lang") +
//                    " with level " + innerObj.get("knowledge"));
//        }

//        JSONObject structure = (JSONObject) jsonObject.get("job");
//        System.out.println("Into job structure, name: " + structure.get("name"));

        return new HashSet<>();
    }
}
