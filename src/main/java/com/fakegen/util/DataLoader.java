package com.fakegen.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fakegen.locale.FakerLocale;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataLoader {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Map<String, Map<String, Object>> dataCache = new ConcurrentHashMap<>();
    private static FakerLocale currentLocale = FakerLocale.EN_US;

    public static void setLocale(FakerLocale locale) {
        if (locale != currentLocale) {
            currentLocale = locale;
            dataCache.clear();
        }
    }

    public static FakerLocale getCurrentLocale() {
        return currentLocale;
    }

    @SuppressWarnings("unchecked")
    public static List<String> loadData(String category, String subCategory) {
        Map<String, Object> categoryData = loadCategoryData(category);
        Object data = categoryData.get(subCategory);
        
        if (data == null && currentLocale != FakerLocale.EN_US) {
            // Fallback to EN_US if data not found in current locale
            String fallbackKey = FakerLocale.EN_US.getCode() + ":" + category;
            categoryData = dataCache.computeIfAbsent(fallbackKey, k -> loadCategoryData(category));
            data = categoryData.get(subCategory);
        }
        
        if (data == null) {
            // Instead of throwing an exception, return an empty list
            return new ArrayList<>();
        }

        if (data instanceof List) {
            return (List<String>) data;
        }
        throw new RuntimeException("Data is not a list for category: " + category +
                                ", subCategory: " + subCategory);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, List<String>> loadDataAsMap(String category, String subCategory) {
        Map<String, Object> categoryData = loadCategoryData(category);
        Object data = categoryData.get(subCategory);
        
        if (data == null && currentLocale != FakerLocale.EN_US) {
            // Fallback to EN_US if data not found in current locale
            String fallbackKey = FakerLocale.EN_US.getCode() + ":" + category;
            categoryData = dataCache.computeIfAbsent(fallbackKey, k -> loadCategoryData(category));
            data = categoryData.get(subCategory);
        }
        
        if (data == null) {
            throw new RuntimeException("Map data not found for category: " + category + 
                                    ", subCategory: " + subCategory + 
                                    ", locale: " + currentLocale.getCode());
        }

        if (data instanceof Map) {
            return (Map<String, List<String>>) data;
        }
        throw new RuntimeException("Data is not a map for category: " + category +
                                ", subCategory: " + subCategory);
    }

    private static Map<String, Object> loadCategoryData(String category) {
        String cacheKey = currentLocale.getCode() + ":" + category;
        return dataCache.computeIfAbsent(cacheKey, k -> {
            String path = String.format("data/%s/%s.json", currentLocale.getCode().toLowerCase(), category);
            InputStream is = null;
            try {
                is = DataLoader.class.getClassLoader().getResourceAsStream(path);
                if (is == null && currentLocale != FakerLocale.EN_US) {
                    // Fallback to EN_US if locale file not found
                    path = String.format("data/%s/%s.json", FakerLocale.EN_US.getCode().toLowerCase(), category);
                    is = DataLoader.class.getClassLoader().getResourceAsStream(path);
                }
                
                if (is == null) {
                    throw new RuntimeException("Data file not found: " + path);
                }
                
                return objectMapper.readValue(is, new TypeReference<Map<String, Object>>() {});
            } catch (IOException e) {
                throw new RuntimeException("Failed to load data for category: " + category + 
                                        ", locale: " + currentLocale.getCode(), e);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        // Ignore close error
                    }
                }
            }
        });
    }
}
