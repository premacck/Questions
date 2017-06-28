package com.prembros.questions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<PageBeans> items;

    RecyclerViewAdapter(List<PageBeans> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.logo.setImageResource(items.get(position).getLogoSrc());
        holder.nameTextView.setText(items.get(position).getName());
        holder.currentValueTextView.setText(items.get(position).getCurrentValue());
        holder.withdrawalAmount.setText(items.get(position).getWithdrawalAmount());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView logo;
        TextView nameTextView;
        Switch aSwitch;
        TextView currentValueTextView;
        EditText withdrawalAmount;

        ViewHolder(View view) {
            super(view);
            logo = view.findViewById(R.id.logo);
            nameTextView = view.findViewById(R.id.name);
            aSwitch = view.findViewById(R.id.switch1);
            currentValueTextView = view.findViewById(R.id.current_value_value);
            withdrawalAmount = view.findViewById(R.id.withdrawal_amount_value);
        }
    }
}
