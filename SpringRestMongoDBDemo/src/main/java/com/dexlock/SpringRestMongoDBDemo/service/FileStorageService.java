package com.dexlock.SpringRestMongoDBDemo.service;
import com.dexlock.SpringRestMongoDBDemo.exceptions.FileStorageException;
import com.dexlock.SpringRestMongoDBDemo.exceptions.MyFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    public String storeFile(MultipartFile file) throws FileStorageException;

    public Resource loadFileAsResource(String fileName) throws MyFileNotFoundException;

}
