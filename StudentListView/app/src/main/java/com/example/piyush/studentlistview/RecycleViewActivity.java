package com.example.piyush.studentlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {

    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        ArrayList<Students.Student> studentList = Students.getStudents();

        StudentViewAdapter studentViewAdapter = new StudentViewAdapter(studentList);
        recyclerView.setAdapter(studentViewAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        studentViewAdapter.notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView studentName;
        TextView studentAge;
        ImageView studentPhoto;

        public ViewHolder(View itemView) {
            super(itemView);

            studentName = (TextView) itemView.findViewById(R.id.tvName);
            studentAge = (TextView) itemView.findViewById(R.id.tvAge);
            studentPhoto = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

    public class StudentViewAdapter extends RecyclerView.Adapter<ViewHolder> {

        private ArrayList<Students.Student> studentList;

        public StudentViewAdapter(ArrayList<Students.Student> studentList) {
            this.studentList = studentList;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View itemView = layoutInflater.inflate(viewType,null);

            ViewHolder viewHolder = new ViewHolder(itemView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.studentPhoto.setImageResource(studentList.get(position).photoID);
            holder.studentAge.setText(Integer.toString(studentList.get(position).age));
            holder.studentName.setText(studentList.get(position).name);
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (position % 2 == 0) {
                return R.layout.left_view;
            }
            return R.layout.right_view;
        }
    }
}
