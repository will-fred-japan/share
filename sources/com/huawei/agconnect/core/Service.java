package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f14620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f14621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f14622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14625f;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Class<?> f14626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Class<?> f14627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f14630e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14631f;

        public Service build() {
            Class<?> cls = this.f14626a;
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
            Class<?> cls2 = this.f14627b;
            if (cls2 == null) {
                Object obj = this.f14628c;
                if (obj == null) {
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                }
                Service service = new Service(cls, obj);
                service.f14623d = this.f14629d;
                return service;
            }
            if (cls2.isInterface() || !Modifier.isPublic(this.f14627b.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
            }
            Service service2 = new Service((Class) this.f14626a, (Class) this.f14627b);
            service2.f14623d = this.f14629d;
            service2.f14624e = this.f14630e;
            service2.f14625f = this.f14631f;
            return service2;
        }

        public Builder isAutoCreated(boolean z8) {
            this.f14631f = z8;
            return this;
        }

        public Builder isSharedInstance(boolean z8) {
            this.f14630e = z8;
            return this;
        }

        public Builder isSingleton(boolean z8) {
            this.f14629d = z8;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.f14627b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f14626a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f14628c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f14620a = cls;
        this.f14621b = cls2;
        this.f14622c = null;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.f14622c;
    }

    public Class<?> getInterface() {
        return this.f14620a;
    }

    public Class<?> getType() {
        return this.f14621b;
    }

    public boolean isAutoCreated() {
        return this.f14625f;
    }

    public boolean isSharedInstance() {
        return this.f14624e;
    }

    public boolean isSingleton() {
        return this.f14623d;
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    private Service(Class<?> cls, Object obj) {
        this.f14620a = cls;
        this.f14621b = null;
        this.f14622c = obj;
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }
}
