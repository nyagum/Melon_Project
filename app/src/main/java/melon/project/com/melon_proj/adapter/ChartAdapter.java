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

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ChartHolder>{

    public ChartAdapter() {

    }

    @Override
    public ChartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false);
        return new ChartHolder(view);
    }

    @Override
    public void onBindViewHolder(ChartHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ChartHolder extends RecyclerView.ViewHolder {

        ImageView chartAlbumImage;
        TextView tvRank, chartTitle, chartArtist;
        ImageButton chartPlayButton;

        public ChartHolder(View itemView) {
            super(itemView);

            chartAlbumImage = itemView.findViewById(R.id.chart_album_image);
            tvRank = itemView.findViewById(R.id.tv_rank);
            chartTitle = itemView.findViewById(R.id.chart_title);
            chartArtist = itemView.findViewById(R.id.chart_artist);
            chartPlayButton = itemView.findViewById(R.id.chart_play_button);
        }
    }
}
