package Y;

import U.f;
import android.graphics.Rect;
import java.util.Comparator;

/* JADX INFO: compiled from: FocusStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: FocusStrategy.java */
    public static class a<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f5195a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f5196b = new Rect();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f5197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Y.a.C0074a f5198d;

        public a(boolean z8, Y.a.C0074a c0074a) {
            this.f5197c = z8;
            this.f5198d = c0074a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t6) {
            Y.a.C0074a c0074a = this.f5198d;
            c0074a.getClass();
            Rect rect = this.f5195a;
            ((f) t).f(rect);
            c0074a.getClass();
            Rect rect2 = this.f5196b;
            ((f) t6).f(rect2);
            int i9 = rect.top;
            int i10 = rect2.top;
            if (i9 < i10) {
                return -1;
            }
            if (i9 > i10) {
                return 1;
            }
            int i11 = rect.left;
            int i12 = rect2.left;
            boolean z8 = this.f5197c;
            if (i11 < i12) {
                return z8 ? 1 : -1;
            }
            if (i11 > i12) {
                return z8 ? -1 : 1;
            }
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            if (i13 < i14) {
                return -1;
            }
            if (i13 > i14) {
                return 1;
            }
            int i15 = rect.right;
            int i16 = rect2.right;
            if (i15 < i16) {
                return z8 ? 1 : -1;
            }
            if (i15 > i16) {
                return z8 ? -1 : 1;
            }
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0044 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:29:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x004f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0053  */
    /* JADX WARN: Code duplicated, block: B:34:0x0059  */
    /* JADX WARN: Code duplicated, block: B:36:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    public static boolean a(int i9, Rect rect, Rect rect2, Rect rect3) {
        int iD;
        int i10;
        int i11;
        boolean zB = b(i9, rect, rect2);
        if (b(i9, rect, rect3) || !zB) {
            return false;
        }
        if (i9 != 17) {
            if (i9 != 33) {
                if (i9 != 66) {
                    if (i9 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    if (rect.bottom <= rect3.top) {
                        if (i9 != 17 && i9 != 66) {
                            iD = d(i9, rect, rect2);
                            if (i9 != 17) {
                                i10 = rect.left;
                                i11 = rect3.left;
                            } else if (i9 != 33) {
                                i10 = rect.top;
                                i11 = rect3.top;
                            } else if (i9 != 66) {
                                i10 = rect3.right;
                                i11 = rect.right;
                            } else {
                                if (i9 == 130) {
                                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                                }
                                i10 = rect3.bottom;
                                i11 = rect.bottom;
                            }
                            if (iD < Math.max(1, i10 - i11)) {
                                return false;
                            }
                        }
                    }
                } else if (rect.right <= rect3.left) {
                    if (i9 != 17) {
                        iD = d(i9, rect, rect2);
                        if (i9 != 17) {
                            i10 = rect.left;
                            i11 = rect3.left;
                        } else if (i9 != 33) {
                            i10 = rect.top;
                            i11 = rect3.top;
                        } else if (i9 != 66) {
                            i10 = rect3.right;
                            i11 = rect.right;
                        } else {
                            if (i9 == 130) {
                                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                            }
                            i10 = rect3.bottom;
                            i11 = rect.bottom;
                        }
                        if (iD < Math.max(1, i10 - i11)) {
                            return false;
                        }
                    }
                }
            } else if (rect.top >= rect3.bottom) {
                if (i9 != 17) {
                    iD = d(i9, rect, rect2);
                    if (i9 != 17) {
                        i10 = rect.left;
                        i11 = rect3.left;
                    } else if (i9 != 33) {
                        i10 = rect.top;
                        i11 = rect3.top;
                    } else if (i9 != 66) {
                        i10 = rect3.right;
                        i11 = rect.right;
                    } else {
                        if (i9 == 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                        i10 = rect3.bottom;
                        i11 = rect.bottom;
                    }
                    if (iD < Math.max(1, i10 - i11)) {
                        return false;
                    }
                }
            }
        } else if (rect.left >= rect3.right) {
            if (i9 != 17) {
                iD = d(i9, rect, rect2);
                if (i9 != 17) {
                    i10 = rect.left;
                    i11 = rect3.left;
                } else if (i9 != 33) {
                    i10 = rect.top;
                    i11 = rect3.top;
                } else if (i9 != 66) {
                    i10 = rect3.right;
                    i11 = rect.right;
                } else {
                    if (i9 == 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    i10 = rect3.bottom;
                    i11 = rect.bottom;
                }
                if (iD < Math.max(1, i10 - i11)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(int i9, Rect rect, Rect rect2) {
        if (i9 != 17) {
            if (i9 != 33) {
                if (i9 != 66) {
                    if (i9 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static boolean c(int i9, Rect rect, Rect rect2) {
        if (i9 == 17) {
            int i10 = rect.right;
            int i11 = rect2.right;
            return (i10 > i11 || rect.left >= i11) && rect.left > rect2.left;
        }
        if (i9 == 33) {
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            return (i12 > i13 || rect.top >= i13) && rect.top > rect2.top;
        }
        if (i9 == 66) {
            int i14 = rect.left;
            int i15 = rect2.left;
            return (i14 < i15 || rect.right <= i15) && rect.right < rect2.right;
        }
        if (i9 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i16 = rect.top;
        int i17 = rect2.top;
        return (i16 < i17 || rect.bottom <= i17) && rect.bottom < rect2.bottom;
    }

    public static int d(int i9, Rect rect, Rect rect2) {
        int i10;
        int i11;
        if (i9 == 17) {
            i10 = rect.left;
            i11 = rect2.right;
        } else if (i9 == 33) {
            i10 = rect.top;
            i11 = rect2.bottom;
        } else if (i9 == 66) {
            i10 = rect2.left;
            i11 = rect.right;
        } else {
            if (i9 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i10 = rect2.top;
            i11 = rect.bottom;
        }
        return Math.max(0, i10 - i11);
    }

    public static int e(int i9, Rect rect, Rect rect2) {
        if (i9 != 17) {
            if (i9 != 33) {
                if (i9 != 66) {
                    if (i9 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}
