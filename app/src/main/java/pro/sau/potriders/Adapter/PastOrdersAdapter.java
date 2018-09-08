package pro.sau.potriders.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import pro.sau.potriders.R;

public class PastOrdersAdapter extends RecyclerView.Adapter<PastOrdersAdapter.ViewHolder> {
    private Context context;


    public PastOrdersAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PastOrdersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.past_orders, parent, false);
        PastOrdersAdapter.ViewHolder viewHolder = new PastOrdersAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PastOrdersAdapter.ViewHolder holder, final int position) {
        Animation animation1 = AnimationUtils.loadAnimation(context,
                R.anim.bottom_up);
        holder.linearLayout.startAnimation(animation1);
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.card_viewPastOders);
        }
    }
}
