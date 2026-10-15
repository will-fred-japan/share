package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import cn.ikaile.ruoshui.client.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class AlertController {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final int f5805A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final int f5806B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final int f5807C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final boolean f5808D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final c f5809E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f5812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f5813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f5814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f5815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecycleListView f5816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f5817g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Button f5819i;
    public CharSequence j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Message f5820k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Button f5821l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f5822m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Message f5823n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f5824o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f5825p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Message f5826q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public NestedScrollView f5827r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f5828s;
    public ImageView t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f5829u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f5830v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f5831w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ListAdapter f5832x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f5834z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5818h = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f5833y = -1;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final a f5810F = new a();

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5836b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p059i.a.t);
            this.f5836b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.f5835a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.f5819i && (message3 = alertController.f5820k) != null) {
                messageObtain = Message.obtain(message3);
            } else if (view != alertController.f5821l || (message2 = alertController.f5823n) == null) {
                messageObtain = (view != alertController.f5824o || (message = alertController.f5826q) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            alertController.f5809E.obtainMessage(1, alertController.f5812b).sendToTarget();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContextThemeWrapper f5838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f5839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Drawable f5840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f5841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f5842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f5843f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CharSequence f5844g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public DialogInterface.OnClickListener f5845h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f5846i;
        public DialogInterface.OnClickListener j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnCancelListener f5847k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public androidx.appcompat.view.menu.g f5848l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f5849m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f5850n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f5851o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f5852p = -1;

        public b(ContextThemeWrapper contextThemeWrapper) {
            this.f5838a = contextThemeWrapper;
            this.f5839b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f5853a;

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i9 = message.what;
            if (i9 == -3 || i9 == -2 || i9 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f5853a.get(), message.what);
            } else {
                if (i9 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class d extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i9) {
            return i9;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, e eVar, Window window) {
        this.f5811a = context;
        this.f5812b = eVar;
        this.f5813c = window;
        c cVar = new c();
        cVar.f5853a = new WeakReference<>(eVar);
        this.f5809E = cVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, p059i.a.f19178e, R.attr.alertDialogStyle, 0);
        this.f5834z = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f5805A = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f5806B = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.f5807C = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f5808D = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        eVar.c().v(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i9, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.f5809E.obtainMessage(i9, onClickListener) : null;
        if (i9 == -3) {
            this.f5825p = charSequence;
            this.f5826q = messageObtainMessage;
        } else if (i9 == -2) {
            this.f5822m = charSequence;
            this.f5823n = messageObtainMessage;
        } else {
            if (i9 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.j = charSequence;
            this.f5820k = messageObtainMessage;
        }
    }
}
