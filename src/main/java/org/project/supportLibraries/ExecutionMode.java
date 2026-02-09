package org.project.supportLibraries;

public enum ExecutionMode {
    LOCAL("local"),
    JENKINS("jenkins"),
    GRID("grid"),
    MOBILE("mobile");

    private final String mode;

    ExecutionMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
