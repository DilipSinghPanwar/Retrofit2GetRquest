package androiddevs.com.retrofitsample.simplegetrequest.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import androiddevs.com.retrofitsample.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView description;

    public MyViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.post_title);
        description = (TextView) itemView.findViewById(R.id.post_description);
    }
}
