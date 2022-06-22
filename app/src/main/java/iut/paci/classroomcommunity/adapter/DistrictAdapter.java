package iut.paci.classroomcommunity.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import iut.paci.classroomcommunity.Quizz.QuestionsActivity;
import iut.paci.classroomcommunity.Quizz.QuizMainActivity;
import iut.paci.classroomcommunity.R;
import iut.paci.classroomcommunity.models.District;
import iut.paci.classroomcommunity.ui.QuizzActivity;

public class DistrictAdapter  extends ArrayAdapter<District> {

    private List<District> listData;
    private Context mContext;

    public DistrictAdapter(@NonNull Context context, ArrayList<District> list) {
        super(context, 0 , list);
        mContext = context;
        listData = list;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.district_adapter_layout,parent,false);

        District currentDistrict = listData.get(position);

        CardView cardView = listItem.findViewById(R.id.parent);

        cardView.setOnClickListener(v -> {
            AlertDialog.Builder popup = new AlertDialog.Builder(mContext);
            popup.setTitle(currentDistrict.getName());
            popup.setMessage("Faire le quizz sur " + currentDistrict.getName());
            popup.setNegativeButton("retour", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            popup.setPositiveButton("commencer", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mContext.startActivity(new Intent(mContext.getApplicationContext(), QuestionsActivity.class));
                }
            });
            popup.show();
        });

        ImageView image = (ImageView)listItem.findViewById(R.id.districtImg);
        image.setBackgroundResource(currentDistrict.getImageResourceId());

        TextView name = (TextView) listItem.findViewById(R.id.districtName);
        name.setText(currentDistrict.getName());

        return listItem;
    }
}
