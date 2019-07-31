package com.example.piyush.studentfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Main Activity";

    ArrayList<Students.Student> studentList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = Students.getStudents();
        recyclerView = (RecyclerView) findViewById(R.id.student_list);

        StuViewAdapter stuViewAdapter = new StuViewAdapter(studentList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(stuViewAdapter);

        stuViewAdapter.notifyDataSetChanged();

        Log.d(TAG, "onCreate: recycler done");

        // FRAGMENT'S WORK
        StudentFragment studentFragment = new StudentFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, studentFragment.newInstance(studentList.get(0)));
        fragmentTransaction.commit();
    }

    public class StuViewHolder extends RecyclerView.ViewHolder {

        ImageView stuPhoto;

        public StuViewHolder(View itemView) {
            super(itemView);

            stuPhoto = (ImageView) itemView.findViewById(R.id.photo_button);
        }
    }


    public class StuViewAdapter extends RecyclerView.Adapter<StuViewHolder> {

        ArrayList<Students.Student> stuList = new ArrayList<>();

        public StuViewAdapter(ArrayList<Students.Student> studentArrayList) {
            this.stuList = studentArrayList;
        }

        @Override
        public StuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d(TAG, "onCreateViewHolder: called");

            LayoutInflater layoutInflater = getLayoutInflater();
            View itemView = layoutInflater.inflate(R.layout.rv_item, null);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: called");
                    int position = recyclerView.getChildLayoutPosition(v);
                    FragmentManager fragmentManager = getSupportFragmentManager();

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, StudentFragment.newInstance(studentList.get(position)));
                    fragmentTransaction.commit();
                }
            });

            return new StuViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(StuViewHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder: called");

            holder.stuPhoto.setImageResource(stuList.get(position).photoID);

        }

        @Override
        public int getItemCount() {
            return stuList.size();
        }


    }

}





