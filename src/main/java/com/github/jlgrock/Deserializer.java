package com.github.jlgrock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

/**
 *
 */
public class Deserializer {

    private ObjectMapper mapper;

    public Deserializer(final ObjectMapper mapperIn) {
        mapper = mapperIn;
    }

    protected <O> O deserialize(final String input,
                                 final Class<?> readerClass,
                                 final Class<O> outputClass) throws IOException {
        O returnVal = null;
        if (input != null) {
            ObjectReader objectReader;
            objectReader = mapper.addMixIn(readerClass, VersionReadMixin.class).readerFor(outputClass);
            returnVal = objectReader.readValue(input);
        }
        return returnVal;
    }
}
