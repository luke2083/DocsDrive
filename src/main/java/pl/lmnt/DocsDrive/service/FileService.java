package pl.lmnt.DocsDrive.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by luke on 31.07.2017.
 */
public interface FileService {

    String store(MultipartFile file) throws IOException;
    Resource getFileAsResource(String filePath);

}
