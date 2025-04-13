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

/**
 * A utility class for loading and caching YAML data files.
 * This class provides functionality to load data from YAML files based on the current locale
 * and cache the loaded data for better performance.
 */
public final class DataLoader {
    private static final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    private static final Map<String, Map<String, Object>> dataCache = new ConcurrentHashMap<>();
    private static FakerLocale currentLocale = FakerLocale.TR_TR;
    private static final String DATA_PATH = "data/";

    /**
     * Private constructor to prevent instantiation of this utility class.
     *
     * @throws IllegalStateException if an attempt is made to instantiate this class
     */
    private DataLoader() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Sets the current locale for data loading.
     * This method also clears the data cache to ensure fresh data is loaded for the new locale.
     *
     * @param locale The new locale to set
     */
    public static void setLocale(FakerLocale locale) {
        currentLocale = locale;
        dataCache.clear();
    }

    /**
     * Returns the current locale being used for data loading.
     *
     * @return The current locale
     */
    public static FakerLocale getCurrentLocale() {
        return currentLocale;
    }

    /**
     * Retrieves a list of strings from the specified category and field in the YAML data.
     * The field can be specified using dot notation for nested fields.
     *
     * @param category The category of data to load
     * @param field The field to retrieve, using dot notation for nested fields
     * @return An unmodifiable list of strings from the specified field
     * @throws RuntimeException if the field is not found or is not a list
     */
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

    /**
     * Loads YAML data for the specified category from the appropriate locale directory.
     * The data is cached to improve performance on subsequent requests.
     *
     * @param category The category of data to load
     * @return A map containing the loaded YAML data
     * @throws RuntimeException if the data file cannot be found or loaded
     */
    private static Map<String, Object> loadYamlData(String category) {
        String cacheKey = currentLocale.getCode() + "/" + category;
        return dataCache.computeIfAbsent(cacheKey, key -> {
            try {
                String fullPath = DATA_PATH + currentLocale.getCode() + "/" + category + ".yaml";
                System.out.println("Loading YAML file: " + fullPath);
                InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(fullPath);
                if (is == null) {
                    System.out.println("Resource not found: " + fullPath);
                    throw new RuntimeException("Data file not found: " + fullPath);
                }
                Map<String, Object> data = objectMapper.readValue(is, new TypeReference<>() {});
                System.out.println("Loaded data for category " + category + ": " + data.keySet());
                return data;
            } catch (IOException e) {
                System.out.println("Error loading data: " + e.getMessage());
                throw new RuntimeException("Error loading data from " + category, e);
            }
        });
    }
}
