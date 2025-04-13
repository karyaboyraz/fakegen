package com.fakegen.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class LazyLoader {

    private static final Map<String, Object> cache = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> T load(String key, Supplier<T> loader) {
        return (T) cache.computeIfAbsent(key, k -> loader.get());
    }
}