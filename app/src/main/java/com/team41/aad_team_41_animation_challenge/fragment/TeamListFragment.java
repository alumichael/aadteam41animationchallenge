package com.team41.aad_team_41_animation_challenge.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;
import com.team41.aad_team_41_animation_challenge.R;
import com.team41.aad_team_41_animation_challenge.adapter.teamAdapter;
import com.team41.aad_team_41_animation_challenge.model.teamModel;
import com.team41.aad_team_41_animation_challenge.util.UserPreferences;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Michael on 10/18/2019.
 */

public class TeamListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private String mParam1;
    private String mParam2;

    /** ButterKnife Code **/
    @BindView(R.id.team_list_layout)
    LinearLayout mTeamListLayout;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recycler_team_list)
    RecyclerView mRecyclerTeamList;
    /** ButterKnife Code **/

    private teamAdapter teamAdapter;
    LinearLayoutManager layoutManager;
    UserPreferences userPreferences;


    List<teamModel> teamModelList;





    public TeamListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_team_list, container, false);
        ButterKnife.bind(this,view);
        teamModelList = new ArrayList<>();
        //populating the card
        init();
        return  view;
    }

    private void init() {
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(true));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        getHistory();

    }

    @Override
    public void onRefresh() {
        getHistory();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void getHistory() {
        
        /*Adding members records to List
        * Please Note, we are  suppose to use a DB for this, but
        * for use to quickly  work on the objective of this
        * Project(Animation), Let Have it this way. thanks
         */
        teamModel m = new teamModel("Alu Michael Boluwaji","aluichael9@gmail.com","Male","+2348106746804",
                "Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571430511/samples/michael_boluwaji.jpg");
        teamModelList.add(m);

        m = new teamModel("Salama Jatau", "salamajatau@gmail.com","Female","+2348032434434","Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571428259/samples/IMG-20191018-WA0006.jpg");
        teamModelList.add(m);

        m = new teamModel("Yemisi Ajibulu", "yemisiajibulu2018@gmail.com","Female","+2349056168016","Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571428258/samples/IMG-20191018-WA0009.jpg");
        teamModelList.add(m);

        m = new teamModel("Ngozi Njeze", "ngozinjeze@gmail.com","Female","+2349090977900","Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571428266/samples/IMG-20191018-WA0010.jpg");
        teamModelList.add(m);

        m = new teamModel("Alao Kolapo Michael", "alaokolapo7@gmail.com","Male","+2348115847810","Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571428255/samples/IMG-20191018-WA0011.jpg");
        teamModelList.add(m);

        m = new teamModel("Yohanna Okojie", "okojieosereme@gmail.com","Male","+2348096959106","Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571428253/samples/IMG-20191018-WA0012.jpg");
        teamModelList.add(m);

        m = new teamModel("Suhailu Sani", "sahalsen11@gmail.com","Male","+2348065392359","Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571428258/samples/IMG-20191018-WA0017.jpg");
        teamModelList.add(m);

        m = new teamModel("Chukwunonye Dan", "Immanueell698@gmail.com","Male","+2348020669181","Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571428278/samples/IMG-20191018-WA0019.jpg");
        teamModelList.add(m);

        m = new teamModel("Pius Aboyi", "Apeapius@gmail.com","Male","+2348060386628","Active","https://res.cloudinary.com/adekunle-ajasin-university-akungba-akoko/image/upload/v1571430502/samples/IMG-20191018-WA0021.jpg");
        teamModelList.add(m);

        int count = teamModelList.size();

        Log.i("Re-SuccessSize", String.valueOf(teamModelList.size()));

//stop refresh when done insertion
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {

                mSwipeRefreshLayout.setRefreshing(false);

            }
        });



        if (count == 0) {

            mSwipeRefreshLayout.setVisibility(View.GONE);
            showMessage("Empty Member");

        } else {

            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
            layoutManager = new LinearLayoutManager(getContext());
            mRecyclerTeamList.setLayoutManager(layoutManager);
            teamAdapter = new teamAdapter(getContext(), teamModelList);
            mRecyclerTeamList.setAdapter(teamAdapter);
            teamAdapter.notifyDataSetChanged();

        }

    }

    private void showMessage(String s) {
        Snackbar.make(mTeamListLayout, s, Snackbar.LENGTH_SHORT).show();
    }


}
