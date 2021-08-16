package org.techtown.oasis.DoctorList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.techtown.oasis.Fragment17;
import org.techtown.oasis.HospitalList.Fragment8;
import org.techtown.oasis.R;

public class Fragment16 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_16, container, false);

        Button call_button2 = rootView.findViewById(R.id.call_button2);
        call_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = "이민수";
                // 정보 전달
                Bundle bundle = new Bundle();  // bundle으로 값 전달
                bundle.putString("Name", string); // bundle에 넘길 값 저장

                Fragment17 fragment17 = new Fragment17();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragment17.setArguments(bundle);  // bundle을 Fragment17로 보낼 준비
                transaction.replace(R.id.container, fragment17);
                transaction.commit();
            }
        });

        return rootView;
    }
}