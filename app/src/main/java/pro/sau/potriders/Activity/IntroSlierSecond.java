package pro.sau.potriders.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import pro.sau.potriders.R;

public class IntroSlierSecond extends Fragment {
    ImageView goto_login;
    LinearLayout imageView;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_intro_slier_second, container, false);
        imageView = (LinearLayout) view.findViewById(R.id.linearLayout);
        return view;
    }


}

