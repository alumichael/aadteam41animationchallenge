package com.team41.aad_team_41_animation_challenge.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.card.MaterialCardView;
import com.team41.aad_team_41_animation_challenge.R;
import com.team41.aad_team_41_animation_challenge.activity.MemberDetail;
import com.team41.aad_team_41_animation_challenge.model.teamModel;
import com.team41.aad_team_41_animation_challenge.util.Constant;
import com.team41.aad_team_41_animation_challenge.util.ItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;



/**
 * Created by Michael on 10/18/2019.
 */


public class teamAdapter extends RecyclerView.Adapter<teamAdapter.MyViewHolder> {

    private Context context;
    private List<teamModel> teamModelList;


    public teamAdapter(Context context, List<teamModel> teamModelList) {
        this.context = context;
        this.teamModelList = teamModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list, parent, false);
        ButterKnife.bind(this, view);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        teamModel teamModelOption = teamModelList.get(i);

        Log.i("teamModel", teamModelOption.getEmail());

            holder.mName.setText(teamModelOption.getName());
            holder.mEmail.setText(teamModelOption.getEmail());
            holder.mStatus.setText(teamModelOption.getStatus());
            String img_url=teamModelOption.getImg();

            if(img_url==null) {
                holder.mThumnail.setImageResource(R.drawable.man);
            }else{
                holder.userPhoto(img_url);
            }

            holder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onItemClick(int pos) {
                    teamAdapter.this.nextActivity(teamModelList.get(pos).getName(), teamModelList.get(pos).getEmail(), teamModelList.get(pos).getGender(),
                            teamModelList.get(pos).getPhone_num(), teamModelList.get(pos).getStatus(), teamModelList.get(pos).getImg(),
                            MemberDetail.class);

                }
            });


    }

    private void nextActivity(String name,String email,String gender,
                    String phone_no,String status,String img,
    Class teamModelActivityClass) {
        Intent i = new Intent(context, teamModelActivityClass);
        i.putExtra(Constant.EMAIL, email);
        i.putExtra(Constant.NAME, name);
        i.putExtra(Constant.GENDER, gender);
        i.putExtra(Constant.PHONE_NUM, phone_no);
        i.putExtra(Constant.STATUS, status);
        i.putExtra(Constant.IMG, img);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return teamModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        /** ButterKnife Code **/
        @BindView(R.id.list_card)
        MaterialCardView mListCard;
        @BindView(R.id.icon_photo)
        CircleImageView mThumnail;
        @BindView(R.id.name)
        TextView mName;
        @BindView(R.id.email_addr)
        TextView mEmail;
        @BindView(R.id.status)
        TextView mStatus;

        /** ButterKnife Code **/

        ItemClickListener itemClickListener;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

           itemView.setOnClickListener(this);

        }

        public void userPhoto(String url) {
            CircleImageView circleImageView = this.mThumnail;
            if (circleImageView != null) {
                Glide.with(circleImageView.getContext()).load(url)
                        .error(R.drawable.man).apply(new RequestOptions().fitCenter().circleCrop()).into(this.mThumnail);
            }
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

    }
}

