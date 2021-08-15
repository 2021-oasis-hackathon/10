package org.techtown.oasis.HospitalList.Child8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.techtown.oasis.DoctorList.Fragment15;
import org.techtown.oasis.DoctorList.Fragment16;
import org.techtown.oasis.HospitalList.OnPersonItemClickListener;
import org.techtown.oasis.HospitalList.Person;
import org.techtown.oasis.HospitalList.PersonAdapter;
import org.techtown.oasis.R;

public class FragmentChild5 extends Fragment {
    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_child5, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView2);
        // 레이아웃 매니저: recyclerView가 보일 기본 형태 설정(방향, 격자 모양 여부)
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // recyclerView에 어댑터 설정
        adapter = new PersonAdapter();
        adapter.addItem(new Person(R.drawable.psychiatry_leeminsoo, "이민수", "고려대학교 안암병원", "", "대기 시간: 30분"));
        adapter.addItem(new Person(R.drawable.psychiatry_hanseolhee, "한설희", "건국대학교병원", "", "대기 시간: 1시간"));
        adapter.addItem(new Person(R.drawable.psychiatry_jeongdoeon, "정도언", "서울대병원", "", "대기 시간: 40분"));
        adapter.addItem(new Person(R.drawable.psychiatry_jeongdongcheong, "정동청", "서울청정신건강의학과의원 강남점", "", "대기 시간: 1시간"));
        adapter.addItem(new Person(R.drawable.psychiatry_kimbyungsoo, "김병수", "김병수 정신건강의학과 의원", "", "대기 시간: 40분"));
        recyclerView.setAdapter(adapter);

        // 어댑터에 리스너 설정
        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);  // 어댑터에 리스너 설정
                Toast.makeText(getContext(), "의사 선택됨: " + item.getName(), Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    Fragment16 fragment16 = new Fragment16();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment16);
                    transaction.commit();
                }
            }
        });

        return rootView;
    }
}