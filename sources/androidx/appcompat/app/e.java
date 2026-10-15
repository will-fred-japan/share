package androidx.appcompat.app;

import T.G;
import T.L;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: AlertDialog.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends n implements DialogInterface {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AlertController f5946g;

    /* JADX INFO: compiled from: AlertDialog.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlertController.b f5947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5948b;

        public a(Context context) {
            this(context, e.f(context, 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v1, types: [android.widget.ListAdapter] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4 */
        public e a() {
            AlertController.b bVar = this.f5947a;
            e eVar = new e(bVar.f5838a, this.f5948b);
            View view = bVar.f5842e;
            AlertController alertController = eVar.f5946g;
            if (view != null) {
                alertController.f5831w = view;
            } else {
                CharSequence charSequence = bVar.f5841d;
                if (charSequence != null) {
                    alertController.f5814d = charSequence;
                    TextView textView = alertController.f5829u;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = bVar.f5840c;
                if (drawable != null) {
                    alertController.f5828s = drawable;
                    ImageView imageView = alertController.t;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.t.setImageDrawable(drawable);
                    }
                }
            }
            CharSequence charSequence2 = bVar.f5843f;
            if (charSequence2 != null) {
                alertController.f5815e = charSequence2;
                TextView textView2 = alertController.f5830v;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = bVar.f5844g;
            if (charSequence3 != null) {
                alertController.c(-1, charSequence3, bVar.f5845h);
            }
            CharSequence charSequence4 = bVar.f5846i;
            if (charSequence4 != null) {
                alertController.c(-2, charSequence4, bVar.j);
            }
            if (bVar.f5849m != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar.f5839b.inflate(alertController.f5805A, (ViewGroup) null);
                int i9 = bVar.f5851o ? alertController.f5806B : alertController.f5807C;
                Object obj = bVar.f5849m;
                ?? dVar = obj;
                if (obj == null) {
                    dVar = new AlertController.d(bVar.f5838a, i9, R.id.text1, null);
                }
                alertController.f5832x = dVar;
                alertController.f5833y = bVar.f5852p;
                if (bVar.f5850n != null) {
                    recycleListView.setOnItemClickListener(new d(bVar, alertController));
                }
                if (bVar.f5851o) {
                    recycleListView.setChoiceMode(1);
                }
                alertController.f5816f = recycleListView;
            }
            eVar.setCancelable(true);
            eVar.setCanceledOnTouchOutside(true);
            eVar.setOnCancelListener(bVar.f5847k);
            eVar.setOnDismissListener(null);
            androidx.appcompat.view.menu.g gVar = bVar.f5848l;
            if (gVar != null) {
                eVar.setOnKeyListener(gVar);
            }
            return eVar;
        }

        public a b(DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f5947a;
            bVar.f5844g = bVar.f5838a.getText(R.string.ok);
            bVar.f5845h = onClickListener;
            return this;
        }

        public a c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f5947a;
            bVar.f5844g = charSequence;
            bVar.f5845h = onClickListener;
            return this;
        }

        public a(Context context, int i9) {
            this.f5947a = new AlertController.b(new ContextThemeWrapper(context, e.f(context, i9)));
            this.f5948b = i9;
        }
    }

    public e(ContextThemeWrapper contextThemeWrapper, int i9) {
        super(contextThemeWrapper, f(contextThemeWrapper, i9));
        this.f5946g = new AlertController(getContext(), this, getWindow());
    }

    public static int f(Context context, int i9) {
        if (((i9 >>> 24) & 255) >= 1) {
            return i9;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(cn.ikaile.ruoshui.client.R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.n, p030e.k, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i9;
        int i10;
        int i11;
        ListAdapter listAdapter;
        View viewFindViewById;
        super.onCreate(bundle);
        AlertController alertController = this.f5946g;
        alertController.f5812b.setContentView(alertController.f5834z);
        Window window = alertController.f5813c;
        View viewFindViewById2 = window.findViewById(cn.ikaile.ruoshui.client.R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(cn.ikaile.ruoshui.client.R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(cn.ikaile.ruoshui.client.R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(cn.ikaile.ruoshui.client.R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(cn.ikaile.ruoshui.client.R.id.customPanel);
        FrameLayout frameLayout = alertController.f5817g;
        if (frameLayout == null) {
            frameLayout = null;
        }
        boolean z8 = frameLayout != null;
        if (!z8 || !AlertController.a(frameLayout)) {
            window.setFlags(131072, 131072);
        }
        if (z8) {
            i9 = 2;
            FrameLayout frameLayout2 = (FrameLayout) window.findViewById(cn.ikaile.ruoshui.client.R.id.custom);
            frameLayout2.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.f5818h) {
                frameLayout2.setPadding(0, 0, 0, 0);
            }
            if (alertController.f5816f != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            i9 = 2;
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(cn.ikaile.ruoshui.client.R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(cn.ikaile.ruoshui.client.R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(cn.ikaile.ruoshui.client.R.id.buttonPanel);
        ViewGroup viewGroupB = AlertController.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = AlertController.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = AlertController.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(cn.ikaile.ruoshui.client.R.id.scrollView);
        alertController.f5827r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.f5827r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(R.id.message);
        alertController.f5830v = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f5815e;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.f5827r.removeView(alertController.f5830v);
                if (alertController.f5816f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.f5827r.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(alertController.f5827r);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(alertController.f5816f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(R.id.button1);
        alertController.f5819i = button;
        AlertController.a aVar = alertController.f5810F;
        button.setOnClickListener(aVar);
        if (TextUtils.isEmpty(alertController.j)) {
            alertController.f5819i.setVisibility(8);
            i10 = 0;
        } else {
            alertController.f5819i.setText(alertController.j);
            alertController.f5819i.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroupB3.findViewById(R.id.button2);
        alertController.f5821l = button2;
        button2.setOnClickListener(aVar);
        if (TextUtils.isEmpty(alertController.f5822m)) {
            alertController.f5821l.setVisibility(8);
        } else {
            alertController.f5821l.setText(alertController.f5822m);
            alertController.f5821l.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroupB3.findViewById(R.id.button3);
        alertController.f5824o = button3;
        button3.setOnClickListener(aVar);
        if (TextUtils.isEmpty(alertController.f5825p)) {
            alertController.f5824o.setVisibility(8);
        } else {
            alertController.f5824o.setText(alertController.f5825p);
            alertController.f5824o.setVisibility(0);
            i10 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        alertController.f5811a.getTheme().resolveAttribute(cn.ikaile.ruoshui.client.R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data == 0) {
            i11 = i9;
        } else if (i10 == 1) {
            Button button4 = alertController.f5819i;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
            layoutParams.gravity = 1;
            layoutParams.weight = 0.5f;
            button4.setLayoutParams(layoutParams);
            i11 = i9;
        } else {
            i11 = i9;
            if (i10 == i11) {
                Button button5 = alertController.f5821l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i10 == 4) {
                Button button6 = alertController.f5824o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i10 == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (alertController.f5831w != null) {
            viewGroupB.addView(alertController.f5831w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(cn.ikaile.ruoshui.client.R.id.title_template).setVisibility(8);
        } else {
            alertController.t = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(alertController.f5814d) || !alertController.f5808D) {
                window.findViewById(cn.ikaile.ruoshui.client.R.id.title_template).setVisibility(8);
                alertController.t.setVisibility(8);
                viewGroupB.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(cn.ikaile.ruoshui.client.R.id.alertTitle);
                alertController.f5829u = textView2;
                textView2.setText(alertController.f5814d);
                Drawable drawable = alertController.f5828s;
                if (drawable != null) {
                    alertController.t.setImageDrawable(drawable);
                } else {
                    alertController.f5829u.setPadding(alertController.t.getPaddingLeft(), alertController.t.getPaddingTop(), alertController.t.getPaddingRight(), alertController.t.getPaddingBottom());
                    alertController.t.setVisibility(8);
                }
            }
        }
        boolean z9 = viewGroup.getVisibility() != 8;
        int i12 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z10 = viewGroupB3.getVisibility() != 8;
        if (!z10 && (viewFindViewById = viewGroupB2.findViewById(cn.ikaile.ruoshui.client.R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i12 != 0) {
            NestedScrollView nestedScrollView2 = alertController.f5827r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (alertController.f5815e == null && alertController.f5816f == null) ? null : viewGroupB.findViewById(cn.ikaile.ruoshui.client.R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupB2.findViewById(cn.ikaile.ruoshui.client.R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController.RecycleListView recycleListView = alertController.f5816f;
        if (recycleListView != null && (!z10 || i12 == 0)) {
            recycleListView.setPadding(recycleListView.getPaddingLeft(), i12 != 0 ? recycleListView.getPaddingTop() : recycleListView.f5835a, recycleListView.getPaddingRight(), z10 ? recycleListView.getPaddingBottom() : recycleListView.f5836b);
        }
        if (!z9) {
            View view = alertController.f5816f;
            if (view == null) {
                view = alertController.f5827r;
            }
            if (view != null) {
                int i13 = i12 | (z10 ? i11 : 0);
                View viewFindViewById11 = window.findViewById(cn.ikaile.ruoshui.client.R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(cn.ikaile.ruoshui.client.R.id.scrollIndicatorDown);
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                view.setScrollIndicators(i13, 3);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController.RecycleListView recycleListView2 = alertController.f5816f;
        if (recycleListView2 == null || (listAdapter = alertController.f5832x) == null) {
            return;
        }
        recycleListView2.setAdapter(listAdapter);
        int i14 = alertController.f5833y;
        if (i14 > -1) {
            recycleListView2.setItemChecked(i14, true);
            recycleListView2.setSelection(i14);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i9, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f5946g.f5827r;
        if (nestedScrollView == null || !nestedScrollView.c(keyEvent)) {
            return super.onKeyDown(i9, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i9, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f5946g.f5827r;
        if (nestedScrollView == null || !nestedScrollView.c(keyEvent)) {
            return super.onKeyUp(i9, keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.app.n, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.f5946g;
        alertController.f5814d = charSequence;
        TextView textView = alertController.f5829u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
