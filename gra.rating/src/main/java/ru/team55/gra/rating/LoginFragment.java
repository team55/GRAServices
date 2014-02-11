package ru.team55.gra.rating;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Required;
import com.mobsandgeeks.saripaar.annotation.TextRule;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.fragment_login)
public class LoginFragment extends Fragment implements Validator.ValidationListener {


    @Required(order = 1)
    @Email(order = 2, message = "некорректный мыло")
    @ViewById(R.id.editEmail)
    EditText name;


    @Password(order = 3)
    @TextRule(order = 4, minLength = 6, message = "Enter at least 6 characters.")
    @ViewById(R.id.editPassword)
    EditText password;

    @Click(R.id.buttonLogin)
    void LogIn(){

        validator.validate();
/*
        final boolean isValid = FormValidator.validate(this, new SimpleErrorPopupCallback(getActivity()));

        if (isValid) {
            SimpleDialogFragment.createBuilder(getActivity(), getActivity().getSupportFragmentManager())
                    .setMessage("Все ок")
                    .setPositiveButtonText(android.R.string.ok)
                    .show();
        }
*/

    }


    Validator validator;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        validator = new Validator(this);
        validator.setValidationListener(this);

/*
        ((main) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
*/
        ((main) activity).onSectionAttached(1);

    }


    @Override
    public void onValidationSucceeded() {
        Toast.makeText(getActivity(), "Yay! we got it right!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(View view, Rule<?> rule) {
        String message = rule.getFailureMessage();

        if (view instanceof EditText) {
            view.requestFocus();
            ((EditText) view).setError(message);
        } else {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
