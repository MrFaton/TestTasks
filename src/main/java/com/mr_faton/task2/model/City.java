package com.mr_faton.task2.model;

public class City {
    private final int id;
    private final String name;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + 31 * id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        City other = (City) obj;
        if (this.id == other.id && this.name.equals(other.name)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + "(id:" + id + ")";
    }
}
/*
This bean represents some city
 */