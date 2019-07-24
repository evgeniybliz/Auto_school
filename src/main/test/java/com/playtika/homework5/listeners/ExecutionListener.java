package com.playtika.homework5.listeners;

import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener {

    @Override
    public void onExecutionStart(){
        System.out.println("Start");
    }

    @Override
    public void onExecutionFinish(){
        System.out.println("Finish");
    }
}