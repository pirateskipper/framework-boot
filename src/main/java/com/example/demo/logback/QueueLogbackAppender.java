package com.example.demo.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.util.Assert;

/**
 * @author blindskipper
 */
@Getter
@Setter
public class QueueLogbackAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    private Layout<ILoggingEvent> layout;
    private String defined;

    @Override
    public void start() {
        Assert.notNull(layout,"Layout was not defined");
        super.start();
    }

    @Override
    public void stop() {
        if (isStarted()) {
            return;
        }
        super.stop();
    }

    @SneakyThrows
    @Override
    protected void append(ILoggingEvent o) {
        if (o == null || !isStarted()) {
            return;
        }
        System.out.print("log details is:" + layout.doLayout(o));
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(System.getProperty("java.class.path"));
    }

}
