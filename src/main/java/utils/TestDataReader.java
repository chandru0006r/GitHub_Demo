package utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataReader {

    public static JsonNode readJsonData(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(new File("src/test/resources/testdata/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from " + fileName);
        }
    }
}
