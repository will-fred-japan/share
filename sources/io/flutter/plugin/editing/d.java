package io.flutter.plugin.editing;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import p088l7.v;
import p096m7.k;

/* JADX INFO: compiled from: SpellCheckPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements SpellCheckerSession.SpellCheckerSessionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f19532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextServicesManager f19533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpellCheckerSession f19534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f19535d;

    public d(TextServicesManager textServicesManager, v vVar) {
        this.f19533b = textServicesManager;
        this.f19532a = vVar;
        vVar.f20212a = this;
    }

    public final void a(String str, String str2, k kVar) {
        if (this.f19535d != null) {
            kVar.error("error", "Previous spell check request still pending.", null);
            return;
        }
        this.f19535d = kVar;
        Locale localeA = p105n7.a.a(str);
        if (this.f19534c == null) {
            this.f19534c = this.f19533b.newSpellCheckerSession(null, localeA, this, true);
        }
        this.f19534c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public final void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        if (sentenceSuggestionsInfoArr.length == 0) {
            this.f19535d.success(new ArrayList());
            this.f19535d = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
        if (sentenceSuggestionsInfo == null) {
            this.f19535d.success(new ArrayList());
            this.f19535d = null;
            return;
        }
        for (int i9 = 0; i9 < sentenceSuggestionsInfo.getSuggestionsCount(); i9++) {
            SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i9);
            int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
            if (suggestionsCount > 0) {
                HashMap map = new HashMap();
                int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i9);
                int lengthAt = sentenceSuggestionsInfo.getLengthAt(i9) + offsetAt;
                map.put("startIndex", Integer.valueOf(offsetAt));
                map.put("endIndex", Integer.valueOf(lengthAt));
                ArrayList arrayList2 = new ArrayList();
                boolean z8 = false;
                for (int i10 = 0; i10 < suggestionsCount; i10++) {
                    String suggestionAt = suggestionsInfoAt.getSuggestionAt(i10);
                    if (!suggestionAt.isEmpty()) {
                        arrayList2.add(suggestionAt);
                        z8 = true;
                    }
                }
                if (z8) {
                    map.put("suggestions", arrayList2);
                    arrayList.add(map);
                }
            }
        }
        this.f19535d.success(arrayList);
        this.f19535d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public final void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
