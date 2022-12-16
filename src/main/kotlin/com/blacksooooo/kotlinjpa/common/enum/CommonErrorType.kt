package com.blacksooooo.kotlinjpa.common.enum

enum class CommonErrorType(
    val message: String,
) {
    LACK_OF_STOCK_QUANTITY("재고가 충분하지 않습니다."),
    ALREADY_DELIVERY_COMPLETED("이미 배송이 완료되었습니다.")
}
