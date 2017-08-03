package pl.lmnt.DocsDrive.service;

import pl.lmnt.DocsDrive.model.Document;
import pl.lmnt.DocsDrive.model.Type;

import java.util.List;

/**
 * Created by luke on 30.07.2017.
 */
public interface SearchEngine {

    List<Document> findAll();

    List<Document> findByType(Type type);

}
