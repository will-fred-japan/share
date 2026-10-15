package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FlutterMutatorsStack {
    private List<a> mutators = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<Path> finalClippingPaths = new ArrayList();
    private float finalOpacity = 1.0f;

    public class a {
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public float getFinalOpacity() {
        return this.finalOpacity;
    }

    public List<a> getMutators() {
        return this.mutators;
    }

    public void pushClipPath(Path path) {
        this.mutators.add(new a());
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRRect(int i9, int i10, int i11, int i12, float[] fArr) {
        Rect rect = new Rect(i9, i10, i11, i12);
        this.mutators.add(new a());
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(int i9, int i10, int i11, int i12) {
        Rect rect = new Rect(i9, i10, i11, i12);
        this.mutators.add(new a());
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushOpacity(float f6) {
        this.mutators.add(new a());
        this.finalOpacity *= f6;
    }

    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        this.mutators.add(new a());
        this.finalMatrix.preConcat(matrix);
    }
}
