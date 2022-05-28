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

import java.util.List;

public class SuggestAdapter extends RecyclerView.Adapter<SuggestAdapter.ViewHolder> {
    private List<Plan> listPlan;

    public SuggestAdapter(List<Plan> listPlan) {
        this.listPlan = listPlan;
    }

    public void setListPlan(List<Plan> listPlan) {
        this.listPlan = listPlan;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggest_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plan plan = listPlan.get(position);
        holder.tvTitle.setText(plan.getTitle());
        holder.tvCorrectAnswer.setText(plan.getDescription());
        holder.btnSelect.setOnClickListener(view -> {
            itemClickListener.onClick(plan);
        });
    }

    @Override
    public int getItemCount() {
        if(listPlan.isEmpty())
            return 0;
        else{
            return listPlan.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle,tvCorrectAnswer;
        private Button btnSelect;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCorrectAnswer = itemView.findViewById(R.id.tvCorrectAnswer);
            btnSelect = itemView.findViewById(R.id.btnSelect);
        }
    }
}
