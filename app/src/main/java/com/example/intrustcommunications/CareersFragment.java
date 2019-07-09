package com.example.intrustcommunications;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CareersFragment extends Fragment implements View.OnClickListener {

    private final String MAIL_TO = "mick.hull@intrustcommunications.ie";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View careersView = inflater.inflate(R.layout.fragment_careers, container, false);

        //set listeners
        setOnClickListeners(careersView);

        return careersView;
    }

    private void setOnClickListeners(View view) {
        //first job button
        TextView firstJobButton = (TextView) view.findViewById(R.id.firstJobButton);
        firstJobButton.setOnClickListener(this);

        //second job button
        TextView secondJobButton = (TextView) view.findViewById(R.id.secondJobButton);
        secondJobButton.setOnClickListener(this);

        //third job button
        TextView thirdJobButton = (TextView) view.findViewById(R.id.thirdJobButton);
        thirdJobButton.setOnClickListener(this);

        //fourth job button
        TextView fourthJobButton = (TextView) view.findViewById(R.id.fourthJobButton);
        fourthJobButton.setOnClickListener(this);

        //submit button listener
        Button submit = (Button) view.findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //set scroll view
        ScrollView scrollView = (ScrollView) getView().findViewById(R.id.careers_scroll_view);

        //get layouts
        RelativeLayout firstJobLayout = (RelativeLayout) getView().findViewById(R.id.firstJobContent);
        RelativeLayout secondJobLayout = (RelativeLayout) getView().findViewById(R.id.secondJobContent);
        RelativeLayout thirdJobLayout = (RelativeLayout) getView().findViewById(R.id.thirdJobContent);
        RelativeLayout fourthJobLayout = (RelativeLayout) getView().findViewById(R.id.fourthJobContent);

        //get buttons
        TextView firstButton = (TextView) getView().findViewById(R.id.firstJobButton);
        TextView secondButton = (TextView) getView().findViewById(R.id.secondJobButton);
        TextView thirdButton = (TextView) getView().findViewById(R.id.thirdJobButton);
        TextView fourthButton = (TextView) getView().findViewById(R.id.fourthJobButton);

        int id = view.getId();

        if (id == R.id.firstJobButton) {

            //set view
            scrollView.scrollTo(0, firstButton.getTop());

            //get first layout visibility
            int visible = firstJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.VISIBLE);
                firstButton.setText("-");
                secondJobLayout.setVisibility(View.GONE);
                secondButton.setText("+");
                thirdJobLayout.setVisibility(View.GONE);
                thirdButton.setText("+");
                fourthJobLayout.setVisibility(View.GONE);
                fourthButton.setText("+");

            } else {
                firstJobLayout.setVisibility(View.GONE);

                //set button text
                firstButton.setText("+");
            }
        } else if (id == R.id.secondJobButton) {

            //set view
            scrollView.scrollTo(0, secondButton.getTop());

            //get layout visibility
            int visible = secondJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.GONE);
                firstButton.setText("+");
                secondJobLayout.setVisibility(View.VISIBLE);
                secondButton.setText("-");
                thirdJobLayout.setVisibility(View.GONE);
                thirdButton.setText("+");
                fourthJobLayout.setVisibility(View.GONE);
                fourthButton.setText("+");

            } else {
                secondJobLayout.setVisibility(View.GONE);

                //set button text
                secondButton.setText("+");
            }
        } else if (id == R.id.thirdJobButton) {

            //set view
            scrollView.scrollTo(0, thirdButton.getTop());

            //get layout visibility
            int visible = thirdJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.GONE);
                firstButton.setText("+");
                secondJobLayout.setVisibility(View.GONE);
                secondButton.setText("+");
                thirdJobLayout.setVisibility(View.VISIBLE);
                thirdButton.setText("-");
                fourthJobLayout.setVisibility(View.GONE);
                fourthButton.setText("+");

            } else {
                thirdJobLayout.setVisibility(View.GONE);

                //set button text
                thirdButton.setText("+");

            }
        } else if (id == R.id.fourthJobButton) {

            //set view
            scrollView.scrollTo(0, fourthButton.getTop());

            //get layout visibility
            int visible = fourthJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.GONE);
                firstButton.setText("+");
                secondJobLayout.setVisibility(View.GONE);
                secondButton.setText("+");
                thirdJobLayout.setVisibility(View.GONE);
                thirdButton.setText("+");
                fourthJobLayout.setVisibility(View.VISIBLE);
                fourthButton.setText("-");

            } else {
                fourthJobLayout.setVisibility(View.GONE);

                //set button text
                fourthButton.setText("+");
            }
        } else if (id == R.id.submitButton) {
            //add logic with validator
            EditText subjectEdit = (EditText) getView().findViewById(R.id.subjectEditText);
            EditText messageEdit = (EditText) getView().findViewById(R.id.messageEditText);

            String subject = subjectEdit.getText().toString();
            String message = messageEdit.getText().toString();

            if(isEmailValid(subject, message)){
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{MAIL_TO});
                i.putExtra(Intent.EXTRA_SUBJECT, subject);
                i.putExtra(Intent.EXTRA_TEXT   , message);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                }
            }
        }
    }

    private boolean isEmailValid(String subject, String message){

        subject = subject.trim();
        message = message.trim();

        if(subject != null && !subject.equals("")){
            if(message != null && !message.equals("")){
                return true;
            }
        }
        return false;
    }

}
