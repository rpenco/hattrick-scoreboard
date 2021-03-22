package org.hattrickscoreboardl.ui.views.transfers;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.hattrick.providers.models.HTransfersSearch;
import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.database.models.transfer.HBid;
import org.hattrickscoreboardl.database.models.transfer.HTransfer;
import org.hattrickscoreboardl.database.models.world.HCountry;
import org.hattrickscoreboardl.services.UpdateListener;
import org.hattrickscoreboardl.services.process.hattrick.TransfersSearchProcess;
import org.hattrickscoreboardl.ui.abstracts.HFragment;
import org.hattrickscoreboardl.ui.componants.HButton;
import org.hattrickscoreboardl.ui.componants.HButtonFlat;
import org.hattrickscoreboardl.ui.componants.HContentView;
import org.hattrickscoreboardl.ui.utils.spinners.SimpleSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class TransfersSearchFragment extends HFragment {

    static final String TAG = (TransfersSearchFragment.class).getSimpleName();

    HTeam team;
    List<HBid> bids;
    List<HTransfer> transfers;
    List<HCountry> countries;

    public static TransfersSearchFragment newInstance(HTeam team) {
        TransfersSearchFragment fragment = new TransfersSearchFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    protected boolean onPrepareData() {

        /////////////////////////////
        //Get data from DB

        if(team != null) {

            bids = HBid.find(HBid.class, "TEAM_ID = ?", String.valueOf(team.getTeamID()));
            countries = HCountry.listAll(HCountry.class);

//            transfers = HTransfer.find(HTransfer.class, "TEAM_ID = ?", String.valueOf(team.getTeamID()));

            if(bids == null || countries == null/* || transfers == null*/){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    @Override
    protected View onDisplayData() {

        //////////////////////////////////////////
        //Container

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);

        ScrollView sv = new ScrollView(getActivity());
        sv.setLayoutParams(params);
        LinearLayout llContainer = new LinearLayout(getActivity());
        llContainer.setLayoutParams(params);
        llContainer.setOrientation(LinearLayout.VERTICAL);
        sv.addView(llContainer);

        //Spinner age
        List<String> listAge = new ArrayList<String>();
        listAge.add("-- Age --");
        for(int i= 17; i < 100; i++) {
            listAge.add(i+" ans");
        }

        //Spinner ageday
        List<String> listAgeDay = new ArrayList<String>();
        listAgeDay.add("-- Jours --");
        for(int i= 0; i < 111; i++) {
            listAgeDay.add(i+" jours");
        }

        //Spinner skills
        List<String> listSkills = new ArrayList<String>();
        listSkills.add("-- Caractéristique --");
        listSkills.add("Gardien");
        listSkills.add("Défense");
        listSkills.add("Construction");
        listSkills.add("Ailier");
        listSkills.add("Buteur");
        listSkills.add("Passe");
        listSkills.add("Coup franc");
        listSkills.add("Expérience");
        listSkills.add("Temp. de chef");

        //Spinner skill level
        String[] skills = getResources().getStringArray(R.array.hattrick_skills);
        List<String> listSkillLevelMin = Arrays.asList(skills);
//        listSkillLevelMin.add(0,"-- Min --");

        List<String> listSkillLevelMax = Arrays.asList(skills);
//        listSkillLevelMax.add(0,"-- Max --");


        //Spinner ageday
        List<String> listCountry = new ArrayList<String>();
        listCountry.add("-- Tous --");
        for(HCountry country : countries) {
            listCountry.add(country.getCountryName());
        }

        //////////////////////////////////////////

        //Line 1: Age min
        LinearLayout llAgeMin = new LinearLayout(getActivity());
        llAgeMin.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llAgeMin);

        TextView tvAgeMin = new TextView(getActivity());
        tvAgeMin.setText("Age min.");
        llAgeMin.addView(tvAgeMin);

        //Age min
        SimpleSpinner spAgeMin = new SimpleSpinner(getActivity());
        spAgeMin.setItems(listAge);
        llAgeMin.addView(spAgeMin);

        //AgeDay min
        SimpleSpinner spAgeDayMin = new SimpleSpinner(getActivity());
        spAgeDayMin.setItems(listAgeDay);
        llAgeMin.addView(spAgeDayMin);

        //////////////////////////////////////////

        //Line 2: Age max
        LinearLayout llAgeMax = new LinearLayout(getActivity());
        llAgeMax.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llAgeMax);

        TextView tvAgeMax = new TextView(getActivity());
        tvAgeMax.setText("Age max.");
        llAgeMax.addView(tvAgeMax);

        //Age min
        SimpleSpinner spAgeMax = new SimpleSpinner(getActivity());
        spAgeMax.setItems(listAge);
        llAgeMax.addView(spAgeMax);

        //AgeDay min
        SimpleSpinner spAgeDayMax = new SimpleSpinner(getActivity());
        spAgeDayMax.setItems(listAgeDay);
        llAgeMax.addView(spAgeDayMax);

        //////////////////////////////////////////

        //Line 3: Skill 1
        LinearLayout llSkill1 = new LinearLayout(getActivity());
        llSkill1.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llSkill1);

        //Skill
        SimpleSpinner spSkill1 = new SimpleSpinner(getActivity());
        spSkill1.setItems(listSkills);
        llSkill1.addView(spSkill1);

        //Skill min
        SimpleSpinner spSkill1Min = new SimpleSpinner(getActivity());
        spSkill1Min.setItems(listSkillLevelMin);
        llSkill1.addView(spSkill1Min);

        //Skill max
        SimpleSpinner spSkill1Max = new SimpleSpinner(getActivity());
        spSkill1Max.setItems(listSkillLevelMax);
        llSkill1.addView(spSkill1Max);

        //////////////////////////////////////////

        //Line 4: Skill 1
        LinearLayout llSkill2 = new LinearLayout(getActivity());
        llSkill2.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llSkill2);

        //Skill
        SimpleSpinner spSkill2 = new SimpleSpinner(getActivity());
        spSkill2.setItems(listSkills);
        llSkill2.addView(spSkill2);

        //Skill min
        SimpleSpinner spSkill2Min = new SimpleSpinner(getActivity());
        spSkill2Min.setItems(listSkillLevelMin);
        llSkill2.addView(spSkill2Min);

        //Skill max
        SimpleSpinner spSkill2Max = new SimpleSpinner(getActivity());
        spSkill2Max.setItems(listSkillLevelMax);
        llSkill2.addView(spSkill2Max);

        //////////////////////////////////////////

        //Line 5: Skill 3
        LinearLayout llSkill3 = new LinearLayout(getActivity());
        llSkill3.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llSkill3);

        //Skill
        SimpleSpinner spSkill3 = new SimpleSpinner(getActivity());
        spSkill3.setItems(listSkills);
        llSkill3.addView(spSkill3);

        //Skill min
        SimpleSpinner spSkill3Min = new SimpleSpinner(getActivity());
        spSkill3Min.setItems(listSkillLevelMin);
        llSkill3.addView(spSkill3Min);

        //Skill max
        SimpleSpinner spSkill3Max = new SimpleSpinner(getActivity());
        spSkill3Max.setItems(listSkillLevelMax);
        llSkill3.addView(spSkill3Max);

        //////////////////////////////////////////
        //Line 6: Skill 4
        LinearLayout llSkill4 = new LinearLayout(getActivity());
        llSkill4.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llSkill4);

        //Skill
        SimpleSpinner spSkill4 = new SimpleSpinner(getActivity());
        spSkill4.setItems(listSkills);
        llSkill4.addView(spSkill4);

        //Skill min
        SimpleSpinner spSkill4Min = new SimpleSpinner(getActivity());
        spSkill4Min.setItems(listSkillLevelMin);
        llSkill4.addView(spSkill4Min);

        //Skill max
        SimpleSpinner spSkill4Max = new SimpleSpinner(getActivity());
        spSkill4Max.setItems(listSkillLevelMax);
        llSkill4.addView(spSkill4Max);

        //////////////////////////////////////////

        //Line 7: TSI
        LinearLayout llTSI = new LinearLayout(getActivity());
        llTSI.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llTSI);

        TextView tvTSI = new TextView(getActivity());
        tvTSI.setText("TSI");
        llTSI.addView(tvTSI);

        //TSI min
        EditText etTSIMin = new EditText(getActivity());
        etTSIMin.setHint("Min.");
        llTSI.addView(etTSIMin);

        //AgeDay min
        EditText etTSIMax = new EditText(getActivity());
        etTSIMax.setHint("Max.");
        llTSI.addView(etTSIMax);

        //////////////////////////////////////////

        //Line 8: Price
        LinearLayout llPrice = new LinearLayout(getActivity());
        llPrice.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llPrice);

        TextView tvPrice = new TextView(getActivity());
        tvPrice.setText("Prix/Enchère");
        llPrice.addView(tvPrice);

        //TSI min
        EditText etPriceMin = new EditText(getActivity());
        etPriceMin.setHint("Min.");
        llPrice.addView(etPriceMin);

        //AgeDay min
        EditText etPriceMax = new EditText(getActivity());
        etPriceMax.setHint("Max.");
        llPrice.addView(etPriceMax);


        //////////////////////////////////////////
        //Line 6: Speciality
        LinearLayout llSpec = new LinearLayout(getActivity());
        llSpec.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llSpec);

        TextView tvSpec = new TextView(getActivity());
        tvSpec.setText("Spécialité");
        llSpec.addView(tvSpec);

        //Skill
        SimpleSpinner spSpec = new SimpleSpinner(getActivity());
        spSpec.setItems(listSkills);
        llSpec.addView(spSpec);


        //////////////////////////////////////////
        //Line 6: NativeCountryID

        LinearLayout llCountry = new LinearLayout(getActivity());
        llCountry.setOrientation(LinearLayout.HORIZONTAL);
        llContainer.addView(llCountry);

        TextView tvCountry = new TextView(getActivity());
        tvCountry.setText("Nationalité");
        llCountry.addView(tvCountry);

        //Country
        SimpleSpinner spCountry = new SimpleSpinner(getActivity());
        spCountry.setItems(listCountry);
        llCountry.addView(spCountry);


        HContentView hContentButtons = new HContentView(getActivity());
        llContainer.addView(hContentButtons);
        LinearLayout vButtons = hContentButtons.splitViewHorizontal();

        //Connexion alternative
        HButtonFlat btnErease = new HButtonFlat(getActivity());
        btnErease.setText("Effacer");
//        btnErease.setGravity(Gravity.START);
        vButtons.addView(btnErease);
        btnErease.widthMatchParent();

        //Connexion
        HButton btnSearch = new HButton(getActivity());
        btnSearch.setText("Rechercher");
        vButtons.addView(btnSearch);


        //Connexion
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TransfersSearchProcess process = new TransfersSearchProcess(getActivity(), getRequest(), false);
                process.setListener(new UpdateListener() {
                    @Override
                    public void onUpdateStart(String from) {
                        Toast.makeText(getActivity(), "Recherche en cours...",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onUpdateSuccess(String from) {
                        Toast.makeText(getActivity(), "Recherche effectuée...",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onUpdateError(String from, int code) {
                        Toast.makeText(getActivity(), "Recherche erreur...",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                HTransfersSearch search = new HTransfersSearch();
                search.setAgeMin(20);
                search.setAgeMax(22);
                search.addSkill(8,7,9);
                process.perform(search);




            }
        });
        return sv;
    }


}
