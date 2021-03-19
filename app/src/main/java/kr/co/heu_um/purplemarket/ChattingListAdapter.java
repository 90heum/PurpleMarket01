package kr.co.heu_um.purplemarket;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChattingListAdapter extends RecyclerView.Adapter<ChattingListAdapter.VH> {

    Context context;
    ArrayList<String> others;
    ArrayList<String> otherIds;

    public ChattingListAdapter(Context context, ArrayList<String> others, ArrayList<String> otherIds) {
        this.context = context;
        this.others = others;
        this.otherIds = otherIds;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(context).inflate(R.layout.recycler_item_chatting_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvChatOther.setText(others.get(position));
    }

    @Override
    public int getItemCount() {
        return others.size();
    }

    class VH extends RecyclerView.ViewHolder {

        TextView tvChatOther;

        public VH(@NonNull View itemView) {
            super(itemView);
            tvChatOther = itemView.findViewById(R.id.tv_chatting_list_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    String otherName = otherIds.get(pos);
                    Intent intent = new Intent(context, ChattingActivity.class);
                    intent.putExtra("otherName", otherName);
                    context.startActivity(intent);
                }
            });
        }
    }
}
