package main.impl;

import main.service.IOutputGenerator;

public class CSVOutputGenerator implements IOutputGenerator {

    @Override
    public void generateOutput() {
        System.out.println("CSV Output Generator");
    }
}
