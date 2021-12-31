package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.util.Properties;

public class configReader {
    private Properties props;

    /**
     * this method is used to return values form config.properties
     * @return Properties objects
     */
    public Properties init_prop(){
        props=new Properties();
        try {
            FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
            props.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
