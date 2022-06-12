package com.example.recommentflowchartui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recommentflowchartui.R;
import com.example.recommentflowchartui.friendData;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CustomViewHolder> {


    private ArrayList<CommentData> arrayList;


    public CommentAdapter(ArrayList<CommentData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CommentAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_commentlist,parent,false);
        CommentAdapter.CustomViewHolder holder=new CommentAdapter.CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CustomViewHolder holder, int position) {
        holder.commentprofile.setImageResource(arrayList.get(position).getCommentProfile());
        holder.commentnick.setText(arrayList.get(position).getCommentNick());
        holder.comment.setText(arrayList.get(position).getComment());
        holder.itemView.setTag(position);


    }

    @Override
    public int getItemCount() {
        return (null !=arrayList ? arrayList.size():0);
    }



    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView commentprofile;
        protected TextView commentnick;
        protected TextView comment;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.commentprofile=(ImageView) itemView.findViewById(R.id.commentprofile);
            this.commentnick=(TextView) itemView.findViewById(R.id.commentncik);
            this.comment=(TextView) itemView.findViewById(R.id.comment);
        }
    }
}
