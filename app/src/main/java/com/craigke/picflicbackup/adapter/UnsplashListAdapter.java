package com.craigke.picflicbackup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.craigke.picflicbackup.R;
import com.craigke.picflicbackup.SplashActivity;
import com.craigke.picflicbackup.models.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnsplashListAdapter extends RecyclerView.Adapter<UnsplashListAdapter.RestaurantViewHolder> {
    private List<Result> mRestaurants;
    private Context mContext;

    public UnsplashListAdapter(SplashActivity context, List<Result> restaurants) {
        mContext = context;
        mRestaurants = restaurants;
    }

    @Override
    public UnsplashListAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_restaurant_list_adapter, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UnsplashListAdapter.RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(mRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.restaurantImageView) ImageView mRestaurantImageView;
        @BindView(R.id.restaurantNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private android.content.Context mContext;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRestaurant(Result restaurant) {
            Picasso.get().load(restaurant.getUrls().getSmall()).into(mRestaurantImageView);
            mNameTextView.setText(restaurant.getUser().getName());
            mCategoryTextView.setText(restaurant.getDescription());
            mRatingTextView.setText("Rating: " + restaurant.getLikes() + "/5");
        }
    }
}