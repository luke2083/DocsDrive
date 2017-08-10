package pl.lmnt.DocsDrive.data;

import org.springframework.stereotype.Repository;
import pl.lmnt.DocsDrive.model.Document;
import pl.lmnt.DocsDrive.model.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by luke on 30.07.2017.
 */

@Repository
public class DocumentDAOImpl implements DocumentDAO {

    private static final List<Document> DOCS = new ArrayList<>();
    private static final List<Type> TYPES = new ArrayList<>();

    {
        Type t1 = new Type("PDF", "Portable Data File", ".pdf");
        Type t2 = new Type("RTF", "Rich Text Format", ".rtf");
        Type t3 = new Type("WEB", "Łącze sieciowe", ".url");
        Type t4 = new Type("NOTE", "Notatki tekstowe", ".txt");

        Document d1 = new Document("Fajna książka", t1, "/Documents/ksiazki/ksiazka.pdf");
        Document d2 = new Document("Fajny Projekt", t2, "/Documents/projekty/projekt.rtf");
        Document d3 = new Document("Fajny link", t3, "www.fajnylink.pl");
        Document d4 = new Document("Fajna notatka", t4, "/Documents/notatki/notatka.txt");

        DOCS.add(d1);
        DOCS.add(d2);
        DOCS.add(d3);
        DOCS.add(d4);

        TYPES.add(t1);
        TYPES.add(t2);
        TYPES.add(t3);
        TYPES.add(t4);
    }


    @Override
    public List<Document> findAll() {
        return DOCS;
    }

    @Override
    public List<Document> findByType(Type type) {
        List<Document> result = new ArrayList<>();

        for (Document d : DOCS) {
            if (d.getType().getName().equals(type.getName()))
                result.add(d);
        }

        return result;
    }

    @Override
    public void save(Document document) {
        DOCS.add(document);
    }

    @Override
    public List<Type> findAllType() {
        List<Type> types = new ArrayList<>();

        for (Document d : DOCS) {
            types.add(d.getType());
        }

        return types;
    }

    @Override
    public Type findTypeByName(String name) {
        Type type = new Type();
        for (Type t : TYPES) {
            if (t.getName().equals(name))
                return t;
        }

        return null;
    }
}
