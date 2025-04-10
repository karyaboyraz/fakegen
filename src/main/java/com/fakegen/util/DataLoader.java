package com.fakegen.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fakegen.locale.FakerLocale;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DataLoader {
    private static final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    private static final Map<String, Map<String, Object>> dataCache = new ConcurrentHashMap<>();
    private static FakerLocale currentLocale = FakerLocale.TR_TR;
    private static final String DATA_PATH = "data/";
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC = "0123456789";
    private static final String SAMPLE_CHARACTERS = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    private DataLoader() {
        throw new IllegalStateException("Utility class");
    }

    public static void setLocale(FakerLocale locale) {
        currentLocale = locale;
        dataCache.clear();
    }

    public static FakerLocale getCurrentLocale() {
        return currentLocale;
    }

    public static String getAlphabet() {
        return ALPHABET;
    }

    public static String getNumeric() {
        return NUMERIC;
    }

    public static String getSampleCharacters() {
        return SAMPLE_CHARACTERS;
    }

    public static Map<String, Object> loadYamlData(String category) {
        String cacheKey = currentLocale.getCode() + "/" + category;
        return dataCache.computeIfAbsent(cacheKey, key -> {
            try {
                String fullPath = DATA_PATH + currentLocale.getCode() + "/" + category + ".yaml";
                InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(fullPath);
                if (is == null) {
                    System.out.println("Resource not found: " + fullPath);
                    throw new RuntimeException("Data file not found: " + fullPath);
                }
                return objectMapper.readValue(is, new TypeReference<>() {
                });
            } catch (IOException e) {
                System.out.println("Error loading data: " + e.getMessage());
                throw new RuntimeException("Error loading data from " + category, e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    public static List<String> getListData(String category, String field) {
        Map<String, Object> data = loadYamlData(category);
        String[] fieldParts = field.split("\\.");
        Object current = data;
        
        for (String part : fieldParts) {
            if (current instanceof Map) {
                current = ((Map<String, Object>) current).get(part);
                if (current == null) {
                    System.out.println("Field " + part + " not found in current map");
                    throw new RuntimeException("Field " + field + " not found in " + category);
                }
            } else {
                System.out.println("Current object is not a map: " + current);
                throw new RuntimeException("Field " + field + " is not a map in " + category);
            }
        }
        
        if (current instanceof List) {
            return Collections.unmodifiableList((List<String>) current);
        }
        System.out.println("Current object is not a list: " + current);
        throw new RuntimeException("Field " + field + " is not a list in " + category);
    }

    public static <T> T getMapData(String category, String field, TypeReference<T> typeReference) {
        Map<String, Object> data = loadYamlData(category);
        Object value = data.get(field);
        if (value == null) {
            throw new RuntimeException("Field " + field + " not found in " + category);
        }
        try {
            return objectMapper.convertValue(value, typeReference);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error converting value for field " + field + " in " + category, e);
        }
    }
}
