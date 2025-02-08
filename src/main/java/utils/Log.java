package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    public static Logger getLogger(Class<?> cls) {
        return LoggerFactory.getLogger(cls);
    }
}
