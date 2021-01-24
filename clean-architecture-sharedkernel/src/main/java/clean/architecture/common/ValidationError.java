package clean.architecture.common;

import lombok.Data;

@Data
public class ValidationError {

    private final String identifier;
    private final String errorMessage;
    private final ValidationSeverity severity;

    public ValidationError(String identifier, String errorMessage, ValidationSeverity severity) {
        this.identifier = identifier;
        this.errorMessage = errorMessage;
        this.severity = severity;
    }
}

