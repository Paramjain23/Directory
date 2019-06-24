package adapter;
import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.directory.R;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class RecyclerViewAdp extends RecyclerView.Adapter<RecyclerViewAdp.ViewHolder> {
    private Context context;
    private ArrayList<String> arrayList;


    public RecyclerViewAdp(Context context, ArrayList<String> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View listItem=layoutInflater.inflate(R.layout.recycler_cell,viewGroup,false);
        ViewHolder v=new ViewHolder(listItem);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
        viewHolder.titleTv.setText(arrayList.get(i));
        viewHolder.okBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(context,arrayList.get(i), LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return  arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView logoIv;
        Button okBtn;
        TextView titleTv;
        TextView desTv;
        public ViewHolder(View item){

            super(item);
            logoIv= item.findViewById(R.id.recyclerImage);
            okBtn= item.findViewById(R.id.RecOK);
            titleTv= item.findViewById(R.id.header);
            desTv= item.findViewById(R.id.description);





        }

    }



}
