//package com.dexlock.SpringRestMongoDBDemo.service;
//
//import com.dexlock.SpringRestMongoDBDemo.exceptions.FileStorageException;
//import com.dexlock.SpringRestMongoDBDemo.exceptions.MyFileNotFoundException;
//import com.dexlock.SpringRestMongoDBDemo.property.FileStorageProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//
//@Service
//public class FileServiceImplementor implements FileStorageService{
////    private final Path root = Paths.get("file");
//    private final Path fileStorageLocation;
//
//    @Autowired
//    public FileServiceImplementor(FileStorageProperties fileStorageProperties) throws FileStorageException {
//        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
//
//        try{
//            Files.createDirectories(this.fileStorageLocation);
//        }
//        catch(Exception e){
//            throw new FileStorageException("Could not create the directory where the uploaded files will be stored."+e);
//        }
//    }
//
//    @Override
//    public String storeFile(MultipartFile file) throws FileStorageException {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try{
//            if(fileName.contains("..")){
//                throw new FileStorageException("Sorry...Filename contains invalid characters");
//            }
//            Path targetLocation = this.fileStorageLocation.resolve(fileName);
//
//            Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
//            return fileName;
//        } catch (IOException | FileStorageException e) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!"+e);
//        }
//    }
//
//    @Override
//    public Resource loadFileAsResource(String fileName) throws MyFileNotFoundException {
//        try {
//            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
//            Resource resource = new UrlResource(filePath.toUri());
//            if(resource.exists()) {
//                return resource;
//            } else {
//                throw new MyFileNotFoundException("File not found " + fileName);
//            }
//        } catch (MalformedURLException ex) {
//            throw new MyFileNotFoundException("File not found " + fileName +ex);
//        }
//    }
//
//}
