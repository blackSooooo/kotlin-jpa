package com.blacksooooo.kotlinjpa.support.exception

import com.blacksooooo.kotlinjpa.common.enum.CommonErrorType
import org.springframework.http.HttpStatus

class NotEnoughStockException(
    errorType: CommonErrorType = CommonErrorType.LACK_OF_STOCK_QUANTITY,
    message: String = errorType.message,
    statusCode: HttpStatus = HttpStatus.BAD_REQUEST
) : ApplicationException(errorType, message, statusCode)