package ru.team55.gra.rating;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.EditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.fragment_register)
public class RegisterFragment extends Fragment {


    @ViewById(R.id.editLogin)
    EditText name;

    @ViewById(R.id.editPassword)
    EditText password;

    @ViewById(R.id.editConfirmPassword)
    EditText confirm_password;


  /*  @Click(R.id.log_in_button)
    void LogIn(){
        ((pageLoginRegister_)getActivity()).attemptLogin(name.getText().toString(), password.getText().toString());
    }
*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        ((main) activity).onSectionAttached(2); //TODO: переделать

    }


}
