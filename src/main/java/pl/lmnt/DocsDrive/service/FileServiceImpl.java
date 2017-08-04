package pl.lmnt.DocsDrive.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by luke on 31.07.2017.
 */
@Service
public class FileServiceImpl implements FileService {

    private static final String UPLOAD_PATH = "upload";
    private Path uploadDir = Paths.get(UPLOAD_PATH);

    @Override
    public String store(MultipartFile file) throws IOException {
        Path targetPath;
        String fileName;

        this.initFileSystem();

        if (file.isEmpty()){
            throw new MultipartException("File is empty");
        }

        InputStream inputStream = file.getInputStream();
        fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        targetPath = uploadDir.resolve(fileName);

        long bytesWritten = Files.copy(inputStream, targetPath);

        if (bytesWritten <= 0)
            throw new IllegalStateException("Couldn't upload file");


        return fileName;
    }

    @Override
    public Resource getFileAsResource(String filePath) {

        try {
            Path targetFilePath = uploadDir.resolve(filePath);
            Resource resource = new UrlResource(targetFilePath.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Path getFilePath(String fileName) {
        return uploadDir.resolve(fileName);
    }

    private void initFileSystem() throws IOException {

        if (!Files.exists(uploadDir))
            Files.createDirectory(uploadDir);

    }
}
