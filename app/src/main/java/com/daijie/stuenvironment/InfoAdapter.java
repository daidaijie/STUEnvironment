package com.daijie.stuenvironment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liyujie on 2017/4/13.
 */

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    private final List<EnvironmentInfo> mEnvironmentInfos;

    private final Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public InfoAdapter(Context context, List<EnvironmentInfo> environmentInfos) {
        mEnvironmentInfos = environmentInfos;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final EnvironmentInfo environmentInfo = mEnvironmentInfos.get(position);
        holder.mInfoImageView.setImageDrawable(mContext.getResources().getDrawable(
                environmentInfo.getIcon()
        ));
        holder.mInfoTextView.setText(environmentInfo.getName());
        holder.mUnitTextView.setText(environmentInfo.getUnit());
        holder.mItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(environmentInfo, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEnvironmentInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout mItemLayout;
        TextView mInfoTextView;
        TextView mUnitTextView;
        TextView mNumberTextView;
        ImageView mInfoImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemLayout = (RelativeLayout) itemView.findViewById(R.id.itemLayout);
            mInfoImageView = (ImageView) itemView.findViewById(R.id.infoImageView);
            mUnitTextView = (TextView) itemView.findViewById(R.id.unitTextView);
            mInfoTextView = (TextView) itemView.findViewById(R.id.infoTextView);
            mNumberTextView = (TextView) itemView.findViewById(R.id.numberTextView);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(EnvironmentInfo environmentInfo, int position);
    }
}
