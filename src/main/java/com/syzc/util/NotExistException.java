package com.syzc.util;

import com.syzc.sseip.util.HosException;
import org.apache.log4j.Level;

public class NotExistException extends com.syzc.sseip.util.HosException {
    protected NotExistException(Level level) {
        super("目标不存在", level);
    }

    protected NotExistException(Throwable cause, String msg, Level level) {
        super(cause, msg, level);
    }

    protected NotExistException(Throwable cause, Level level) {
        super(cause, level);
    }

    protected NotExistException(String msg, Level level) {
        super(msg, level);
    }

    public static HosException create(Level level) {
        return new NotExistException(level);
    }
}
