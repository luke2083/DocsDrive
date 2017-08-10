package pl.lmnt.DocsDrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.lmnt.DocsDrive.model.Document;
import pl.lmnt.DocsDrive.model.Type;
import pl.lmnt.DocsDrive.service.FileService;
import pl.lmnt.DocsDrive.service.SearchEngine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by luke on 30.07.2017.
 */
@Controller
public class UploadController {

    @Autowired
    private FileService fileServiceImpl;

    @Autowired
    private SearchEngine searchEngineImpl;

    @GetMapping("/upload")
    public ModelAndView renderFileUpload() {
        ModelAndView view = new ModelAndView("upload");
        view.addObject("doc", new Document());
        view.addObject("type", new Type());
        view.addObject("types", searchEngineImpl.findAllTypes());
        return view;
    }

    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("type") Type type, Document doc) {

        try {
            String uploadedFile = fileServiceImpl.store(file);
            doc.setLocation(uploadedFile);
            doc.setCreated(LocalDateTime.now());
            doc.setModified(LocalDateTime.now());
            doc.setType(type);
            searchEngineImpl.save(doc);
            return new ModelAndView("redirect:/");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelAndView view = new ModelAndView();
        view.addObject("doc", doc);
        view.setViewName("index");
        return view;
    }

}
