package main.impl;

import main.service.IOutputGenerator;

public class JsonOutputGenerator implements IOutputGenerator {

    @Override
    public void generateOutput() {
        System.out.println("JSON Output Generator");
    }
}
