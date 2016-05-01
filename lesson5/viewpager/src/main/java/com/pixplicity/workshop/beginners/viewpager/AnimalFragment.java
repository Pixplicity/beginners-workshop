package com.pixplicity.workshop.beginners.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AnimalFragment extends Fragment {

    private static final String ARG_IMAGE_RESOURCE = "image_resource";
    private static final String ARG_SOUND_RESOURCE = "sound_resource";

    private int imageResource;
    private int soundResource;

    public interface Contract {
        void playSound (int soundResource);
    }

    public static AnimalFragment newInstance(Animal animal) {
        AnimalFragment fragment = new AnimalFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RESOURCE, animal.imageResource);
        args.putInt(ARG_SOUND_RESOURCE, animal.soundResource);
        fragment.setArguments(args);

        return fragment;
    }

    /**
     * All subclasses of Fragment must include a public empty constructor. The framework will often
     * re-instantiate a fragment class when needed, in particular during state restore, and needs to
     * be able to find this constructor to instantiate it. If the empty constructor is not available,
     * a runtime exception will occur in some cases during state restore.
     */
    public AnimalFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageResource = getArguments().getInt(ARG_IMAGE_RESOURCE);
        soundResource = getArguments().getInt(ARG_SOUND_RESOURCE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView imageView = (ImageView) inflater.inflate(R.layout.fragment_image, container, false);
        imageView.setImageResource(imageResource);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Contract) getActivity()).playSound(soundResource);
            }
        });
        return imageView;
    }

}