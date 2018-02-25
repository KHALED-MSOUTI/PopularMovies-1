package pl.nataliana.popularmovies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pl.nataliana.popularmovies.model.Movie;

/**
 * Created by Natalia Nazaruk on 17.02.2018.
 */

public class DetailActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ivPoster = findViewById(R.id.poster_image_iv);
        TextView tvOriginalTitle = findViewById(R.id.original_title_tv);
        TextView tvOverView = findViewById(R.id.synopsis_text_tv);
        TextView tvVoteAverage = findViewById(R.id.rating_value_tv);
        TextView tvReleaseDate = findViewById(R.id.date_value_tv);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra(getString(R.string.movie_parcelable));

        Picasso.with(this)
                .load(movie.getPosterUrl())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(ivPoster);

        tvOriginalTitle.setText(movie.getTitle());
        tvOverView.setText(movie.getSynopsis());
        tvVoteAverage.setText(movie.getRating());
        tvReleaseDate.setText(movie.getDate());
    }
}

