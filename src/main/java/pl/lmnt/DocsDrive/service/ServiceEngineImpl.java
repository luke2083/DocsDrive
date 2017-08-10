package pl.lmnt.DocsDrive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lmnt.DocsDrive.data.DocumentDAO;
import pl.lmnt.DocsDrive.model.Document;
import pl.lmnt.DocsDrive.model.Type;

import java.util.List;

/**
 * Created by luke on 30.07.2017.
 */
@Service
public class ServiceEngineImpl implements SearchEngine {

    @Autowired
    DocumentDAO documentDAOImpl;

    @Override
    public List<Document> findAll() {
        return documentDAOImpl.findAll();
    }

    @Override
    public List<Document> findByType(Type type) {
        return documentDAOImpl.findByType(type);
    }

    @Override
    public void save(Document document) {
        documentDAOImpl.save(document);
    }

    @Override
    public List<Type> findAllTypes() {
        return documentDAOImpl.findAllType();
    }

    @Override
    public Type findTypeByName(String name) {
        return documentDAOImpl.findTypeByName(name);
    }
}
