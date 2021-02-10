package kr.co.heu_um.purplemarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home_Recycler03_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Home_Recycler03_item> items;

    public Home_Recycler03_Adapter(Context context, ArrayList<Home_Recycler03_item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.home_recycler03_item,parent,false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VH vh=(VH)holder;

         Home_Recycler03_item item=items.get(position);
         vh.ivImg.setImageResource(Integer.parseInt(String.valueOf(item.imgUrl)));



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView ivImg;

        public VH(@NonNull View itemView) {
            super(itemView);

            ivImg=itemView.findViewById(R.id.iv);


        }
    }
}
