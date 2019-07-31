package com.example.piyush.studentfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentFragment extends Fragment {

    public static final String TAG = "Student Fragment";

    // KEYS
    private static final String ARG_STUDENT_NAME = "studentName";
    private static final String ARG_STUDENT_AGE = "studentAge";
    private static final String ARG_STUDENT_PHOTO = "studentPhotoID";


    // VALUES
    private String studentName;
    private int studentAge;
    private int studentPhotoID;

    ImageView ivStudentPhoto;
    TextView tvStudentName;
    TextView tvStudentAge;

    public StudentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param thisStudent Parameter 1.
     * @return A new instance of fragment StudentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentFragment newInstance(Students.Student thisStudent) {
        Log.d(TAG, "newInstance: called");
        StudentFragment fragment = new StudentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STUDENT_NAME, thisStudent.name);
        args.putInt(ARG_STUDENT_AGE, thisStudent.age);
        args.putInt(ARG_STUDENT_PHOTO,thisStudent.photoID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: called");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            studentName = getArguments().getString(ARG_STUDENT_NAME);
            studentAge = getArguments().getInt(ARG_STUDENT_AGE);
            studentPhotoID = getArguments().getInt(ARG_STUDENT_PHOTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: called");
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_student, container, false);
        tvStudentName = (TextView) itemView.findViewById(R.id.name_tv);
        tvStudentAge = (TextView) itemView.findViewById(R.id.age_tv);
        ivStudentPhoto = (ImageView) itemView.findViewById(R.id.photo_iv);
        tvStudentAge.setText(Integer.toString(studentAge));
        tvStudentName.setText(studentName);
        ivStudentPhoto.setImageResource(studentPhotoID);

        return itemView;
    }

}
