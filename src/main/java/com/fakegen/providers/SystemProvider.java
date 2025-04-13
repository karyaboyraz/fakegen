package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SystemProvider {
    private final RandomService random;
    private final Map<String, List<String>> systemData;

    public SystemProvider(RandomService random) {
        this.random = random;
        this.systemData = new HashMap<>();
    }

    private String get(String category) {
        if (!systemData.containsKey(category)) {
            systemData.put(category, LazyLoader.load("system" + category, () -> DataLoader.getListData("system", category)));
        }
        return random.randomElement(systemData.get(category));
    }

    public String fileName() {
        return get("file_names");
    }

    public String fileExtension() {
        return get("file_extensions");
    }

    public String fileNameWithExtension() {
        return String.format("%s.%s",
            fileName(),
            fileExtension()
        );
    }

    public String directoryPath() {
        return get("directory_paths");
    }

    public String filePath() {
        return String.format("%s/%s",
            directoryPath(),
            fileNameWithExtension()
        );
    }

    public String mimeType() {
        return get("mime_types");
    }

    public String commonFileType() {
        return get("common_file_types");
    }

    public String commonFileExtension() {
        return get("common_file_extensions");
    }

    public String commonFileName() {
        return get("common_file_names");
    }

    public String commonFileNameWithExtension() {
        return String.format("%s%s",
            commonFileName(),
            commonFileExtension()
        );
    }

    public static void main(String[] args) {
        SystemProvider systemProvider = new SystemProvider(new RandomService());
        System.out.println("File Name: " + systemProvider.fileName());
        System.out.println("File Extension: " + systemProvider.fileExtension());
        System.out.println("File Name with Extension: " + systemProvider.fileNameWithExtension());
        System.out.println("Directory Path: " + systemProvider.directoryPath());
        System.out.println("File Path: " + systemProvider.filePath());
        System.out.println("Mime Type: " + systemProvider.mimeType());
        System.out.println("Common File Type: " + systemProvider.commonFileType());
        System.out.println("Common File Extension: " + systemProvider.commonFileExtension());
        System.out.println("Common File Name: " + systemProvider.commonFileName());
        System.out.println("Common File Name with Extension: " + systemProvider.commonFileNameWithExtension());
    }
} 