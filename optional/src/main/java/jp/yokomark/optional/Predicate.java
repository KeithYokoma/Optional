package jp.yokomark.optional;

import android.support.annotation.NonNull;

/**
 * Backport of Predicate interface in Java8.
 * @author KeithYokoma
 */
public interface Predicate<T> {
    boolean test(T value);
    @NonNull Predicate<T> and(@NonNull Predicate<? super T> other);
    @NonNull Predicate<T> negate();
    @NonNull Predicate<T> or(@NonNull Predicate<? super T> other);
}
