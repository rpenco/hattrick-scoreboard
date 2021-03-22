package org.hattrick.providers;

import org.hattrick.providers.exceptions.SerializerException;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 * @author Khips
 * @since 28 march 2014
 */
public class HattrickParser {

    /**
     * Parse XML result to Object
     *
     * @param object  class result
     * @param content xml result string
     * @return object
     * @throws SerializerException
     */
    public static <T> T parseFrom(Class<T> object, String content)
            throws SerializerException {
        Serializer serializer = new Persister();
        try {
            return serializer.read(object, content);
        } catch (Exception e) {
            throw new SerializerException(e);
        }

    }

}
