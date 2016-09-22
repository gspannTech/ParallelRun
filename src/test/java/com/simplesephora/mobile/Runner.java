package com.simplesephora.mobile;

import org.testng.annotations.Test;

import com.appium.manager.ParallelThread;

public class Runner {
	
	

    @Test public void runWebTests() throws Exception {
        ParallelThread parallelThread = new ParallelThread();
        parallelThread.runner("com.simplesephora.mobile");
    }
}
