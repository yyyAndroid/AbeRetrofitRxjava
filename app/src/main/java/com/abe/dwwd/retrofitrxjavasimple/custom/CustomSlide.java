package com.abe.dwwd.retrofitrxjavasimple.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abe.dwwd.retrofitrxjavasimple.R;

import agency.tango.materialintroscreen.SlideFragment;

public class CustomSlide extends SlideFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_custom_slide, container, false);
        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.colorOrange;
    }

    @Override
    public int buttonsColor() {
        return R.color.colorOrangeTwo;
    }

    @Override
    public boolean canMoveFurther() {
        return true;
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return "";
    }
}