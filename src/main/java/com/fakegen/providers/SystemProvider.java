package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;

public class SystemProvider {
    private final RandomService random;

    public SystemProvider(RandomService random) {
        this.random = random;
    }

    public String fileName() {
        return random.randomElement(DataLoader.getListData("system", "file_names"));
    }

    public String fileExtension() {
        return random.randomElement(DataLoader.getListData("system", "file_extensions"));
    }

    public String fileNameWithExtension() {
        return String.format("%s.%s",
            fileName(),
            fileExtension()
        );
    }

    public String directoryPath() {
        return random.randomElement(DataLoader.getListData("system", "directory_paths"));
    }

    public String filePath() {
        return String.format("%s/%s",
            directoryPath(),
            fileNameWithExtension()
        );
    }

    public String mimeType() {
        return random.randomElement(DataLoader.getListData("system", "mime_types"));
    }

    public String commonFileType() {
        return random.randomElement(DataLoader.getListData("system", "common_file_types"));
    }

    public String commonFileExtension() {
        return random.randomElement(DataLoader.getListData("system", "common_file_extensions"));
    }

    public String commonFileName() {
        return random.randomElement(DataLoader.getListData("system", "common_file_names"));
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