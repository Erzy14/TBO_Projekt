package com.example;

import com.zaxxer.nuprocess.NuAbstractProcessHandler;
import com.zaxxer.nuprocess.NuProcess;
import java.nio.ByteBuffer;

public class ProcessHandler extends NuAbstractProcessHandler {
    @Override
    public void onStart(NuProcess nuProcess) {
        System.out.println("Process started: " + nuProcess.getPID());
    }

    @Override
    public void onStdout(ByteBuffer buffer, boolean closed) {
        if (buffer != null) {
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            System.out.println("Output: " + new String(bytes));
        }
    }

    @Override
    public void onStderr(ByteBuffer buffer, boolean closed) {
        if (buffer != null) {
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            System.err.println("Error: " + new String(bytes));
        }
    }

    @Override
    public void onExit(int exitCode) {
        System.out.println("Process exited with code: " + exitCode);
    }
}
