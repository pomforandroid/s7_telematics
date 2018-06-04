package com.skankhunt.s7_telematics.base;

public interface BaseView<T> {

    /**
     * 使用fragment作为view时，将activity中的presenter传递给fragment
     * @param presenter
     */
    void setPresenter(T presenter);
}
