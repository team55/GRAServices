package ru.team55.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import ru.team55.gra.rating.R;

public class CustomFontTextView extends TextView {

    private static Map<String, Typeface> mTypefaces;

    public CustomFontTextView(final Context context) {
        this(context, null);
    }

    public CustomFontTextView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomFontTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        if (mTypefaces == null) {
            mTypefaces = new HashMap<String, Typeface>();
        }

        final TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        if (arr != null) {
            final String typefaceAssetPath = arr.getString(R.styleable.CustomFontTextView_UseTypeface);

            if (typefaceAssetPath != null) {
                Typeface typeface = null;

                if (mTypefaces.containsKey(typefaceAssetPath)) {
                    typeface = mTypefaces.get(typefaceAssetPath);
                } else {
                    AssetManager assets = context.getAssets();
                    typeface = Typeface.createFromAsset(assets, typefaceAssetPath);
                    mTypefaces.put(typefaceAssetPath, typeface);
                }

                setTypeface(typeface);
            }
            arr.recycle();
        }
    }

}