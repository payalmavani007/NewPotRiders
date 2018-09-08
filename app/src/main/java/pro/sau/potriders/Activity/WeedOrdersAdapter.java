package pro.sau.potriders.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.sau.potriders.R;


public class WeedOrdersAdapter extends RecyclerView.Adapter<WeedOrdersAdapter.ViewHolder> {
    private Context context;
    WeedTypeActivity activity;

    public WeedOrdersAdapter(Context context) {
        this.context = context;
    }

    @Override
    public WeedOrdersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weeb_type_lisview, parent, false);
        WeedOrdersAdapter.ViewHolder viewHolder = new WeedOrdersAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final WeedOrdersAdapter.ViewHolder holder, final int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ScrollingActivityAddToCartWeed.class);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_viewFood);
        }
    }
}
