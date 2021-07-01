package com.neocaptainnemo.notesappjava.ui.info;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;
import com.neocaptainnemo.notesappjava.R;

public class AlertDialogFragment extends DialogFragment {

    public static final String TAG = "AlertDialogFragment";
    public static final String RESULT = "AlertDialogFragment";

    private static final String ARG_TITLE = "ARG_TITLE";

    public static AlertDialogFragment newInstance(@StringRes int title) {
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_TITLE, title);
        alertDialogFragment.setArguments(bundle);
        return alertDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        assert getArguments() != null;
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext())
                .setTitle(getArguments().getInt(ARG_TITLE))
                .setMessage(R.string.alert_dialog_message)
                .setIcon(R.drawable.ic_clear)
                .setCancelable(false)
                .setPositiveButton(R.string.btn_positive, (dialog, which) -> getParentFragmentManager().setFragmentResult(RESULT, null));
//                .setNegativeButton(R.string.btn_negative, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Snackbar.make(getView(), "Negative", Snackbar.LENGTH_SHORT).show();
//
//                    }
//                })
//                .setNeutralButton(R.string.btn_neutral, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Snackbar.make(getView(), "Neutral", Snackbar.LENGTH_SHORT).show();
//                    }
//                });

        return builder.create();
    }
}
