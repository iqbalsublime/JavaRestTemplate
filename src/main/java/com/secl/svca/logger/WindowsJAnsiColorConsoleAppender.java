package com.secl.svca.logger;

import java.io.PrintStream;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.fusesource.jansi.AnsiConsole;

// Color Console Appender for log4j: using jansi (http://jansi.fusesource.org/)

public class WindowsJAnsiColorConsoleAppender extends BaseColorConsoleAppender {
    
	String gTarget = null;
    boolean usingStdErr;
    
    
    public WindowsJAnsiColorConsoleAppender() {
        super();
    }

    public WindowsJAnsiColorConsoleAppender(Layout layout) {
        super(layout);
    }

    public WindowsJAnsiColorConsoleAppender(Layout layout, String target) {
        super(layout, target);
    }

    @SuppressWarnings("static-method")
    public void setPassThrough(boolean value) {
        System.setProperty("jansi.passthrough", value ? "true" : "false");
    }

    @SuppressWarnings("static-method")
    public void setStrip(boolean value) {
        System.setProperty("jansi.strip", value ? "true" : "false");
    }

    @Override
    protected void subAppend(LoggingEvent event) {
        @SuppressWarnings("resource")
        // Eclipse complains about this not being closed, but this is stdout/stderr.
        PrintStream currentOutput = usingStdErr ? AnsiConsole.err : AnsiConsole.out;

        if (!hackPatternString()) {
            currentOutput.print(getColour(event.getLevel()));
            super.subAppend(event);
            //currentOutput.print(getLayout().format(event));
        } else {
            String color = getColour(event.getLevel());
            currentOutput.print(getLayout().format(event).replace(HIGHLIGHT_START, color));
        }
        
    }

    @Override
    protected boolean hackPatternString() {
        String theTarget = getTarget();
        if (gTarget != theTarget) // I really want to have the same object, not just equal content
            usingStdErr = SYSTEM_ERR.equalsIgnoreCase(theTarget);

        return super.hackPatternString();
    }
}
