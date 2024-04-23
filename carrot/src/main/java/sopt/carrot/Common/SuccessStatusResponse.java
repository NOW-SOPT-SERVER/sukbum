package sopt.carrot.Common;

import sopt.carrot.Common.Dto.SuccessMessage;

public record SuccessStatusResponse(
        int status,
        String message
) {
    public static SuccessStatusResponse of(SuccessMessage successMessage) {
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
