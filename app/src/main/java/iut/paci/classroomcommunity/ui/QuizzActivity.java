package iut.paci.classroomcommunity.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import iut.paci.classroomcommunity.R;
import iut.paci.classroomcommunity.adapter.DistrictAdapter;
import iut.paci.classroomcommunity.models.District;

public class QuizzActivity extends AppCompatActivity {

    private DistrictAdapter mAdapter;

    public List<District> getData(){
        ArrayList<District> districtsList = new ArrayList<>();
        districtsList.add(new District(1,"BMW","Distric chic",1,1,R.drawable.bmw_x5_06_2018));
        districtsList.add(new District(1,"Renault","Distric chic",1,1,R.drawable.renault_clio_5));
        districtsList.add(new District(1,"Peugeot","Distric chic",1,1,R.drawable.peugeot_2008));
        districtsList.add(new District(1,"Mercedes","Distric chic",1,1,R.drawable.mercedes_cla_2019));
        districtsList.add(new District(1,"Lamborghini","Distric chic",1,1,R.drawable.lamborghini_urus));
        districtsList.add( new District(1,"Renault","Distric chic",1,1,R.drawable.renault_clio_5));

        return districtsList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        GridView gridViewView = (GridView) findViewById(R.id.grid);

        mAdapter = new DistrictAdapter(this, (ArrayList<District>) getData());
        gridViewView.setAdapter(mAdapter);
    }
}