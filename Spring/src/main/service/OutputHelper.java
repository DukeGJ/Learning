package main.service;

public class OutputHelper {
    private IOutputGenerator generator;

    public void generateOutput() {
        generator.generateOutput();
    }

    public void setGenerator(IOutputGenerator generator) {
        this.generator = generator;
    }
}
