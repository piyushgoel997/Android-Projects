package com.codingblocks.lecturesixfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    public static final String TAG = "Third Fragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);

        Log.d(TAG, "newInstance: called");

        return fragment;
    }

    private OnCreateViewCalledListner ocvcl;

    public void setOnCreateViewListnerCalled(OnCreateViewCalledListner ocvcl){
        this.ocvcl = ocvcl;
        Log.d(TAG, "setOnCreateViewListnerCalled: called");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        // make fags corr to each student here
        Log.d(TAG, "onCreate: called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ocvcl.onCreateViewCalled();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        ((DynamicFragmentActivity)getActivity()).showToast();

        Log.d(TAG, "onCreateView: called");

        return view;
    }

    public void myfn(){
        Log.d(TAG, "myfn: called");
    }

    public interface OnCreateViewCalledListner {
        void onCreateViewCalled();
    }


}
