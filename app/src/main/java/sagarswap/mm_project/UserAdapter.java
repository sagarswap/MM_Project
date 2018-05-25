package sagarswap.mm_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> users;
    Context mcontext;

    public UserAdapter(List<User> users)
    {
        this.users=users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        mcontext=parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position)
    {
        holder.ownerName.setText(users.get(position).getOwnerName());
        holder.vehicleName.setText(users.get(position).getVehicleName());
        holder.vehicleNumber.setText(users.get(position).getVehicleNumber());

        holder.userRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mcontext, UserDetails.class);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ownerName, vehicleName, vehicleNumber;
        public LinearLayout userRow;

        public ViewHolder(View itemView) {
            super(itemView);
            ownerName=itemView.findViewById(R.id.owner_name);
            vehicleName=itemView.findViewById(R.id.vehicle_name);
            vehicleNumber=itemView.findViewById(R.id.vehicle_number);
            userRow=itemView.findViewById(R.id.user_row);
        }
    }
}
