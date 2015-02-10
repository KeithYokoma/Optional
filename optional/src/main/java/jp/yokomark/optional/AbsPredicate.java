package jp.yokomark.optional;

import android.support.annotation.NonNull;

/**
 * * Backport for full implementation of Predicate interface in Java8.
 * @author KeithYokoma
 */
public abstract class AbsPredicate<T> implements Predicate<T> {
    public static final String TAG = AbsPredicate.class.getSimpleName();

    @Override
    public @NonNull Predicate<T> and(@NonNull final Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return new AbsPredicate<T>() {
            @Override
            public boolean test(T value) {
                return AbsPredicate.this.test(value) && other.test(value);
            }
        };
    }

    @Override
    public @NonNull Predicate<T> negate() {
        return new AbsPredicate<T>() {
            @Override
            public boolean test(T value) {
                return !AbsPredicate.this.test(value);
            }
        };
    }

    @Override
    public @NonNull Predicate<T> or(@NonNull final Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return new AbsPredicate<T>() {
            @Override
            public boolean test(T value) {
                return AbsPredicate.this.test(value) || other.test(value);
            }
        };
    }
}
