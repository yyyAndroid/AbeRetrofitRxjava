package com.abe.dwwd.retrofitrxjavasimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.view.View;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class IntroActivity extends MaterialIntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enableLastSlideAlphaExitTransition(false);
        hideBackButton();

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.colorRed)
                        .buttonsColor(R.color.colorRedTwo)
//                        .image(R.drawable.img_office)
                        .title("欢迎来到一家人")
                        .description("油腻更精彩...")
                        .build());
                /*,
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("We provide solutions to make you love your work");
                    }
                }, "Work with love"));
*/
        addSlide(new CustomSlide());
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorOrange)
                .buttonsColor(R.color.colorYellowTwo)
                .title("Want more?")
                .description("Go on")
                .build());
    }

    @Override
    public void onFinish() {
        startActivity(new Intent(this,MainActivity.class));
    }
}
