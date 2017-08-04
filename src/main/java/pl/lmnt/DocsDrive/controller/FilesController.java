package pl.lmnt.DocsDrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lmnt.DocsDrive.service.FileService;

/**
 * Created by luke on 31.07.2017.
 */
@RequestMapping("/files")
@Controller
public class FilesController {

    @Autowired
    FileService fileServiceImpl;

    @GetMapping("/upload/{filemane:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable("filename") String filename) {
        Resource file = fileServiceImpl.getFileAsResource(filename);

        return ResponseEntity.
                ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"").
                body(file);
    }


}
