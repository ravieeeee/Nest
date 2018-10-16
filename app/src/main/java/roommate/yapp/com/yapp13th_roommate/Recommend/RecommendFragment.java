package roommate.yapp.com.yapp13th_roommate.Recommend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import roommate.yapp.com.yapp13th_roommate.DataModel.UserInfo;
import roommate.yapp.com.yapp13th_roommate.Global.GlobalVariable;
import roommate.yapp.com.yapp13th_roommate.R;
import roommate.yapp.com.yapp13th_roommate.main.BottomRecyclerViewAdapter;
import roommate.yapp.com.yapp13th_roommate.main.TopRecyclerViewAdapter;

public class RecommendFragment extends Fragment implements BottomRecyclerViewAdapter.ItemClickListener {

    private RecyclerView top_recyclerView;
    private RecyclerView bottom_recyclerView;
    private BottomRecyclerViewAdapter bottom_adapter;
    private TopRecyclerViewAdapter top_adapter;
    private Context context;

    private GlobalVariable global;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        global = (GlobalVariable)getActivity().getApplication();

        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        top_recyclerView = rootView.findViewById(R.id.topRecyclerView);
        bottom_recyclerView = rootView.findViewById(R.id.recyclerView);

        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};

        int numberOfColumns = 1;
        bottom_recyclerView.setLayoutManager(new GridLayoutManager(context, numberOfColumns));

        bottom_adapter = new BottomRecyclerViewAdapter(context, global.filterInfo);
        bottom_recyclerView.setAdapter(bottom_adapter);
        bottom_recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager
                (context, LinearLayoutManager.HORIZONTAL, false);
        top_recyclerView.setLayoutManager(layoutManager);
        // TODO: custom divider 만들어야함
        top_recyclerView.addItemDecoration(new DividerItemDecoration(context, layoutManager.getOrientation()));

        top_adapter = new TopRecyclerViewAdapter(context, data);
        top_recyclerView.setAdapter(top_adapter);
        top_adapter.setClickListener(this);

        return rootView;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "click", Toast.LENGTH_SHORT).show();
    }
}
