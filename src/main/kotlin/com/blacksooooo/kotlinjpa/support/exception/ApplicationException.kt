package com.blacksooooo.kotlinjpa.support.exception

import com.blacksooooo.kotlinjpa.common.enum.CommonErrorType
import org.springframework.http.HttpStatus

open class ApplicationException(
    val errorType: CommonErrorType,
    message: String = errorType.message,
    val statusCode: HttpStatus
) : RuntimeException(message)
