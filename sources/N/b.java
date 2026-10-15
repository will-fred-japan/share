package N;

import android.location.Location;
import android.location.LocationListener;
import java.util.List;
import p185x4.j;

/* JADX INFO: compiled from: LocationListenerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends LocationListener {
    @Override // android.location.LocationListener
    default void onLocationChanged(List<Location> list) {
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((j) this).onLocationChanged(list.get(i9));
        }
    }

    @Override // android.location.LocationListener
    default void onFlushComplete(int i9) {
    }
}
