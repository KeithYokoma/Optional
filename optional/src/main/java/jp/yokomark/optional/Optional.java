package jp.yokomark.optional;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Backport class of Java8 Optional class.
 * @author KeithYokoma
 */
public class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    private Optional() {
        this.value = null;
    }

    private Optional(T value) {
        this.value = Objects.requireNonNull(value);
    }

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }

    public static <T> Optional<T> of(@NonNull T value) {
        return new Optional<>(value);
    }

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> ofNullable(@Nullable T value) {
        return value == null ? (Optional<T>) empty() : new Optional<>(value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Optional)) {
            return false;
        }
        Optional<?> other = (Optional<?>) o;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return value == null ? "Optional.empty" : String.format("Optional[%s]", value);
    }

    public T get() {
        if (value == null) {
            throw new NullPointerException("value is not present.");
        }
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public void ifPresent(@NonNull Consumer<? super T> consumer) {
        if (value != null)
            consumer.accept(value);
    }

    public T orElse(T other) {
        return value == null ? other : value;
    }

    public T orElseGet(@NonNull Supplier<? extends T> supplier) {
        return value == null ? supplier.get() : value;
    }

    public <X extends Throwable> T orElseThrow(@NonNull Supplier<? extends X> supplier) throws X {
        if (value == null) {
            throw supplier.get();
        }
        return value;
    }

    public <U> Optional<U> flatMap(@NonNull Function<? super T, Optional<U>> function) {
        Objects.requireNonNull(function);
        if (value == null) {
            return empty();
        }
        return Objects.requireNonNull(function.apply(value));
    }

    public <U> Optional<U> map(@NonNull Function<? super T, ? extends U> function) {
        Objects.requireNonNull(function);
        if (value == null) {
            return empty();
        }
        return Optional.ofNullable(function.apply(value));
    }

    @SuppressWarnings("unchecked")
    public Optional<T> filter(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (value == null) {
            return this;
        }
        return predicate.test(value) ? this : (Optional<T>) empty();
    }
}
