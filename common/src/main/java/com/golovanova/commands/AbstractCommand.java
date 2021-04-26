package com.golovanova.commands;

import java.io.Serializable;

public abstract class AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    private String name;
    private String description;

    public AbstractCommand() {
    }

    public AbstractCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    };

    public int hashCode() {
        return name.hashCode() + description.hashCode();
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AbstractCommand other = (AbstractCommand) obj;
        return name.equals(other.name) && description.equals(other.description);
    }
}