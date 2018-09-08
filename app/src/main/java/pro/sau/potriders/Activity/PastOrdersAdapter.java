package pro.sau.potriders.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import pro.sau.potriders.R;

import static java.security.AccessController.getContext;


public class PastOrdersAdapter extends RecyclerView.Adapter<PastOrdersAdapter.ViewHolder> {
    private Context context;

    Activity mActivity;
    public PastOrdersAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PastOrdersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lisview, parent, false);
        PastOrdersAdapter.ViewHolder viewHolder = new PastOrdersAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PastOrdersAdapter.ViewHolder holder, final int position) {
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ScrollingActivityAddToCart.class);
                context.startActivity(intent);
                ((Activity)context).finish();
//                ((AppCompatActivity) context).overridePendingTransition(R.anim.card_exit, R.anim.card_enter);
            }
        });
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.cartClick);
        }
    }
}
