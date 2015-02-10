package jp.yokomark.optional;

/**
 * Backport of Supplier interface in Java8.
 * @author KeithYokoma
 */
public interface Supplier<T> {
    T get();
}
