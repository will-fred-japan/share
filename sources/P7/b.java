package P7;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: KCallable.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface b<R> extends a {
    R call(Object... objArr);

    R callBy(Map<h, ? extends Object> map);

    List<h> getParameters();

    l getReturnType();

    List<Object> getTypeParameters();

    m getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
