package pro.sau.potriders.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.sau.potriders.R;

public class WeedWeightAdapter extends RecyclerView.Adapter<WeedWeightAdapter.ViewHolder>  {
    Context context;

    public WeedWeightAdapter(Context context) {

        this.context = context;
    }
    @Override
    public WeedWeightAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weedweight, parent, false);
        return new WeedWeightAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeedWeightAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 5 ;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);


        }
    }
}
