package clean.architecture.sharedkernel;

// https://github.com/jhewlett/ValueObject
public interface ValueObject {

    int hashCode();

    boolean equals(Object obj);

}
