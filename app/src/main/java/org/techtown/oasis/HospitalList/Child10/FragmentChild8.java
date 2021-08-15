package org.techtown.oasis.HospitalList.Child10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.techtown.oasis.HospitalList.Person;
import org.techtown.oasis.HospitalList.PersonAdapter;
import org.techtown.oasis.R;

public class FragmentChild8 extends Fragment {

    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_child8, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView5);
        // 레이아웃 매니저: recyclerView가 보일 기본 형태 설정(방향, 격자 모양 여부)
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // recyclerView에 어댑터 설정
        adapter = new PersonAdapter();
        adapter.addItem(new Person(R.drawable.dermatology_parkkibum, "박기범", "현대의원", "", "대기 시간: 30분"));
        adapter.addItem(new Person(R.drawable.dermatology_kwonohsang, "권오상", "효사랑의원", "", "대기 시간: 1시간"));
        adapter.addItem(new Person(R.drawable.dermatology_yoonjaeil, "윤재일", "연합의원", "", "대기 시간: 40분"));
        adapter.addItem(new Person(R.drawable.dermatology_seoseongjun, "서성준", "세종의원", "", "대기 시간: 2시간"));
        adapter.addItem(new Person(R.drawable.dermatology_gowooseok, "고우석", "성심의원", "", "대기 시간: 3시간"));
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}