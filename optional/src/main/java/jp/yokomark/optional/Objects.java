package jp.yokomark.optional;

/**
 * Backport of {@link java.util.Objects} methods for pre-KitKat.
 * @author KeithYokoma
 * @see java.util.Objects
 */
public final class Objects {
    private Objects() {
        throw new AssertionError();
    }

    /**
     * Returns {@code o} if non-null, or throws {@code NullPointerException}.
     */
    public static <T> T requireNonNull(T o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return o;
    }

    /**
     * Returns the hash code of a non-null argument and 0 for a null argument.
     * @param o an object
     * @return the hash code of a non-null argument and 0 for a null argument.
     * @see Object#hashCode()
     */
    public static int hashCode(Object o) {
        return o != null ? o.hashCode() : 0;
    }

    /**
     * Returns true if the arguments are equal to each other and false otherwise. Consequently, if both arguments are null, true is returned and if exactly one argument is null, false is returned. Otherwise, equality is determined by using the equals method of the first argument.
     * @param a an object
     * @param b an object to be compared with a for equality
     * @return true if the arguments are equal to each other and false otherwise
     */
    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
