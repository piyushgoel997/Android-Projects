package com.example.piyush.studentlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    public static final String TAG = "List View Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayList<Students.Student> studentsList = Students.getStudents();
        ListView listView = (ListView) findViewById(R.id.listView);

        StudentListAdapter studentListAdapter = new StudentListAdapter(studentsList);
        listView.setAdapter(studentListAdapter);

        Log.d(TAG, "onCreate: called");
    }


    private class StudentListAdapter extends BaseAdapter {

        ArrayList<Students.Student> studentsList;

        public StudentListAdapter(ArrayList<Students.Student> studentsList) {
            this.studentsList = studentsList;
        }

        class ViewHolder{
            TextView studentName;
            TextView studentAge;
            ImageView photoID;
        }

        @Override
        public int getCount() {
            return studentsList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            ViewHolder viewHolder;

            Log.d(TAG, "getView: called");

            if(convertView == null){
                convertView = layoutInflater.inflate(getItemViewType(position),null);
                viewHolder = new ViewHolder();
                viewHolder.studentAge = (TextView) convertView.findViewById(R.id.tvAge);
                viewHolder.studentName = (TextView) convertView.findViewById(R.id.tvName);
                viewHolder.photoID = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Students.Student thisStudent = studentsList.get(position);

            viewHolder.studentAge.setText(Integer.toString(thisStudent.age));
            viewHolder.studentName.setText(thisStudent.name);
            viewHolder.photoID.setImageResource(thisStudent.photoID);

            Log.d(TAG, "getView: done");

            return convertView;
        }


        @Override
        public int getItemViewType(int position) {
            Log.d(TAG, "getItemViewType: called");
            if(position%2 == 0){
                return R.layout.left_view;
            }else{
                return R.layout.right_view;
            }
        }
    }

}
