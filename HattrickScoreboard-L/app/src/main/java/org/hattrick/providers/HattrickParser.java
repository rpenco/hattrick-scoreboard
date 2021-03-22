package org.hattrick.providers;

import org.hattrick.models.chpp.CHPPError;
import org.hattrick.providers.abstracts.IParser;
import org.hattrick.providers.exceptions.ParserException;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 * @author Khips
 * @since 28 mars 2014
 */
public class HattrickParser extends IParser {

    static final String TAG = (HattrickParser.class).getSimpleName();

    /**
     * Parse XML result to Object
     *
     * @param object  class result
     * @param content xml result string
     * @return object
     * @throws org.hattrick.providers.exceptions.ParserException
     */
    @Override
    public  <T> T parse(Class<T> object, String content) throws ParserException{

        Serializer serializer = new Persister();

        //Expected XML..
        if(content != null && content.contains("HattrickData")){

            //CHPP Error XML
            if(content.contains("chpperror")){

                //Get CHPP error and throw exception
                CHPPError err = null;
                try {

                    err = serializer.read(CHPPError.class, content);

                } catch (Exception e) {
                    //Throw unknown exception...
                    throw new ParserException(e);

                } finally {
                    //throw known chpp exception
                    throw new ParserException(new ParserException(),err.getErrorCode(), content);
                }

            }else{

                try {
                    //Right XML
                    return serializer.read(object, content);
                }catch (Exception e) {

                    //Throw unknown exception...
                    throw new ParserException(e);
                }
            }
        }
        else{
            //Error no XML File..
            throw new ParserException(content);
        }
    }
}
