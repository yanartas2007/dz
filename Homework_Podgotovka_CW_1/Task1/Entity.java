package Homework_Podgotovka_CW_1.Task1;

import java.util.Objects;

public abstract class Entity<T> {
    public T id;

    public Entity(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
