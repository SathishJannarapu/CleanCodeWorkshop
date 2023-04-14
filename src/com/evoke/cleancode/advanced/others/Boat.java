package com.evoke.cleancode.advanced.others;

public class Boat {

	private String name;

    Boat(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boat boat = (Boat) o;

        return !(name != null ? !name.equals(boat.name) : boat.name != null);
    }

    @Override
    public int hashCode() {
        return (int) (Math.random() * 5000);
    }

}
