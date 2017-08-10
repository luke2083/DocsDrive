package pl.lmnt.DocsDrive.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.lmnt.DocsDrive.model.Type;
import pl.lmnt.DocsDrive.service.SearchEngine;

/**
 * Created by luke on 09.08.2017.
 */
@Component
public class TypeNameToTypeConverter implements Converter<String, Type> {

    @Autowired
    private SearchEngine searchEngineImpl;

    @Override
    public Type convert(String s) {
        return searchEngineImpl.findTypeByName(s);
    }
}
