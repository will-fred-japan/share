package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.K;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f6054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f6055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f6056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f6057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CheckBox f6058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f6059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f6060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f6061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f6062i;
    public final Drawable j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f6063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f6064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Drawable f6066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f6067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f6068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6069q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        K kE = K.e(getContext(), attributeSet, p059i.a.f19190r, R.attr.listMenuViewStyle);
        this.j = kE.b(5);
        TypedArray typedArray = kE.f6420b;
        this.f6063k = typedArray.getResourceId(1, -1);
        this.f6065m = typedArray.getBoolean(7, false);
        this.f6064l = context;
        this.f6066n = kE.b(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f6067o = typedArrayObtainStyledAttributes.hasValue(0);
        kE.f();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f6068p == null) {
            this.f6068p = LayoutInflater.from(getContext());
        }
        return this.f6068p;
    }

    private void setSubMenuArrowVisible(boolean z8) {
        ImageView imageView = this.f6060g;
        if (imageView != null) {
            imageView.setVisibility(z8 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f6061h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6061h.getLayoutParams();
        rect.top = this.f6061h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    @Override // androidx.appcompat.view.menu.k.a
    public final void d(h hVar) {
        boolean z8;
        int i9;
        String string;
        boolean z9;
        this.f6054a = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        setTitle(hVar.f6159e);
        setCheckable(hVar.isCheckable());
        if (hVar.f6167n.o()) {
            if ((hVar.f6167n.n() ? hVar.j : hVar.f6162h) != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
        } else {
            z8 = false;
        }
        hVar.f6167n.n();
        if (z8) {
            h hVar2 = this.f6054a;
            if (hVar2.f6167n.o()) {
                if ((hVar2.f6167n.n() ? hVar2.j : hVar2.f6162h) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            } else {
                z9 = false;
            }
            i9 = z9 ? 0 : 8;
        }
        if (i9 == 0) {
            TextView textView = this.f6059f;
            h hVar3 = this.f6054a;
            char c5 = hVar3.f6167n.n() ? hVar3.j : hVar3.f6162h;
            if (c5 == 0) {
                string = "";
            } else {
                f fVar = hVar3.f6167n;
                Resources resources = fVar.f6126a.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(fVar.f6126a).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i10 = fVar.n() ? hVar3.f6164k : hVar3.f6163i;
                h.c(sb, i10, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
                h.c(sb, i10, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                h.c(sb, i10, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                h.c(sb, i10, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                h.c(sb, i10, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                h.c(sb, i10, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (c5 == '\b') {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (c5 == '\n') {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (c5 != ' ') {
                    sb.append(c5);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                string = sb.toString();
            }
            textView.setText(string);
        }
        if (this.f6059f.getVisibility() != i9) {
            this.f6059f.setVisibility(i9);
        }
        setIcon(hVar.getIcon());
        setEnabled(hVar.isEnabled());
        setSubMenuArrowVisible(hVar.hasSubMenu());
        setContentDescription(hVar.f6170q);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f6054a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f6057d = textView;
        int i9 = this.f6063k;
        if (i9 != -1) {
            textView.setTextAppearance(this.f6064l, i9);
        }
        this.f6059f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f6060g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f6066n);
        }
        this.f6061h = (ImageView) findViewById(R.id.group_divider);
        this.f6062i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        if (this.f6055b != null && this.f6065m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f6055b.getLayoutParams();
            int i11 = layoutParams.height;
            if (i11 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i11;
            }
        }
        super.onMeasure(i9, i10);
    }

    public void setCheckable(boolean z8) {
        CompoundButton compoundButton;
        View view;
        if (!z8 && this.f6056c == null && this.f6058e == null) {
            return;
        }
        if ((this.f6054a.f6176x & 4) != 0) {
            if (this.f6056c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f6056c = radioButton;
                LinearLayout linearLayout = this.f6062i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f6056c;
            view = this.f6058e;
        } else {
            if (this.f6058e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f6058e = checkBox;
                LinearLayout linearLayout2 = this.f6062i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f6058e;
            view = this.f6056c;
        }
        if (z8) {
            compoundButton.setChecked(this.f6054a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f6058e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f6056c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z8) {
        CompoundButton compoundButton;
        if ((this.f6054a.f6176x & 4) != 0) {
            if (this.f6056c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f6056c = radioButton;
                LinearLayout linearLayout = this.f6062i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f6056c;
        } else {
            if (this.f6058e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f6058e = checkBox;
                LinearLayout linearLayout2 = this.f6062i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f6058e;
        }
        compoundButton.setChecked(z8);
    }

    public void setForceShowIcon(boolean z8) {
        this.f6069q = z8;
        this.f6065m = z8;
    }

    public void setGroupDividerEnabled(boolean z8) {
        ImageView imageView = this.f6061h;
        if (imageView != null) {
            imageView.setVisibility((this.f6067o || !z8) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z8 = this.f6054a.f6167n.f6143s || this.f6069q;
        if (z8 || this.f6065m) {
            ImageView imageView = this.f6055b;
            if (imageView == null && drawable == null && !this.f6065m) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f6055b = imageView2;
                LinearLayout linearLayout = this.f6062i;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f6065m) {
                this.f6055b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f6055b;
            if (!z8) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f6055b.getVisibility() != 0) {
                this.f6055b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f6057d.getVisibility() != 8) {
                this.f6057d.setVisibility(8);
            }
        } else {
            this.f6057d.setText(charSequence);
            if (this.f6057d.getVisibility() != 0) {
                this.f6057d.setVisibility(0);
            }
        }
    }
}
