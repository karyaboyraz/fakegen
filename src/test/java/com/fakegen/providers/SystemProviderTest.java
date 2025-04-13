package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemProviderTest {
    private SystemProvider systemProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        systemProvider = new SystemProvider(new RandomService());
    }

    @Test
    void fileName_ShouldReturnValidFileName() {
        String fileName = systemProvider.fileName();
        assertNotNull(fileName);
        assertFalse(fileName.isEmpty());
    }

    @Test
    void fileExtension_ShouldReturnValidExtension() {
        String extension = systemProvider.fileExtension();
        assertNotNull(extension);
        assertFalse(extension.isEmpty());
    }

    @Test
    void fileNameWithExtension_ShouldReturnValidFileName() {
        String fileName = systemProvider.fileNameWithExtension();
        assertNotNull(fileName);
        assertFalse(fileName.isEmpty());
        assertTrue(fileName.contains("."));
    }

    @Test
    void directoryPath_ShouldReturnValidPath() {
        String path = systemProvider.directoryPath();
        assertNotNull(path);
        assertFalse(path.isEmpty());
    }

    @Test
    void filePath_ShouldReturnValidPath() {
        String path = systemProvider.filePath();
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertTrue(path.contains("/"));
    }

    @Test
    void mimeType_ShouldReturnValidMimeType() {
        String mimeType = systemProvider.mimeType();
        assertNotNull(mimeType);
        assertFalse(mimeType.isEmpty());
    }

    @Test
    void commonFileType_ShouldReturnValidType() {
        String type = systemProvider.commonFileType();
        assertNotNull(type);
        assertFalse(type.isEmpty());
    }

    @Test
    void commonFileExtension_ShouldReturnValidExtension() {
        String extension = systemProvider.commonFileExtension();
        assertNotNull(extension);
        assertFalse(extension.isEmpty());
    }

    @Test
    void commonFileName_ShouldReturnValidName() {
        String name = systemProvider.commonFileName();
        assertNotNull(name);
        assertFalse(name.isEmpty());
    }

    @Test
    void commonFileNameWithExtension_ShouldReturnValidName() {
        String name = systemProvider.commonFileNameWithExtension();
        assertNotNull(name);
        assertFalse(name.isEmpty());
        assertTrue(name.contains("."));
    }
} 