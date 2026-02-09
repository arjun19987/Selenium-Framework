package org.project.supportLibraries;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    SAFARI("safari");

    private final String name;

    Browser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
