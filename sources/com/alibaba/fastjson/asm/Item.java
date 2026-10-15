package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
final class Item {
    int hashCode;
    int index;
    int intVal;
    long longVal;
    Item next;
    String strVal1;
    String strVal2;
    String strVal3;
    int type;

    public Item() {
    }

    public boolean isEqualTo(Item item) {
        int i9 = this.type;
        if (i9 != 1) {
            if (i9 != 15) {
                if (i9 == 12) {
                    return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2);
                }
                if (i9 != 13) {
                    switch (i9) {
                        case 3:
                        case 4:
                            return item.intVal == this.intVal;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2) && item.strVal3.equals(this.strVal3);
                    }
                }
            }
            return item.longVal == this.longVal;
        }
        return item.strVal1.equals(this.strVal1);
    }

    public void set(int i9, String str, String str2, String str3) {
        this.type = i9;
        this.strVal1 = str;
        this.strVal2 = str2;
        this.strVal3 = str3;
        if (i9 != 1 && i9 != 7 && i9 != 8) {
            if (i9 == 12) {
                this.hashCode = ((str2.hashCode() * str.hashCode()) + i9) & Integer.MAX_VALUE;
                return;
            } else if (i9 != 13) {
                this.hashCode = ((str3.hashCode() * str2.hashCode() * str.hashCode()) + i9) & Integer.MAX_VALUE;
                return;
            }
        }
        this.hashCode = (str.hashCode() + i9) & Integer.MAX_VALUE;
    }

    public Item(int i9, Item item) {
        this.index = i9;
        this.type = item.type;
        this.intVal = item.intVal;
        this.longVal = item.longVal;
        this.strVal1 = item.strVal1;
        this.strVal2 = item.strVal2;
        this.strVal3 = item.strVal3;
        this.hashCode = item.hashCode;
    }

    public void set(int i9) {
        this.type = 3;
        this.intVal = i9;
        this.hashCode = (3 + i9) & Integer.MAX_VALUE;
    }
}
