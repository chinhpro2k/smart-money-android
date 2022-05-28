package com.b18cn082.smart_money.addapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.b18cn082.smart_money.R;
import com.b18cn082.smart_money.model.Plan;
import com.b18cn082.smart_money.model.Question;
import com.b18cn082.smart_money.model.Spend;

import java.util.List;

public class ShowSpendAdapter extends RecyclerView.Adapter<ShowSpendAdapter.ViewHolder> {
    private List<Spend> listSpend;

    public ShowSpendAdapter(List<Spend> listSpend) {
        this.listSpend = listSpend;
    }

    public void setListSpend(List<Spend> listSpend) {
        this.listSpend = listSpend;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener{
        void onClick(Plan plan);
    }

    private OnItemClickListener itemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spend_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Spend spend = listSpend.get(position);
        holder.tvTitle.setText(spend.getTitle());
        holder.tvPrice.setText(spend.getPrice());
        holder.tvDes.setText(spend.getType());
//        holder.btnSelect.setOnClickListener(view -> {
//            itemClickListener.onClick(spend);
//        });
    }

    @Override
    public int getItemCount() {
        if(listSpend.isEmpty())
            return 0;
        else{
            return listSpend.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle,tvPrice,tvDes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDes = itemView.findViewById(R.id.tvDes);
        }
    }
}
