package com.example.MOP_task_asg;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0015J\b\u0010\r\u001a\u00020\fH\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/MOP_task_asg/check_netwotk_conection;", "Landroidx/lifecycle/LiveData;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Landroid/net/ConnectivityManager;)V", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "onActive", "", "onInactive", "app_debug"})
public final class check_netwotk_conection extends androidx.lifecycle.LiveData<java.lang.Boolean> {
    private final android.net.ConnectivityManager connectivityManager = null;
    private final android.net.ConnectivityManager.NetworkCallback networkCallback = null;
    
    public check_netwotk_conection(@org.jetbrains.annotations.NotNull()
    android.net.ConnectivityManager connectivityManager) {
        super(null);
    }
    
    public check_netwotk_conection(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override()
    protected void onActive() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @java.lang.Override()
    protected void onInactive() {
    }
}