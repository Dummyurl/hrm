package com.ourdesignz.hrm.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.activity.HomeActivity;
import com.ourdesignz.hrm.adapter.HomeAdapter;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.interfaces.RestClient;
import com.ourdesignz.hrm.model.HomePOJO;
import com.ourdesignz.hrm.utilities.Utilitity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ourdesignz on 26/9/16.
 */
public class HomeFragment extends Fragment implements Callback<HomePOJO>, Constant {

    private static String TAG = HomeFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private ProgressBar progressBar;
    private LinearLayoutManager mLayoutManager;
    private TextView label;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        label = (TextView) rootView.findViewById(R.id.label);
        Utilitity.setTypeFace2(getActivity(), label);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.public_message_list);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        if (Utilitity.isNetworkAvailable(getActivity())) {

            getHomeIndex();

        } else {
            Utilitity.showSnackBarError(getActivity(),
                    HomeActivity.getInstance().getCoordinateLayout(),
                    getResources().getString(R.string.no_internet_connection));

        }


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }

    /* Make Rest Client Call For Getting Home Index Data */
    private void getHomeIndex() {

        Utilitity.showProgressDialog(progressBar);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH + Constant.INDEX)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<HomePOJO> call = restClientAPI.loadHomeRequest(HomeActivity.getInstance().getUser().getId());

        //asynchronous call
        call.enqueue(this);
    }

    /* Get Response From HomeIndex */
    @Override
    public void onResponse(Call<HomePOJO> call, Response<HomePOJO> response) {
        HomePOJO homepojo = response.body();

        int code = response.code();
        if (code == RESPONSE_CODE) {
            Utilitity.dismissProgressDialog(progressBar);

            if (homepojo.getStatus().equals(SUCCESS)) {

                adapter = new HomeAdapter(getActivity(), homepojo.getResult());
                recyclerView.setAdapter(adapter);


            } else {
                adapter = new HomeAdapter(getActivity(), homepojo.getResult());
                recyclerView.setAdapter(adapter);
            }


            if (homepojo.getMessage() != null && !homepojo.getMessage().equals("")) {
                if (!HomeActivity.getInstance().getIsLoadFirstTime()) {
                    Utilitity.showSnackBar(getActivity(),
                            HomeActivity.getInstance().getCoordinateLayout(),
                            homepojo.getMessage());
                }
            }

            HomeActivity.getInstance().setIsLoadFirstTime(true);

        } else {

            Utilitity.dismissProgressDialog(progressBar);
            Log.e("ResponseD", "ResponseD?? " + homepojo.getStatus());
            HomeActivity.getInstance().setIsLoadFirstTime(false);

        }
    }

    @Override
    public void onFailure(Call<HomePOJO> call, Throwable t) {
        Utilitity.dismissProgressDialog(progressBar);
        HomeActivity.getInstance().setIsLoadFirstTime(false);
        Log.e("onFailure", "onFailure?? " + t.getMessage());
    }
}


