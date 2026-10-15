package com.engagelab.privates.core.global;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MTAddressGlobal {
    private static final List<String[]> list;

    static {
        ArrayList arrayList = new ArrayList();
        list = arrayList;
        arrayList.add(getSingapore01());
        arrayList.add(usaVirginia());
        arrayList.add(DEU_Frankfurt());
        arrayList.add(getSingapore02());
        arrayList.add(getHongKong());
    }

    private static String[] DEU_Frankfurt() {
        return new String[]{"sis-defra.push.theengagelab.com:19000", "sis-defra.push.engageforce.net:19000", "sis-defra.push.engage7.com:19000"};
    }

    private static String[] getHongKong() {
        return new String[]{"sis-hk.push.theengagelab.com:19000", "sis-hk.push.engageforce.net:19000", "sis-hk.push.engage7.com:19000"};
    }

    public static List<String[]> getList() {
        return list;
    }

    private static String[] getSingapore01() {
        return new String[]{"sis.push.theengagelab.com:19000", "sis.push.engageforce.net:19000", "sis.push.engage7.com:19000"};
    }

    private static String[] getSingapore02() {
        return new String[]{"sis-sgp2.push.theengagelab.com:19000", "sis-sgp2.push.engageforce.net:19000", "sis-sgp2.push.engage7.com:19000"};
    }

    private static String[] usaVirginia() {
        return new String[]{"sis-usva.push.theengagelab.com:19000", "sis-usva.push.engageforce.net:19000", "sis-usva.push.engage7.com:19000"};
    }
}
