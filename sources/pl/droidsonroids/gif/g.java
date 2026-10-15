package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.net.Uri;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: GifViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f20870a = Arrays.asList("raw", "drawable", "mipmap");

    public static boolean a(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new d(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean b(ImageView imageView, boolean z8, int i9) {
        Resources resources = imageView.getResources();
        if (resources == null) {
            return false;
        }
        try {
            if (!f20870a.contains(resources.getResourceTypeName(i9))) {
                return false;
            }
            d dVar = new d(resources, i9);
            if (z8) {
                imageView.setImageDrawable(dVar);
                return true;
            }
            imageView.setBackground(dVar);
            return true;
        } catch (Resources.NotFoundException | IOException unused) {
            return false;
        }
    }
}
