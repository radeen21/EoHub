package com.example.admin.eohub.base;

public interface IBasePresenter<T extends IBaseView> {

    void onAttach(T view);
    void onDetach();
    boolean isAttached();
}
