package com.example.favoritelistvideo.ui.favorites;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.favoritelistvideo.R;
import com.example.favoritelistvideo.VideoAdapter;
import com.example.favoritelistvideo.databinding.FragmentFavoritesBinding;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {
    private ArrayList<String> videoItems;
    VideoView videoView;
    ListView listView;
    ArrayAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_favorites,container,false);
        videoView= (VideoView) root.findViewById(R.id.videoview);
        listView= (ListView) root.findViewById(R.id.lvideo);
        videoItems = new ArrayList<>();
        videoItems.add("video");

        adapter= new ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,videoItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video));
                        break;
                    default:
                        break;
                }
                videoView.setMediaController(new MediaController(getActivity()));
                videoView.requestFocus();
                videoView.start();
            }
        });
        return root;
    }

}