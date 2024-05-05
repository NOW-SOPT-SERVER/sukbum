package sopt.carrot.common.success;

public record SuccessStatusResponse<T>(
        int status,
        String message,
        T data
) {
    public static <T> SuccessStatusResponse<T> of(SuccessMessage successMessage, T bodyData) {
        return new SuccessStatusResponse<>(successMessage.getStatus(), successMessage.getMessage(), bodyData);
    }

    public static <T> SuccessStatusResponse<T> of(SuccessMessage successMessage) {
        return new SuccessStatusResponse<>(successMessage.getStatus(), successMessage.getMessage(), null);
    }
}
