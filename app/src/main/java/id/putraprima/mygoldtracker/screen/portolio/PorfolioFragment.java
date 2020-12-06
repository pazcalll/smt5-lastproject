package id.putraprima.mygoldtracker.screen.portolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import id.putraprima.mygoldtracker.R;

public class PorfolioFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    public PorfolioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> tab) {
//        initialize main adapter
        MainAdapter adapter = new MainAdapter(getFragmentManager());
//        Initialize the fragment
        DompetFragment fragment = new DompetFragment();
        for (int i = 0; i < tab.size(); i++) {
//            initialize bundle
            Bundle bundle = new Bundle();
//            put string
            bundle.putString("title", tab.get(i));
//            set arguments
            fragment.setArguments(bundle);
//            add fragment
            adapter.addFragment(fragment, tab.get(i));
//            define new fragment
            fragment = new DompetFragment();
        }
//        set adapter
        viewPager.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_porfolio, container, false);

//        assign variable
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

//        initialize Array list
        ArrayList<String> tab = new ArrayList<>();
        tab.add("Dompet");
        tab.add("Harga");
        tab.add("Pembelian");

//        prepare view pager
        prepareViewPager(viewPager, tab);

//        setup with view pager
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private class MainAdapter extends FragmentPagerAdapter {
//        Initializing arryalist
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Fragment> fragmentList = new ArrayList<>();

//        create constructor
        public void addFragment(Fragment fragment, String title){
//            add array title
            arrayList.add(title);
//            add fragment
            fragmentList.add(fragment);
        }

        public MainAdapter(@NonNull FragmentManager p0) {
            super(p0);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
//            return fragment position
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
//            return fragmentList size
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
//            return array list position
            return arrayList.get(position);
        }
    }
}