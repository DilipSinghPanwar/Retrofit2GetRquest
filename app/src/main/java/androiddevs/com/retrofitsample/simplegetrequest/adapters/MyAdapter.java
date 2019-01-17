package androiddevs.com.retrofitsample.simplegetrequest.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androiddevs.com.retrofitsample.R;
import androiddevs.com.retrofitsample.simplegetrequest.responsebeans.ApiReponseObject;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private Context context;
    private List<ApiReponseObject> apiReponseObjectList;

    public MyAdapter(Context context, List<ApiReponseObject> apiReponseObjects){
        this.context = context;
        this.apiReponseObjectList = apiReponseObjects;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ApiReponseObject apiReponseObject = apiReponseObjectList.get(position);
        holder.title.setText(apiReponseObject.getTitle());
        holder.description.setText(apiReponseObject.getDescription());
    }

    @Override
    public int getItemCount() {
        return apiReponseObjectList.size();
    }
}
