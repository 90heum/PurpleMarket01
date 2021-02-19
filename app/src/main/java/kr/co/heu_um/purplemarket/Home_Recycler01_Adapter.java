package kr.co.heu_um.purplemarket;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Home_Recycler01_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Home_Recycler01_item> items;

    public Home_Recycler01_Adapter(Context context, ArrayList<Home_Recycler01_item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.home_recycler01_item,parent,false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VH vh=(VH)holder;
         Home_Recycler01_item item=items.get(position);

        //이미지 설정[DB]에는 이미지경로가 "./uploads/IMG_20210240_moana01.jpg"임
        //안드로이드에서는 서버(dothome)의 전체 주소가 필요하기에
        String imgUrl="http://majeongheum.dothome.co.kr/PurpleMarket/"+item.file;
        Glide.with(context).load(imgUrl).into(((VH) holder).ivImg);

        //텍스트지정
         vh.tvTitle.setText(item.name);
         vh.tvPrice.setText(item.price+"원");


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView ivImg;
        TextView tvTitle;
        TextView tvPrice;

        public VH(@NonNull View itemView) {
            super(itemView);

            ivImg=itemView.findViewById(R.id.iv);
            tvTitle=itemView.findViewById(R.id.tv01);
            tvPrice=itemView.findViewById(R.id.tv02);

        }
    }
}
