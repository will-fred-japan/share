package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;
import okhttp3.Route;

/* JADX INFO: compiled from: RouteDatabase.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        k.e(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(Route failedRoute) {
        k.e(failedRoute, "failedRoute");
        this.failedRoutes.add(failedRoute);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        k.e(route, "route");
        return this.failedRoutes.contains(route);
    }
}
