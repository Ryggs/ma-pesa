package com.maku.easydata;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maku.easydata.interfaces.IMainActivity;

public class ShareFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "ShareFragment";

    //widgets
    private TextView mFragmentHeading;
    private RelativeLayout mBackArrow;

    //vars
    private IMainActivity mInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_share, container, false);

        Log.d(TAG, "onCreateView: started.");
        mBackArrow = view.findViewById(R.id.back_arrow);
        mFragmentHeading = view.findViewById(R.id.fragment_heading);

        initToolbar();

        return view;
    }

    private void initToolbar(){
        Log.d(TAG, "initToolbar: initializing toolbar.");
        mBackArrow.setOnClickListener(this);
        mFragmentHeading.setText(getString(R.string.tag_fragment_agreement));

    }


    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: clicked.");

        if(view.getId() == R.id.back_arrow){
            Log.d(TAG, "onClick: navigating back.");
            mInterface.onBackPressed();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mInterface = (IMainActivity) getActivity();
    }

}
