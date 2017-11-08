package melon.project.com.melon_proj.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import melon.project.com.melon_proj.R;
/**
 * Created by quf93 on 2017-11-08.
 */

public class RecentMusicAdapter extends RecyclerView.Adapter<RecentMusicAdapter.RecentMusicHolder>{

    public RecentMusicAdapter() {
    }

    @Override
    public RecentMusicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_music_item, parent, false);
        return new RecentMusicHolder(view);
    }

    @Override
    public void onBindViewHolder(RecentMusicHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class RecentMusicHolder extends RecyclerView.ViewHolder {
        ImageView albumImageView;
        ImageButton playButton;
        TextView itemTitle, itemArtist;

        public RecentMusicHolder(View itemView) {
            super(itemView);
            // TODO Glide ( ? ) or 다른 라이브러리 써서 이미지 Load
            albumImageView = itemView.findViewById(R.id.albumImageView);

            playButton = itemView.findViewById(R.id.playButton);
            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO 해당 곡 play 되는 logic
                }
            });

            itemTitle = itemView.findViewById(R.id.item_title);
            itemArtist = itemView.findViewById(R.id.item_artist);
        }
    }
}
