package clean.architecture.common;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {

    @Getter
    private T value;

    @Getter
    private ResultStatus status;

    @Getter
    private final List<String> errors = new ArrayList<>();

    @Getter
    private final List<ValidationError> validationErrors = new ArrayList<>();

    public Result(T value) {
        this.value = value;
    }

    private Result(ResultStatus status) {
        this.status = status;
    }

    public static <R> Result<R> success(R value) {
        return new Result<>(value);
    }

    public static <R> Result<R> error(List<String> errorMessages) {
        Result<R> result = new Result<>(ResultStatus.Error);
        result.errors.addAll(errorMessages);
        return result;
    }

    public static <R> Result<R> invalid(List<ValidationError> validationErrors) {
        Result<R> result = new Result<>(ResultStatus.Error);
        result.validationErrors.addAll(validationErrors);
        return result;
    }

    public static <R> Result<R> notFound() {
        return new Result<>(ResultStatus.NotFound);
    }

    public static <R> Result<R> forbidden() {
        return new Result<>(ResultStatus.Forbidden);
    }
}
