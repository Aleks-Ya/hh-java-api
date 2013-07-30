package ru.yaal.project.hhapi.dictionary.entry;

import static java.lang.String.format;

public abstract class AbstractDictionaryEntry implements IDictionaryEntry {
    private static final String NULL_ID = "IdForNullEntries";
    private static final String NULL_NAME = "NameForNullEntries";
    private String id;
    private String name;

    public AbstractDictionaryEntry() {
        this(NULL_ID, NULL_NAME);
    }

    public AbstractDictionaryEntry(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isNull() {
        return (getId() == null
                || getId().isEmpty()
                || NULL_ID.equalsIgnoreCase(getId())
                || NULL_NAME.equalsIgnoreCase(getName()));
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof AbstractDictionaryEntry)) {
            return false;
        }
        AbstractDictionaryEntry other = (AbstractDictionaryEntry) otherObj;
        return getId().equalsIgnoreCase(other.getId());
    }

    @Override
    public String toString() {
        return format("%s(%s)", getName(), getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
