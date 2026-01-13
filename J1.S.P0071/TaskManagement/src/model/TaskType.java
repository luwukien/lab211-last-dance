package model;

/**
 *
 * @author IdeaPad
 */
public enum TaskType {
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");

    private final int id;
    private final String name;

    TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Gets the TaskType object associated with the given Id
     *
     * @param id the ID to search for
     * @return The TaskType object if found, otherwise null
     */
    public static TaskType getById(int id) {
        TaskType result = null;

        for (TaskType type : values()) {
            if (type.getId() == id) {
                result = type;
                break;
            }
        }
        return result;
    }

}
