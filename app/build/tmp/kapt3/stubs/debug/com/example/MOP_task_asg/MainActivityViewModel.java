package com.example.MOP_task_asg;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\fJ \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\f2\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/example/MOP_task_asg/MainActivityViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "retroService", "Lcom/example/MOP_task_asg/network/RetroService;", "getRetroService", "()Lcom/example/MOP_task_asg/network/RetroService;", "setRetroService", "(Lcom/example/MOP_task_asg/network/RetroService;)V", "getListData", "Lkotlin/Function0;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/MOP_task_asg/network/DataObject;", "getList_search_Data", "query", "", "app_debug"})
public final class MainActivityViewModel extends androidx.lifecycle.AndroidViewModel {
    public com.example.MOP_task_asg.network.RetroService retroService;
    
    public MainActivityViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.MOP_task_asg.network.RetroService getRetroService() {
        return null;
    }
    
    public final void setRetroService(@org.jetbrains.annotations.NotNull()
    com.example.MOP_task_asg.network.RetroService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.MOP_task_asg.network.DataObject>>> getListData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.MOP_task_asg.network.DataObject>>> getList_search_Data(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
}