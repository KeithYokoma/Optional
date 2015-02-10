package jp.yokomark.optional;

/**
 * Backport of Consumer interface in Java8.
 * @author KeithYokoma
 */
public interface Consumer<T> {
    void accept(T value);
}
