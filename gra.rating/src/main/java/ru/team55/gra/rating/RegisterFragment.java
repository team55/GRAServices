package ru.team55.gra.rating;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.EditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.fragment_main)
public class RegisterFragment extends Fragment {


    //@ViewById EditText name;
    //@ViewById EditText password;

  /*  @Click(R.id.log_in_button)
    void LogIn(){
        ((pageLoginRegister_)getActivity()).attemptLogin(name.getText().toString(), password.getText().toString());
    }
*/



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
/*
        ((main) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
*/
        ((main) activity).onSectionAttached(2);

    }


}
