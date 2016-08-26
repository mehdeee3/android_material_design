package khzahre.materialdesign;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Drawer extends Fragment {

    private ActionBarDrawerToggle actionBarDrawerToggle ;
    private DrawerLayout drawerLayout;
    private View container_view ;

    private boolean user_learned, from_instance;

    private static final String pref_name = "FILE_NAME";
    private static final String userLearn = "KEY_USER_LEARNED";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user_learned=Boolean.valueOf(readFromPref(getActivity(), userLearn, "false"));
        if(savedInstanceState != null){
            from_instance = true;
        }

    }

    public Drawer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drawer, container, false);
    }

    public void setUp(int fragmentid, DrawerLayout dl, Toolbar tb) {
        drawerLayout = dl ;
        container_view = getActivity().findViewById(fragmentid) ;
        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), dl, tb, R.string.open, R.string.close)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!user_learned){
                    user_learned = true;
                    saveInPref(getActivity(), pref_name, user_learned+"" );
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };
        if(!user_learned && !from_instance){
            drawerLayout.openDrawer(container_view);
        }
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();
            }
        });
    }

    public static void saveInPref( Context c, String pName, String pValue){
        SharedPreferences sp = c.getSharedPreferences( pref_name, Context.MODE_PRIVATE) ;
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(pName, pValue);
        editor.apply();
    }

    public static String readFromPref( Context c, String pName, String pValue){
        SharedPreferences sp = c.getSharedPreferences(pref_name, Context.MODE_PRIVATE) ;
        return sp.getString(pName, pValue);
    }
}
