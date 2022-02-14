package com.example.MOP_task_asg.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u000e\u001a\u00020\tH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/MOP_task_asg/network/RetroService;", "", "get_alltrending_images", "Lcom/example/MOP_task_asg/network/DataResult;", "page_number", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search_alltrending_images", "search", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upload_into_giphy", "Lretrofit2/Call;", "Lcom/example/MOP_task_asg/network/DataObject;", "url", "app_debug"})
public abstract interface RetroService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "gifs/trending?api_key=xCK3sN3tiWhMw8SrhczeDn8FSV09MSR4")
    public abstract java.lang.Object get_alltrending_images(@retrofit2.http.Query(value = "offset")
    int page_number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.MOP_task_asg.network.DataResult> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "gifs/search?api_key=xCK3sN3tiWhMw8SrhczeDn8FSV09MSR4")
    public abstract java.lang.Object search_alltrending_images(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String search, @retrofit2.http.Query(value = "offset")
    int page_number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.MOP_task_asg.network.DataResult> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "gifs?api_key=xCK3sN3tiWhMw8SrhczeDn8FSV09MSR4")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<com.example.MOP_task_asg.network.DataObject> upload_into_giphy(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "file")
    java.lang.String url);
}