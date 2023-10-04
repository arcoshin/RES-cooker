package com.example.rescooker.common.exception;

import lombok.Getter;

/**
 * 業務異常類
 *
 * @author XJX@de.tw
 * @version 1.0
 */
public class ServiceException extends RuntimeException {
    @Getter
    private ServiceCode serviceCode;

    public ServiceException(ServiceCode serviceCode, String message) {
        super(message);
        this.serviceCode = serviceCode;
    }

}
