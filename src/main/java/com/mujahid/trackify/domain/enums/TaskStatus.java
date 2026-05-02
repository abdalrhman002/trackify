package com.mujahid.trackify.domain.enums;

/**
 * Enum representing the various states a task can be in.
 */
public enum TaskStatus {
    OPEN("Open"),
    IN_PROGRESS("In Progress"),
    CLOSED("Closed");

    private final String displayName;

    TaskStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
