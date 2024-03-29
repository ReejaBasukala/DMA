package com.example.todofragement;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TodoFragment extends Fragment {
    private Todo mTodo;
    private EditText mEditTextTitle;
    private Button mButtonDate;
    private CheckBox mCheckBoxIsComplete;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mTodo = new Todo();
        // TODO: refactor
        mTodo.setTitle("Test title");
        mTodo.setIsComplete(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo, container, false);
        mEditTextTitle = (EditText) view.findViewById(R.id.todo_title);
        mEditTextTitle.setText(mTodo.getTitle());
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTodo.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This line is intentionally left blank
            }
        });
        mButtonDate = (Button) view.findViewById(R.id.todo_date);
        mButtonDate.setText(mTodo.getDate().toString());
        mButtonDate.setEnabled(false);
        mCheckBoxIsComplete = (CheckBox) view.findViewById(R.id.todo_complete);
        mCheckBoxIsComplete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTodo.setIsComplete(isChecked);
            }
        });
        return view;
    }
}