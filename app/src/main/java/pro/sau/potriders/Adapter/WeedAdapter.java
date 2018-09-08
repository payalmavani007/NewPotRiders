package pro.sau.potriders.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import pro.sau.potriders.Activity.WeedTypeActivity;
import pro.sau.potriders.R;

public class WeedAdapter extends RecyclerView.Adapter<WeedAdapter.ViewHolder> {
    Context context;


    public WeedAdapter(Context context) {

        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weedbrand, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Animation animation1 = AnimationUtils.loadAnimation(context,
                R.anim.bottom_up);
        holder.card_view.startAnimation(animation1);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WeedTypeActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.weed);
            card_view = (CardView) itemView.findViewById(R.id.card_viewFood);

        }
    }
}
