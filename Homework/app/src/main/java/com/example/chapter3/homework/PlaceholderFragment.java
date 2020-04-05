package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



////////


import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private ArrayAdapter<Item> adapterItems;
    private ListView IvItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create arraylist from item fixtures
        ArrayList<Item> items = Item.getItems();
        adapterItems = new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_list_item_activated_1, items);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        //animationView = animationView.findViewById(animation_view);
        View view=inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView=(LottieAnimationView)view.findViewById(R.id.animation_view) ;
        IvItems=(ListView)view.findViewById(R.id.IvItems);
        IvItems.setAdapter(adapterItems);
        IvItems.setAlpha(0);
        IvItems.setVisibility(View.VISIBLE);
        return view;


        //return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

//    public void finish() {
//        super.finish();
//        if (exitAnim != 0) {
//            overridePendingTransition(0, exitAnim);
//        }
//    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //animationView=(LottieAnimationView) animationView.findViewById(R.id.animation_view);
//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.fade_out);
//        animator.setTarget(findViewById(R.id.animation_view));
        animationView.animate()
                .alpha(0f)
                .setDuration(5000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override

                    public void onAnimationEnd(Animator animation){
                        animationView.setVisibility(View.GONE);
                    }
                });


        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
//                LottieAnimationView animationView;
//                animationView=findViewById(R.id.animation_view);
               // animationView.cancelAnimation();
                //getView().findViewById(R.id.animation_view).clearAnimation();

//                animator.end();
                IvItems.animate().alpha(1f).setDuration(5000).setListener(null);



            }
        }, 5000);
    }
}
