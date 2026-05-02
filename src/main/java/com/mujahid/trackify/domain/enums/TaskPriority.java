package com.mujahid.trackify.domain.enums;

/**
 * Enum representing the priority levels for tasks.
 */
public enum TaskPriority {
    HIGH("High", 1),
    MEDIUM("Medium", 2),
    LOW("Low", 3);

    private final String displayName;
    private final int level;

    TaskPriority(String displayName, int level) {
        this.displayName = displayName;
        this.level = level;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getLevel() {
        return level;
    }
}
