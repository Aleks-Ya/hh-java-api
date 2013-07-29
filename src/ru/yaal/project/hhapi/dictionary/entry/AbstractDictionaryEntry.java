package ru.yaal.project.hhapi.dictionary.entry;

import static java.lang.String.format;

public abstract class AbstractDictionaryEntry implements IDictionaryEntry {
    private static final String NULL_ID = "IdForNullEntries";
    private static final String NULL_NAME = "NameForNullEntries";
    protected String id;
    protected String name;

    public AbstractDictionaryEntry() {
        setId(NULL_ID);
        setName(NULL_NAME);
    }

    public AbstractDictionaryEntry(String id, String name) {
        setId(id);
        setName(name);
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
