package pl.lmnt.DocsDrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.lmnt.DocsDrive.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by luke on 04.08.2017.
 */
@Controller
public class DownloadController {

    @Autowired
    FileService fileServiceImpl;

    @GetMapping("/download/{filename:.+}")
    public void downloadFile(@PathVariable("filename") String filename, HttpServletResponse response) {

        Path file = fileServiceImpl.getFilePath(filename);
        if (Files.exists(file)) {
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.addHeader("Content-Disposition", "attachment; filename =" + filename);
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
