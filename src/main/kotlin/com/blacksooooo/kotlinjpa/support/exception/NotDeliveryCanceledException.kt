package com.blacksooooo.kotlinjpa.support.exception

import com.blacksooooo.kotlinjpa.common.enum.CommonErrorType
import org.springframework.http.HttpStatus

class NotDeliveryCanceledException(
    errorType: CommonErrorType = CommonErrorType.ALREADY_DELIVERY_COMPLETED,
    message: String = errorType.message,
    statusCode: HttpStatus = HttpStatus.BAD_REQUEST
): ApplicationException(errorType, message, statusCode)